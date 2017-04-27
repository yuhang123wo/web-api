package com.yuhang.domain;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2017-4-27 11:22:38
 */
public class Log extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2629824485502254324L;
	private int status;
	private int sequence; // 排序，越大越靠前
	private String modelClass;
	private String modelName;
	private String type;
	private String updateBy; // 操作人
	private String remark;
	private String content;
	private String identy; // 数据唯一主键

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

	public String getModelClass() {
		return this.modelClass;
	}

	public void setModelClass(String modelClass) {
		this.modelClass = modelClass;
	}

	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getIdenty() {
		return this.identy;
	}

	public void setIdenty(String identy) {
		this.identy = identy;
	}

}
