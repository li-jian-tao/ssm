package com.briup.service.Impl;

import com.briup.bean.UserCollection;

public interface IUserCollectionService {
	public UserCollection findByUserCollection(Integer uid,Integer aid);
	public void addUserCollection(UserCollection userCollection);
	public void updateUserCollection(UserCollection userCollection);
}
