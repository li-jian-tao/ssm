package com.briup.util;

import java.util.HashMap;
import java.util.Map;

import com.github.pagehelper.PageInfo;

public class saverPage {
	public Map<String,Integer> StartAndEnd(PageInfo<?> allCategory,int page,int pageCount){
		HashMap<String,Integer> map = new HashMap<>();
		int start = 0;
		int end = 0;
		if(allCategory.getPages()<=pageCount) {
			start=1;
			end = allCategory.getPages();
		}else if(page>=((int)(pageCount/2)+1) && page<=allCategory.getPages()-((int)(pageCount/2))) {
			start=page-(int)(pageCount/2);
			if(pageCount%2==1) {
				end = page+(int)(pageCount/2);
			} else {
				end = page+(int)(pageCount/2)-1;				
			}
		}else if(page<((int)(pageCount/2)+1)){
			start=1;
			end = pageCount;
		}else if(page>allCategory.getPages()-((int)(pageCount/2))) {
			start=allCategory.getPages()-pageCount+1;
			end = allCategory.getPages();
		}
		map.put("start", start);
		map.put("end", end);
		return map;
	}
}
