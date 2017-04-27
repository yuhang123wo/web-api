package com.yuhang.controller.admin;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuhang.controller.BaseController;
import com.yuhang.domain.User;
import com.yuhang.dto.LoginDto;
import com.yuhang.framework.ErrorInfos;
import com.yuhang.framework.JsonResult;
import com.yuhang.framework.MyException;
import com.yuhang.service.UserService;
import com.yuhang.util.MD5;

@Controller
public class LoginController extends BaseController {

	@Resource
	private UserService userService;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseBody
	public JsonResult login(@ModelAttribute LoginDto model) {
		try {
			User user = userService.loadUserByName(model.getUserName());
			if (user != null) {
				if (MD5.encrytMD5(model.getPassword()).equals(user.getPassword())
						&& model.getUserName().equals(user.getUserName())) {
					userService.login(model, user, request, response);
					return new JsonResult(T_RETURN, model);
				}
				model.setTipMessage("用户密码有误");
				return new JsonResult(F_RETURN, model);
			} else {
				model.setTipMessage("用户名不存在");
				return new JsonResult(F_RETURN, model);
			}
		} catch (Exception e) {
			if (e instanceof MyException) {
				model.setTipMessage(ErrorInfos.getMessage(e.getMessage()));
			} else {
				log.error(e.getMessage(), e);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				String exceptionDetail[] = baos.toString().split("Caused by:");
				try {
					baos.close();
				} catch (IOException ioe) {
				}

				String cusedBy = "";
				if (exceptionDetail.length > 0) {
					cusedBy = exceptionDetail[exceptionDetail.length - 1].split("\n")[0];
				}
				model.setTipMessage("未知异常，请查看日志：" + cusedBy);
			}
		}
		return new JsonResult(F_RETURN, model);

	}
}
