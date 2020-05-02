package com.briup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.briup.bean.UserHistory;

@Mapper
public interface UserHistoryDao {
	void addUserHistory(UserHistory userHistory);
	List<UserHistory> findAllUserHistory(Integer uid);
}
