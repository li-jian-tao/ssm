package com.briup.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserReport implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Timestamp reportDate;
	private String reportType;
	private String reportContent;
	private Integer state;
	private Timestamp processDate;
	private String processContent;
	private User user;
	private Article article;
	
	public UserReport() {
	}

	
	public UserReport(Integer state, User user, Article article) {
		super();
		this.state = state;
		this.user = user;
		this.article = article;
	}


	public UserReport(String reportType, String reportContent, User user, Article article) {
		super();
		this.reportType = reportType;
		this.reportContent = reportContent;
		this.user = user;
		this.article = article;
	}


	public UserReport(String reportContent, User user, Article article) {
		super();
		this.reportContent = reportContent;
		this.user = user;
		this.article = article;
	}


	public UserReport(String reportContent, Integer state, User user, Article article) {
		super();
		this.reportContent = reportContent;
		this.state = state;
		this.user = user;
		this.article = article;
	}


	public UserReport(User user, Article article) {
		super();
		this.user = user;
		this.article = article;
	}


	public UserReport(Integer id, Timestamp reportDate, String reportType, String reportContent, Integer state,
			Timestamp processDate, String processContent, User user, Article article) {
		this.id = id;
		this.reportDate = reportDate;
		this.reportType = reportType;
		this.reportContent = reportContent;
		this.state = state;
		this.processDate = processDate;
		this.processContent = processContent;
		this.user = user;
		this.article = article;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getReportDate() {
		return reportDate;
	}

	public void setReportDate(Timestamp reportDate) {
		this.reportDate = reportDate;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getReportContent() {
		return reportContent;
	}

	public void setReportContent(String reportContent) {
		this.reportContent = reportContent;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Timestamp getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Timestamp processDate) {
		this.processDate = processDate;
	}

	public String getProcessContent() {
		return processContent;
	}

	public void setProcessContent(String processContent) {
		this.processContent = processContent;
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
		return "UserReport [id=" + id + ", reportDate=" + reportDate + ", reportType=" + reportType + ", reportContent="
				+ reportContent + ", state=" + state + ", processDate=" + processDate + ", processContent="
				+ processContent + ", user=" + user + ", article=" + article + "]";
	}
	
	

}
