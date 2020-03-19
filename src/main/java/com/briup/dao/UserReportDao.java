package com.briup.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.briup.bean.UserReport;

@Mapper
public interface UserReportDao {
	UserReport findByUserReport(Integer uid,Integer aid);
	void addUserReport(UserReport userReport);
	List<UserReport> findAllUserReport(Integer uid);
	UserReport findByUserReportId(Integer id);
	List<UserReport> reportMount(String name);
	List<UserReport> findByUserReportArticleId(Integer aid);
	Map<String, Object> mount(); 
	void updateByProcess(UserReport userReport);
}
