package com.yuhang.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yuhang.domain.Project;
import com.yuhang.domain.ProjectUser;
import com.yuhang.domain.User;
import com.yuhang.service.ProjectService;
import com.yuhang.service.ProjectUserService;
import com.yuhang.service.RoleService;
import com.yuhang.util.Const;
import com.yuhang.util.Tools;

public class LoginInfoDto implements Serializable {

	private static final long serialVersionUID = -3080443296964367848L;
	private String userName;
	private String trueName;
	private String authStr;// 权限，由用户权限、角色拼接而成
	private String roleId;
	private long id;
	private byte type;
	private String email;
	private Map<Long, ProjectUser> projects = new HashMap<Long, ProjectUser>();

	public LoginInfoDto(User user, RoleService roleService, ProjectService projectService,
			ProjectUserService projectUserService) {
		this.userName = user.getUserName();
		this.trueName = user.getTrueName();
		this.roleId = user.getRoleId();
		this.id = user.getId();
		this.type = user.getType();
		this.email = user.getEmail();

		StringBuilder sb = new StringBuilder(",");
		// 将用户的自己的模块添加至权限中
		List<Project> myProjects = projectService.findProjectByMap(Tools.getMap("userId",
				user.getId()));
		for (Project project : myProjects) {
			sb.append(Const.AUTH_PROJECT + project.getId() + ",");
		}


		this.authStr = sb.toString();
	}

	public String getUserName() {
		return userName;
	}

	public String getTrueName() {
		return trueName;
	}

	public String getAuthStr() {
		if (authStr == null)
			return "";
		return authStr;
	}

	public String getRoleId() {
		return roleId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<Long, ProjectUser> getProjects() {
		return projects;
	}

	public void setProjects(Map<Long, ProjectUser> projects) {
		this.projects = projects;
	}

}
