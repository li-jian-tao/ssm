package com.briup.service.Impl;

import com.briup.bean.UserCollection;
import com.github.pagehelper.PageInfo;

public interface IUserCollectionService {
	public UserCollection findByUserCollection(Integer uid,Integer aid);
	public void addUserCollection(UserCollection userCollection);
	public void updateUserCollection(UserCollection userCollection);
	public PageInfo<UserCollection> findAllUserCollection(Integer uid,Integer page);
}
