package com.briup.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.briup.bean.User;
import com.briup.bean.UserDown;

@Mapper
public interface UserDownDao {
	 void addByUserDown(UserDown userDown);
	 List<UserDown> findByUserDownId(Integer uid);
}
