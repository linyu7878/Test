package com.test.main.day20150727;

import java.util.List;

/**
 * @param <T>
 * @param <T>
 * @2015年7月27日 by linyj
 */
public class Root<T> implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serialNum;
	private String timestamp;
	private String userId;
	private String busiCode;
	private List<T> list;

	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBusiCode() {
		return busiCode;
	}

	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public String toString() {
		return "serialNum:" + serialNum + ", timestamp:, userId:" + userId
				+ ", busiCode:" + busiCode + ",  list:" + list;
	}

}
