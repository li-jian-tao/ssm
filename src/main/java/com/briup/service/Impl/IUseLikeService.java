package com.briup.service.Impl;

import com.briup.bean.UserLike;
import com.github.pagehelper.PageInfo;

public interface IUseLikeService {
	public UserLike findByUserLike(Integer uid,Integer aid);
	public void addUserLike(UserLike userlike);
	public void updateUserLike(UserLike userlike);
	public PageInfo<UserLike> findAllUserLike(Integer uid,Integer page);
}
