package com.yuhang.domain;

import java.util.Date;
/**
 * @类说明： 
 * 
 * @version 1.0
 * @创建时间：2017-4-27 11:22:38
 */
public class Interface extends Entity {

	private static final long serialVersionUID = 1L;
    
    private String url; // api链接
    private String method; //  请求方式
    private String param; // 参数列表
    private String paramRemark; // 请求参数备注
    private String requestExam; // 请求示例
    private String responseParam; // 返回参数说明
    private String errorList; // 接口错误码列表
    private String trueExam; // 正确返回示例
    private String falseExam; // 错误返回示例
    private int status; // 是否可用;0不可用；1可用;-1 删除
    private String moduleId; // 所属模块ID
    private String interfaceName; // 接口名
    private String remark;
    private String errors; // 错误码、错误码信息
    private String updateBy;
    private Date updateTime;
    private String version; // 版本号
    private int sequence; // 排序，越大越靠前
    private String header;
    private String fullUrl;
	private int monitorType; // 监控类型，多选：Network("网络异常",1),Include("包含指定字符串",2),NotInclude("不包含指定字符串",3),NotEqual("不等于指定字符串",4);
    private String monitorText; // 监控比较内容
    private String monitorEmails;
    private int isTemplate; // 是否是模板

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    
    public String getParam() {
        return this.param;
    }

    public void setParam(String param) {
        this.param = param;
    }
    
    public String getParamRemark() {
        return this.paramRemark;
    }

    public void setParamRemark(String paramRemark) {
        this.paramRemark = paramRemark;
    }
    
    public String getRequestExam() {
        return this.requestExam;
    }

    public void setRequestExam(String requestExam) {
        this.requestExam = requestExam;
    }
    
    public String getResponseParam() {
        return this.responseParam;
    }

    public void setResponseParam(String responseParam) {
        this.responseParam = responseParam;
    }
    
    public String getErrorList() {
        return this.errorList;
    }

    public void setErrorList(String errorList) {
        this.errorList = errorList;
    }
    
    public String getTrueExam() {
        return this.trueExam;
    }

    public void setTrueExam(String trueExam) {
        this.trueExam = trueExam;
    }
    
    public String getFalseExam() {
        return this.falseExam;
    }

    public void setFalseExam(String falseExam) {
        this.falseExam = falseExam;
    }
    
    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    public String getModuleId() {
        return this.moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }
    
    public String getInterfaceName() {
        return this.interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }
    
    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getErrors() {
        return this.errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
    
    public String getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }
    
    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    
    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
    
    public int getSequence() {
        return this.sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
    
    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
    
    public String getFullUrl() {
        return this.fullUrl;
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }
    
    public int getMonitorType() {
        return this.monitorType;
    }

    public void setMonitorType(int monitorType) {
        this.monitorType = monitorType;
    }
    
    public String getMonitorText() {
        return this.monitorText;
    }

    public void setMonitorText(String monitorText) {
        this.monitorText = monitorText;
    }
    
    public String getMonitorEmails() {
        return this.monitorEmails;
    }

    public void setMonitorEmails(String monitorEmails) {
        this.monitorEmails = monitorEmails;
    }
    
    public int getIsTemplate() {
        return this.isTemplate;
    }

    public void setIsTemplate(int isTemplate) {
        this.isTemplate = isTemplate;
    }
    
}
