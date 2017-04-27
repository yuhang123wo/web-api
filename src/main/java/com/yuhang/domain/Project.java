package com.yuhang.domain;
/**
 * @类说明： 
 * 
 * @version 1.0
 * @创建时间：2017-4-27 11:22:38
 */
public class Project extends Entity {

	private static final long serialVersionUID = 6485535389329131469L;
	private String name; // 项目名称
    private int status; // 2：推荐项目，3，管理员管理项目，4，管理管理&推荐项目
    private int sequence; // 排序，越大越靠前
    private String remark; // 备注
    private int userId;
    private int type; // 1:私有项目，2公开项目，3公开推荐
    private String password;
    private String cover; // 项目封面

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
    
    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getCover() {
        return this.cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }
    
}
