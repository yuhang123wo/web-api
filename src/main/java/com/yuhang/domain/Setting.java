package com.yuhang.domain;

/**
 * @类说明： 
 * 
 * @version 1.0
 * @创建时间：2017-4-27 11:22:38
 */
public class Setting extends Entity {

	private static final long serialVersionUID = 6453628669586608097L;
	private String mkey;
    private String value;
    private String remark;
    private int status;
    private String type;
    private int canDel;

    public String getMkey() {
        return this.mkey;
    }

    public void setMkey(String mkey) {
        this.mkey = mkey;
    }
    
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public int getCanDel() {
        return this.canDel;
    }

    public void setCanDel(int canDel) {
        this.canDel = canDel;
    }

    
}
