package com.briup.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.UserCommentary;
import com.briup.dao.UserCommentaryDao;
import com.briup.service.Impl.IUserCommentaryService;

@Service
public class UserCommentaryServiceImpl implements IUserCommentaryService{
	
	@Autowired
	private UserCommentaryDao dao;

	@Override
	public void addUserCommentary(UserCommentary userCommentary) {
		userCommentary.setCommentaryTimes(0);
		userCommentary.setCommentaryState(1);
		dao.addUserCommentary(userCommentary);
		System.out.println("结束"+userCommentary);
	}

	@Override
	public UserCommentary findByUserCommentary(Integer uid,Integer aid,Integer ucid) {
		UserCommentary userCommentary = dao.findByUserCommentary(uid,aid,ucid);
		return userCommentary;
	}

	@Override
	public void updateUserCommentaryState(UserCommentary userCommentary) {
		dao.updateUserCommentaryState(userCommentary);
		System.out.println("结束"+userCommentary);
	}

	@Override
	public List<UserCommentary> allUserCommentary(Integer uid, Integer aid) {
		List<UserCommentary> allUserComment = dao.allUserCommentary(uid,aid);
		Collections.reverse(allUserComment);
		return allUserComment;
	}

}
