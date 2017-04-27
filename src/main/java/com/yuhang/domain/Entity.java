package com.yuhang.domain;

import java.util.Date;

@SuppressWarnings("serial")
public abstract class Entity implements java.io.Serializable {

	private Long id;
	private Date createTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
