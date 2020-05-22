package com.briup.web.controller;

import java.io.File;
import java.sql.Timestamp;

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
import com.briup.util.dateTime;

@Controller
public class UserHistoryController {
	@Value("${historyfile.upload-path}")
	private String path;
	
	@Autowired
	private IUserHistoryService service;
	
	@RequestMapping("showUserHistory")
	public String getColumnChart(String date,
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
		int ndate = Integer.parseInt(date.split("-")[1])+1;
		System.out.println("sdhjshdja"+ndate);
		String nextdate = date.split("-")[0]+"-"+ndate;
	    JFreeChart chart = service.findAllUserHistory(user.getId(),date,nextdate);
	    columnarTools.saveAsFile(chart, path+"\\"+filename+".png", 700, 400);
	    session.setAttribute("before", dateTime.ChangeMonth(0));
	    session.setAttribute("center", dateTime.ChangeMonth(1));
	    session.setAttribute("after", dateTime.ChangeMonth(2));
	    session.setAttribute("chartURL", filename+".png");
		return "user/myhistory";		
	}
	
}
