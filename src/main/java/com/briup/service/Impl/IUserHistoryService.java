package com.briup.service.Impl;

import org.jfree.chart.JFreeChart;

import com.briup.bean.UserHistory;

public interface IUserHistoryService {
	public void addUserHistory(UserHistory userHistory);
	public JFreeChart findAllUserHistory(Integer uid);
}
