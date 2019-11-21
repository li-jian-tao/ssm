package com.briup.service;

import java.io.File;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.briup.bean.Article;
import com.briup.dao.ArticleDao;
import com.briup.service.Impl.IArticleService;
import com.briup.util.dateTime;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ArtcleServiceImpl implements IArticleService{

	@Value("${videofile.upload-path}")
	private String path;
	
	@Autowired
	private ArticleDao dao;
	
	private dateTime date = new dateTime();
	
	@Override
	public List<Article> findByCategoryId(Integer cid) {
		List<Article> list = dao.findByCategoryId(cid);
		System.out.println("caeshi");
		return list;
	}

	@Override
	public List<Article> findByArticleTitle(String title) {
		List<Article> list = dao.findByArticleTitle(title);
		return list;
	}

	@Override
	public List<Article> findByArticleAuthor(String nickname) {
		List<Article> list = dao.findByArticleAuthor(nickname);
		return list;
	}

	@Override
	public Article findByArticle(Integer id) {
		Article article = dao.findByArticle(id);
		return article;
	}

	@Override
	public void updateByClickTimes(Integer times, Integer id) {
		times++;
		dao.updateByClickTimes(times, id);
	}

	@Override
	public List<Article> findByUserId(Integer uid) {
		List<Article> list = dao.findByUserId(uid);
		return list;
	}
	
	@Override
	public PageInfo<Article> findByUserPage(Integer uid,Integer page) {
		Page<Article> p = PageHelper.startPage(page,3);
		System.out.println(page);
		List<Article> list = dao.findByUserId(uid);
		PageInfo<Article> pageInfo = new PageInfo<Article>(list);
		System.out.println(pageInfo.getSize()+"hang");
		return pageInfo;
	}

	@Override
	public void addByArticle(Article article,MultipartFile fileToUpload) throws Exception{
		Timestamp nowDate = date.NowDate();
		System.out.println("时间打印"+nowDate);	
		article.setReleaseDate(nowDate);
		article.setClickTimes(0);
		System.out.println(path);
		if(!fileToUpload.isEmpty()) {
			String filename = System.currentTimeMillis()+fileToUpload.getOriginalFilename();
			System.out.println(filename);
			fileToUpload.transferTo(new File(path+"\\"+filename));
			System.out.println(path+"1");
			article.setContent(filename);
			dao.addByArticle(article);
		}
		System.out.println("结束"+article);
	}

}
