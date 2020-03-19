package com.briup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.briup.bean.Category;

@Mapper
public interface CategoryDao {
	List<Category> findByCategory();
	List<Category> findByCategorys();
	List<Category> allCategory();
	void addByCategory(Category category);
	List<Category> findByCategoryParent();
	List<Category> findByCategoryChildren();
	Category findByCategoryPid(String name);
	Category findByCategoryId(Integer id);
	void deleteByCategory(Integer cid);
	void updateByCategory(Category category);
}
