package com.briup.dao;

import org.apache.ibatis.annotations.Mapper;

import com.briup.bean.UserReport;

@Mapper
public interface UserReportDao {
	UserReport findByUserReport(Integer uid,Integer aid);
	void addUserReport(UserReport userReport);
}
