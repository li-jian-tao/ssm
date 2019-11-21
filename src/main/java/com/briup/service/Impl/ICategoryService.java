package com.briup.service.Impl;

import java.util.List;

import com.briup.bean.Category;

public interface ICategoryService {
	public List<Category> findByCategory();
	public List<Category> findByCategorys();
}
