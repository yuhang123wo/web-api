package com.yuhang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuhang.dao.ProjectDao;
import com.yuhang.domain.Project;
import com.yuhang.service.ProjectService;

@Service("projectService")
public class ProjectServiceImpl implements ProjectService {

	@Resource
	private ProjectDao projectDao;

	@Override
	public List<Project> findProjectByMap(Map<String, Object> map) {
		return projectDao.findByMap(map);
	}

}
