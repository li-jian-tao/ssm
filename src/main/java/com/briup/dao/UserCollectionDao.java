package com.briup.dao;

import org.apache.ibatis.annotations.Mapper;

import com.briup.bean.UserCollection;

@Mapper
public interface UserCollectionDao {
	UserCollection findByUserCollection(Integer uid,Integer aid);
	void addUserCollection(UserCollection userCollection);
	void updateUserCollection(UserCollection userCollection);
}
