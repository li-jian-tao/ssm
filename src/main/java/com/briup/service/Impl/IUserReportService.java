package com.briup.service.Impl;

import java.util.List;

import com.briup.bean.Article;
import com.briup.bean.User;
import com.briup.bean.UserReport;
import com.github.pagehelper.PageInfo;

public interface IUserReportService {
	public UserReport findByUserReport(Integer uid,Integer aid);
	public void addUserReport(UserReport userReport,String[] box,User user,Article article);
	public PageInfo<UserReport> findAllUserReport(Integer uid,Integer page);
	public UserReport findByUserReportId(Integer id);
	public PageInfo<UserReport> reportMount(String name,Integer page);
	public List<UserReport> findByUserReportArticleId(Integer aid);
	public void updateByProcess(UserReport userReport,Integer st);
}
