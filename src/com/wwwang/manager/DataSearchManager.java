package com.wwwang.manager;

import java.util.List;

import com.wwwang.pojos.IPAndLocationPojo;
import com.wwwang.utils.IPAndLongConvertUtil;


public class DataSearchManager {
	private IPAndLocationPojo[] sortedPojoArray = null;

	public DataSearchManager(String ipAddressLib) throws Exception {
		List<IPAndLocationPojo> pojoList = DataLoadManager
				.getPojoList(ipAddressLib);
		IPAndLocationPojo[] pojoArray = new IPAndLocationPojo[0];
		sortedPojoArray = pojoList.toArray(pojoArray);
	}

	/**
	 * 简单测试二分查找算法
	 * 
	 * @param sortedArray
	 * @param startPos
	 * @param endPos
	 * @param aid
	 * @return
	 */
	public static int getIndexByBinarySearch(int[] sortedArray, int startPos,
			int endPos, int aid) {
		if (startPos < 0 || endPos > sortedArray.length || startPos > endPos) {
			return -1;
		}
		int middle = (startPos + endPos) / 2;
		if (aid > sortedArray[middle]) {
			startPos = middle + 1;
			return getIndexByBinarySearch(sortedArray, startPos, endPos, aid);
		} else if (aid < sortedArray[middle]) {
			endPos = middle - 1;
			return getIndexByBinarySearch(sortedArray, startPos, endPos, aid);
		}
		return middle;
	}

	public int getIndexByBinarySearch(IPAndLocationPojo[] sortedArray,
			int startPos, int endPos, long ipLong) {
		if (startPos < 0 || endPos > sortedArray.length || startPos > endPos) {
			return -1;
		}
		int middle = (startPos + endPos) / 2;
		if (ipLong > sortedArray[middle].getEndIpLong()) {
			startPos = middle + 1;
			return getIndexByBinarySearch(sortedArray, startPos, endPos, ipLong);
		} else if (ipLong < sortedArray[middle].getStartIPLong()) {
			endPos = middle - 1;
			return getIndexByBinarySearch(sortedArray, startPos, endPos, ipLong);
		}
		return middle;
	}

	public String getLocationByIPString(String ip) throws Exception {
		int startPos = 0;
		int endPos = sortedPojoArray.length - 1;
		long aidIpLong = IPAndLongConvertUtil.ipToLong(ip);
		int pos = getIndexByBinarySearch(sortedPojoArray, startPos, endPos,
				aidIpLong);
		if (pos > -1) {
			return sortedPojoArray[pos].getLocation();
		}
		return null;
	}

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
