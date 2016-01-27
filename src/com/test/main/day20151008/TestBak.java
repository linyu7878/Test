package com.test.main.day20151008;

/**
 *@2015年10月8日 by linyj
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.json.JSONArray;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.crypto.hash.SimpleHash;

import com.alibaba.fastjson.JSON;
import com.fh.entity.Page;
import com.fh.service.rate.RateService;
import com.fh.util.Const;
import com.runlion.shop.common.util.EncryptUtil;
import com.runlion.shop.common.util.Mail;
import com.test.main.day20150729.TestHttpRequest;

/**
 * @2015年7月1日 by linyj
 */
public class TestBak {

	public static void main(String[] args) throws Exception {

		String s = URLEncoder.encode("哈哈", "UTF-8");
		println(s);

		// String s2 = "%B9%FE%B9%FE";
		String s2 = s;
		String s3 = URLDecoder.decode(s2, "UTF-8");
		println(s3);

		// getNcBillNo();
		// formatShowNum();
		// yearsBetween();
		// monsBetween();
		// processDataFile();
		// daysbetween2();
		// rateMoneyGtPledgeMoeny();
		// formatTimeShow();
		// getExtractRows();
		// getFileRows();
		// getSql();
		// bakFile();
		// testHttpLength();
		// testJDBC();
		// testBigInteger();
		// testFileReader(5);
		// testDays();
		// checkSysCorp();
		// testMatchs();

		// testPageStr();
		// byte b = 1;
		// ProceedingJoinPoint pj;
		//
		// BigDecimal d = new BigDecimal("12.23");
		// BigDecimal d2 = new BigDecimal("2");
		// d = d.subtract(d2);
		// println(d);
		// formatBigDecimal();
		// formatBankAccount("3310198607082412");
		// double d = getRateMoney(500000, 1.15, 96);
		// println(d);
		// getTotalRateMoney();
		// formatJSON();
		// formatDbl2(d);
		// testHSSCMPwd();
		// effctTime();
		// testJson();
		// testUuid();
		// testJiemi();
		// testJiaimi();
		// testTimeFormat();
		// String mail = "admin@admin.com            ";
		// println(isEffectMail(mail));
		// testMail();
		// testEncryptUtil();
	}

	public static void getNcBillNo() {
		int todayCnt = 10810;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String nowStr = sdf.format(Calendar.getInstance().getTime());
		String billNo = "XD" + nowStr;
		if (todayCnt > 999) {
			billNo = billNo + todayCnt;
		} else if (todayCnt > 99) {
			billNo = billNo + "0" + todayCnt;
		} else if (todayCnt > 9) {
			billNo = billNo + "00" + todayCnt;
		} else {
			billNo = billNo + "000" + todayCnt;
		}
		println(billNo);
	}

	public static void formatShowNum() throws Exception {
		String str = "1234";
		String res = "";
		DecimalFormat df = new DecimalFormat("0.00");
		if (StringUtils.isNotEmpty(str)) {
			try {
				BigDecimal creditBalance = new BigDecimal(str);
				BigDecimal resBal = new BigDecimal("0");
				if (creditBalance.doubleValue() >= 10000
						|| creditBalance.doubleValue() <= -10000) {
					resBal = creditBalance.divide(new BigDecimal("10000"), 4,
							BigDecimal.ROUND_DOWN);
					res = df.format(resBal) + "万";
				} else {
					res = df.format(creditBalance) + "元";
				}

			} catch (Exception e) {
				res = str;
				e.printStackTrace();
			}
		}
		println(res);
	}

	public static void yearsBetween() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date beginDate = sdf.parse("2015-01");
		Date endDate = sdf.parse("2015-11");
		if (beginDate.getTime() > endDate.getTime()) {
			println("123");
		} else {
			Calendar calst = Calendar.getInstance();
			Calendar caled = Calendar.getInstance();
			calst.setTime(beginDate);
			caled.setTime(endDate);
			// List<String> dealMons = new ArrayList<String>();
			while (calst.getTime().getTime() <= caled.getTime().getTime()) {
				String year_ = sdf.format(caled.getTime()).substring(0, 4);
				println(year_);
				caled.set(Calendar.YEAR, caled.get(Calendar.YEAR) - 1);
			}
		}
	}

	public static void monsBetween() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		Date beginDate = sdf.parse("2015-12");
		Date endDate = sdf.parse("2015-11");
		if (beginDate.getTime() > endDate.getTime()) {
		} else {
			Calendar calst = Calendar.getInstance();
			Calendar caled = Calendar.getInstance();
			calst.setTime(beginDate);
			caled.setTime(endDate);
			// List<String> dealMons = new ArrayList<String>();
			while (calst.getTime().getTime() <= caled.getTime().getTime()) {
				String mon_ = sdf.format(caled.getTime());
				println(mon_);
				caled.set(Calendar.MONTH, caled.get(Calendar.MONTH) - 1);
			}
		}
	}

	public static void formatBigdec2() throws Exception {
		DecimalFormat f = new DecimalFormat("0,000.00");
		BigDecimal big = new BigDecimal("12345678123456789.0123456");
		println(f.format(big));
	}

	public static void processDataFile() throws Exception {
		String dataFilePath = "D://temp/20150915/2_1110.txt";
		File tmpDataFile = new File(dataFilePath + ".datatmp");
		long len = tmpDataFile.length();
		println("len:" + len);
		File dataFile = new File(dataFilePath);
		dataFile.createNewFile();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(tmpDataFile), "UTF-8"));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(dataFile), "UTF-8"));
		int count = 0;
		while (br.ready()) {
			String line = br.readLine();
			String sep = "\\[new_line___\\]";
			line = line.replaceAll(sep, "\n");
			line = repErrEndLineChar(line);
			bw.write(line);
			// char c = (char) br.read();
			// if (c == '\r' || c == '\n') {
			count++;
			// } else {
			// bw.write(c);
			// }
		}
		println("count:" + count);
		br.close();
		bw.close();

	}

	public static String repErrEndLineChar(String line) {
		if (StringUtils.isEmpty(line))
			return line;
		while (line.endsWith("\\\n")) {
			line = line.substring(0, line.length() - 2) + "\n";
			println("repErrEndLineChar--------" + line);
		}
		return line;
	}

	public static void daysbetween2() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = sdf.parse("2015-10-26");
		Date endDate = sdf.parse("2015-11-25");
		Calendar calst = Calendar.getInstance();
		Calendar caled = Calendar.getInstance();
		calst.setTime(beginDate);
		caled.setTime(endDate);
		calst.set(Calendar.HOUR_OF_DAY, 0);
		calst.set(Calendar.MINUTE, 0);
		calst.set(Calendar.SECOND, 0);
		caled.set(Calendar.HOUR_OF_DAY, 0);
		caled.set(Calendar.MINUTE, 0);
		caled.set(Calendar.SECOND, 0);
		int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst
				.getTime().getTime() / 1000)) / 3600 / 24;
		int r = days + 1;
		println(r);
	}

	public static void rateMoneyGtPledgeMoeny() {
		double loanMoney = 100.00;
		double rateValue = 13.5;
		int monthNum = 1;
		double pledgeMoney = 20.0;
		int mon = monthNum + 1;
		double rateMoney = loanMoney * rateValue * mon * 0.01;

		boolean b = rateMoney > pledgeMoney;
		println(b);
	}

	public static void formatTimeShow() {
		long time = 3 * 60 * 60 * 1000 + 15 * 60 * 1000 + 53 * 1000;
		println(time);
		time = 25123123;
		String str = "";
		if (time < 1000) {
			str = time + "毫秒";
		} else if (time <= 60 * 1000) {
			BigDecimal t = new BigDecimal(time);
			t = t.divide(new BigDecimal(1000));
			str = df.format(t) + "秒";
		} else if (time <= 60 * 60 * 1000) {
			int f = (int) (time / (60 * 1000));
			int ms = (int) time - f * 60 * 1000;
			BigDecimal s = new BigDecimal(ms);
			s = s.divide(new BigDecimal(1000));
			str = f + "分钟" + df.format(s) + "秒";
		} else {
			int h = (int) (time / (60 * 60 * 1000));
			println("h:" + h);
			long ms = time - h * 60 * 60 * 1000;
			long s = ms / 1000;
			long f = s / 60;
			str = h + "小时" + f + "分钟";
		}
		println(str);
	}

	public static DecimalFormat df = new DecimalFormat("0");

	public static String formatDbl2Str(double d) {
		if (d == 0)
			return "0.00";
		BigDecimal b = new BigDecimal(d);
		return df.format(b);
	}

	public static void getExtractRows() throws Exception {
		String querySql = " select deal_mon ||'^~^^~^'|| corp_pk ||'^~^'|| corp_code  ||'^~^'|| corp_name ||'^~^'|| corp_short_name  ||'^~^'|| supply_pk  ||'^~^'|| supply_code ||'^~^'|| supply_name  ||'^~^'|| supply_short_name  ||'^~^'|| goods_code ||'^~^'|| goods_name  ||'^~^'|| orepoint_code  ||'^~^'|| orepoint_name ||'^~^'|| operator_id  ||'^~^'|| operator_name ||'^~^'|| approve_id  ||'^~^'|| approve_name  ||'^~^'|| approve_note ||'^~^'|| htbh ||'^~^'|| pk_monstatementhid  ||'^~^'|| vbillstatus  ||'^~^'|| sl  ||'^~^'|| nums  ||'^~^'|| moeny  ||'^~^'|| hand_moeny    from T_MPG_SUPPLY_BILL ;";
		querySql = querySql.trim().endsWith(";") ? querySql.trim().replaceAll(
				";", "") : querySql.trim();
		String userName = "bap_dw";
		String password = "bap";
		String ip = "192.168.10.42";
		String port = "1521";
		String name = "racdb1";
		String drive = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@" + ip + ":" + port + ":" + name;
		Connection conn = null;
		PreparedStatement ps;
		ResultSet rs;
		Statement st;
		// 初始化驱动包
		Class.forName(drive);
		// 根据数据库连接字符，名称，密码给conn赋值
		conn = DriverManager.getConnection(url, userName, password);
		String sql = "select count(1) cnt from (" + querySql + ")";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		rs.next();
		int cnt = rs.getInt(1);
		println(cnt);
	}

	public static void getFileRows() throws Exception {
		File file = new File("D://temp/20150906/2_5.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		int cnt = 0;
		while (br.ready()) {
			br.readLine();
			cnt++;
		}
		br.close();
		println("cnt:" + cnt);
	}

	public static void getSql() {
		String sql = "select * \rfrom dual";
		sql = sql.replaceAll("\n", " ").replaceAll("\r", " ");

		println(sql);

	}

	public static void bakFile() throws IOException {
		String fileName = "d://t1.txt";
		File file = new File(fileName);
		String name = file.getAbsolutePath();
		long time = System.currentTimeMillis();
		String bakName = name + ".bak" + time;
		File bakFile = new File(bakName);
		// bakFile.createNewFile();
		file.renameTo(bakFile);
		println("file name:" + name + ", bakFileName:" + bakName);
	}

	public static void testHttpLength() throws Exception {
		String url = "http://192.168.158.81:8080/HSSCM/app/supplyLoan/relationShipRecord.do";
		StringBuffer param = new StringBuffer(
				"supplyId=0001E110000000002OHR&a=");
		for (int i = 0; i < 159650; i++) {
			param.append("_a" + i + "_" + i);
		}
		String request = url + param.toString();
		println("=====================sendPost - request.length:"
				+ request.length());
		String response = TestHttpRequest.sendPost(url, param.toString());
		println(response);
		println("=====================sendPost - response.length:"
				+ response.length());

	}

	public static void testJDBC() throws Exception {
		String drive = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.158.241:1521:orcl";
		String username = "nc56true";
		String password = "nc56true";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Connection conn = null;
		PreparedStatement ps;
		ResultSet rs;
		Statement st;
		// 初始化驱动包
		Class.forName(drive);
		// 根据数据库连接字符，名称，密码给conn赋值
		conn = DriverManager.getConnection(url, username, password);
		println(conn);
		String sql = "select sysdate from dual";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		rs.next();
		println(rs.getMetaData().getColumnLabel(1) + ":"
				+ sdf.format(rs.getTimestamp(1)));

	}

	public static void testBigInteger() throws Exception {
		int b1 = 4;
		BigInteger sum = new BigInteger("1925219090486");
		// sum = sum.setBit(b1);
		// sum = sum.setBit(1040);
		boolean b = sum.testBit(b1);
		println("sum:" + sum + ", len:" + sum.toString().length() + ", b:" + b);
	}

	private static void testFileReader(int page) throws IOException {
		String fileName = "D://work/8月/从前有座灵剑山.txt";// D://work/8月/从前有座灵剑山.txt
		File file = new File(fileName);
		if (!file.exists()) {
			println(file.getAbsolutePath() + " is not exists");
			return;
		}
		long length = file.length();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName), "GBK"));
		int base = 3800000;
		int per = 5000;
		br.skip(base + per * page);
		int i = 0;
		int ch = 0;
		int maxSize = 60;
		int size = 0;
		int sum = 0;
		while (ch != -1) {
			ch = br.read();
			char c = (char) ch;
			if (c == '\r') {
				size = 0;
			} else {
				sum++;
			}
			if (size > 0 && size % maxSize == 0) {
				System.out.println();
			}
			if (sum > 0 && sum % 100000 == 0) {
				// System.out.println("sum:" + sum);
			}

			System.out.print(c);
			i++;
			size++;
			if (i >= per)
				break;
		}
		// System.out.println("\n end sum:" + sum);
		br.close();
	}

	private static void testDays() {
		Calendar beginCal = Calendar.getInstance();
		Date beginDate = beginCal.getTime();
		Calendar endCal = Calendar.getInstance();
		endCal.set(Calendar.MONTH, endCal.get(Calendar.MONTH) + 2);
		endCal.set(Calendar.DAY_OF_MONTH, endCal.get(Calendar.DAY_OF_MONTH) - 1);
		Date endDate = endCal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		println("beginDate:" + sdf.format(beginDate) + ", endDate:"
				+ sdf.format(endDate));
		int days = RateService.daysbetween(beginDate, endDate);
		println(days);

	}

	public static void checkSysCorp() {
		boolean b = false;
		String sysCode = "HS";
		String corpCode = "3001";
		String sysFlag = "HS_10";
		String[] ss = sysFlag.split("_");

		if (ss.length > 1 && StringUtils.isNotEmpty(ss[0])
				&& StringUtils.isNotEmpty(ss[1])) {
			String userSysCode = ss[0];
			String userCorpCode = ss[1];
			b = userSysCode.equals(sysCode) && userCorpCode.equals(corpCode);
		} else if (ss.length == 1 && StringUtils.isNotEmpty(ss[0])) {
			String userSysCode = ss[0];
			b = userSysCode.equals(sysCode);
		} else {
			b = true;
		}

		println(ss.length + "--" + b);

	}

	public static void testMatchs() {
		String NO_INTERCEPTOR_PATH = ".*/((login)|(logout)|(code)|(app)|(weixin)|(static)|(main)|(websocket)).*";
		String path = "http://localhost:8080/HSSCM/main/syssets/querySysSets.do";
		boolean b = path.matches(Const.NO_INTERCEPTOR_PATH);
		println(b);

	}

	public static void testPageStr() {
		Page p = new Page();
		p.setTotalResult(25);
		p.setCurrentPage(1);
		p.setShowCount(20);
		p.setTotalPage(2);
		println(p.getPageStr());
	}

	public static void formatBigDecimal() {
		double d = -0.12545;
		java.text.DecimalFormat df = new java.text.DecimalFormat("0.00");
		BigDecimal b = new BigDecimal(d);

		d = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		String s = df.format(d);
		println(d + "|" + s);
	}

	// 银行卡号格式化***
	public static void formatBankAccount(String no) {
		String s2 = no;
		if (no != null && no.length() >= 10) {
			int len = no.length();
			String p = no.substring(0, 4);
			String s = no.substring(len - 4, len);
			s2 = p + "*********" + s;
		}
		println(s2);
	}

	public static void getTotalRateMoney() throws Exception {
		String now = "2015-07-23";
		int repayDay = 26;
		int months = 3;
		double totalMoney = 50000;
		double rateValue = 1.15;
		double totalRateMoney = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date beginDate = sdf.parse(now);
		Calendar beginCal = Calendar.getInstance();
		beginCal.setTime(beginDate);
		Calendar endCal = Calendar.getInstance();
		endCal.setTime(beginDate);
		endCal.set(Calendar.DAY_OF_MONTH, repayDay);
		Date endDate = endCal.getTime();
		String beginDateStr = sdf.format(beginDate);
		String endDateStr = sdf.format(endDate);
		println("1.months:" + months + ",beginDate:" + beginDateStr
				+ ",endDate:" + sdf.format(endDate));
		if (beginDateStr.equals(endDateStr)) {
			endCal.set(Calendar.MONTH, endCal.get(Calendar.MONTH) + 1);
			endDate = endCal.getTime();
			println("2.months:" + months + ",beginDate:"
					+ sdf.format(beginDate) + ",endDate:" + sdf.format(endDate));

		} else if (beginDate.getTime() > endDate.getTime()) {
			months++;
			endCal.set(Calendar.MONTH, endCal.get(Calendar.MONTH) + 1);
			endDate = endCal.getTime();
			println("3.months:" + months + ",beginDate:"
					+ sdf.format(beginDate) + ",endDate:" + sdf.format(endDate));
		} else {
			months++;
		}
		for (int i = 0; i < months; i++) {
			if (i > 0) {
				beginCal.setTime(endDate);
				beginCal.set(Calendar.DAY_OF_MONTH,
						beginCal.get(Calendar.DAY_OF_MONTH) + 1);
				beginDate = beginCal.getTime();
				endCal.set(Calendar.MONTH, endCal.get(Calendar.MONTH) + 1);
				endDate = endCal.getTime();
			}

			int days = daysbetween(beginDate, endDate);
			double rateMoney = getRateMoney(totalMoney, rateValue, days);
			totalRateMoney += rateMoney;
			println("--------------.i:" + i + ", beginDate:"
					+ sdf.format(beginDate) + ", endDate:"
					+ sdf.format(endDate) + ", days:" + days + ", rateMoney:"
					+ rateMoney + ", totalRateMoney:" + totalRateMoney);
		}

	}

	public static double getRateMoney(double totalMoney, double rateValue,
			int days) {
		double d = (totalMoney * rateValue * days) / (30 * 100);
		BigDecimal b = new BigDecimal(d);
		return b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

	public static int daysbetween(Date beginDate, Date endDate) {
		Calendar calst = Calendar.getInstance();
		Calendar caled = Calendar.getInstance();
		calst.setTime(beginDate);
		caled.setTime(endDate);
		calst.set(Calendar.HOUR_OF_DAY, 0);
		calst.set(Calendar.MINUTE, 0);
		calst.set(Calendar.SECOND, 0);
		caled.set(Calendar.HOUR_OF_DAY, 0);
		caled.set(Calendar.MINUTE, 0);
		caled.set(Calendar.SECOND, 0);
		int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst
				.getTime().getTime() / 1000)) / 3600 / 24;
		return days + 1;
	}

	public static void formatJSON() {
		Map<String, Object> o = new HashMap<String, Object>();
		o.put("name", "散打");
		o.put("age", 16);
		JSONArray jo = JSONArray.fromObject(o);
		println(jo);
	}

	// 保留两位小数
	public static void formatDbl2(double d) {
		BigDecimal b = new BigDecimal(d);
		println(b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
	}

	public static void testHSSCMPwd() {
		String passwd = new SimpleHash("SHA-1", "admin", "1").toString();
		println(passwd);
	}

	// 判断验证邮箱链接是否在有效时间内
	public static void effctTime() {
		String time = "20150713102900";
		Date d = parseFormatTime(time);
		Date now = Calendar.getInstance().getTime();
		long dL = d.getTime();
		long nowL = now.getTime();
		long c = 1 * 60 * 60 * 1000;
		boolean b = dL + c >= nowL;
		println("b:" + b);
	}

	public static Date parseFormatTime(String time) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			return sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
			Date d = Calendar.getInstance().getTime();
			d.setTime(0);
			return d;
		}
	}

	public static void testJson() {
		Map<String, Object> par = new HashMap<String, Object>();
		par.put("uid", 25);
		par.put("time", "20150713102336");
		String jsonStr = JSON.toJSONString(null);
		println("jsonStr:" + jsonStr);

		Object obj = JSON.parse(null);
		Map<String, Object> m = obj == null ? null : (Map<String, Object>) obj;
		println("m:" + m);
		// println("m.uid:" + m.get("uid") + ",m.time:" + m.get("time"));

	}

	public static void testUuid() {
		UUID u = UUID.randomUUID();
		println(u.toString().replaceAll("-", ""));
	}

	public static void testJiemi() {
		String s = "ndcejfniiahchdf";
		String key = "0123456789";
		String str = "";
		int ch;
		for (int i = 0, j = 0; i < s.length(); i++, j++) {
			if (j > key.length() - 1) {
				j = j % key.length();
			}
			ch = (s.codePointAt(i) + 65535 - key.codePointAt(j));
			if (ch > 65535) {
				ch = ch % 65535;// ch - 33 = (ch - 33) % 95 ;
			}
			str += (char) ch;
		}
		println(str);
	}

	public static void testJiaimi() {
		String s = "uid=25&time=20150710171501";
		String key = "0123456789";
		String str = "";
		int ch;
		if (StringUtils.isNotEmpty(s)) {
			for (int i = 0, j = 0; i < s.length(); i++, j++) {
				if (j > key.length() - 1) {
					j = j % key.length();
				}
				ch = s.codePointAt(i) + key.codePointAt(j);
				if (ch > 65535) {
					ch = ch % 65535;// ch - 33 = (ch - 33) % 95 ;
				}
				str += (char) ch;
			}
		}
		println(str);
	}

	public static void testTimeFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = Calendar.getInstance().getTime();
		println(sdf.format(date));
	}

	public static boolean isEffectMail(String mail) {
		if (StringUtils.isEmpty(mail))
			return false;
		Pattern pattern = Pattern
				.compile("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}");
		Matcher matcher = pattern.matcher(mail.toUpperCase());
		return matcher.matches();
	}

	public static void testMail() {
		Mail mail = new Mail();
		// mail.setHost("smtp.139.com");
		// mail.setUsername("13957180842@139.com");
		// mail.setPassword("lyj87928731");
		// mail.setFrom("13957180842@139.com");

		mail.setHost("smtp.163.com");
		mail.setUsername("linyjDev@163.com");
		mail.setPassword("opnpwhqzljlxrhiy");
		mail.setFrom("linyjDev@163.com");

		mail.setTo("87928731@qq.com");
		mail.setSubject("主题-邮件linyj163");
		mail.setContent("这个是内容<font color='red' >红色的字</font><font color='green' >绿色的字</font>");
		boolean b = mail.toSend();
		System.out.println(b);
	}

	public static void testEncryptUtil() throws Exception {
		String pwd = "abc";
		String pwd1 = EncryptUtil.encrypt(pwd);
		println(pwd1);
		String pwd1_ = EncryptUtil.encrypt("Abc");
		println(pwd1_);
		String pwd2 = "zaBLco3WbbCXBCtxQxkJaa7JNe32tpf1";
		String pwd3 = EncryptUtil.decrypt(pwd2);
		println(pwd3);
	}

	public static void println(Object obj) {
		System.out.println(obj);
	}

}
