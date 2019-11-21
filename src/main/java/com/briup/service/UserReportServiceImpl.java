package com.briup.service;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.Article;
import com.briup.bean.User;
import com.briup.bean.UserCollection;
import com.briup.bean.UserLike;
import com.briup.bean.UserReport;
import com.briup.dao.UserCollectionDao;
import com.briup.dao.UserLikeDao;
import com.briup.dao.UserReportDao;
import com.briup.service.Impl.IUserReportService;
import com.briup.util.dateTime;

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
		UserLike userLike = new UserLike();
		UserCollection userCollection = new UserCollection();
		userLike.setLikeDate(nowDate);
		userLike.setState(0);
		userLike.setArticle(article);
		userLike.setUser(user);
		userCollection.setCollectionDate(nowDate);
		userCollection.setState(0);
		userCollection.setArticle(article);
		userCollection.setUser(user);
		likedao.updateUserLike(userLike);
		collectiondao.updateUserCollection(userCollection);
		System.out.println("结束"+userReport);
	}

}
