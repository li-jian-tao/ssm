package com.briup.bean;

import java.io.Serializable;

public class UserNote implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String content;
	
	public UserNote() {
	}
	public UserNote(String title, String content) {
		this.title = title;
		this.content = content;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "UserNote [id=" + id + ", title=" + title + ", content="
				+ content + "]";
	}

}