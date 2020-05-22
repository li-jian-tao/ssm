package com.briup.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.Article;
import com.briup.bean.User;
import com.briup.bean.UserNote;
import com.briup.bean.UserNoteRelated;
import com.briup.bean.UserReport;
import com.briup.service.Impl.IArticleService;
import com.briup.service.Impl.IUserNoteRelatedService;
import com.briup.service.Impl.IUserReportService;
import com.briup.util.saverPage;
import com.github.pagehelper.PageInfo;

@Controller
public class UserReportController {
	@Autowired
	private IUserReportService service;
	
	@Autowired
	private IArticleService aservice;
	
	@Autowired
	private IUserNoteRelatedService unservice;
	
	@RequestMapping("addUserReportState")
	public String addUserReport(Integer articleId,String[] box,String content,
			HttpSession session,HttpServletRequest request) {
		System.out.println("article_id"+articleId);
		User user = (User) session.getAttribute("user");
		Article article = aservice.findByArticle(articleId);
		System.out.println(article);
		UserReport userReport = new UserReport();
		if(box!=null&&content!=null) {			
			userReport.setUser(user);
			userReport.setArticle(article);
			userReport.setReportContent(content);
			userReport.setState(0);
			service.addUserReport(userReport,box,user,article);
			List<UserReport> reportMount = service.findByUserReportArticleId(articleId);
			aservice.updateByReportNum(reportMount.size(), articleId);
			aservice.updateByClickTimes(null, 99, articleId);
			UserNoteRelated noteRelated = unservice.findByUserNoteAndArtcle(5, article.getId(), article.getUser().getId());
			if(noteRelated==null) {
				UserNote userNote = new UserNote();
				userNote.setId(5);
				UserNoteRelated userNoteRelated = new UserNoteRelated();
				userNoteRelated.setUser(article.getUser());
				unservice.addByUserNoteRelated(userNoteRelated, userNote, article.getId());
			}
			UserNote newuserNote = new UserNote();
			newuserNote.setId(6);
			UserNoteRelated newuserNoteRelated = new UserNoteRelated();
			newuserNoteRelated.setUser(user);
			unservice.addByUserNoteRelated(newuserNoteRelated, newuserNote, article.getId());
		}
		session.setAttribute("userReport", userReport);
		return "index";
	}
	
	@RequestMapping("showUserReports")
	public String showUserReports(Integer id,
			HttpSession session,HttpServletRequest request) {
		User user = (User) session.getAttribute("user");
		PageInfo<UserReport> pageInfo = service.findAllUserReport(user.getId(), id);
		Map<String, Integer> map = saverPage.StartAndEnd(pageInfo, id, 5);
		session.setAttribute("start", map.get("start"));
		session.setAttribute("end", map.get("end"));
		session.setAttribute("nextpage", pageInfo.getNextPage());
		session.setAttribute("prepage", pageInfo.getPrePage());
		session.setAttribute("pagecount", pageInfo.getNavigatepageNums());
		session.setAttribute("page", id);
		session.setAttribute("list", pageInfo.getList());
		return "user/myreport";			
	}
	
	@RequestMapping("findReport")
	public String findReport(Integer id,Integer page,
			HttpSession session,HttpServletRequest request) {
		UserReport userReport = service.findByUserReportId(id);
		String[] strings = userReport.getReportType().split(",");
		session.setAttribute("userReport", userReport);
		session.setAttribute("strings", strings);
		System.out.println(userReport);
		return "redirect:/showUserReports?id="+page;			
	}
	
	@RequestMapping("checkReport")
	public String checkReport(Integer id,Integer page,
			HttpSession session,HttpServletRequest request) {
		List<UserReport> content = service.findByUserReportArticleId(id);
		System.out.println("report尺度"+page);
		int str1 = 0,str2 = 0,str3 = 0,str4 = 0;
		for (UserReport userReport : content) {
			String[] split = userReport.getReportType().split(",");
			if(split!=null) {
				for (String str : split) {
					if(str.equals("抄袭")) {
						str1++;
					}else if(str.equals("色情")) {
						str2++;
					}else if(str.equals("暴力")) {
						str3++;
					}else if(str.equals("反动")) {
						str4++;
					}
				}
			}
		}
		session.setAttribute("content", content);
		session.setAttribute("str1", str1);
		session.setAttribute("str2", str2);
		session.setAttribute("str3", str3);
		session.setAttribute("str4", str4);
		return "redirect:/showReportCheck?page="+page;			
	}
	
	@RequestMapping("showReportCheck")
	public String showReportCheck(String name,Integer page,
			HttpSession session,HttpServletRequest request) {
		System.out.println("跳进去了"+page);
		PageInfo<UserReport> pageInfo = service.reportMount(name,page);
		Map<String, Integer> map = saverPage.StartAndEnd(pageInfo, page, 5);
		session.setAttribute("start", map.get("start"));
		session.setAttribute("end", map.get("end"));
		session.setAttribute("nextpage", pageInfo.getNextPage());
		session.setAttribute("prepage", pageInfo.getPrePage());
		session.setAttribute("pagecount", pageInfo.getNavigatepageNums());
		session.setAttribute("page", page);
		session.setAttribute("list", pageInfo.getList());
		return "admin/reportMangar";			
	}
}
