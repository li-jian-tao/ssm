package com.briup.web.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jfree.chart.JFreeChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.briup.bean.User;
import com.briup.service.Impl.IUserHistoryService;
import com.briup.util.columnarTools;

@Controller
public class UserHistoryController {
	@Value("${historyfile.upload-path}")
	private String path;
	
	@Autowired
	private IUserHistoryService service;
	
	@RequestMapping("showUserHistory")
	public String getColumnChart(
			HttpSession session,HttpServletRequest request) throws Exception {
		User user = (User) session.getAttribute("user");
		String filename = "user"+user.getId();
		File file=new File(path);
		if(file.isDirectory()) {
			String[] list = file.list();
			for (int i = 0; i < list.length; i++) {
				if(list[i].contains(filename)) {
					File f = new File(path,list[i]);
					f.delete();
				}
			}
		}
	    JFreeChart chart = service.findAllUserHistory(user.getId());
	    columnarTools.saveAsFile(chart, path+"\\"+filename+".png", 700, 400);
	    session.setAttribute("chartURL", filename+".png");
		return "user/myhistory";		
	}
	
}
