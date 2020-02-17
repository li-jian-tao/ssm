package com.briup.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.briup.bean.UserComment;

@Mapper
public interface UserCommentDao {
	UserComment findByUserComment(Integer id);
	void addUserComment(UserComment userComment);
	List<UserComment> allUserComment(Integer aid);
	void updateUserCommentTimes(UserComment userComment);
}
