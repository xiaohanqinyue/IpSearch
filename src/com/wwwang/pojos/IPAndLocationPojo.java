package com.wwwang.pojos;

import com.wwwang.utils.IPAndLongConvertUtil;


public class IPAndLocationPojo implements Comparable<IPAndLocationPojo> {
	@Override
	public int compareTo(IPAndLocationPojo o) {
		return this.endIpLong - o.startIPLong > 0 ? 1 : 0;
	}

	@Override
	public String toString() {
		return "IPAndLocationPojo [startIp=" + startIp + ", endIP=" + endIP
				+ ", location=" + location + ", startIPLong=" + startIPLong
				+ ", endIpLong=" + endIpLong + "]";
	}

	private String startIp;
	private String endIP;
	private String location;
	private long startIPLong;
	private long endIpLong;

	public long getStartIPLong() {
		return startIPLong;
	}

	public void setStartIPLong(long startIPLong) {
		this.startIPLong = startIPLong;
	}

	public long getEndIpLong() {
		return endIpLong;
	}

	public void setEndIpLong(long endIpLong) {
		this.endIpLong = endIpLong;
	}

	public IPAndLocationPojo(String startIp, String endIP, String location) {
		super();
		this.startIp = startIp;
		this.endIP = endIP;
		this.location = location;

		this.startIPLong = IPAndLongConvertUtil.ipToLong(startIp);
		this.endIpLong = IPAndLongConvertUtil.ipToLong(endIP);
	}

	public String getStartIp() {
		return startIp;
	}

	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}

	public String getEndIP() {
		return endIP;
	}

	public void setEndIP(String endIP) {
		this.endIP = endIP;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}
