package com.crawler.dao;

import java.util.List;

import com.crawler.po.ArticlePo;

public interface ArticleDao {
	
	List<ArticlePo> listArticle(ArticlePo po);

}
