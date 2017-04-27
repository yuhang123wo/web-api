package com.yuhang.domain;

import java.util.Date;

/**
 * @类说明： 
 * 
 * @version 1.0
 * @创建时间：2017-4-27 11:22:38
 */
public class Source extends Entity {

	private static final long serialVersionUID = 6418801547826057823L;
	private int sequence;
    private int status;
    private String name; // 资源名称
    private Date updateTime;
    private String moduleId; // 模块ID
    private String remark; // 备注
    private String filePath; // 文件目录

    
    public int getSequence() {
        return this.sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
    
    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public String getModuleId() {
        return this.moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
    
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
    
}
