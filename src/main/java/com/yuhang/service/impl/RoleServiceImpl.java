package com.yuhang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuhang.dao.RoleDao;
import com.yuhang.domain.Role;
import com.yuhang.service.RoleService;

@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleDao roleDao;

	@Override
	public List<Role> findByMap(Map<String, Object> params) {
		return roleDao.findByMap(params);
	}

}
