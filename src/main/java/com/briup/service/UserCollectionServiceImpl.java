package com.briup.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.UserCollection;
import com.briup.dao.UserCollectionDao;
import com.briup.service.Impl.IUserCollectionService;
import com.briup.util.dateTime;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserCollectionServiceImpl implements IUserCollectionService{
	
	@Autowired
	private UserCollectionDao dao;
	
	private dateTime date = new dateTime();
	
	@Override
	public UserCollection findByUserCollection(Integer uid, Integer aid) {
		UserCollection userCollection = dao.findByUserCollection(uid, aid);
		return userCollection;
	}

	@Override
	public void addUserCollection(UserCollection userCollection) {
		Timestamp nowDate = date.NowDate();
		System.out.println("时间打印"+nowDate);		
		userCollection.setCollectionDate(nowDate);
		userCollection.setState(1);
		dao.addUserCollection(userCollection);
		System.out.println("结束"+userCollection);
	}

	@Override
	public void updateUserCollection(UserCollection userCollection) {
		Timestamp nowDate = date.NowDate();
		System.out.println("时间打印"+nowDate);
		userCollection.setCollectionDate(nowDate);
		dao.updateUserCollection(userCollection);
		System.out.println("修改"+userCollection);		
	}

	@Override
	public PageInfo<UserCollection> findAllUserCollection(Integer uid, Integer page) {
		PageHelper.startPage(page,5);
		System.out.println(page);
		List<UserCollection> list = dao.findAllUserCollection(uid);
		PageInfo<UserCollection> pageInfo = new PageInfo<UserCollection>(list);
		System.out.println(pageInfo.getSize()+"hang");
		return pageInfo;
	}

}
