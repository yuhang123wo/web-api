package com.yuhang.framework.auth;

import java.net.InetAddress;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yuhang.framework.MyException;
import com.yuhang.service.CacheService;
import com.yuhang.util.Aes;
import com.yuhang.util.Const;
import com.yuhang.util.MyCookie;
import com.yuhang.util.Tools;

/**
 * 对登录状态进行拦截
 * 
 * @author
 *
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private CacheService cacheService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object handler) throws Exception {
		if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
			AuthPassport authPassport = ((HandlerMethod) handler)
					.getMethodAnnotation(AuthPassport.class);

			// 未登陆用户唯一识别
			String uuid = MyCookie.getCookie(Const.COOKIE_UUID, false, request);
			if (StringUtils.isEmpty(uuid)) {
				MyCookie.addCookie(Const.COOKIE_UUID,
						System.currentTimeMillis() + Tools.getChar(10), response);
			}

			try {
				// 返回服务器ip
				response.setHeader("serviceIp", InetAddress.getLocalHost().getHostAddress());
			} catch (Exception e) {
				e.printStackTrace();
				response.setHeader("serviceIp", "服务器配置异常，无法获取服务器IP");
			}

			if (authPassport == null || authPassport.validate() == false)
				return true;

			String token = MyCookie.getCookie(Const.COOKIE_TOKEN, false, request);
			String uid = MyCookie.getCookie(Const.COOKIE_USERID, false, request);
			// 前端没有传递token，未登录
			if (StringUtils.isEmpty(token) || StringUtils.isEmpty(uid)
					|| !Aes.desEncrypt(token).equals(uid)) {
				if (request.getRequestURI().endsWith("login"))
					response.sendRedirect("index");
				else
					throw new MyException("000021");
			}

			// 后端没登录信息：登录超时
			Object obj = cacheService.getObj(Const.CACHE_USER + uid);
			if (obj == null) {
				// 删除cookie
				MyCookie.deleteCookie(Const.COOKIE_TOKEN, request, response);
				if (request.getRequestURI().endsWith("login")) {
					response.sendRedirect("index");
					return false;
				} else
					throw new MyException("000021");
			}

			// 每次访问，将用户登录有效信息延长
			cacheService.setObj(Const.CACHE_USER + uid, obj, 3600);

			if (!authPassport.authority().equals("")) {
				return Tools.hasAuth(authPassport.authority());
			} else {
				return true;
			}

		} else {
			return true;
		}
	}

}