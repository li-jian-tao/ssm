package com.briup.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Article;
import com.briup.bean.User;
import com.briup.bean.UserCollection;
import com.briup.bean.UserLike;
import com.briup.bean.UserReport;
import com.briup.dao.ArticleDao;
import com.briup.dao.UserCollectionDao;
import com.briup.dao.UserLikeDao;
import com.briup.dao.UserReportDao;
import com.briup.service.Impl.IUserReportService;
import com.briup.util.dateTime;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class UserReportServiceImpl implements IUserReportService{

	@Autowired
	private UserReportDao dao;
	
	@Autowired
	private UserLikeDao likedao;
	
	@Autowired
	private UserCollectionDao collectiondao;
	
	private dateTime date = new dateTime();
	
	@Override
	public UserReport findByUserReport(Integer uid, Integer aid) {
		UserReport userReport = dao.findByUserReport(uid, aid);
		return userReport;
	}

	@Override
	public void addUserReport(UserReport userReport,String[] box,User user,Article article) {
		String boxes="";
		for(int i=0;i<box.length;i++) {
			boxes+=(box[i]+",");
		}
		Timestamp nowDate = date.NowDate();
		System.out.println("时间打印"+nowDate);
		userReport.setReportDate(nowDate);
		userReport.setReportType(boxes);
		dao.addUserReport(userReport);
		System.out.println("结束"+userReport);
	}

	@Override
	public PageInfo<UserReport> findAllUserReport(Integer uid, Integer page) {
		PageHelper.startPage(page,5);
		System.out.println(page);
		List<UserReport> list = dao.findAllUserReport(uid);
		PageInfo<UserReport> pageInfo = new PageInfo<UserReport>(list);
		System.out.println(pageInfo.getSize()+"hang");
		return pageInfo;
	}

	@Override
	public UserReport findByUserReportId(Integer id) {
		UserReport userReport = dao.findByUserReportId(id);
		return userReport;
	}

	@Override
	public PageInfo<UserReport> reportMount(String name,Integer page) {
		PageHelper.startPage(page,5);
		System.out.println(page);
		List<UserReport> list = dao.reportMount(name);
		System.out.println(list);
		PageInfo<UserReport> pageInfo = new PageInfo<UserReport>(list);
		System.out.println(pageInfo.getSize()+"hang");
		return pageInfo;
	}

	@Override
	public List<UserReport> findByUserReportArticleId(Integer aid) {
		List<UserReport> reportArticle = dao.findByUserReportArticleId(aid);
		return reportArticle;
	}

	@Override
	public void updateByProcess(UserReport userReport,Integer st) {
		Timestamp nowDate = date.NowDate();
		System.out.println("时间打印"+nowDate);	
		if(st.equals(-2)) {			
			userReport.setProcessContent("文章已成功处理");
		} else if(st.equals(2)) {
			userReport.setProcessContent("由于你的举报有误，文章未进行处理");			
		} else {
			userReport.setProcessContent("结果暂未处理");	
		}
		userReport.setState(1);
		userReport.setProcessDate(nowDate);
		dao.updateByProcess(userReport);
	}

}
