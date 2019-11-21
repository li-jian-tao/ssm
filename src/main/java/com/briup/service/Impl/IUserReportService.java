package com.briup.service.Impl;

import com.briup.bean.Article;
import com.briup.bean.User;
import com.briup.bean.UserReport;

public interface IUserReportService {
	public UserReport findByUserReport(Integer uid,Integer aid);
	public void addUserReport(UserReport userReport,String[] box,User user,Article article);
}
