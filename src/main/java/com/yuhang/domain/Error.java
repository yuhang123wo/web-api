package com.yuhang.domain;

import java.util.Date;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2017-4-27 11:22:37
 */
public class Error extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -188582427191769145L;
	private String errorCode; // 错误码编码
	private String errorMsg; // 错误码描述
	private String moduleId;
	private Date createTime;
	private int status; // 状态
	private int sequence; // 排序，越大越靠前

	public String getErrorCode() {
		return this.errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return this.errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(String moduleId) {
		this.moduleId = moduleId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
