package com.briup.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Article;
import com.briup.bean.User;
import com.briup.bean.UserCollection;
import com.briup.service.Impl.IArticleService;
import com.briup.service.Impl.IUserCollectionService;
import com.briup.util.saverPage;
import com.github.pagehelper.PageInfo;

@Controller
public class UserCollectionController {

	@Autowired
	private IUserCollectionService service;
	
	@Autowired
	private IArticleService aservice;
	
	@RequestMapping("addUserCollectionState")
	public String addUserCollection(Integer articleId,
			HttpSession session,HttpServletRequest request) {
		System.out.println("article_id"+articleId);
		User user = (User) session.getAttribute("user");
		Article article = aservice.findByArticle(articleId);
		System.out.println(article);
		UserCollection userCollection = new UserCollection();
		userCollection.setUser(user);
		userCollection.setArticle(article);
		service.addUserCollection(userCollection);
		session.setAttribute("userCollection", userCollection);
		return "user/articleDetail";
	}
	
	@RequestMapping("changeUserCollectionState")
	public String updateUserCollection(Integer state,Integer articleId,
			HttpSession session,HttpServletRequest request) {
		System.out.println("article_id"+articleId);
		User user = (User) session.getAttribute("user");
		Article article = aservice.findByArticle(articleId);
		System.out.println(article);
		UserCollection userCollection = new UserCollection();
		userCollection.setState(state);
		userCollection.setUser(user);
		userCollection.setArticle(article);
		service.updateUserCollection(userCollection);
		session.setAttribute("userCollection", userCollection);
		return "user/articleDetail";		
	}
	
	@RequestMapping("showUserCollections")
	public String showUserCollections(Integer id,
			HttpSession session,HttpServletRequest request) {
		User user = (User) session.getAttribute("user");
		PageInfo<UserCollection> pageInfo = service.findAllUserCollection(user.getId(), id);
		saverPage saverPage = new saverPage();
		Map<String, Integer> map = saverPage.StartAndEnd(pageInfo, id, 5);
		session.setAttribute("start", map.get("start"));
		session.setAttribute("end", map.get("end"));
		session.setAttribute("nextpage", pageInfo.getNextPage());
		session.setAttribute("prepage", pageInfo.getPrePage());
		session.setAttribute("pagecount", pageInfo.getNavigatepageNums());
		session.setAttribute("page", id);
		session.setAttribute("list", pageInfo.getList());
		return "user/mycollect";			
	}
}
