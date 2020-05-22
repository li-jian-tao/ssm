package com.briup.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.briup.bean.User;

@Mapper
public interface UserDao {
	User findByAccount(String Account);
	void saveByUser(User user);
	void updateByAccount(User user);
	List<Map<String,Integer>> findAllUserManger();
}
