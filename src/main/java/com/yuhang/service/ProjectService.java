package com.yuhang.service;

import java.util.List;
import java.util.Map;

import com.yuhang.domain.Project;

public interface ProjectService {

	List<Project> findProjectByMap(Map<String, Object> map);
}
