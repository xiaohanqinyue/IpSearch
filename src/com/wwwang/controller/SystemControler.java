package com.wwwang.controller;

import com.wwwang.manager.DataSearchManager;

/**
 * 项目入口类
 * @author Administrator
 *
 */
public class SystemControler {
	public static void main(String[] args) throws Exception {
		String ipAddressSource = "ip_location_relation.txt";
		String ip = "223.255.243.252";
		DataSearchManager dataSearchManager = new DataSearchManager(
				ipAddressSource);
		
		long startTS = System.currentTimeMillis();
		String location = dataSearchManager.getLocationByIPString(ip);
		long endTS = System.currentTimeMillis();
		System.out.println(endTS - startTS);
		System.out.println(location);
	}
}
