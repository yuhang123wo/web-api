package com.yuhang.domain;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2017-4-27 11:22:38
 */
public class Module extends Entity {

	private static final long serialVersionUID = 1L;

	private String name; // 所属模块名称
	private int status;
	private int sequence; // 排序，越大越靠前
	private String url; // 模块地址
	private int canDelete; // 1：可删除，0：不可删除
	private String remark; // 备注
	private int userId;
	private int projectId;
	private int templateId; // 接口模板ID

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getSequence() {
		return this.sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getCanDelete() {
		return this.canDelete;
	}

	public void setCanDelete(int canDelete) {
		this.canDelete = canDelete;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getTemplateId() {
		return this.templateId;
	}

	public void setTemplateId(int templateId) {
		this.templateId = templateId;
	}

}
