package com.briup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.briup.bean.UserCommentary;

@Mapper
public interface UserCommentaryDao {
	UserCommentary findByUserCommentary(Integer uid,Integer aid,Integer ucid);
	void addUserCommentary(UserCommentary userCommentary);
	List<UserCommentary> allUserCommentary(Integer uid,Integer aid);
	void updateUserCommentaryState(UserCommentary userCommentary);
}
