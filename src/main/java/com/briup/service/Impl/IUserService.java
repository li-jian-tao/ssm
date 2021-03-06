package com.briup.service.Impl;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.briup.bean.User;
import com.github.pagehelper.PageInfo;

public interface IUserService {
	public User findByAccount(String Account,String password) throws Exception;
	public void saveByUser(User user) throws Exception;
	public User updateAndFindByAccount(User user,MultipartFile file) throws Exception;
	public void updateImage(User user);
	public User findByAccount(String Account);
	public PageInfo<Map<String,Integer>> findAllUserManger(Integer page);
}
