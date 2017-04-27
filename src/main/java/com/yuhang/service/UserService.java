package com.yuhang.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yuhang.domain.User;
import com.yuhang.dto.LoginDto;

public interface UserService {

	
	User loadUserById(long id);

	User loadUserByName(String userName);
	
	void login(LoginDto model, User user, HttpServletRequest request, HttpServletResponse response);
}
