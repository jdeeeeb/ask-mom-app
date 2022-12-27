package com.jdeeb.askmom.db.entities;

import java.io.Serializable;

import com.jdeeb.askmom.rest.models.beans.ArticleBean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

/**
 * Article Entity part of Article Module
 * @author JDeeb
 * @Date May 10, 2022
 */

@Entity
@Table(name = "App_Articles")
public class ArticleEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private long id;
	private String subject;
	@Lob
	private String body;
	private String articleImg;
	private String keywords;
	private long createDate;
	private long lastModifyDate;
	private UserEntity creator;
	private UserEntity lastModifier;
	/*******************************************/
	public ArticleBean toBean() {
		ArticleBean bean = new ArticleBean();
		
		bean.setId(id);
		bean.setSubject(subject);
		bean.setBody(body);
		bean.setArticleImg(articleImg);
		bean.setKeywords(keywords);
		if(creator != null)
			bean.setCreator(creator.toBean());
		
		if(lastModifier != null)
			bean.setLastModifier(lastModifier.toBean());
		
		return bean;
	}
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
	public UserEntity getCreator() {
		return creator;
	}
	public void setCreator(UserEntity creator) {
		this.creator = creator;
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
	public UserEntity getLastModifier() {
		return lastModifier;
	}
	public void setLastModifier(UserEntity lastModifier) {
		this.lastModifier = lastModifier;
	}
	@Override
	public String toString() {
		return "ArticleEntity [id=" + id + ", subject=" + subject + ", body=" + body + ", articleImg=" + articleImg
				+ ", keywords=" + keywords + ", createDate=" + createDate + ", lastModifyDate=" + lastModifyDate
				+ ", creator=" + creator + ", lastModifier=" + lastModifier + "]";
	}
}
