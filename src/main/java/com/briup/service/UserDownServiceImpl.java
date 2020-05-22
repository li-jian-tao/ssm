package com.briup.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.briup.bean.UserDown;
import com.briup.dao.UserDownDao;
import com.briup.service.Impl.IUserDownService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserDownServiceImpl implements IUserDownService{
	@Value("${imgfile.upload-path}")
	private String imgpath;
	
	@Autowired
	private UserDownDao dao;

	@Override
	public void addByUserDown(UserDown userDown) {
		dao.addByUserDown(userDown);
	}

	@Override
	public PageInfo<UserDown> findByUserDownId(Integer page,Integer uid) {
		PageHelper.startPage(page,5);
		List<UserDown> allUserDown = dao.findByUserDownId(uid);
		PageInfo<UserDown> pageInfo = new PageInfo<UserDown>(allUserDown);
		System.out.println(pageInfo.getSize()+"hang");
		return pageInfo;
	}

}
