package com.yuhang.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.yuhang.domain.Project;
import com.yuhang.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Override
	public List<Project> findProjectByMap(Map<String, Object> map) {
		return null;
	}

}
