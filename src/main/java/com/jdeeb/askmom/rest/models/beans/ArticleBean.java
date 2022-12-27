package com.jdeeb.askmom.rest.models.beans;

import java.io.Serializable;

public class ArticleBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String subject;
	private String body;
	private String articleImg;
	private String keywords;
	private long createDate;
	private long lastModifyDate;
	private UserBean creator;
	private UserBean lastModifier;
	/*******************************************/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getArticleImg() {
		return articleImg;
	}
	public void setArticleImg(String articleImg) {
		this.articleImg = articleImg;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public long getCreateDate() {
		return createDate;
	}
	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}
	public long getLastModifyDate() {
		return lastModifyDate;
	}
	public void setLastModifyDate(long lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	public UserBean getCreator() {
		return creator;
	}
	public void setCreator(UserBean creator) {
		this.creator = creator;
	}
	public UserBean getLastModifier() {
		return lastModifier;
	}
	public void setLastModifier(UserBean lastModifier) {
		this.lastModifier = lastModifier;
	}
	@Override
	public String toString() {
		return "ArticleBean [id=" + id + ", subject=" + subject + ", body=" + body + ", articleImg=" + articleImg
				+ ", keywords=" + keywords + ", createDate=" + createDate + ", lastModifyDate=" + lastModifyDate
				+ ", creator=" + creator + ", lastModifier=" + lastModifier + "]";
	}
}
