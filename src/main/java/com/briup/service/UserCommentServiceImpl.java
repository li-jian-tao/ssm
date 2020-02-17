package com.briup.service;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.UserComment;
import com.briup.bean.UserCommentary;
import com.briup.dao.UserCommentDao;
import com.briup.service.Impl.IUserCommentService;
import com.briup.util.dateTime;

@Service
public class UserCommentServiceImpl implements IUserCommentService{
	
	@Autowired
	private UserCommentDao dao;
	
	private dateTime date = new dateTime();

	@Override
	public void addUserComment(UserComment userComment) {
		Timestamp nowDate = date.NowDate();
		System.out.println("时间打印"+nowDate);		
		userComment.setCommentDate(nowDate);
		userComment.setCommentTimes(0);
		dao.addUserComment(userComment);
		System.out.println("结束"+userComment);
	}

	@Override
	public List<UserComment> allUserComment(Integer aid) {
		List<UserComment> allUserComment = dao.allUserComment(aid);
		Collections.reverse(allUserComment);
		return allUserComment;
	}

	@Override
	public void updateUserCommentTimes(UserComment userComment,UserCommentary userCommentary) {
		System.out.println("状态"+userCommentary.getCommentaryState());
		if(userCommentary.getCommentaryState()==1) {
			System.out.println("进去了"+userComment.getCommentTimes());
			userComment.setCommentTimes(userComment.getCommentTimes()+1);
		} else {
			userComment.setCommentTimes(userComment.getCommentTimes()-1);
			System.out.println("出去了");
		}
		dao.updateUserCommentTimes(userComment);
	}

	@Override
	public UserComment findByUserComment(Integer id) {
		UserComment userComment = dao.findByUserComment(id);
		return userComment;
	}

}
