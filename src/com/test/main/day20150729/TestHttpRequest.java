package com.test.main.day20150729;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;

/**
 * @2015年7月29日 by linyj
 */
public class TestHttpRequest {

	public static void main(String[] args) {
		// String enStr =
		// encodeStr("测试客户您好！您汇入我公司1.00元固定预收款已预入账，正在审核中。经财务审核无误的自动入账，不再发送确认消息！[浙江红狮]");
		// System.out.println(enStr);
		// String deStr = decodeStr(enStr);
		// System.out.println(deStr);
		t2();
		// t1();
	}

	public static String decodeStr(String str) {
		String enStr = "";
		if (StringUtils.isNotEmpty(str))
			try {
				enStr = URLDecoder.decode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		return enStr;
	}

	public static String encodeStr(String str) {
		String enStr = "";
		if (StringUtils.isNotEmpty(str))
			try {
				enStr = URLEncoder.encode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		return enStr;
	}

	public static void t2() {
		// String url = "http://192.168.158.88:8080/saler/getNCMessageList.do";
		String url = "http://devtest.hongshids.com/saler/getNCMessageList.do";
		// String url = "http://www.hongshids.com/saler/getNCMessageList.do";
		Map<String, Object> data = new HashMap<String, Object>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("msg_type", encodeStr("提货信息"));
		m1.put("msg_time", "2015-12-22 10:29:07");
		m1.put("msg_source", encodeStr("NC56"));
		m1.put("msg_title", encodeStr("水泥保证金通知"));
		m1.put("msg_content",
				encodeStr("测试客户您好！您汇入我公司1.00元固定预收款已预入账，正在审核中。经财务审核无误的自动入账，不再发送确认消息！[浙江红狮]"));
		m1.put("cust_code", "ceshi");
		m1.put("pkcorp", "1002");
		list.add(m1);

		Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("msg_type", "预警消息2");
		m2.put("msg_time", "2015-12-22 09:44:00");
		m2.put("msg_source", "NC系统");
		m2.put("msg_title", "2015年12月09日兰溪红狮提货情况");
		m2.put("msg_content",
				"测试客户,您好!12月09日从兰溪红狮提水泥T,其中:本月累计:T。今日交款:1元,账户余额(含保证金):24750.86元。[销售科电话:0579-88256902、财务科电话:0579-88256561]");
		m2.put("cust_code", "ceshi");
		m2.put("pkcorp", "1002");
		list.add(m2);
		data.put("list", list);
		data.put("cnt", list.size() + "");
		String jsonStr = JSON.toJSONString(data);
		String param = "json_data=" + jsonStr;
		// 发送 POST 请求
		String sr = sendPost(url, param);
		System.out.println(sr);
	}

	// public static void t1() {
	// String url =
	// "http://192.168.158.81:8080/HSSCM/apprepay/addLoanRecord.do";
	// // String param =
	// //
	// "userid=df96df0778b8471a9b071199564ddf57&user_type=1&loan_money=50000&repay_type_code=1&rate_type_id=3&bank_name=农业银行&bank_account=3333444455556666777&bank_account_name=李雪东&supply_id=32745&supply_code=2010105747&supply_name=浙江博森家具有限公司&busi_number=244444444444&apply_user=王宏亮&apply_user_cert=331000000000x&apply_user_phone=153333333&corp_id=1002&corp_code=3101&corp_name=兰溪红狮&loan_use=资金周转&bank_uaid=660d49d4102b4428a126f19774b583e1";
	// String param =
	// "userid=df96df0778b8471a9b071199564ddf57&user_type=1&loan_money=250000&repay_type_code=1&rate_type_id=3&bank_name=农业银行&bank_account=3333444455556666777&bank_account_name=李雪东&supply_id=0001E110000000002OHR&corp_id=1002&loan_use=资金周转222&bank_uaid=";
	//
	// // 发送 POST 请求
	// String sr = sendPost(url, param);
	// System.out.println(sr);
	//
	// }

	public static String sendGet(String url, String param) {
		String result = "";
		BufferedReader in = null;
		try {
			String urlNameString = url + "?" + param;
			URL realUrl = new URL(urlNameString);
			// 打开和URL之间的连接
			URLConnection connection = realUrl.openConnection();
			// 设置通用的请求属性
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 建立实际的连接
			connection.connect();
			// 获取所有响应头字段
			Map<String, List<String>> map = connection.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义 BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(
					connection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输入流
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * 向指定 URL 发送POST方法的请求
	 * 
	 * @param url
	 *            发送请求的 URL
	 * @param param
	 *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
	 * @return 所代表远程资源的响应结果
	 */
	public static String sendPost(String url, String param) {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			URL realUrl = new URL(url);
			// 打开和URL之间的连接
			URLConnection conn = realUrl.openConnection();
			// 设置通用的请求属性
			conn.setRequestProperty("accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
			// 发送POST请求必须设置如下两行
			conn.setDoOutput(true);
			conn.setDoInput(true);
			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(conn.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
			// 获取所有响应头字段
			Map<String, List<String>> map = conn.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			System.out.println("发送 POST 请求出现异常！" + e);
			e.printStackTrace();
		}
		// 使用finally块来关闭输出流、输入流
		finally {
			try {
				if (out != null) {
					out.close();
				}
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}
}
