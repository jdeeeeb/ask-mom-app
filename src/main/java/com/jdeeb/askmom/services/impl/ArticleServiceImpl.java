package com.jdeeb.askmom.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdeeb.askmom.db.entities.ArticleEntity;
import com.jdeeb.askmom.db.repository.ArticleRepository;
import com.jdeeb.askmom.rest.models.beans.ArticleBean;
import com.jdeeb.askmom.services.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleRepository articleRepository;

	@Override
	public ArticleBean saveArticle(ArticleBean bean) {
		ArticleEntity entity = new ArticleEntity();
		entity.setSubject(bean.getSubject());
		entity.setBody(bean.getBody());
		entity.setKeywords(bean.getKeywords());
		entity.setArticleImg(bean.getArticleImg());
		entity.setCreateDate(bean.getCreateDate());
		entity.setLastModifyDate(bean.getLastModifyDate());
		
		entity = articleRepository.save(entity);
		if(entity != null)
			return entity.toBean();
		else
			return null;
	}

	@Override
	public ArticleBean getArticleById(long id) {
		ArticleEntity entity = articleRepository.findArticleById(id).orElse(null);
		return entity != null ? entity.toBean() : null;
	}

	@Override
	public List<ArticleBean> getAllArticles() {
		List<ArticleEntity> articles = articleRepository.findAll();
		if(articles != null && articles.size() > 0) {
			List<ArticleBean> beans = new ArrayList<>();
			articles.forEach(article -> {
				beans.add(article.toBean());
			});
			return beans;
		}
		return null;
	}
	
	
}
