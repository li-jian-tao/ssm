package com.briup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Category;
import com.briup.dao.CategoryDao;
import com.briup.service.Impl.ICategoryService;

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

}
