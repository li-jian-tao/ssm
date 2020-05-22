package com.briup.service.Impl;

import com.briup.bean.UserDown;
import com.github.pagehelper.PageInfo;

public interface IUserDownService {
	public void addByUserDown(UserDown userDown);
	public PageInfo<UserDown> findByUserDownId(Integer page,Integer uid);
}
