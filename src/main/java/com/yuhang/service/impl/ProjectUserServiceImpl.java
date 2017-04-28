package com.yuhang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yuhang.dao.ProjectUserDao;
import com.yuhang.domain.ProjectUser;
import com.yuhang.service.ProjectUserService;

@Service("projectUserService")
public class ProjectUserServiceImpl implements ProjectUserService {

	@Resource
	private ProjectUserDao projectUserDao;
	@Override
	public List<ProjectUser> findByMap(Map<String, Object> map) {
		return projectUserDao.findByMap(map);
	}

	
	
}
