package com.briup.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserNoteRelated implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Timestamp noteDate;
	private Integer state;
	private Article article;
	private UserNote userNote;
	private User user;
	private User other;
	
	public UserNoteRelated() {
	}
	public UserNoteRelated(Timestamp noteDate, Integer state, Article article,
			UserNote userNote, User user, User other) {
		this.noteDate = noteDate;
		this.state = state;
		this.article = article;
		this.userNote = userNote;
		this.user = user;
		this.other = other;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Timestamp getNoteDate() {
		return noteDate;
	}
	public void setNoteDate(Timestamp noteDate) {
		this.noteDate = noteDate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	public UserNote getUserNote() {
		return userNote;
	}
	public void setUserNote(UserNote userNote) {
		this.userNote = userNote;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getOther() {
		return other;
	}
	public void setOther(User other) {
		this.other = other;
	}
	@Override
	public String toString() {
		return "UserNoteRelated [id=" + id + ", noteDate=" + noteDate
				+ ", state=" + state + ", article=" + article + ", userNote="
				+ userNote + ", user=" + user + ", other=" + other + "]";
	}
	
}
