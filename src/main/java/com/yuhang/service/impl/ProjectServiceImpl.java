package com.yuhang.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
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

	@Override
	public Page<Project> loadProjectByParams(Map<String, Object> params, int pageNo, int pageSize) {
		PageRequest pageRequest = new PageRequest(pageNo - 1, pageSize);
		if (params == null) {
			params = new HashMap<String, Object>();
		}
		params.put("start", pageRequest.getOffset());
		params.put("size", pageSize);
		int count = projectDao.countFindByMap(params);
		List<Project> list = projectDao.findByMap(params);
		return new PageImpl<Project>(list, pageRequest, count);
	}

}
