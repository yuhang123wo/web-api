package com.yuhang.dao;

import java.util.List;
import java.util.Map;

import com.yuhang.domain.ProjectUser;

@MyBatisRepository
public interface ProjectUserDao {
	List<ProjectUser> findByMap(Map<String, Object> map);
}
