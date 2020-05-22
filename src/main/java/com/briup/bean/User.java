package com.briup.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nickname;
	private String account;
	private String password;
	private String image;
	private String role;
	private List<Article> articles = new ArrayList<Article>();
	
	public User() {
	}
	
	public User(Integer id, String nickname, String account, String password, String role) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.account = account;
		this.password = password;
		this.role = role;
	}
	
	public User(Integer id, String nickname, String account, String password, String image, String role) {
		super();
		this.id = id;
		this.nickname = nickname;
		this.account = account;
		this.password = password;
		this.image = image;
		this.role = role;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", account="
				+ account + ", password=" + password + ", image=" + image
				+ ", role=" + role + ", articles=" + articles + "]";
	}

}
