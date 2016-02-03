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
import com.runlion.shop.common.util.JstlFunction;
import com.runlion.shop.common.util.MD5;
import com.runlion.shop.common.util.ReplaceUtils;
import com.runlion.shop.common.util.ehcache.EHCacheUtil;
import com.runlion.shop.controller.home2.NewsCyclopediaController;
import com.runlion.shop.service.ncinterface.NcInterface;
import com.runlion.shop.service.ncinterface.NcRequestParam;
import com.runlion.shop.service.ncinterface.NcReturnResult;
import com.unionpay.acp.sdk.CertUtil;
import com.unionpay.acp.sdk.SDKConfig;

/**
 * @2015年7月1日 by linyj
 */
public class Test {

	public static void main(String[] args) throws Exception {

		String p = "2,1";
		println(JstlFunction.formatPickway(p));

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

	private static void testDelHTMLTag() {
		String s = "有特殊性能的水泥和用于某种工程的专用水泥。2010年我国水泥总产量达18.68亿吨，特种水泥产量为1000多万吨，仅占水泥总产量的1%，与发达国家5%-10%的比重有着很大的差距。</p><p></p><div class=\"catalog01\"><div class=\"gray flr\">1　具有特殊性能的水泥和用于某种工程的专用水泥。</div><!--catalog_list-->                     <div class=\"clr\"></div></div><div class=\"catalog01\"><div class=\"gray flr\">2 &nbsp; &nbsp; 特种水泥品种繁多，主要有以下几种：</div><div class=\"catalog_list flr\"><p>　　快硬水泥 　也称早强水泥，通常以水泥的1天或3天抗压强度值确定标号。按其矿物组成不同可分为：硅酸盐快硬水泥、铝酸盐快硬水泥、硫铝酸盐快硬水泥和氟铝酸盐快硬水泥。按其早期强度增长速度不同又可分为：快硬水泥，以3天抗压强度值确定标号；特快硬水泥,以小时抗压强度值确定标号，氟铝酸盐快硬水泥即属特快硬水泥。 </p><p>　　低热和中热水泥 　这类水泥水化热较低，适用于大坝和其他大体积建筑。按水泥组成不同可分为硅酸盐中热水泥、普通硅酸盐中热水泥、矿渣硅酸盐低热水泥和低热微膨胀水泥等。低热和中热水泥是按水泥在3、7天龄期内放出的水化热量来区别。中国标准规定：低热水泥3、7天的水化热值,分别低于188×103和251×103焦/千克；中热水泥分别低于230×103和293×103焦/千克。 </p><p>　　抗硫酸盐水泥 　对硫酸盐腐蚀具有较高抵抗能力的水泥。按水泥矿物组成不同可分为抗硫酸盐硅酸盐水泥、铝酸盐贝利特水泥和矿渣锶水泥等。按水泥抵抗硫酸盐侵蚀能力的大小，又可分为抗硫酸盐水泥和高抗硫酸盐水泥。抗硫酸盐硅酸盐水泥是抗硫酸盐水泥的主要品种，由特定矿物组成的硅酸盐水泥熟料，掺加适量石膏磨细而成。中国标准规定：抗硫酸盐硅酸盐水泥熟料中，硅酸三钙含量不大于50%;铝酸三钙不大于5%；铝酸三钙与铁铝酸四钙含量不大于22%；游离石灰含量不得超过1.0%；氧化镁含量不得超过4.5%；而水泥中的三氧化硫含量不得超过2.5%；水泥的抗硫酸盐侵蚀指标,即腐蚀系数Fb不得小于 0.8。抗硫酸盐水泥适用于同时受硫酸盐侵蚀、冻融和干湿作用的海港工程、水利工程以及地下工程。 </p><p>　　油井水泥 　专用于油井、气井固井工程的水泥，也称堵塞水泥。按用途可分为普通油井水泥和特种油井水泥。普通油井水泥由适当矿物组成的硅酸盐水泥熟料和适量石膏磨细而成，必要时可掺加不超过水泥重量15%的活性混合材料（如矿渣），或不超过水泥重量10%的非活性混合材料（如石英砂、石灰石）。中国的普通油井水泥按油（气）井深度不同，分为45°C、75°C、95°C和 120°C四个品种，适用于一般油（气）井的固井工程。特种油井水泥通常由普通油井水泥掺加各种外加剂制成。 </p><p>　　膨胀水泥 　硬化过程中体积膨胀的水泥，按矿物组成不同，中国分为硅酸盐类膨胀水泥、铝酸盐类膨胀水泥、硫铝酸盐类膨胀水泥和氢氧化钙类膨胀水泥。硅酸盐膨胀水泥、明矾石膨胀水泥、氧化铁膨胀水泥、氧化镁膨胀水泥、 K型膨胀水泥等属于硅酸盐类膨胀水泥。这类水泥一般是在硅酸盐水泥中，掺加各种不同的膨胀组分磨制而成。如以高铝水泥和石膏作为膨胀组分，适量加入硅酸盐水泥中，可制得硅酸盐膨胀水泥。石膏矾土膨胀水泥属于铝酸盐类膨胀水泥，通常是在高铝水泥中掺加适量石膏和石灰共同磨制而成。硫铝酸盐膨胀水泥是由硫铝酸盐水泥熟料掺加适量石膏共同磨制而成。一般膨胀值较小的水泥，可配制收缩补偿胶砂和混凝土，适用于加固结构，灌筑机器底座或地脚螺栓，堵塞、修补漏水的裂缝和孔洞，以及地下建筑物的防水层等。膨胀值较大的水泥，也称自应力水泥，用于配制钢筋混凝土。自应力水泥在硬化初期，由于化学反应，水泥石体积膨胀，使钢筋受到拉应力，反之，钢筋使混凝土受到压应力，这种预压应力能够提高钢筋混凝土构件的承载能力和抗裂性能。对自应力水泥，要求其砂浆或混凝土在膨胀变形稳定后的自应力值大于2兆帕(一般膨胀水泥为1兆帕以下)。自应力水泥按矿物组成不同可分为硅酸盐类自应力水泥、铝酸盐类自应力水泥和硫铝酸盐类自应力水泥。这类水泥的抗渗性良好，适宜于制作各种直径的、承受不同液压和气压的自应力管，如城市水管、煤气管和其他输油、输气管道。 </p><p>　　膨胀水泥在硬化过程中，水泥中的矿物水化生成的水化物在结晶时会产生很大的膨胀能，人们利用这一原理研制成功了无声破碎剂，已应用于混凝土构筑物的拆除及岩石的开采、切割和破碎等方面，收到了良好的效果。 </p><p>　　耐火水泥 　耐火度不低于1580°C的水泥。按组成不同可分为铝酸盐耐火水泥、低钙铝酸盐耐火水泥、钙镁铝酸盐水泥和白云石耐火水泥等。耐火水泥可用于胶结各种耐火集料（如刚玉、煅烧高铝矾土等），制成耐火砂浆或混凝土，用于水泥回转窑和其他工业窑炉作内衬。 </p><p>　　白色水泥 　白色硅酸盐水泥是白色水泥中最主要的品种，是以氧化铁和其他有色金属氧化物含量低的石灰石、粘土、硅石为主要原料，经高温煅烧、淬冷成水泥熟料，加入适量石膏（也可加入少量白色石灰石代替部分熟料），在装有石质（或耐磨金属）衬板和研磨体的磨机内磨细而成的一种硅酸盐水泥。在制造过程中，为了避免有色杂质混入，煅烧时大多采用天然气或重油作燃料。也可用电炉炼钢生成的还原渣、石膏和白色粒化矿渣，配制成无熟料白色水泥。白色水泥的色泽以白度表示，分四个等级，用白度计测定。白色硅酸盐水泥的物理性能和普通硅酸盐水泥相似，主要用作建筑装饰材料，也可用于雕塑工艺制品。 </p><p>　　彩色水泥 　通常由白色水泥熟料、石膏和颜料共同磨细而成。所用的颜料要求在光和大气作用下具有耐久性，高的分散度，耐碱，不含可溶性盐，对水泥的组成和性能不起破坏作用。常用的无机颜料有氧化铁（可制红、黄、褐、黑色水泥）、二氧化锰（黑、褐色）、氧化铬（绿色）、钴蓝（蓝色）、群青蓝（蓝色）、炭黑（黑色）；有机颜料有孔雀蓝(蓝色)、天津绿（绿色）等。在制造红、褐、黑等深色彩色水泥时，也可用硅酸盐水泥熟料代替白色水泥熟料磨制。彩色水泥还可在白色水泥生料中加入少量金属氧化物作为着色剂，直接煅烧成彩色水泥熟料，然后再磨细，制成水泥。彩色水泥主要用作建筑装饰材料，也可用于混凝土、砖石等的粉刷饰面。 </p><p>　　防辐射水泥 　对X射线、γ射线、快中子和热中子能起较好屏蔽作用的水泥。这类水泥的主要品种有钡水泥、锶水泥、含硼水泥等。钡水泥以重晶石粘土为主要原料，经煅烧获得以硅酸二钡为主要矿物组成的熟料，再掺加适量石膏磨制而成。其比重达4.7～5.2,可与重集料(如重晶石、钢段等)配制成防辐射混凝土。钡水泥的热稳定性较差，只适宜于制作不受热的辐射防护墙。锶水泥是以碳酸锶全部或部分代替硅酸盐水泥原料中的石灰石，经煅烧获得以硅酸三锶为主要矿物组成的熟料，加入适量石膏磨制而成。其性能与钡水泥相近，但防射线性能稍逊于钡水泥。在高铝水泥熟料中加入适量硼镁石和石膏，共同磨细，可获得含硼水泥。这种水泥与含硼集料、重质集料可配制成比重较高的混凝土，适用于防护快中子和热中子的屏蔽工程。 </p><p>　　抗菌水泥 　在磨制硅酸盐水泥时，掺入适量的抗菌剂(如五氯酚、DDT等)而成。用它可配制抗菌混凝土,用在需要防止细菌繁殖的地方，如游泳池、公共澡堂或食品工业构筑物等。 </p><p>　　防藻水泥 　在高铝水泥熟料中掺入适量硫磺（或含硫物质）及少量的促硬剂(如消石灰等)，共同磨细而成。主要用于潮湿背荫结构的表面，防止藻类的附着，减轻藻类对构筑物的破坏作用。 </p></div><!--catalog_list-->                     <div class=\"clr\"></div></div><div class=\"catalog01\"><div class=\"gray flr\">3　2010年我国水泥总产量达18.68亿吨，特种<span style=\"line-height: 1.5;\">水泥产量为1000多万吨，仅占水泥总产量的1%，与发达国家</span><span style=\"line-height: 1.5;\">5%-10%的比重有着很大的差距。主要原因在于，我国对特</span><span style=\"line-height: 1.5;\">种水泥特性还缺乏充分的认识和了解，相应的工程设计和施</span><span style=\"line-height: 1.5;\">工规范（标准）尚待完善，很多该使用特种水泥的工程尚未得</span><span style=\"line-height: 1.5;\">到应用。</span></div><div class=\"catalog_list flr\"><p><br /></p><p>　　2013年10月，《关于化<span style=\"line-height: 1.5;\">解产能严重过剩矛盾的指导意见》出台</span><span style=\"line-height: 1.5;\">了。在文件中，特种水泥使用被提到</span><span style=\"line-height: 1.5;\">重要位置。具体措施为：鼓励依托现有水泥生产线，综合利</span><span style=\"line-height: 1.5;\">用废渣发展满足海洋、港口、核电、隧道等工程需要的特种</span><span style=\"line-height: 1.5;\">水泥等新产品。</span></p></div></div><br /><p></p>";
		s = NewsCyclopediaController.delHTMLTag(s);
		println(s);
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
