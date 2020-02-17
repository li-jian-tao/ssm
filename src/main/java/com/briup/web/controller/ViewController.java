package com.briup.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Article;
import com.briup.bean.User;

@Controller
public class ViewController {
	
	@RequestMapping(value = {"login","/"})
	public String login() {
		return "login";		
	}
	
	@RequestMapping(value = {"register"})
	public String register() {
		return "register";		
	}
	
	@RequestMapping(value = {"indexContent"})
	public String indexContent() {
		return "indexContent";		
	}
	
	@RequestMapping(value = {"showCategory"})
	public String Categoryshow() {
		return "user/category";
	}
	
//	@RequestMapping(value = {"showHotArticle"})
//	public String showHotArticle(
//			HttpSession session,HttpServletRequest request) {
//		return "user/hotArticle";
//	}
	
	@RequestMapping(value = {"showUserInfo"})
	public String showuserInfo(HttpSession session) {
		User user = (User) session.getAttribute("user");
		session.setAttribute("user", user);
		return "user/showUserInfo";		
	}
	
	@RequestMapping(value = {"userinfo"})
	public String userinfo(HttpSession session) {
		User user = (User) session.getAttribute("user");
		session.setAttribute("user", user);
		System.out.println("ceshi");
		return "user/userInfo";	
	}
	
	@RequestMapping(value = {"myrelease"})
	public String myrelease(HttpSession session) {
		User user = (User) session.getAttribute("user");
		session.setAttribute("user", user);
		System.out.println("ceshi");
		return "user/myrelease";	
	}
	
	@RequestMapping(value = {"publishpicture"})
	public String publishpicture() {
		return "user/publishpicture";	
	}
	
	@RequestMapping(value = {"publishvideo"})
	public String publishvideo() {
		return "user/publishvideo";	
	}
	
	@RequestMapping(value = {"empty"})
	public String empty() {
		return "user/empty";	
	}
	
}
