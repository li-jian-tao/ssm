package com.briup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Category;
import com.briup.dao.CategoryDao;
import com.briup.service.Impl.ICategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	private CategoryDao dao;
	
	@Override
	public List<Category> findByCategory() {
		List<Category> category = dao.findByCategory();
		return category;
	}

	@Override
	public List<Category> findByCategorys() {
		List<Category> categorys = dao.findByCategorys();
		return categorys;
	}

	@Override
	public PageInfo<Category> allCategory(Integer page) {
		PageHelper.startPage(page,10);
		List<Category> allCategory = dao.allCategory();
		PageInfo<Category> pageInfo = new PageInfo<Category>(allCategory);
		return pageInfo;
	}

	@Override
	public void addByCategory(Category category,Integer pid) {
		System.out.println(pid);
		if(pid!=-1) {			
			Category cate = new Category();
			cate.setId(pid);
			category.setCate(cate);
		}
		dao.addByCategory(category);
	}

	@Override
	public List<Category> findByCategoryParent() {
		List<Category> categoryParent = dao.findByCategoryParent();
		return categoryParent;
	}

	@Override
	public Category findByCategoryPid(String name) {
		Category pid = dao.findByCategoryPid(name);
		return pid;
	}

	@Override
	public void deleteByCategory(Integer cid) {
		dao.deleteByCategory(cid);
	}

	@Override
	public Category findByCategoryId(Integer id) {
		Category category = dao.findByCategoryId(id);
		return category;
	}

}
