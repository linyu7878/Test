package com.test.main.day20150930;

import com.fh.util.SmsUtil;
import com.runlion.shop.common.util.HttpRequest;

/**
 * @2015年9月30日 by linyj
 */
public class TestSms {

	public static void main(String[] args) throws Exception {
		// HttpRequest
		// .sendMsm("13957180842", "短信短信短信短信您的验证码是：1111。请不要把验证码泄露给其他人。");
		// SmsUtil.sendSmsHS("13957180842",
		// "短信短信短信短信您的验证码是：1111。请不要把验证码泄露给其他人。");
		// String code = "测试短信-1235 - 412312！";
		// code = URLEncoder.encode(code);
		// System.out.println(code);
		// t3();
		t2();
		// t1();
		// String v =
		// "From=A06&MsgId=&DeptId=&EmpId=&To=13957180842&Time=2015-01-01 10:10&Flag=1&Success=-1&Cardid=&MsgType=SMS&SendType=Text&Subject=&Body=\u6d4b\u8bd5\u77ed\u4fe1-1235 - 412312\uff01&vcode=B9827F970E0DF95E4093441152F5E9D1";
		// String sr =
		// HttpRequest.sendPost("http://sms.runlion.com/PostSms.ashx",
		// v);
		// System.out.println(sr);
		// t4();
		// t5();
	}

	public static void t5() throws Exception {
		String v = "phone=13957180842&str=验证码:1234 -123456789abcd -  不要告诉别人！";
		v = new String(v.getBytes(), "UTF-8");
		String result = HttpRequest.sendPost(
				"http://192.168.158.89:8888/HSSCM/appuser/testSendSms.do", v);
		System.out.println(result);
	}

	public static void t4() throws Exception {
		String phone = "13957180842";
		int i = (int) (Math.random() * 9000 + 999);
		String num = String.valueOf(i);
		String message = "验证码:" + num + "，请不要告诉别人！";
		String result = SmsUtil.sendSmsHS(phone, message);
		System.out.println(result);
	}

	public static void t3() throws Exception {
		String phone = "13957180842";
		String code = "测试短信-1235 - 412312！";
		SmsUtil.sendSms1(phone, code);
		System.out.println("end-------");
	}

	public static void t2() throws Exception {
		// String phone = "15757157651";
		String phone = "13957180842";
		String code = "测试123213测试短信。请不要把验证码泄露给其他人。";
		// String code =
		// "%E6%B5%8B%E8%AF%95%E7%9F%AD%E4%BF%A1-1235+-+412312%EF%BC%81";
		// String t = "\u6d4b\u8bd5\u77ed\u4fe1-1235 - 412312\uff01";
		System.out.println("begin-------");
		SmsUtil.sendSmsHS(phone, code);
		System.out.println("end-------");
	}

	public static void t1() throws Exception {
		String url = "http://192.168.158.89:8080/HSSCM/apprepay/getLoanRecordInfo.do";
		String par = "userid=123&loanid=1024&t1=测试中文！123\u6d4b\u8bd5\u77ed\u4fe1-1235 - 412312\uff01";
		String s = SmsUtil.sendPost(url, par);
		System.out.println(s);
	}

}
