package com.yuhang.service;

import java.util.List;
import java.util.Map;

import com.yuhang.domain.Role;

public interface RoleService {

	List<Role> loadByMap(Map<String, Object> params);
}
