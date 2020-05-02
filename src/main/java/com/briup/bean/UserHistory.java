package com.briup.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserHistory implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Timestamp historyDate;
	private User user;
	private Article article;
	private Category category;
	
	public UserHistory() {
	}
	public UserHistory(User user,Article article, Category category) {
		this.user = user;
		this.article = article;
		this.category = category;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getHistoryDate() {
		return historyDate;
	}
	public void setHistoryDate(Timestamp historyDate) {
		this.historyDate = historyDate;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "UserHistory [id=" + id + ", historyDate=" + historyDate
				+ ", user=" + user + ", article=" + article + ", category="
				+ category + "]";
	}
	
	

}
