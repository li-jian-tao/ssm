package com.briup.service;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.bean.UserHistory;
import com.briup.dao.UserHistoryDao;
import com.briup.service.Impl.IUserHistoryService;
import com.briup.util.columnarTools;
import com.briup.util.dateTime;

@Service
public class UserHistoryServiceImpl implements IUserHistoryService{

	@Autowired
	private UserHistoryDao dao;
	
	@Override
	public void addUserHistory(UserHistory userHistory) {
		System.out.println("时间打印"+dateTime.NowDate());
		userHistory.setHistoryDate(dateTime.NowDate());
		dao.addUserHistory(userHistory);
		System.out.println("结束"+userHistory);
	}

	@Override
	public JFreeChart findAllUserHistory(Integer uid,String date,String ndate) {
	    // 获得数据
	    CategoryDataset dataset = getDataSet(uid,date,ndate);
	    // 获取柱状图工具类创建的柱状图，（将数据集传入）
	    JFreeChart chart = columnarTools.createCoColumnar(dataset);
	    return chart;
	}

	 //获取一个演示用的组合数据集对象 为柱状图添加数据

	private CategoryDataset getDataSet(Integer uid,String date,String nextdate) {
		Map<String,Integer> map = new HashMap<>();
		List<UserHistory> list = dao.findAllUserHistory(uid);
		for (UserHistory userHistory : list) {
			try {
				boolean time = dateTime.setTime(userHistory.getHistoryDate(), date, nextdate);
				String cname = userHistory.getCategory().getName();
				if(time) {
					if(map.keySet().contains(cname)) {
						map.put(cname, map.get(cname)+1);
					} else {
						map.put(cname, 1);
					}
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	    // 数据可以从数据库中得到
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    for (String key : map.keySet()) {
	    	System.out.println("key= "+ key + " and value= " + map.get(key));
	    	dataset.addValue(map.get(key), "栏目", key);
	    }
	    return dataset;
	}

	@Override
	public List<UserHistory> findHistory(Integer uid, Integer cid,
			Integer aid) {
		List<UserHistory> list = dao.findHistory(uid, cid, aid);
		return list;
	}

}
