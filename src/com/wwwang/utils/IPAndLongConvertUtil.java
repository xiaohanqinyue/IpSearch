package com.wwwang.utils;

public class IPAndLongConvertUtil {
	// ip = 3232235778
	public static String longToIp(long ip) {

		return ((ip >> 24) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "."
				+ ((ip >> 8) & 0xFF) + "." + (ip & 0xFF);
	}

	public static long ipToLong(String ipAddress) {

		// ipAddressInArray[0] = 192
		String[] ipAddressInArray = ipAddress.split("\\.");

		long result = 0;
		for (int i = 0; i < ipAddressInArray.length; i++) {

			int power = 3 - i;
			int ip = Integer.parseInt(ipAddressInArray[i]);

			// 1. 192 * 256^3
			// 2. 168 * 256^2
			// 3. 1 * 256^1
			// 4. 2 * 256^0
			result += ip * Math.pow(256, power);

		}

		return result;

	}

	public static void main(String[] args) {
		String ip = "1.27.248.0";
		long ipLong = ipToLong(ip);
		String ipRecover = longToIp(ipLong);
		
		System.out.println(ipLong);
		System.out.println(ipRecover);

	}
}
