package com.yuhang.domain;

/**
 * @类说明：
 * 
 * @version 1.0
 * @创建时间：2017-4-27 11:22:37
 */
public class Article extends Entity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6443535155389499981L;
	private String name;
	private String brief;
	private String content;
	private int click;
	private String type;
	private int status;
	private int moduleId;
	private String mkey; // key，唯一键，页面唯一标识
	private int canDelete; // 是否可删除，可修key，默认可以
	private String category;
	private int canComment;
	private int commentCount;
	private int sequence; // 排序，越大越靠前
	private String markdown;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrief() {
		return this.brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getClick() {
		return this.click;
	}

	public void setClick(int click) {
		this.click = click;
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

	public int getModuleId() {
		return this.moduleId;
	}

	public void setModuleId(int moduleId) {
		this.moduleId = moduleId;
	}

	public String getMkey() {
		return this.mkey;
	}

	public void setMkey(String mkey) {
		this.mkey = mkey;
	}

	public int getCanDelete() {
		return this.canDelete;
	}

	public void setCanDelete(int canDelete) {
		this.canDelete = canDelete;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCanComment() {
		return this.canComment;
	}

	public void setCanComment(int canComment) {
		this.canComment = canComment;
	}

	public int getCommentCount() {
		return this.commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getSequence() {
		return this.sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getMarkdown() {
		return this.markdown;
	}

	public void setMarkdown(String markdown) {
		this.markdown = markdown;
	}

}
