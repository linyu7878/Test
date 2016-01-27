package com.test.main.day20151214;

import java.util.Map;

import com.runlion.shop.service.ncinterface.NcInterface;

/**
 * @2015年12月14日 by linyj
 */
public class TestNcMobileService {

	public static void main(String[] args) throws Exception {
		t2();
		// t1();

	}

	public static void t2() throws Exception {
		Map<String, Object> ret = NcInterface
				.getCustCarNumAndEngineNum("2010106081");// ceshi,2010106081
		System.out.println("ret:" + ret);
	}

	public static void t1() throws Exception {
		Map<String, Object> cust = NcInterface.getNcCust("ceshi");// ceshi,2010106081
		System.out.println("cust:" + cust);
	}

}
