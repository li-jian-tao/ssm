package com.briup.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.briup.bean.User;
import com.briup.dao.UserDao;
import com.briup.service.Impl.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserServiceImpl implements IUserService{

	@Value("${file.upload-path}")
	private String path;
	
	@Autowired
	private UserDao dao;
	
	@Override
	public User findByAccount(String Account,String password) throws Exception{
		User user = dao.findByAccount(Account);
		if(user == null) {
			throw new Exception("用户名不存在");
		}
		if(!user.getPassword().equals(password)) {
			throw new Exception("密码错误");
		}
		return user;
		
	}

	@Override
	public void saveByUser(User user) throws Exception {
		User u = dao.findByAccount(user.getAccount());
		System.out.println(u);
		if(u == null) {
			dao.saveByUser(user);
		} else {
			throw new Exception("用户名已存在");
		}
	}
	
	@Override
	public User updateAndFindByAccount(User user,MultipartFile file) throws Exception{
		System.out.println(path);
		if(!file.isEmpty()) {
			String filename = System.currentTimeMillis()+file.getOriginalFilename();
			System.out.println(filename);
			file.transferTo(new File(path+"\\"+filename));
			System.out.println(path+"1");
			user.setImage(filename);
		}
		dao.updateByAccount(user);
		User u = dao.findByAccount(user.getAccount());
		System.out.println(u);
		return u;
	}

	@Override
	public void updateImage(User user) {
		dao.updateByAccount(user);
	}

	@Override
	public User findByAccount(String Account) {
		User user = dao.findByAccount(Account);
		return user;
	}

	@Override
	public PageInfo<Map<String, Integer>> findAllUserManger(Integer page) {
		PageHelper.startPage(page,10);
		System.out.println(page);
		List<Map<String,Integer>> list = dao.findAllUserManger();
		PageInfo<Map<String,Integer>> pageInfo = new PageInfo<Map<String,Integer>>(list);
		System.out.println(pageInfo.getSize()+"hang");
		return pageInfo;
	}
}
