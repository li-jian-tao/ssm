package com.briup.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.UserNote;
import com.briup.service.Impl.IUserNoteRelatedService;
import com.briup.service.Impl.IUserNoteService;


@Controller
public class UserNoteController {
	
	@Autowired
	private IUserNoteService service;
	
	@Autowired
	private IUserNoteRelatedService noterelatedservice;
	
	@RequestMapping("showNoteMangar")
	public String showNoteMangar(
			HttpSession session,HttpServletRequest request) {
		
		return "admin/noteManger";
	}
	
	@RequestMapping("addUserNote")
	public String addUserNote(String notetitle,String notecontent,
			HttpSession session,HttpServletRequest request) {
		System.out.println(notecontent);
		UserNote userNote = new UserNote(notetitle, notecontent);
		service.addByUserNote(userNote);
		noterelatedservice.addAllUserNoteRelatedPack(userNote);
		return "admin/index";
	}
	
}
