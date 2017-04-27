package com.yuhang.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.yuhang.dao.UserDao;
import com.yuhang.domain.User;
import com.yuhang.dto.LoginDto;
import com.yuhang.dto.LoginInfoDto;
import com.yuhang.service.CacheService;
import com.yuhang.service.ProjectService;
import com.yuhang.service.ProjectUserService;
import com.yuhang.service.RoleService;
import com.yuhang.service.UserService;
import com.yuhang.util.Aes;
import com.yuhang.util.Const;
import com.yuhang.util.MyCookie;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	@Resource
	private CacheService cacheService;
	@Resource
	private RoleService roleService;
	@Resource
	private ProjectService projectService;
	@Resource
	private ProjectUserService projectUserService;

	@Override
	public User loadUserById(long id) {
		return userDao.loadUserById(id);
	}

	@Override
	public User loadUserByName(String userName) {
		return userDao.loadUserByName(userName);
	}

	@Override
	public void login(LoginDto model, User user, HttpServletRequest request,
			HttpServletResponse response) {
		String token = Aes.encrypt(user.getId().toString());
		MyCookie.addCookie(Const.COOKIE_TOKEN, token, response);
		// 将用户信息存入缓存
		cacheService.setObj(Const.CACHE_USER + user.getId(), new LoginInfoDto(user, roleService,
				projectService, projectUserService), 3600);
		MyCookie.addCookie(Const.COOKIE_USERID, user.getId().toString(), response);
		MyCookie.addCookie(Const.COOKIE_USERNAME, model.getUserName(), response);
		MyCookie.addCookie(Const.COOKIE_REMBER_PWD, model.getRemberPwd(), response);

		// 如果选择了记住密码，或者remberPwd==null，则记住密码
		if (model.getRemberPwd() == null || model.getRemberPwd().equalsIgnoreCase("yes")) {
			MyCookie.addCookie(Const.COOKIE_PASSWORD, model.getPassword(), true, response);
		} else {
			MyCookie.deleteCookie(Const.COOKIE_PASSWORD, request, response);
		}
		model.setSessionAdminName(model.getUserName());
	}

}
