package com.briup.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.briup.bean.User;
import com.briup.service.Impl.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService service;
	
	@PostMapping("/userLogin")
	public String Login(String account,String password,
			HttpSession session,HttpServletRequest request) {
		try {
			User user = service.findByAccount(account, password);
			System.out.println(user);
			session.setAttribute("user", user);
			if(user.getRole().equals("0")) {
				System.out.println("admin");
				return "admin/index";
			}
			return "index";
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			return "login";
		}		
	}
	
	@PostMapping("/userRegister")
	public String Register(String nickname,String account,String password,
			HttpSession session,HttpServletRequest request) {
		User user = new User();
		user.setNickname(nickname);
		user.setAccount(account);
		user.setImage("");
		user.setPassword(password);
		user.setRole("1");
		try {
			service.saveByUser(user);
			return "login";
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			return "register";
		}		
	}
	
	@PostMapping("/userInfo")
	public String Info(User user,MultipartFile file,
			HttpSession session,HttpServletRequest request) {
		try {
			User u = service.updateAndFindByAccount(user,file);
			session.setAttribute("user", u);
			System.out.println(u);
		} catch (Exception e){
			request.setAttribute("msg", "文件上传失败");
		}
		return "index";
		
	}
}
