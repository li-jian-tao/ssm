package com.briup.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Article;
import com.briup.bean.User;
import com.briup.bean.UserLike;
import com.briup.service.Impl.IArticleService;
import com.briup.service.Impl.IUseLikeService;

@Controller
public class UserLikeController {

	@Autowired
	private IUseLikeService service;
	
	@Autowired
	private IArticleService aservice;
	
	@RequestMapping("addUserLikeState")
	public String addUserLike(Integer articleId,
			HttpSession session,HttpServletRequest request) {
		System.out.println("article_id"+articleId);
		User user = (User) session.getAttribute("user");
		Article article = aservice.findByArticle(articleId);
		System.out.println(article);
		UserLike userLike = new UserLike();
		userLike.setUser(user);
		userLike.setArticle(article);
		service.addUserLike(userLike);
		session.setAttribute("userLike", userLike);
		return "user/articleDetail";
	}
	
	@RequestMapping("changeUserLikeState")
	public String updateUserLike(Integer state,Integer articleId,
			HttpSession session,HttpServletRequest request) {
		System.out.println("article_id"+articleId);
		User user = (User) session.getAttribute("user");
		Article article = aservice.findByArticle(articleId);
		System.out.println(article);
		UserLike userLike = new UserLike();
		userLike.setState(state);
		userLike.setUser(user);
		userLike.setArticle(article);
		service.updateUserLike(userLike);
		session.setAttribute("userLike", userLike);
		return "user/articleDetail";		
	}
}
