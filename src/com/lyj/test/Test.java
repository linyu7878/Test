package com.lyj.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("a", "12");
		println(map);

	}

	public static void t1() {

	}

	/**
	 * 获取随机的流水号
	 * 
	 * @return
	 */
	public static String getRandomReqNo() {
		int length = 18;
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		String date_str = sdf.format(Calendar.getInstance().getTime());
		String str = date_str + sb.toString();
		println(str);
		return str;
	}

	public static void println(Object obj) {
		System.out.println(obj);
	}

	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
}
