package com.test.main.day20150727;

import java.util.ArrayList;
import java.util.List;

import com.fh.webService.bean.ReqRoot;
import com.fh.webService.bean.ResRoot;
import com.fh.webService.bean.repay.LoanApprove;
import com.fh.webService.bean.repay.LoanRecord;
import com.fh.webService.bean.repay.LoanRepay;
import com.fh.webService.bean.repay.LoanRespone;
import com.fh.webService.utils.XmlUtil;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.XmlFriendlyReplacer;
import com.thoughtworks.xstream.io.xml.XppDriver;

/**
 * @2015年7月27日 by linyj
 */
public class TestXstream {

	public static void main(String[] args) throws Exception {
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><MBILL>  <serial_num/>  <timestamp/>  <user_id/>  <busi_code/>  <flag>0</flag>  <des>success</des>  <BILLS>    <BILL>      <loanid>XD201509280023</loanid>      <status>2</status>      <msg>审批通过</msg>      <approve_userid>woojun</approve_userid>      <approve_date>2015-09-28</approve_date>    </BILL>  </BILLS></MBILL>";
		ReqRoot req = XmlUtil.xml2loanApprove(xml);
		LoanApprove approve = (LoanApprove) req.getList().get(0);
		println(approve.getApproveDate());
		// t9();
		// t8();
		// t7();
		// t6();
		// t5();
		// t4();
		// t3();
		// t2();
		// t1();
	}

	public static void t9() {
		String xml = "	<?xml version=\"1.0\" encoding=\"UTF-8\"?><MBILL>  <serial_num>6bf985a4086d4ba0a0c9bc39a06c09aa</serial_num>  <timestamp>20150728105001</timestamp>  <user_id>admin</user_id>  <busi_code>小贷-NC审批回调</busi_code>  <BILLS>    <BILL>      <loanid>103</loanid>      <status>2</status>      <msg>审批通过</msg>      <approve_userid>123457890</approve_userid>    </BILL>  </BILLS></MBILL>";
		ReqRoot root = XmlUtil.xml2loanApprove("asds");
		println(root);
		List list = root.getList();
		LoanApprove loan = (LoanApprove) list.get(0);
		println(XmlUtil.toXml(loan));
	}

	public static void t8() {
		LoanApprove loan = new LoanApprove();
		loan.setApproveUserid("123457890");
		loan.setLoanid("103");
		loan.setStatus("2");
		loan.setMsg("审批通过");
		String xml = XmlUtil.loanApprove2xml("admin", loan);
		println(xml);

	}

	public static void t7() {
		String xml = "	<?xml version=\"1.0\" encoding=\"UTF-8\"?><MBILL>  <flag>0</flag>  <des>success</des>  <BILLS>    <BILL>      <stats>8</stats><loanid>103</loanid>    </BILL>  </BILLS></MBILL>";
		ResRoot root = XmlUtil.xml2loanRespone(xml);
		println(root);
		List list = root.getList();
		LoanRespone loan = (LoanRespone) list.get(0);
		println(XmlUtil.toXml(loan));
	}

	public static void t6() {
		LoanRespone r1 = new LoanRespone();
		r1.setLoanid("103");
		String xml = XmlUtil.loanRespone2xml("0", "success", r1);
		println(xml);

	}

	public static void t5() {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><MBILL>  <serial_num>709e78c9fc9948e181465e0404e84418</serial_num>  <timestamp>20150727171411</timestamp>  <user_id>admin</user_id>  <busi_code>小贷-还款</busi_code>  <BILLS>    <BILL>      <loanid>102</loanid>      <plan_id>96</plan_id>      <plan_repay_day>2015-08-26</plan_repay_day>      <plan_repay_money>1300.00</plan_repay_money>      <repay_money>1300.00</repay_money>      <repay_type>1</repay_type>      <is_last>否</is_last>    </BILL>    <BILL>      <loanid>102</loanid>      <plan_id>96</plan_id>      <plan_repay_day>2015-08-26</plan_repay_day>      <plan_repay_money>100000.00</plan_repay_money>      <repay_money>100000.00</repay_money>      <repay_type>2</repay_type>      <is_last>是</is_last>    </BILL>  </BILLS></MBILL>";
		ReqRoot root = XmlUtil.xml2loanRepay(xml);
		println(root);
		List list = root.getList();
		LoanRepay loan1 = (LoanRepay) list.get(0);
		println(XmlUtil.toXml(loan1));
		LoanRepay loan2 = (LoanRepay) list.get(1);
		println(XmlUtil.toXml(loan2));
	}

	public static void t4() {
		List<LoanRepay> list = new ArrayList<LoanRepay>();
		LoanRepay r1 = new LoanRepay();
		r1.setIsLast("N");
		r1.setLoanid("102");
		r1.setRepayType("1");
		r1.setPlanId("96");
		r1.setRepayMoney("1300.00");
		r1.setPlanRepayDay("2015-08-26");
		r1.setPlanRepayMoney("1300.00");
		r1.setSuminterest("30033.33");
		r1.setNpledgeamount("10000.00");
		list.add(r1);

		LoanRepay r2 = new LoanRepay();
		r2.setIsLast("Y");
		r2.setLoanid("102");
		r2.setRepayType("2");
		r2.setPlanId("96");
		r2.setRepayMoney("100000.00");
		r2.setPlanRepayDay("2015-08-26");
		r2.setPlanRepayMoney("100000.00");
		r2.setSuminterest("30033.33");
		r2.setNpledgeamount("10000.00");
		list.add(r2);
		String xml = XmlUtil.loanRepay2xml("admin", list);
		println(xml);

	}

	public static void t3() {
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><MBILL>  <serial_num>13380bd57f2f4351b6c9868938adc86d</serial_num>  <timestamp>20150727164355</timestamp>  <user_id>admin</user_id>  <busi_code>小贷-申请单提交</busi_code>  <BILLS>    <BILL>      <vbillno>101</vbillno>      <repay_type_code>1</repay_type_code>      <bankname>农业银行</bankname>    </BILL>  </BILLS></MBILL>";
		ReqRoot root = XmlUtil.xml2loanRecord(xml);
		println(root);
		List list = root.getList();
		LoanRecord loan = (LoanRecord) list.get(0);
		println(XmlUtil.toXml(loan));
	}

	public static void t2() {
		LoanRecord loan = new LoanRecord();
		loan.setVbillno("101");
		loan.setNloanamount("500000.00");
		loan.setRepay_type_code("1");
		loan.setRepayway("公司代还");
		loan.setDexpiredate("两年");
		loan.setRepaydate("26");
		loan.setRate("1.52");
		loan.setBankname("农业银行");
		loan.setBankno("12456789987654321");
		loan.setAccountname("李雪竹");
		loan.setPk_cubasdoc("00123");
		loan.setCustcode("A00123");
		loan.setPledgecompany("粉体材料悠闲公司");
		loan.setBusinessnumber("33333333xxxx");
		loan.setName("王宏亮");
		loan.setIdnumber("3331100011100445");
		loan.setPhonenum("1234567890");
		loan.setPk_corp("1001");
		loan.setCorpcode("GX1001");
		loan.setCorp_name("兰溪红狮");
		loan.setLoanfor("借款用途");
		loan.setNpledgeamount("50000.00");
		loan.setApplytype("1");
		String xml = XmlUtil.loanRecord2xml("admin", loan);
		println(xml);

	}

	public static void t1() throws Exception {
		XStream xs = new XStream(new XppDriver(new XmlFriendlyReplacer("_-",
				"_")));// 解决解析下划线时出现双下划线
		xs.alias("MBILL", Root.class);
		xs.aliasField("serial_num", Root.class, "serialNum");
		xs.aliasField("BILLS", Root.class, "list");
		xs.alias("BILL", Foo.class);
		xs.aliasField("vbillnoVbillno", Foo.class, "vbillno");

		Root root = new Root();
		root.setTimestamp(System.currentTimeMillis() + "");
		root.setBusiCode("小贷-申请单");
		root.setSerialNum("12345");
		root.setUserId("");
		List<Foo> list = new ArrayList<Foo>();
		Foo f1 = new Foo();
		f1.setVbillno("103");
		f1.setNloanamount("50000.00");
		f1.setPk_corp("A1_sdaqwe1233");
		f1.setCorp_name("公司名称123Xxxx");
		f1.setRepay_type_code("1");
		list.add(f1);

		Foo f2 = new Foo();
		f2.setVbillno("104");
		f2.setNloanamount("35000.00");
		list.add(f2);

		root.setList(list);

		println(root);
		println("1.--------------");
		String xml = xs.toXML(root);
		println(xml);
		println("2.--------------");
		Object obj = xs.fromXML(xml);
		Root root2 = obj == null ? null : (Root) obj;
		println(root2);

	}

	public static void println(Object obj) {
		System.out.println(obj);
	}

}
