package com.wwwang.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.wwwang.pojos.IPAndLocationPojo;
import com.wwwang.utils.IOUtil;


public class DataLoadManager {
	public static List<IPAndLocationPojo> getPojoList(List<String> ipAddressList) {
		List<IPAndLocationPojo> pojoList = new ArrayList<IPAndLocationPojo>();
		for (String line : ipAddressList) {
			line = line.trim();
			if (line.length() == 0) {
				continue;
			}
			String[] columnArray = line.split("\t");
			if (columnArray.length != 3) {
				continue;
			}

			IPAndLocationPojo pojo = new IPAndLocationPojo(columnArray[0],
					columnArray[1], columnArray[2]);
			pojoList.add(pojo);
		}
		return pojoList;
	}

	public static List<IPAndLocationPojo> getPojoList(String ipPath)
			throws Exception {
		// 把文本文件加载到内存的字符串集合中
		List<String> lineList = IOUtil.getLineList(ipPath, "UTF-8");
		// 把String集合解析成对应的集合对象
		List<IPAndLocationPojo> pojoList = getPojoList(lineList);
		Collections.sort(pojoList);
		return pojoList;
	}

	public static void main(String[] args) throws Exception {
		String ipAddressSource = "ip_location_relation.txt";
		List<IPAndLocationPojo> pojoList = getPojoList(ipAddressSource);
//		System.out.println(pojoList);
		for(IPAndLocationPojo pojo:pojoList){
			System.out.println(pojo);
		}
	}
}
