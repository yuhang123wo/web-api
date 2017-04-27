package com.yuhang.domain;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2017-4-27 11:22:38
 */
public class ProjectUser extends Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7348433381700753393L;
	private int status;
	private int sequence;
	private int projectId;
	private int userId;
	private int addModule; // 是否可以添加模块
	private int delModule; // 是否可以删除模块
	private int modModule; // 是否可是修改模块
	private int addInter; // 是否可以添加接口
	private int delInter; // 是否可以删除接口
	private int modInter; // 是否可以修改接口
	private int addArticle; // 是否可以添加文章
	private int delArticle; // 是否可以删除文章
	private int modArticle; // 是否可以修改文章
	private int addSource; // 是否可以添加资源
	private int delSource; // 是否可以删除资源
	private int modSource; // 是否可以修改资源
	private int addDict; // 是否可以添加数据字典
	private int delDict; // 是否可以删除数据字典
	private int modDict; // 是否可以修改数据字典
	private String userEmail;
	private String userName;
	private int addError; // 是否可以添加错误码
	private int delError; // 是否可以删除错误码
	private int modError; // 是否可以修改错误码

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

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getAddModule() {
		return this.addModule;
	}

	public void setAddModule(int addModule) {
		this.addModule = addModule;
	}

	public int getDelModule() {
		return this.delModule;
	}

	public void setDelModule(int delModule) {
		this.delModule = delModule;
	}

	public int getModModule() {
		return this.modModule;
	}

	public void setModModule(int modModule) {
		this.modModule = modModule;
	}

	public int getAddInter() {
		return this.addInter;
	}

	public void setAddInter(int addInter) {
		this.addInter = addInter;
	}

	public int getDelInter() {
		return this.delInter;
	}

	public void setDelInter(int delInter) {
		this.delInter = delInter;
	}

	public int getModInter() {
		return this.modInter;
	}

	public void setModInter(int modInter) {
		this.modInter = modInter;
	}

	public int getAddArticle() {
		return this.addArticle;
	}

	public void setAddArticle(int addArticle) {
		this.addArticle = addArticle;
	}

	public int getDelArticle() {
		return this.delArticle;
	}

	public void setDelArticle(int delArticle) {
		this.delArticle = delArticle;
	}

	public int getModArticle() {
		return this.modArticle;
	}

	public void setModArticle(int modArticle) {
		this.modArticle = modArticle;
	}

	public int getAddSource() {
		return this.addSource;
	}

	public void setAddSource(int addSource) {
		this.addSource = addSource;
	}

	public int getDelSource() {
		return this.delSource;
	}

	public void setDelSource(int delSource) {
		this.delSource = delSource;
	}

	public int getModSource() {
		return this.modSource;
	}

	public void setModSource(int modSource) {
		this.modSource = modSource;
	}

	public int getAddDict() {
		return this.addDict;
	}

	public void setAddDict(int addDict) {
		this.addDict = addDict;
	}

	public int getDelDict() {
		return this.delDict;
	}

	public void setDelDict(int delDict) {
		this.delDict = delDict;
	}

	public int getModDict() {
		return this.modDict;
	}

	public void setModDict(int modDict) {
		this.modDict = modDict;
	}

	public String getUserEmail() {
		return this.userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAddError() {
		return this.addError;
	}

	public void setAddError(int addError) {
		this.addError = addError;
	}

	public int getDelError() {
		return this.delError;
	}

	public void setDelError(int delError) {
		this.delError = delError;
	}

	public int getModError() {
		return this.modError;
	}

	public void setModError(int modError) {
		this.modError = modError;
	}

}
