package com.briup.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Article;
import com.briup.bean.User;
import com.briup.bean.UserLike;
import com.briup.service.Impl.IArticleService;
import com.briup.service.Impl.IUserLikeService;
import com.briup.util.saverPage;
import com.github.pagehelper.PageInfo;

@Controller
public class UserLikeController {

	@Autowired
	private IUserLikeService service;
	
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
	
	@RequestMapping("showUserLikes")
	public String showUserLikes(Integer id,
			HttpSession session,HttpServletRequest request) {
		User user = (User) session.getAttribute("user");
		PageInfo<UserLike> pageInfo = service.findAllUserLike(user.getId(), id);
		saverPage saverPage = new saverPage();
		Map<String, Integer> map = saverPage.StartAndEnd(pageInfo, id, 5);
		session.setAttribute("start", map.get("start"));
		session.setAttribute("end", map.get("end"));
		session.setAttribute("nextpage", pageInfo.getNextPage());
		session.setAttribute("prepage", pageInfo.getPrePage());
		session.setAttribute("pagecount", pageInfo.getNavigatepageNums());
		session.setAttribute("page", id);
		session.setAttribute("list", pageInfo.getList());
		return "user/mylike";			
	}
}
