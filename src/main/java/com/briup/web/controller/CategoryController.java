package com.briup.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Category;
import com.briup.service.Impl.ICategoryService;

@Controller
public class CategoryController {

//	@Autowired
//	private ICategoryService service;
//	
//	@RequestMapping("showCategory")
//	public String Categoryshow(
//			HttpSession session,HttpServletRequest request) {
//		List<Category> category = service.findByCategory();
//		session.setAttribute("category", category);
//		return "index";
//	}
}
