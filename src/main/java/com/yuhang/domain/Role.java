package com.yuhang.domain;


/**
 * @类说明： 
 * 
 * @version 1.0
 * @创建时间：2017-4-27 11:22:38
 */
public class Role extends Entity {

	private static final long serialVersionUID = 1L;
    
    private String roleName; // 角色名称
    private String auth;
    private String authName;
    private int status;
    private int sequence; // 排序，越大越靠前

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    public String getAuth() {
        return this.auth;
    }

    public void setAuth(String auth) {
        this.auth = auth;
    }
    
    public String getAuthName() {
        return this.authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
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
