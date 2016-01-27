package com.test.main.day20151203;

import com.gexin.rp.sdk.base.ITemplate;
import com.runlion.shop.common.util.StringUtil;
import com.runlion.shop.service.message.AppMessageService;

/**
 * @2015年12月3日 by linyj
 */
public class TestAppMessage {

	public static void main(String[] args) throws Exception {
		t1();

	}

	public static void t1() throws Exception {
		// String CID = "e19d590a928b95043c988ec15465b7ce";
		String CID = "123";

		String ss = "测试消息推送";
		ITemplate template = AppMessageService.getNotificationTemplate("测试",
				ss, "", 1);
		System.out.println(ss.getBytes().length);
		if (ss.getBytes().length > 180) {
			ss = StringUtil.getSubString(ss, 180) + "...";
		}
		System.out.println(ss);
		System.out.println(ss.getBytes().length);

		// System.out.println(pushAPNMessageToSingle("xxxxxxxxxxxx", 1,
		// CID_IOS));
		AppMessageService.pushToSingle(CID, template);
	}
}
