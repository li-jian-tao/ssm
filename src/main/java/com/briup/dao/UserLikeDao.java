package com.briup.dao;

import org.apache.ibatis.annotations.Mapper;

import com.briup.bean.UserLike;

@Mapper
public interface UserLikeDao {
	UserLike findByUserLike(Integer uid,Integer aid);
	void addUserLike(UserLike userlike);
	void updateUserLike(UserLike userlike);
}
