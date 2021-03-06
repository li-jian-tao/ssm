package com.briup.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.briup.bean.Article;
import com.briup.dao.ArticleDao;
import com.briup.service.Impl.IArticleService;
import com.briup.util.dateTime;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ArtcleServiceImpl implements IArticleService{

	@Value("${videofile.upload-path}")
	private String path;
	
	@Autowired
	private ArticleDao dao;
	
	@Override
	public List<Article> findByHotArticle() {
		List<Article> hotArticle = dao.findByHotArticle();
		Collections.reverse(hotArticle);
		return hotArticle;
	}
	
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
	public void updateByReportNum(Integer num, Integer id) {
		dao.updateByReportNum(num, id);
	}

	@Override
	public void updateByClickTimes(Integer times,Integer state, Integer id) {
		if(times != null) {
			times++;
		} 
		System.out.println(times+"-----"+state);
		dao.updateByClickTimes(times, state, id);
	}

	@Override
	public List<Article> findByUserId(Integer uid) {
		List<Article> list = dao.findByUserId(uid);
		return list;
	}
	
	@Override
	public PageInfo<Article> AllArticle(Integer cid, Integer state, String cname,Integer page) {
		PageHelper.startPage(page,10);
		System.out.println("栏目号码"+cid+"栏目状态"+state+"所输入的名字"+cname+"页数"+page);
		List<Article> allArticle = dao.AllArticle(cid, state, cname);
		PageInfo<Article> pageInfo = new PageInfo<Article>(allArticle);
		System.out.println(pageInfo.getSize()+"hang");
		return pageInfo;
	}

	
	@Override
	public PageInfo<Article> findByUserPage(Integer uid,Integer page) {
		PageHelper.startPage(page,5);
		System.out.println(page);
		List<Article> list = dao.findByUserId(uid);
		PageInfo<Article> pageInfo = new PageInfo<Article>(list);
		System.out.println(pageInfo.getSize()+"hang");
		return pageInfo;
	}

	@Override
	public void addByArticle(Article article,MultipartFile fileToUpload) throws Exception{
		System.out.println("时间打印"+dateTime.NowDate());	
		article.setReleaseDate(dateTime.NowDate());
		article.setClickTimes(0);
		article.setState(0);
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

	@Override
	public int selectArticleId() {
		int id = dao.selectArticleId();
		return id;
	}

	@Override
	public Map<Integer,List<Article>> allArticle() {
		
		List<Article> allArticle = dao.allArticle();
		Map<Integer,List<Article>> map = new HashMap<>();
		for (Article article : allArticle) {
			Integer id = article.getUser().getId();
			if(map.keySet().contains(id)) {
				map.get(id).add(article);
			} else {
				List<Article> arrayList = new ArrayList<>();
				arrayList.add(article);
				map.put(id, arrayList);
			}
		}
		return map;
	}


}
