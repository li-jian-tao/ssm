package com.briup.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserCollection implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Timestamp collectionDate;
	private Integer state;
	private User user;
	private Article article;
	
	public UserCollection() {
	}

	public UserCollection(User user, Article article) {
		super();
		this.user = user;
		this.article = article;
	}

	public UserCollection(Integer state, User user, Article article) {
		super();
		this.state = state;
		this.user = user;
		this.article = article;
	}

	public UserCollection(Integer id, Timestamp collectionDate, Integer state, User user, Article article) {
		this.id = id;
		this.collectionDate = collectionDate;
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

	public Timestamp getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(Timestamp collectionDate) {
		this.collectionDate = collectionDate;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "UserCollection [id=" + id + ", collectionDate=" + collectionDate + ", state=" + state + ", user=" + user
				+ ", article=" + article + "]";
	}
	

}
