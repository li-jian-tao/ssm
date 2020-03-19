package com.briup.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Article implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String title;
	private String summary;
	private String content;
	private Timestamp releaseDate;
	private Integer clickTimes;
	private Integer type;
	private Integer state;
	private Integer reportNum;
	private User user;
	private Category category;
	public Article() {
	}
	
	public Article(Integer id, String title, String summary, String content, Timestamp releaseDate, Integer clickTimes,
			Integer type, Integer state,Integer reportNum, User user, Category category) {
		super();
		this.id = id;
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.releaseDate = releaseDate;
		this.clickTimes = clickTimes;
		this.type = type;
		this.state = state;
		this.reportNum = reportNum;
		this.user = user;
		this.category = category;
	}


	public Article(Integer id) {
		this.id = id;
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
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Timestamp releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getClickTimes() {
		return clickTimes;
	}
	public void setClickTimes(Integer clickTimes) {
		this.clickTimes = clickTimes;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getReportNum() {
		return reportNum;
	}
	public void setReportNum(Integer reportNum) {
		this.reportNum = reportNum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", summary=" + summary + ", content=" + content
				+ ", releaseDate=" + releaseDate + ", clickTimes=" + clickTimes + ", type=" + type + ", state=" + state
				+ ", reportNum=" + reportNum + ", user=" + user + ", category=" + category + "]";
	}
	
}
