package com.briup.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.briup.bean.Article;
import com.briup.bean.Category;
import com.briup.bean.User;
import com.briup.bean.UserCollection;
import com.briup.bean.UserLike;
import com.briup.bean.UserReport;
import com.briup.service.ArtcleServiceImpl;
import com.briup.service.Impl.IArticleService;
import com.briup.service.Impl.IUseLikeService;
import com.briup.service.Impl.IUserCollectionService;
import com.briup.service.Impl.IUserReportService;
import com.github.pagehelper.PageInfo;

@Controller
public class ArticleController {

	@Autowired
	private IArticleService service;
	
	@Autowired
	private IUseLikeService userlikeservice;
	
	@Autowired
	private IUserCollectionService usercollectionservice;
	
	@Autowired
	private IUserReportService userreportservice;

	@RequestMapping("acticleShow")
	public String acticleShow(Integer category_id, 
			HttpSession session,HttpServletRequest request) {
		List<Article> list = service.findByCategoryId(category_id);
		session.setAttribute("list", list);
		return "user/acticleShow";
	}

	@RequestMapping("findArticlesByTitle")
	public String acticleLike1(String title,
			HttpSession session,HttpServletRequest request) {
		List<Article> list = service.findByArticleTitle(title);
		session.setAttribute("list", list);
		return "user/acticleShow";
	}
	
	@RequestMapping("findArticlesByNickname")
	public String acticleLike2(String nickname,
			HttpSession session,HttpServletRequest request) {
		List<Article> list = service.findByArticleAuthor(nickname);
		session.setAttribute("list", list);
		return "user/acticleShow";
	}
	
	@RequestMapping("articleDetail")
	public String articleDetail(Integer detail_id,
			HttpSession session,HttpServletRequest request) {
		Article article = service.findByArticle(detail_id);
		service.updateByClickTimes(article.getClickTimes(), detail_id);
		User user = (User) session.getAttribute("user");
		UserLike userLike = userlikeservice.findByUserLike(user.getId(), article.getId());
		UserCollection userCollection = usercollectionservice.findByUserCollection(user.getId(), article.getId());
		UserReport userReport = userreportservice.findByUserReport(user.getId(), article.getId());
		session.setAttribute("userLike", userLike);
		session.setAttribute("userCollection", userCollection);
		session.setAttribute("userReport", userReport);
		session.setAttribute("article", article);
		return "user/articleDetail";
	}
	
	@RequestMapping("showUserArticles")
	public String showUserArticles(Integer id,
			HttpSession session,HttpServletRequest request) {
		User user = (User) session.getAttribute("user");
		PageInfo<Article> pageInfo = service.findByUserPage(user.getId(), id);
		session.setAttribute("nextpage", pageInfo.getNextPage());
		session.setAttribute("prepage", pageInfo.getPrePage());
		session.setAttribute("pagecount", pageInfo.getNavigatepageNums());
		session.setAttribute("page", id);
		session.setAttribute("list", pageInfo.getList());
		return "user/myrelease";	
	}
	
	@RequestMapping("addByArticle")
	public String addByArticle(Article article,Integer id,Integer category_id,MultipartFile fileToUpload,
			HttpSession session,HttpServletRequest request) throws Exception {
		User user = (User) session.getAttribute("user");
		Category category = new Category();
		category.setId(category_id);
		article.setUser(user);
		article.setCategory(category);
		service.addByArticle(article,fileToUpload);
		String fileName = fileToUpload.getName();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		PageInfo<Article> pageInfo = service.findByUserPage(user.getId(), id);
		session.setAttribute("nextpage", pageInfo.getNextPage());
		session.setAttribute("prepage", pageInfo.getPrePage());
		session.setAttribute("pagecount", pageInfo.getNavigatepageNums());
		session.setAttribute("page", id);
		session.setAttribute("list", pageInfo.getList());
		return "user/myrelease";
	}
	
}
