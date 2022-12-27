package com.jdeeb.askmom.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jdeeb.askmom.rest.models.ResponseModel;
import com.jdeeb.askmom.rest.models.beans.ArticleBean;
import com.jdeeb.askmom.services.ArticleService;

@CrossOrigin("*")
@RestController
@RequestMapping("api/")
public class ArticleController extends BaseController{

	@Autowired
	private ArticleService articleService;
	
	@GetMapping("public/article/all")
	public ResponseEntity<ResponseModel> getAllArticles() {
		List<ArticleBean> articles = articleService.getAllArticles();
		if(articles == null) 
			return ResponseEntity.ok().body(prepareResponse(null, "No Data", "No Articles Found", 404));
		else
			return ResponseEntity.ok().body(prepareResponse(articles, null, null, 200));
	}
	
	@GetMapping("public/article/{id}")
	public ResponseEntity<ResponseModel> getUserById(@PathVariable("id") Long id) {
		ArticleBean article = articleService.getArticleById(id);
		if(article != null && article.getId() > 0)
			return ResponseEntity.ok().body(prepareResponse(article, null, null, 200));
		else
			return ResponseEntity.ok().body(prepareResponse(null, "No Data", "No Users Found", 404));
	}
	
	@PostMapping("article/add")
	public ResponseEntity<ResponseModel> addNewArticle(@RequestBody ArticleBean article) {
		if(article == null)
			return ResponseEntity.ok().body(prepareResponse(null, "Missing Data", "Wrong Input", 404));
		
		article = articleService.saveArticle(article);
		if(article != null && article.getId() > 0)
			return ResponseEntity.ok().body(prepareResponse(article, null, null, 200));
		else
			return ResponseEntity.ok().body(prepareResponse(null, "Error in saving", "Error happened, please try again later", 500));
	}
	
	
}
