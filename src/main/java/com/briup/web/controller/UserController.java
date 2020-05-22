package com.briup.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.briup.bean.Article;
import com.briup.bean.User;
import com.briup.bean.UserNote;
import com.briup.bean.UserNoteRelated;
import com.briup.service.Impl.IArticleService;
import com.briup.service.Impl.IUserNoteRelatedService;
import com.briup.service.Impl.IUserService;
import com.briup.util.Init;
import com.briup.util.saverPage;
import com.github.pagehelper.PageInfo;

@Controller
public class UserController {

	@Autowired
	private IUserService service;
	
	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private IUserNoteRelatedService userNoteService;
	
	private Map<String,Boolean> map = new HashMap<String,Boolean>();
	
	@PostMapping("/userLogin")
	public String Login(String account,String password,
			HttpSession session,HttpServletRequest request) {
		Init.in(account);
		if(map.size()!=0) {
			for(String acc:map.keySet()) {
				if(acc.equals(account)) {
					session.setAttribute("ms", "帐号"+account+"已在其他地方登录");
					return "login";
				} 
			}
			User user = null;
			try {
				user = service.findByAccount(account, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			int size = userNoteService.UserNoteRelatedSize(user.getId());
			session.setAttribute("user", user);
			session.setAttribute("size", size);
			map.put(account, true);
			if(user.getRole().equals("0")) {
				return "admin/index";
			}
			return "index";
		} else {
			User user = null;
			try {
				user = service.findByAccount(account, password);
			} catch (Exception e) {
				e.printStackTrace();
			}
			int size = userNoteService.UserNoteRelatedSize(user.getId());
			session.setAttribute("user", user);
			session.setAttribute("size", size);
			map.put(account, true);
			if(user.getRole().equals("0")) {
				return "admin/index";
			}
			return "index";
		}
	}
	
	@RequestMapping("/userLogout")
	public String Logout(
			HttpSession session,HttpServletRequest request) {
		if(session!=null) {
			String out = Init.out();
			map.remove(out);
			session.invalidate();
			System.out.println("注销成功");
		}
		return "login";	
	}
	
	@PostMapping("/userRegister")
	public String Register(String nickname,String account,String password,
			HttpSession session,HttpServletRequest request) {
		User old = service.findByAccount(account);
		if(old!=null) {
			request.setAttribute("msg", "当前用户已经存在");
			return "register";
		}
		User user = new User();
		user.setNickname(nickname);
		user.setAccount(account);
		user.setImage("");
		user.setPassword(password);
		user.setRole("1");
		UserNoteRelated userNoteRelated = new UserNoteRelated();
		userNoteRelated.setUser(user);
		UserNote userNote = new UserNote();
		userNote.setId(1);
		try {
			service.saveByUser(user);
			userNoteService.addByUserNoteRelatedPack(userNoteRelated,userNote);
			return "login";
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
			return "register";
		}		
	}
	
	@PostMapping("/showimg")
	public String showimg(User user,
			HttpSession session,HttpServletRequest request) {
		session.setAttribute("user", user);
		return "index";
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
	
	@RequestMapping("/showUserManager")
	public String showUserManager(Integer page,
			HttpSession session,HttpServletRequest request) {
		Map<Integer, List<Article>> maps = articleService.allArticle();
		PageInfo<Map<String,Integer>> pageInfo = service.findAllUserManger(page);
		Map<String, Integer> map = saverPage.StartAndEnd(pageInfo, page, 5);
		session.setAttribute("start", map.get("start"));
		session.setAttribute("end", map.get("end"));
		session.setAttribute("nextpage", pageInfo.getNextPage());
		session.setAttribute("prepage", pageInfo.getPrePage());
		session.setAttribute("pagecount", pageInfo.getNavigatepageNums());
		session.setAttribute("page", page);
		session.setAttribute("userList", pageInfo.getList());
		session.setAttribute("maps", maps);
		return "admin/userManger";
		
	}
}
