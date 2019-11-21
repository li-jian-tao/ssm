package com.briup.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.UserLike;
import com.briup.dao.UserLikeDao;
import com.briup.service.Impl.IUseLikeService;
import com.briup.util.dateTime;

@Service
public class UserLikeServiceImpl implements IUseLikeService{

	@Autowired
	private UserLikeDao dao;
	
	private dateTime date = new dateTime();
	
	@Override
	public UserLike findByUserLike(Integer uid, Integer aid) {
		UserLike userLike = dao.findByUserLike(uid, aid);
		return userLike;
	}
	
	@Override
	public void addUserLike(UserLike userlike) {
		Timestamp nowDate = date.NowDate();
		System.out.println("时间打印"+nowDate);
		userlike.setLikeDate(nowDate);
		userlike.setState(1);
		dao.addUserLike(userlike);
		System.out.println("结束"+userlike);
	}

	@Override
	public void updateUserLike(UserLike userlike) {
		Timestamp nowDate = date.NowDate();
		System.out.println("时间打印"+nowDate);
		userlike.setLikeDate(nowDate);
		dao.updateUserLike(userlike);
		System.out.println("修改"+userlike);
	}

}
