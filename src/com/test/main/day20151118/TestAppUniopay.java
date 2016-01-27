package com.test.main.day20151118;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.runlion.shop.entity.unionpay.UnionPayParam;
import com.unionpay.acp.sdk.CertUtil;
import com.unionpay.acp.sdk.SDKConfig;
import com.unionpay.acp.sdk.SDKUtil;

/**
 * @2015年11月18日 by linyj
 */
public class TestAppUniopay extends DemoBase {

	public static void main(String[] args) {
		SDKConfig.getConfig().loadPropertiesFromPath(
				"E://Porject/Workspaces/HSSNSHOPADMIN/resources/unionpay");

		t2();
		// t1();
		// t0();
		// t3();
	}

	public static void t4() {
		String path = SDKConfig.getConfig().getSignCertPath();
		System.out.println(path);
		int i = path.lastIndexOf(File.separator);
		System.out.println(i);
		String s = path.substring(0, i + 1) + "103330750390044.pfx";
		System.out.println(s);
		// SDKConfig.getConfig().setSignCertPath(
		// "D:\\test\\app-uniopay\\103330750390044.pfx");
		// CertUtil.init();
	}

	public static void t0() {
		String certId = CertUtil.getSignCertId();
		System.out.println("certId:" + certId);
		Map certMap = CertUtil.getCertMap();
		System.out.println("certMap:" + certMap);

	}

	public static void t2() {
		String requestAppUrl = SDKConfig.getConfig().getSingleQueryUrl();
		System.out.println(requestAppUrl);
		UnionPayParam param = new UnionPayParam();
		Map<String, String> data = param.generateMapValue(param);
		data.put("channelType", "08");
		// 交易类型 01-消费
		data.put("txnType", "00");
		// 交易子类型 01:自助消费 02:订购 03:分期付款
		data.put("txnSubType", "00");
		// 业务类型
		data.put("bizType", "000000");
		// 商户订单号，8-40位数字字母
		// data.put("orderId", orderId + "1234");
		// // 订单发送时间
		// data.put("txnTime", orderId);
		data.put("orderId", "11151223121662224");// 151113165854750
		// 订单发送时间
		data.put("txnTime", "20151223121652");// 20151113165831

		// BigDecimal amount = new BigDecimal("100");
		// 交易金额，单位分,把默认的元转为分
		// amount = amount.multiply(new BigDecimal(100));
		// data.put("txnAmt", amount.toBigInteger().toString());

		// 前台通知地址 ，控件接入方式无作用
		// data.put("frontUrl",
		// "http://localhost:8080/ACPTest/acp_front_url.do");
		// 后台通知地址
		// data.put("backUrl", "http://localhost:8080/ACPTest/acp_back_url.do");
		// 接入类型，商户接入填0 0- 商户 ， 1： 收单， 2：平台商户
		data.put("accessType", "0");
		// 商户号码，请改成自己的商户号
		data.put("merId", "103330750390044");// 103330750390044,103330750390018

		// data.put("reqReserved", "online-pay");
		// 订单描述，可不上送，上送时控件中会显示该信息
		// data.put("orderDesc", "");

		data = signData(data);

		// 交易请求url 从配置文件读取
		// String url = SDKConfig.getConfig().getSingleQueryUrl();

		Map<String, String> resmap = submitUrl(data, requestAppUrl);

		System.out.println("请求报文=[" + data.toString() + "]");
		System.out.println("应答报文=[" + resmap.toString() + "]");
	}

	public static void t1() {
		String requestAppUrl = SDKConfig.getConfig().getAppRequestUrl();
		System.out.println(requestAppUrl);
		UnionPayParam param = new UnionPayParam();
		Map<String, String> data = param.generateMapValue(param);
		data.put("channelType", "08");
		// 交易类型 01-消费
		data.put("txnType", "01");
		// 交易子类型 01:自助消费 02:订购 03:分期付款
		data.put("txnSubType", "01");
		// 业务类型
		data.put("bizType", "000201");
		String orderId = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date());
		// 商户订单号，8-40位数字字母
		data.put("orderId", orderId + "1234");
		// 订单发送时间
		data.put("txnTime", orderId);
		BigDecimal amount = new BigDecimal("100");
		// 交易金额，单位分,把默认的元转为分
		amount = amount.multiply(new BigDecimal(100));
		data.put("txnAmt", amount.toBigInteger().toString());

		// 前台通知地址 ，控件接入方式无作用
		data.put("frontUrl", "http://localhost:8080/ACPTest/acp_front_url.do");
		// 后台通知地址
		data.put("backUrl", "http://localhost:8080/ACPTest/acp_back_url.do");
		// 接入类型，商户接入填0 0- 商户 ， 1： 收单， 2：平台商户
		data.put("accessType", "0");
		// 商户号码，请改成自己的商户号
		data.put("merId", "103330750390018");// 103330750390044,103330750390018

		data.put("reqReserved", "online-pay");
		// 订单描述，可不上送，上送时控件中会显示该信息
		data.put("orderDesc", "");

		data = signData(data);

		// 交易请求url 从配置文件读取
		// String url = SDKConfig.getConfig().getSingleQueryUrl();

		Map<String, String> resmap = submitUrl(data, requestAppUrl);

		System.out.println("请求报文=[" + data.toString() + "]");
		System.out.println("应答报文=[" + resmap.toString() + "]");
	}

	public static void t3() {
		String requestAppUrl = SDKConfig.getConfig().getAppRequestUrl();
		System.out.println(requestAppUrl);
		UnionPayParam param = new UnionPayParam();
		Map<String, String> data = param.generateMapValue(param);
		data.put("channelType", "08");
		// 交易类型 01-消费
		data.put("txnType", "01");
		// 交易子类型 01:自助消费 02:订购 03:分期付款
		data.put("txnSubType", "01");
		// 业务类型
		data.put("bizType", "000201");
		String orderId = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date());
		// 商户订单号，8-40位数字字母
		data.put("orderId", orderId + "1234");
		// 订单发送时间
		data.put("txnTime", orderId);
		BigDecimal amount = new BigDecimal("20");
		// 交易金额，单位分,把默认的元转为分
		amount = amount.multiply(new BigDecimal(100));
		data.put("txnAmt", amount.toBigInteger().toString());

		// 前台通知地址 ，控件接入方式无作用
		data.put("frontUrl", "http://localhost:8080/ACPTest/acp_front_url.do");
		// 后台通知地址
		data.put("backUrl", "http://localhost:8080/ACPTest/acp_back_url.do");
		// 接入类型，商户接入填0 0- 商户 ， 1： 收单， 2：平台商户
		data.put("accessType", "0");
		// 商户号码，请改成自己的商户号
		data.put("merId", "103330750390044");// 103330750390044,103330750390018

		data.put("reqReserved", "online-pay2");
		// 订单描述，可不上送，上送时控件中会显示该信息
		data.put("orderDesc", "test2");

		// data = signData(data);
		SDKUtil.signByCertInfo(data, encoding,
				"D:\\test\\app-uniopay\\103330750390044.pfx", "88250025");

		// 交易请求url 从配置文件读取
		// String url = SDKConfig.getConfig().getSingleQueryUrl();

		Map<String, String> resmap = submitUrl(data, requestAppUrl);

		System.out.println("请求报文=[" + data.toString() + "]");
		System.out.println("应答报文=[" + resmap.toString() + "]");
	}
}
