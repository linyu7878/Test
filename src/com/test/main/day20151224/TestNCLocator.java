package com.test.main.day20151224;

import java.util.List;
import java.util.Map;

import nc.bs.framework.common.NCLocator;
import nc.pubitf.ecapi.presell.service.PresellForTRansferService;

import com.hssn.mobile.inter.IHSSNMAIdentityAdapter;

/**
 * @2015年12月24日 by linyj
 */
public class TestNCLocator {
	public static void main(String[] args) throws Exception {
		t2();
		// t1();
	}

	public static void t2() {
		PresellForTRansferService presellForTRansferService = NCLocator
				.getInstance().lookup(PresellForTRansferService.class);

		System.out.println("---------------presellForTRansferService:"
				+ presellForTRansferService);
	}

	public static void t1() {
		IHSSNMAIdentityAdapter busi = NCLocator.getInstance().lookup(
				IHSSNMAIdentityAdapter.class);
		List<Map<String, String>> list = busi.loginNCSystem("ceshi",
				"a1234567", "", "", "", "", null);
		System.out.println("---------------list:" + list);
	}

}
