package com.test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;

import com.alibaba.fastjson.JSON;
import com.runlion.shop.common.token.Token;
import com.runlion.shop.common.token.TokenManager;
import com.runlion.shop.common.util.DateUtil;
import com.runlion.shop.common.util.EncryptUtil;
import com.runlion.shop.common.util.MD5;
import com.runlion.shop.common.util.ReplaceUtils;
import com.runlion.shop.common.util.ehcache.EHCacheUtil;
import com.runlion.shop.service.ncinterface.NcInterface;
import com.runlion.shop.service.ncinterface.NcRequestParam;
import com.runlion.shop.service.ncinterface.NcReturnResult;
import com.runlion.shop.vo.home2.SettlePickWay;
import com.unionpay.acp.sdk.CertUtil;
import com.unionpay.acp.sdk.SDKConfig;

/**
 * @2015年7月1日 by linyj
 */
public class Test {

	public static void main(String[] args) throws Exception {
		// String s =
		// "708-6.00-%25E5%2590%25A8-0.00%25E5%2585%2583-0.00%25E5%2585%2583";
		String s = "salerId=undefined&saId=150&pickWay=2&selAreaId=192229&pInfos=1060-5-%25E5%258C%2585-0.00%25E5%2585%2583-0.00%25E5%2585%2583*1050-10-%25E5%258C%2585-0.00%25E5%2585%2583-0.00%25E5%2585%2583";
		String s2 = URLDecoder.decode((URLDecoder.decode(s, "UTF-8")), "UTF-8");
		println(s2);
		SettlePickWay w = new SettlePickWay();
		println(w.getSalerid());

		// testDEStr();
		// testReadFile();
		// testNCMessageList();
		// testArrayContains();
		// testPwdEn();
		// testNcService();
		// testCompTime();
		// testXmlStr();
		// testPojo2JsonStr();
		// testReplace();
		// testToken();
		// isMobile();
		// testAdditionalPath();
		// testZero();
		// testMin();
	}

	private static void processResultPrice(Integer store_row,
			Integer factory_row, Integer send_row) {
		factory_row++;
		// TODO Auto-generated method stub

	}

	public static void testDEStr() throws Exception {
		String s = "干粉砂浆";
		String enStr1 = URLEncoder.encode(s, "UTF-8");
		println(enStr1);
		String enStr2 = URLEncoder.encode(URLEncoder.encode(s, "UTF-8"),
				"UTF-8");
		println(enStr2);

		Random rand = new Random();
		int num = (int) (rand.nextDouble() * (1000 - 100) + 100);
		println(num);
	}

	public static void testReadFile() throws Exception {
		File file = new File(
				"D://work//12月//INN15120988ZM_103330750390044.103330750390044");
		BufferedReader rd = new BufferedReader(new FileReader(file));
		while (rd.ready()) {
			String line = rd.readLine();
			String[] ss = line.split(" ");
			String line2 = "";
			for (String s : ss) {
				if (StringUtils.isNotEmpty(s))
					line2 += s + "\t";
			}
			String[] ss2 = line2.split("\t");
			println(ss.length + "|" + ss2.length);
		}

	}

	public static void testNCMessageList() {
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("cnt", "2");
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		m1.put("msg_type", "预收申请");
		m1.put("msg_time", "2015-12-09 10:59:07");
		m1.put("msg_source", "NC56");
		m1.put("msg_title", "水泥保证金通知");
		m1.put("msg_content",
				"测试客户您好！您汇入我公司1.00元固定预收款已预入账，正在审核中。经财务审核无误的自动入账，不再发送确认消息！[浙江红狮]");
		m1.put("cust_code", "2010100346");
		m1.put("pkcorp", "1002");
		list.add(m1);

		Map<String, Object> m2 = new HashMap<String, Object>();
		m2.put("msg_type", "预警消息");
		m2.put("msg_time", "2015-12-10 07:44:00");
		m2.put("msg_source", "NC系统");
		m2.put("msg_title", "2015年12月09日兰溪红狮提货情况");
		m2.put("msg_content",
				"测试客户,您好!12月09日从兰溪红狮提水泥T,其中:本月累计:T。今日交款:1元,账户余额(含保证金):24750.86元。[销售科电话:0579-88256902、财务科电话:0579-88256561]");
		m2.put("cust_code", "2010100346");
		m2.put("pkcorp", "1002");
		list.add(m2);
		data.put("list", list);
		String jsonStr = JSON.toJSONString(data);
		println(jsonStr);
		println("--------------------");
		Object obj = JSON.parse(jsonStr);
		Map<String, Object> par = (Map<String, Object>) obj;
		Object objList = par.get("list");
		List<Map<String, Object>> list2 = (List<Map<String, Object>>) objList;
		println(list2.get(1).get("msg_title"));
	}

	public static void testArrayContains() {
		String[] oo = { "Q", "D" };
		println(ArrayUtils.contains(oo, "Q"));
		println("1002G11000000010XMFG".length());
		Object obj = JSON.parse("{a:'123',b:'测试bb'}");
		Map<String, String> map = (Map<String, String>) obj;
		println(map);
		println(map.get("b"));
	}

	public static void testPwdEn() throws Exception {
		String enPwd = EncryptUtil.encrypt("123456");
		println(enPwd);
		String passwd = new SimpleHash("SHA-1", "lwtao", "").toString(); // 密码加密
		println(passwd);
		String pwd = EncryptUtil
				.decrypt("Ut/TPJyYUxLfbbqUKDMxSj/2ZKcIcjcFZTuDUUnnzwU=");
		println(pwd);

		String md5Str = MD5.md5("1234qwer_3ea342ecf8c748ba8c6046643cf5564e");
		println(md5Str);
	}

	public static void testNcService() throws Exception {
		NcRequestParam ncparam = new NcRequestParam();
		ncparam.setCustcode("ceshi");
		ncparam.setPk_corp("1002");
		NcReturnResult result = NcInterface.checkYxedSuccess(ncparam);
		println(result);
		println(result.getState());
	}

	public static void testCompTime() {
		Date d1 = new Date("2015/11/19 8:26:13");
		Date d2 = new Date("2015/11/19 10:25:14");
		println(d1 + "-----" + d2);
		println(DateUtil.compareHours(d1, d2));
	}

	// public static void testXmlStr() {
	// BillFeedback fb = new BillFeedback();
	// fb.setMon_pk("1002G11000000010XHOB ");
	// String xml = XmlUtil.billFeedback2xml("admin", fb);
	// println(xml);
	//
	// // String xmlStr =
	// //
	// "<?xml version=\"1.0\" encoding=\"UTF-8\"?><MBILL>	<flag>1</flag>	<des> success </des>		<BILLS>	<BILL>		<mon_pk> 1002G11000000010XHOB </mon_pk>	</BILL>	</BILLS></MBILL>";
	// // String xmlStr =
	// //
	// "<?xml version=\"1.0\" encoding=\"utf-8\"?><MBILL>  <BILLS>    <BILL>      <mon_pk>1002G1100000000ZMQ7Z</mon_pk>    </BILL>  </BILLS></MBILL>";
	// // String xmlStr =
	// //
	// "<?xml version=\"1.0\" encoding=\"utf-8\"?><bill>  <flag>0</flag>  <des>success</des></bill>";
	// String xmlStr =
	// "<?xml version=\"1.0\" encoding=\"utf-8\"?><MBILL>   <BILLS>    <BILL>      <mon_pk>1002G1100000000ZMQ7Z</mon_pk>    </BILL>  </BILLS></MBILL>";
	// ResRoot req = XmlUtil.xml2billFeedback(xmlStr);
	// println(req);
	// BillFeedback fb2 = (BillFeedback) req.getList().get(0);
	// println(fb2.getMon_pk());
	//
	// }

	public static void testPojo2JsonStr() throws Exception {
		Token token = new Token();
		token.setUuid("123");
		token.setLastOperTime(Calendar.getInstance().getTime());
		println(JSON.toJSONString(token));

	}

	public static void testReplace() throws Exception {
		String s1 = "尊敬的用户：红狮水泥商城验证码：${YZM}，请在${MM}分钟内输入，工作人员不会索取，请勿泄露。（红狮电商：4008555888）";
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("YZM", "879265");
		data.put("MM", "10");
		String s2 = ReplaceUtils.repStr(s1, data);
		println(s2);

	}

	public static void testToken() throws Exception {
		String uuid = "1231256qsdsad";
		Token t = new Token();
		t.setLoginTime(new Date());
		t.setUid(123);
		t.setUuid(uuid);
		t.setUsername("lyj123");
		TokenManager.put(uuid, t);

		String uuid2 = "adahgfddd";
		Token t2 = new Token();
		t2.setLoginTime(new Date());
		t2.setUid(123);
		t2.setUuid(uuid2);
		t2.setUsername("lyj123");
		TokenManager.put(uuid2, t2);

		// Token token = TokenManager.get(uuid);
		// println(token);
		// List<Token> list = TokenManager.allToken();
		// println(list);
		// List<Token> list = TokenManager.getTokenByUid(123);
		// println(list);

		EHCacheUtil.shutdown();
	}

	public static void isMobile() {
		String mobile = "13457180872";
		String REGEX_MOBILE = "[1]{1}[3,5,8,6]{1}[0-9]{9}";
		boolean flag = Pattern.matches(REGEX_MOBILE, mobile);
		println(flag);
	}

	public static void testPublickKey() {
		SDKConfig.getConfig().loadPropertiesFromSrc();
		String certId = CertUtil.getSignCertId();
		println(certId);

		PublicKey key = CertUtil.getValidateKey(certId);
		println(key);
	}

	public static void testAdditionalPath() {
		int bspAttributesSize = 5;
		String path = "";
		String[] ss = path.split("-");
		String tempStr = "";
		if (ss.length < bspAttributesSize) {
			int cha = bspAttributesSize - ss.length;
			for (int i = 0; i < cha; i++) {
				path += "-0";
			}
		}
		println(path);
	}

	public static void testZero() {
		String path = "";
		int size = 3;
		for (int i = 0; i < size; i++) {
			if (i > 0)
				path += "-";
			path += "0";
		}
		println(path);
	}

	public static void testMin() {
		int size1 = 10;
		int size2 = 20;
		int minSize = size1 > size2 ? size2 : size1;
		println("minSize:" + minSize);
	}

	public static void testURLCoder() throws UnsupportedEncodingException {
		String s = URLEncoder.encode("哈哈", "UTF-8");
		println(s);

		// String s2 = "%B9%FE%B9%FE";
		String s2 = s;
		String s3 = URLDecoder.decode(s2, "UTF-8");
		println(s3);
	}

	public static void println(Object obj) {
		System.out.println(obj);
	}

}
