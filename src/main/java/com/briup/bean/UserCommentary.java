package com.briup.bean;

import java.io.Serializable;

public class UserCommentary implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer commentaryTimes;
	private Integer commentaryState;
	private User user;
	private Article article;
	private UserComment userComment;
		
	public UserCommentary() {
	}
	public UserCommentary(Integer id, Integer commentaryTimes,
			Integer commentaryState, User user, Article article,
			UserComment userComment) {
		this.id = id;
		this.commentaryTimes = commentaryTimes;
		this.commentaryState = commentaryState;
		this.user = user;
		this.article = article;
		this.userComment = userComment;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCommentaryTimes() {
		return commentaryTimes;
	}
	public void setCommentaryTimes(Integer commentaryTimes) {
		this.commentaryTimes = commentaryTimes;
	}
	public Integer getCommentaryState() {
		return commentaryState;
	}
	public void setCommentaryState(Integer commentaryState) {
		this.commentaryState = commentaryState;
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
	public UserComment getUserComment() {
		return userComment;
	}
	public void setUserComment(UserComment userComment) {
		this.userComment = userComment;
	}
	@Override
	public String toString() {
		return "UserCommentary [id=" + id + ", commentaryTimes="
				+ commentaryTimes + ", commentaryState=" + commentaryState
				+ ", user=" + user + ", article=" + article + ", userComment="
				+ userComment + "]";
	}

}
