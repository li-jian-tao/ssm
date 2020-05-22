package com.briup.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserDown implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Timestamp downDate;
	private String url;
	private Integer downTimes;
	private Article article;
	private User user;
	
	public UserDown() {
	}
	public UserDown(Timestamp downDate, String url,
			Integer downTimes, Article article, User user) {
		this.downDate = downDate;
		this.url = url;
		this.downTimes = downTimes;
		this.article = article;
		this.user = user;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getDownDate() {
		return downDate;
	}
	public void setDownDate(Timestamp downDate) {
		this.downDate = downDate;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getDownTimes() {
		return downTimes;
	}
	public void setDownTimes(Integer downTimes) {
		this.downTimes = downTimes;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserDown [id=" + id + ", downDate=" + downDate + ", url=" + url
				+ ", downTimes=" + downTimes + ", article=" + article
				+ ", user=" + user + "]";
	}
	
}
