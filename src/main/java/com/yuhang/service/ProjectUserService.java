package com.yuhang.service;

import java.util.List;
import java.util.Map;

import com.yuhang.domain.ProjectUser;

public interface ProjectUserService {

	List<ProjectUser> findByMap(Map<String, Object> map);
}
