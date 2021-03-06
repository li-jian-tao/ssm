package com.briup.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.UserLike;
import com.briup.dao.UserLikeDao;
import com.briup.service.Impl.IUserLikeService;
import com.briup.util.dateTime;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserLikeServiceImpl implements IUserLikeService{

	@Autowired
	private UserLikeDao dao;
	
	@Override
	public UserLike findByUserLike(Integer uid, Integer aid) {
		UserLike userLike = dao.findByUserLike(uid, aid);
		return userLike;
	}
	
	@Override
	public void addUserLike(UserLike userlike) {
		System.out.println("时间打印"+dateTime.NowDate());
		userlike.setLikeDate(dateTime.NowDate());
		userlike.setState(1);
		dao.addUserLike(userlike);
		System.out.println("结束"+userlike);
	}

	@Override
	public void updateUserLike(UserLike userlike) {
		System.out.println("时间打印"+dateTime.NowDate());
		userlike.setLikeDate(dateTime.NowDate());
		dao.updateUserLike(userlike);
		System.out.println("修改"+userlike);
	}

	@Override
	public PageInfo<UserLike> findAllUserLike(Integer uid,Integer page) {
		PageHelper.startPage(page,5);
		System.out.println(page);
		List<UserLike> list = dao.findAllUserLike(uid);
		PageInfo<UserLike> pageInfo = new PageInfo<UserLike>(list);
		System.out.println(pageInfo.getSize()+"hang");
		return pageInfo;
	}

}
