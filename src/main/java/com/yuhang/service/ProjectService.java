package com.yuhang.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;

import com.yuhang.domain.Project;

public interface ProjectService {

	List<Project> findProjectByMap(Map<String, Object> map);
	
	Page<Project> loadProjectByParams(Map<String, Object> map,int pageNo,int pageSize);
}
