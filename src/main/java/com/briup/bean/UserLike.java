package com.briup.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserLike implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Timestamp likeDate;
	private Integer state;
	private User user;
	private Article article;
	
	public UserLike() {
	}
	
	public UserLike(User user, Article article) {
		super();
		this.user = user;
		this.article = article;
	}
	
	public UserLike(Integer state, User user, Article article) {
		super();
		this.state = state;
		this.user = user;
		this.article = article;
	}

	public UserLike(Integer id, Timestamp likeDate, Integer state, User user, Article article) {
		super();
		this.id = id;
		this.likeDate = likeDate;
		this.state = state;
		this.user = user;
		this.article = article;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Timestamp likeDate) {
		this.likeDate = likeDate;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
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

	@Override
	public String toString() {
		return "UserLike [id=" + id + ", likeDate=" + likeDate + ", state=" + state + ", user=" + user + ", article="
				+ article + "]";
	}
	
}
