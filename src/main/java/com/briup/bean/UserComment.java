package com.briup.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserComment implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Timestamp commentDate;
	private String commentContent;
	private Integer commentTimes;
	private User user;
	private Article article;
	
	
	public UserComment() {
	}
	public UserComment(Integer id, Timestamp commentDate, String commentContent,
			Integer commentTimes, User user, Article article) {
		this.id = id;
		this.commentDate = commentDate;
		this.commentContent = commentContent;
		this.commentTimes = commentTimes;
		this.user = user;
		this.article = article;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Timestamp commentDate) {
		this.commentDate = commentDate;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Integer getCommentTimes() {
		return commentTimes;
	}
	public void setCommentTimes(Integer commentTimes) {
		this.commentTimes = commentTimes;
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
		return "UserComment [id=" + id + ", commentDate=" + commentDate
				+ ", commentContent=" + commentContent + ", commentTimes=" + commentTimes
				+ ", user=" + user + ", article=" + article + "]";
	}

}
