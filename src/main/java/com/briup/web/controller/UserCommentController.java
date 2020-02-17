package com.briup.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Article;
import com.briup.bean.User;
import com.briup.bean.UserComment;
import com.briup.bean.UserCommentary;
import com.briup.service.Impl.IArticleService;
import com.briup.service.Impl.IUserCommentService;
import com.briup.service.Impl.IUserCommentaryService;

@Controller
public class UserCommentController {

	@Autowired
	private IUserCommentService service;
	
	@Autowired
	private IUserCommentaryService uservice;
	
	@Autowired
	private IArticleService aservice;
	
	@RequestMapping("addUserComment")
	public String addUserComment(Integer articleid,String commenttext,
			HttpSession session,HttpServletRequest request) {
		System.out.println("article_id"+articleid);
		User user = (User) session.getAttribute("user");
		Article article = aservice.findByArticle(articleid);
		System.out.println("用户评论"+article);
		UserComment userComment = new UserComment();
		userComment.setCommentContent(commenttext);
		userComment.setUser(user);
		userComment.setArticle(article);
		service.addUserComment(userComment);
		List<UserCommentary> alluserComment = uservice.allUserCommentary(user.getId(),articleid);
		session.setAttribute("userComment", alluserComment);
		return "user/articleDetail";
	}
	
//	@RequestMapping("showUserComment") 
//	public String showUserComment(Integer state,Integer articleId, 
//			HttpSession session,HttpServletRequest request) {
//		System.out.println("article_id"+articleId); 
//		User user = (User)session.getAttribute("user"); 
//		Article article = aservice.findByArticle(articleId); 
//		System.out.println(article);
//		UserCollection userCollection = new UserCollection();
//		userCollection.setState(state); userCollection.setUser(user);
//		userCollection.setArticle(article);
//		service.updateUserCollection(userCollection);
//		session.setAttribute("userCollection", userCollection); 
//		return "user/articleDetail"; 
//	}
}
