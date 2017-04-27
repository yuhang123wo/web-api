package com.yuhang.domain;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2017-4-27 11:22:38
 */
public class Menu extends Entity {

	private static final long serialVersionUID = -1673373441981495427L;
	private String menuName; // 菜单名称
	private String menuUrl; // 菜单链接
	private String roleIds; // 角色可见集合 （ID之间以逗号分隔）
	private String parentId;
	private String iconRemark;
	private String type; // 前端菜单、后台菜单
	private int status;
	private int sequence; // 排序，越大越靠前

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getRoleIds() {
		return this.roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getIconRemark() {
		return this.iconRemark;
	}

	public void setIconRemark(String iconRemark) {
		this.iconRemark = iconRemark;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

}
