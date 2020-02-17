package com.briup.service.Impl;

import java.util.List;

import com.briup.bean.UserCommentary;

public interface IUserCommentaryService {
	public UserCommentary findByUserCommentary(Integer uid,Integer aid,Integer ucid);
	public void addUserCommentary(UserCommentary userCommentary);
	public List<UserCommentary> allUserCommentary(Integer uid,Integer aid);
	public void updateUserCommentaryState(UserCommentary userCommentary);
}
