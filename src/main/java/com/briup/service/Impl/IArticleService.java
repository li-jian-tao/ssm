package com.briup.service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.briup.bean.Article;
import com.github.pagehelper.PageInfo;

public interface IArticleService {
	public Map<Integer,List<Article>> allArticle(); 
	public List<Article> findByHotArticle();
	public List<Article> findByUserId(Integer uid);
	public List<Article> findByCategoryId(Integer cid);
	public List<Article> findByArticleTitle(String title);
	public List<Article> findByArticleAuthor(String nickname);
	public PageInfo<Article> AllArticle(Integer cid,Integer state,String cname,Integer page);
	public PageInfo<Article> findByUserPage(Integer uid,Integer page);
	public Article findByArticle(Integer id);
	public void updateByClickTimes(Integer times, Integer state, Integer id);
	public void updateByReportNum(Integer num,Integer id);
	public void addByArticle(Article article,MultipartFile fileToUpload)throws Exception;
	public int selectArticleId();
}
