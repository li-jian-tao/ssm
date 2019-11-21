package com.briup.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Article;
import com.briup.bean.User;
import com.briup.bean.UserReport;
import com.briup.service.Impl.IArticleService;
import com.briup.service.Impl.IUserReportService;

@Controller
public class UserReportController {
	@Autowired
	private IUserReportService service;
	
	@Autowired
	private IArticleService aservice;
	
	@RequestMapping("addUserReportState")
	public String addUserReport(Integer articleId,String[] box,String content,
			HttpSession session,HttpServletRequest request) {
		System.out.println("article_id"+articleId);
		User user = (User) session.getAttribute("user");
		Article article = aservice.findByArticle(articleId);
		System.out.println(article);
		UserReport userReport = new UserReport();
		if(box!=null&&content!=null) {			
			userReport.setUser(user);
			userReport.setArticle(article);
			userReport.setReportContent(content);
			userReport.setState(1);
			service.addUserReport(userReport,box,user,article);
		} else {
			session.setAttribute("msg", "内容不能为空");
		}
		session.setAttribute("userReport", userReport);
		return "index";
	}
}
