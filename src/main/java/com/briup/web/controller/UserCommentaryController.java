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
public class UserCommentaryController {

	@Autowired
	private IUserCommentaryService service;
	
	@Autowired
	private IUserCommentService uservice;
	
	@Autowired
	private IArticleService aservice;
	
	@RequestMapping("addAndUpdateUserComment")
	public String addAndUpdateUserComment(Integer usercommentid,Integer articleid,Integer state,
			HttpSession session,HttpServletRequest request) {
		System.out.println("评论表id="+usercommentid+"文章id="+articleid+"状态="+state);
		User user = (User) session.getAttribute("user");
		UserCommentary commentary = service.findByUserCommentary(user.getId(),articleid,usercommentid);
		UserComment comment = uservice.findByUserComment(usercommentid);
		Article article = aservice.findByArticle(articleid);
		System.out.println(comment);
		System.out.println("用户评论点赞表"+commentary);
		UserCommentary userCommentary = new UserCommentary();
		userCommentary.setUser(user);
		userCommentary.setArticle(article);
		userCommentary.setUserComment(comment);
		if(commentary==null) {
			service.addUserCommentary(userCommentary);
			System.out.println("添加了");
		} else {
			userCommentary.setCommentaryState(state);
			service.updateUserCommentaryState(userCommentary);
			System.out.println("修改了");
		}
		uservice.updateUserCommentTimes(comment, userCommentary);
		System.out.println("加1了");
		List<UserCommentary> alluserComment = service.allUserCommentary(user.getId(),articleid);
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
