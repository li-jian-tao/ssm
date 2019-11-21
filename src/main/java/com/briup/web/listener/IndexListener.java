package com.briup.web.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.beans.factory.annotation.Autowired;

import com.briup.bean.Category;
import com.briup.service.Impl.IArticleService;
import com.briup.service.Impl.ICategoryService;

@WebListener
public class IndexListener implements ServletContextListener {
	
	@Autowired
	private ICategoryService categoryservice;
	
//	@Autowired
//	private IArticleService articleService;
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("1");
		ServletContext sc = sce.getServletContext();
		List<Category> category = categoryservice.findByCategory();
		List<Category> categorys = categoryservice.findByCategorys();
		sc.setAttribute("category", category);
		sc.setAttribute("categorys", categorys);
		System.out.println("初始化结束");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}
