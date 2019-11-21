package com.briup.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String name;
	private String description;
	private List<Category> cates = new ArrayList<Category>();
	
	public Category() {
	}

	public Category(Integer id, String name, String description, List<Category> cates) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cates = cates;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Category> getCates() {
		return cates;
	}

	public void setCates(List<Category> cates) {
		this.cates = cates;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", cates=" + cates + "]";
	}
	
	
}
