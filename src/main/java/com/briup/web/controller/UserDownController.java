package com.briup.web.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.User;
import com.briup.bean.UserDown;
import com.briup.service.Impl.IUserDownService;
import com.briup.util.saverPage;
import com.github.pagehelper.PageInfo;

@Controller
public class UserDownController {

	@Autowired
	private IUserDownService service;
	
	@RequestMapping("showUserDown")
	public String showUserDown(Integer page,
			HttpSession session,HttpServletRequest request) {
		User user = (User) session.getAttribute("user");
		PageInfo<UserDown> pageInfo = service.findByUserDownId(page, user.getId());
		Map<String, Integer> map = saverPage.StartAndEnd(pageInfo, page, 5);
		session.setAttribute("start", map.get("start"));
		session.setAttribute("end", map.get("end"));
		session.setAttribute("nextpage", pageInfo.getNextPage());
		session.setAttribute("prepage", pageInfo.getPrePage());
		session.setAttribute("pagecount", pageInfo.getNavigatepageNums());
		session.setAttribute("page", page);
		session.setAttribute("list", pageInfo.getList());
		return "user/userdown";
	}
}
