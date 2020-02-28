package com.briup.service.Impl;

import java.util.List;

import com.briup.bean.Category;
import com.github.pagehelper.PageInfo;

public interface ICategoryService {
	public List<Category> findByCategory();
	public List<Category> findByCategorys();
	public PageInfo<Category> allCategory(Integer page);
	public void addByCategory(Category category,Integer pid);
	public List<Category> findByCategoryParent();
	public Category findByCategoryPid(String name);
	public Category findByCategoryId(Integer id);
	public void deleteByCategory(Integer cid);
}
