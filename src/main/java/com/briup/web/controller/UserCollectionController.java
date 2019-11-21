package com.briup.web.controller;

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
}
