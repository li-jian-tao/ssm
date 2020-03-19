package com.briup.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Category;
import com.briup.service.Impl.ICategoryService;
import com.briup.util.saverPage;
import com.github.pagehelper.PageInfo;

@Controller
public class CategoryController {

	@Autowired
	private ICategoryService service;
	
	@RequestMapping("showCategory")
	public String Categoryshow(
			HttpSession session,HttpServletRequest request) {
		List<Category> category = service.findByCategory();
		List<Category> categorys = service.findByCategorys();
		session.setAttribute("category", category);
		session.setAttribute("categorys", categorys);
		return "user/category";
	}
	
	@RequestMapping("showAllCategory")
	public String showAllCategory(Integer page,
			HttpSession session,HttpServletRequest request) {
		boolean isSize = false;
		List<Category> categoryParent = service.findByCategoryParent();
		System.out.println(categoryParent.size());
		if(categoryParent.size()<=7) {
			isSize = true;
		} else {
			isSize = false;
		}
		PageInfo<Category> allCategory = service.allCategory(page);
		saverPage saverPage = new saverPage();
		Map<String, Integer> map = saverPage.StartAndEnd(allCategory, page, 5);
		session.setAttribute("start", map.get("start"));
		session.setAttribute("end", map.get("end"));
		session.setAttribute("page", page);
		session.setAttribute("categoryParent", categoryParent);
		session.setAttribute("isSize", isSize);
		session.setAttribute("nextpage", allCategory.getNextPage());
		session.setAttribute("prepage", allCategory.getPrePage());
		session.setAttribute("pagecount", allCategory.getNavigatepageNums());
		session.setAttribute("category", allCategory.getList());
		
		return "admin/categoryMangar";
	}
	
	@RequestMapping("findCategory")
	public String findCategory(Integer id,
			HttpSession session,HttpServletRequest request) {
		Category oneCategory = service.findByCategoryId(id);
		System.out.println(id);
		session.setAttribute("oneid", oneCategory.getId());
		session.setAttribute("onename", oneCategory.getName());
		session.setAttribute("onedescription", oneCategory.getDescription());
		session.setAttribute("onepid", oneCategory.getCate().getId());
		session.setAttribute("onepname", oneCategory.getCate().getName());
		return "admin/categoryMangar";
	}
	
	@RequestMapping("deleteCategory")
	public String deleteCategory(Integer id,
			HttpSession session,HttpServletRequest request) {
		service.deleteByCategory(id);
		return "redirect:/showAllCategory?page=1";
	}
	
	@RequestMapping("addCategory")
	public String addCategory(Category category,Integer parent_id,String pname,
			HttpSession session,HttpServletRequest request) {
		session.removeAttribute("err");
		String err = "";
		Category p0 = service.findByCategoryPid(category.getName());
		Category p1 = service.findByCategoryPid(pname);
		System.out.println(p0+""+p1);
		if(p0 == null) {
			if(pname == null||pname == "") {
				service.addByCategory(category,parent_id);
				err="添加成功";
			} else {
				if(p1!=null) {
					err = "所添加的父级栏目已有";
				} else {					
					Category cate = new Category();
					cate.setName(pname);
					service.addByCategory(cate,-1);
					Category p = service.findByCategoryPid(pname);
					service.addByCategory(category, p.getId());
					err = "添加成功";
				}
			}
		} else {
			err = "所添加的子级栏目已有";
		}
		List<Category> categoryParent = service.findByCategoryParent();
		PageInfo<Category> allCategory = service.allCategory(1);
		saverPage saverPage = new saverPage();
		Map<String, Integer> map = saverPage.StartAndEnd(allCategory, 1, 5);
		session.setAttribute("start", map.get("start"));
		session.setAttribute("end", map.get("end"));
		session.setAttribute("err", err);
		session.setAttribute("page", 1);
		session.setAttribute("categoryParent", categoryParent);
		session.setAttribute("nextpage", allCategory.getNextPage());
		session.setAttribute("prepage", allCategory.getPrePage());
		session.setAttribute("pagecount", allCategory.getNavigatepageNums());
		session.setAttribute("category", allCategory.getList());
		return "admin/index";
	}
	
	@RequestMapping("updateCategory")
	public String updateCategory(Category category,Integer parent_id,String pname,Integer id,
			HttpSession session,HttpServletRequest request) {
		Category cates = new Category();
		System.out.println(category);
		if(pname=="") {			
			cates.setId(parent_id);
		} else {			
			cates.setId(parent_id);
			cates.setName(pname);
			service.updateByCategory(cates);
		}
		category.setCate(cates);
		service.updateByCategory(category);
		List<Category> categoryParent = service.findByCategoryParent();
		PageInfo<Category> allCategory = service.allCategory(1);
		saverPage saverPage = new saverPage();
		Map<String, Integer> map = saverPage.StartAndEnd(allCategory, 1, 5);
		session.setAttribute("start", map.get("start"));
		session.setAttribute("end", map.get("end"));
		session.setAttribute("page", 1);
		session.setAttribute("categoryParent", categoryParent);
		session.setAttribute("nextpage", allCategory.getNextPage());
		session.setAttribute("prepage", allCategory.getPrePage());
		session.setAttribute("pagecount", allCategory.getNavigatepageNums());
		session.setAttribute("category", allCategory.getList());
		return "admin/index";
	}
}
