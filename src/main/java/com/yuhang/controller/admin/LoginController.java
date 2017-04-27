package com.yuhang.controller.admin;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuhang.controller.BaseController;
import com.yuhang.domain.User;
import com.yuhang.dto.LoginDto;
import com.yuhang.framework.ErrorInfos;
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
	public String login(@ModelAttribute LoginDto model) {
		try {
			User user = userService.loadUserByName(model.getUserName());
			if (user != null) {
				if (MD5.encrytMD5(model.getPassword()).equals(user.getPassword())
						&& model.getUserName().equals(user.getUserName())) {
					userService.login(model, user, request, response);
					return "indexx";
				}
				model.setTipMessage("用户密码有误");
				return "indexg";
			} else {
				model.setTipMessage("用户名不存在");
				return "indexg";
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
		return "indexg";
	}
	
	public static void main(String[] args) {
		System.out.println(MD5.encrytMD5("a"));
	}
}
