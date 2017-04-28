package com.yuhang.dao;

import java.util.List;
import java.util.Map;

import com.yuhang.domain.Project;

@MyBatisRepository
public interface ProjectDao {

	List<Project> findByMap(Map<String, Object> map);
}
