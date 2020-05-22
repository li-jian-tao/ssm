package com.briup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.briup.bean.Article;

@Mapper
public interface ArticleDao {
	List<Article> allArticle(); 
	List<Article> findByHotArticle();
	List<Article> findByUserId(Integer uid);
	List<Article> findByCategoryId(Integer cid);
	List<Article> findByArticleTitle(String title);
	List<Article> findByArticleAuthor(String nickname);
	List<Article> AllArticle(Integer cid,Integer state,String cname);
	Article findByArticle(Integer id);
	void updateByClickTimes(Integer times,Integer state,Integer id);
	void updateByReportNum(Integer num,Integer id);
	void addByArticle(Article article);
	int selectArticleId();
}
