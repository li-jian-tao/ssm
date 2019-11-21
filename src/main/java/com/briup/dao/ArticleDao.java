package com.briup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.briup.bean.Article;

@Mapper
public interface ArticleDao {
	List<Article> findByUserId(Integer uid);
	List<Article> findByCategoryId(Integer cid);
	List<Article> findByArticleTitle(String title);
	List<Article> findByArticleAuthor(String nickname);
	Article findByArticle(Integer id);
	void updateByClickTimes(Integer times,Integer id);
	void addByArticle(Article article);
}
