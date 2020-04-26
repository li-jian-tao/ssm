package com.briup.web.controller;

import java.sql.Timestamp;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.User;
import com.briup.bean.UserNoteRelated;
import com.briup.service.Impl.IArticleService;
import com.briup.service.Impl.IUserNoteRelatedService;
import com.briup.util.dateTime;
import com.briup.util.saverPage;
import com.github.pagehelper.PageInfo;

@Controller
public class UserNoteRelatedController {
	
	@Autowired
	private IUserNoteRelatedService service;
	
	@RequestMapping("showUserNote")
	public String showUserNote(Integer page,
			HttpSession session,HttpServletRequest request) {
		User user = (User) session.getAttribute("user");
		PageInfo<UserNoteRelated> userNoteRelated = service.findByUserNoteRelatedId(user.getId(),page);
		saverPage saverPage = new saverPage();
		Map<String, Integer> map = saverPage.StartAndEnd(userNoteRelated, page, 5);
		session.setAttribute("start", map.get("start"));
		session.setAttribute("end", map.get("end"));
		session.setAttribute("page", page);
		session.setAttribute("nextpage", userNoteRelated.getNextPage());
		session.setAttribute("prepage", userNoteRelated.getPrePage());
		session.setAttribute("pagecount", userNoteRelated.getNavigatepageNums());
		session.setAttribute("userNoteRelated", userNoteRelated.getList());
		return "node";
	}
	
	@RequestMapping("deleteNote")
	public String deleteNote(Integer id,Integer page,
			HttpSession session,HttpServletRequest request) {
		service.deleteNote(id);
		return "redirect:/showUserNote?page="+page;
	}
	
	@RequestMapping("showUserNoteDetail")
	public String showUserNoteDetail(Integer id,Integer page,
			HttpSession session,HttpServletRequest request) {
		UserNoteRelated userNoteRelated = service.findByUserNoteId(id);
		Timestamp date = userNoteRelated.getNoteDate();
		dateTime dateTime = new dateTime();
		String changeDate = dateTime.ChangeDate(date);
		service.updateByNoteState(userNoteRelated.getId());
		session.setAttribute("userNoteRelated", userNoteRelated);
		session.setAttribute("page", page);
		session.setAttribute("changeDate", changeDate);
		return "nodeDetail";
	}
}
