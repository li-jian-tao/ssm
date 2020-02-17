package com.briup.service.Impl;

import java.util.List;

import com.briup.bean.UserComment;
import com.briup.bean.UserCommentary;

public interface IUserCommentService {
	public UserComment findByUserComment(Integer id);
	public void addUserComment(UserComment userComment);
	public List<UserComment> allUserComment(Integer aid);
	public void updateUserCommentTimes(UserComment userComment,UserCommentary userCommentary);
}
