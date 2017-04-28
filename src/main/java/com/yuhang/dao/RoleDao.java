package com.yuhang.dao;

import java.util.List;
import java.util.Map;

import com.yuhang.domain.Role;

@MyBatisRepository
public interface RoleDao {

	List<Role> findByMap(Map<String, Object> map);
}
