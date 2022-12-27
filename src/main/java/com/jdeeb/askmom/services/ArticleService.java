package com.jdeeb.askmom.services;

import java.util.List;

import com.jdeeb.askmom.rest.models.beans.ArticleBean;

public interface ArticleService {

	ArticleBean saveArticle(ArticleBean bean);
	ArticleBean getArticleById(long id);
	List<ArticleBean> getAllArticles();
}
