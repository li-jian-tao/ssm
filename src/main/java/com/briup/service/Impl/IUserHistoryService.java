package com.briup.service.Impl;

import java.util.List;

import org.jfree.chart.JFreeChart;

import com.briup.bean.UserHistory;

public interface IUserHistoryService {
	public void addUserHistory(UserHistory userHistory);
	public JFreeChart findAllUserHistory(Integer uid,String date,String nextdate);
	public List<UserHistory> findHistory(Integer uid,Integer cid,Integer aid);
}
