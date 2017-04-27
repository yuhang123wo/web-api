package com.yuhang.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yuhang.domain.Role;
import com.yuhang.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Override
	public List<Role> loadByMap(Map<String, Object> params) {
		return null;
	}

}
