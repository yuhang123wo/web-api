package com.yuhang.controller.admin;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yuhang.domain.Project;
import com.yuhang.service.ProjectService;

@Controller
@RequestMapping("project")
public class ProjectController {

	@Resource
	private ProjectService projectService;

	@RequestMapping("listView")
	public String listViewProject() {
		return "project.list";
	}

	@RequestMapping("list")
	@ResponseBody
	public Object listProject(HttpServletRequest request) {
		int pageNo = ServletRequestUtils.getIntParameter(request, "pageNo", 1);
		int pageSize = ServletRequestUtils.getIntParameter(request, "pageSize", 20);
		Map<String, Object> map = new HashMap<String, Object>();
		Page<Project> p= projectService.loadProjectByParams(map, pageNo, pageSize);
		return p;
	}
}
