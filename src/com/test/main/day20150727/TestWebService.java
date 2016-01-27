package com.test.main.day20150727;

import java.net.URL;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import com.fh.webService.bean.repay.LoanApprove;
import com.fh.webService.utils.XmlUtil;

/**
 * @2015年7月27日 by linyj
 */
public class TestWebService {

	public static void main(String[] args) throws Exception {

		t6();
		// t5();
		// t4();
		// t3();
		// t2();
		// t1();
	}

	public static void t6() throws Exception {
		String address = "192.168.158.88:8080/HSSCM";
		String interclass = "/webService/LoanWebServicePort";
		String methodname = "supplyBillBack";
		String[] paramnames = { "arg0" };

		// BillFeedback fb = new BillFeedback();
		// fb.setMon_pk("1002G1100000000ZMQ7Z");
		// String xml = XmlUtil.billFeedback2xml("admin", fb);
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?><MBILL>  <BILLS>    <BILL>      <mon_pk>1002G11000000010XM7X</mon_pk>    </BILL>  </BILLS></MBILL>";
		// xml =
		// "<?xml version=\"1.0\" encoding=\"utf-8\"?><MBILL>  <flag>0</flag>  <des>success</des>  <BILLS>    <BILL>      <loanid>12412</loanid>      <status>2</status>      <msg>审批通过</msg>    </BILL>  </BILLS></MBILL>";
		println(xml);
		Object[] params = { xml };

		String soapaction = address + "/";
		String url = "http://" + address + interclass;
		String method = methodname;
		try {
			println("url:" + url);
			Service service = new Service();
			Call call = (Call) service.createCall();

			call.setTargetEndpointAddress(new URL(url));

			call.setOperationName(new QName("http://webService.web.fh.com/",
					method)); //
			// call.addParameter("pkcorp1",
			// org.apache.axis.encoding.XMLType.XSD_STRING,
			// javax.xml.rpc.ParameterMode.IN);
			// // 设置要调用哪个方法
			for (int i = 0, ilen = paramnames.length; i < ilen; i++) {
				call.addParameter(paramnames[i],
						org.apache.axis.encoding.XMLType.XSD_STRING,
						javax.xml.rpc.ParameterMode.IN);
			}

			call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// （标准的类型）

			Object o = call.invoke(params);

			println("--------:" + o);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void t5() throws Exception {
		// String address = "192.168.158.85:83";
		String address = "192.168.10.251:80";
		String interclass = "/uapws/service/com.cxbj.mobile.service.IMobileWebService";
		String methodname = "getCorpInfo";
		String[] paramnames = { "pkcorp" };

		String xml = "1005";

		Object[] params = { xml };

		String url = "http://" + address + interclass;
		String method = methodname;
		try {
			println("url:" + url);
			Service service = new Service();
			Call call = (Call) service.createCall();

			call.setTargetEndpointAddress(new URL(url));

			call.setTimeout(3000);

			call.setOperationName(new QName("192.168.158.85:83", method)); // http://loan.hsll.itf.nc/ILoanWebService
			// call.addParameter("pkcorp1",
			// org.apache.axis.encoding.XMLType.XSD_STRING,
			// javax.xml.rpc.ParameterMode.IN);
			// // 设置要调用哪个方法
			for (int i = 0, ilen = paramnames.length; i < ilen; i++) {
				call.addParameter(paramnames[i],
						org.apache.axis.encoding.XMLType.XSD_STRING,
						javax.xml.rpc.ParameterMode.IN);
			}

			call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// （标准的类型）

			Object o = call.invoke(params);

			println("--------:" + o);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void t4() throws Exception {
		// String address = "192.168.158.241:56";
		String address = "192.168.10.251:80";
		String interclass = "/uapws/service/nc.itf.hsll.loan.ILoanWebService";
		String methodname = "repay";
		String[] paramnames = { "paramStr" };

		// String xml =
		// "<?xml version=\"1.0\" encoding=\"UTF-8\"?><MBILL>  <serial_num>a0c818c1bb3047d3b64c62c01a5f73d0</serial_num>  <timestamp>20150804170210</timestamp>  <user_id>sys</user_id>  <busi_code>小贷-还款</busi_code>  <BILLS>    <BILL>      <loanid>12412</loanid>      <plan_id>170</plan_id>      <plan_repay_day>2015-08-04</plan_repay_day>      <plan_repay_money>1629.17</plan_repay_money>      <repay_user_id>df96df0778b8471a9b071199564ddf57</repay_user_id>      <repay_money>1629.17</repay_money>      <repay_type>1</repay_type>      <is_last>N</is_last>      <had_repay_money>0</had_repay_money>      <need_repay_money>0</need_repay_money>      <suminterest>8145.83</suminterest>      <npledgeamount>50000.00</npledgeamount>      <repay_date>2015-08-04</repay_date>      <repay_person_type>1</repay_person_type>      <repay_corp_id>1002</repay_corp_id>      <repay_corp_code>3101</repay_corp_code>      <recv_unit_id>1035</recv_unit_id>      <recv_unit_code>3130</recv_unit_code>    </BILL>  </BILLS></MBILL>";

		// String xml =
		// "<?xml version=\"1.0\" encoding=\"UTF-8\"?><MBILL>  <serial_num>c10545736c7c42adb0718cae0c2d6f77</serial_num>  <timestamp>20150923110043</timestamp>  <user_id>sys</user_id>  <busi_code>小贷-还款</busi_code>  <BILLS>    <BILL>      <loanid>62</loanid>      <plan_id>341</plan_id>      <plan_repay_day>2015-09-20</plan_repay_day>      <plan_repay_money>18.00</plan_repay_money>      <repay_user_id>0001E110000000002OHR</repay_user_id>      <repay_money>18.00</repay_money>      <repay_type>1</repay_type>      <is_last>N</is_last>      <had_repay_money>0</had_repay_money>      <need_repay_money>0</need_repay_money>      <suminterest>51.72</suminterest>      <npledgeamount>117.60</npledgeamount>      <repay_date>2015-09-23</repay_date>      <repay_person_type>1</repay_person_type>      <repay_corp_id>1008</repay_corp_id>      <repay_corp_code>3301</repay_corp_code>      <recv_unit_id>1035</recv_unit_id>      <recv_unit_code>3130</recv_unit_code>    </BILL>  </BILLS></MBILL>";
		String xml = "<MBILL>  <serial_num>871dba337aec405d94180c3846917e05</serial_num>  <timestamp>20150929161723</timestamp>  <user_id>sys</user_id>  <busi_code>小贷-还款</busi_code>  <BILLS>    <BILL>      <loanid>XD201509290008</loanid>      <plan_id>361</plan_id>      <plan_repay_day>2015-11-20</plan_repay_day>      <plan_repay_money>868.00</plan_repay_money>      <repay_user_id>0001E110000000002OHR</repay_user_id>      <repay_money>868.00</repay_money>      <repay_type>1</repay_type>      <is_last>N</is_last>      <had_repay_money>0</had_repay_money>      <need_repay_money>0</need_repay_money>      <suminterest>2548.00</suminterest>      <npledgeamount>12000.00</npledgeamount>      <repay_date>2015-09-29</repay_date>      <repay_person_type>1</repay_person_type>      <repay_corp_id>1002</repay_corp_id>      <repay_corp_code>3101</repay_corp_code>      <recv_unit_id>1035</recv_unit_id>      <recv_unit_code>3130</recv_unit_code>    </BILL>  </BILLS></MBILL>";

		Object[] params = { xml };

		String url = "http://" + address + interclass;
		String method = methodname;
		try {
			println("url:" + url);
			Service service = new Service();
			Call call = (Call) service.createCall();

			call.setTargetEndpointAddress(new URL(url));

			call.setOperationName(new QName(address, method)); // http://loan.hsll.itf.nc/ILoanWebService
			// call.addParameter("pkcorp1",
			// org.apache.axis.encoding.XMLType.XSD_STRING,
			// javax.xml.rpc.ParameterMode.IN);
			// // 设置要调用哪个方法
			for (int i = 0, ilen = paramnames.length; i < ilen; i++) {
				call.addParameter(paramnames[i],
						org.apache.axis.encoding.XMLType.XSD_STRING,
						javax.xml.rpc.ParameterMode.IN);
			}

			call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// （标准的类型）

			Object o = call.invoke(params);

			println("--------:" + o);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void t3() throws Exception {
		// String address = "192.168.10.251:80";
		// String address = "192.168.10.221:80";
		String address = "192.168.158.241:56";
		String interclass = "/uapws/service/nc.itf.hsll.loan.ILoanWebService";
		String methodname = "moveLoanRequisition";
		String[] paramnames = { "loanRequisition" };

		// String xml =
		// "<?xml version=\"1.0\" encoding=\"UTF-8\"?><MBILL>  <serial_num>1d97786d2e744fdd8dfaac29dd6903a9</serial_num>  <timestamp>20150804160452</timestamp>  <user_id>df96df0778b8471a9b071199564ddf57</user_id>  <busi_code>小贷-申请单提交</busi_code>  <BILLS>    <BILL>      <vbillno>12412</vbillno>      <nloanamount>1.00</nloanamount>      <repay_type_code>1</repay_type_code>      <repayway>公司代还</repayway>      <dexpiredate>一个月</dexpiredate>      <repaydate>26</repaydate>      <rate>0.86</rate>      <bankname>农业银行</bankname>      <bankno>3333444455556666777</bankno>      <accountname>李雪东</accountname>      <pk_cubasdoc>0001E110000000002OHR</pk_cubasdoc>      <custcode>100028</custcode>      <pledgecompany>兰溪市汇鑫贸易有限公司</pledgecompany>      <businessnumber></businessnumber>      <name>liucs</name>      <idnumber>350781199009222317</idnumber>      <phonenum>18551740922</phonenum>      <pk_corp>1002</pk_corp>      <corpcode>3101</corpcode>      <corp_name>浙江红狮水泥股份有限公司</corp_name>      <loanfor>F</loanfor>      <npledgeamount>0.20</npledgeamount>      <applytype>1</applytype>      <loan_unitid>1035</loan_unitid>      <loan_unitcode>3130</loan_unitcode>      <loan_unitname>兰溪汇鑫小额贷款股份有限公司</loan_unitname>    </BILL>  </BILLS></MBILL>";
		String xml = " <MBILL>  <serial_num>8a33f1e841514dc3b8a16104283a9923</serial_num>  <timestamp>20150930153523</timestamp>  <user_id>3b49eb9d70434e85963577ee02f36ff3</user_id>  <busi_code>小贷-申请单提交</busi_code>  <BILLS>    <BILL>      <vbillno>XD201509300001</vbillno>      <nloanamount>50000.00</nloanamount>      <repay_type_code>1</repay_type_code>      <repayway>公司代还</repayway>      <dexpiredate>一个月</dexpiredate>      <repaydate>20</repaydate>      <rate>13.50</rate>      <bankname>中国农业银行</bankname>      <bankno>6268481234567890045</bankno>      <accountname>刘陈述</accountname>      <pk_cubasdoc>0001U8100000000WHB2U</pk_cubasdoc>      <custcode>ceshi</custcode>      <pledgecompany>测试客户</pledgecompany>      <businessnumber></businessnumber>      <name>刘陈述</name>      <idnumber>330781199009222317</idnumber>      <phonenum>18551740999</phonenum>      <pk_corp>1002</pk_corp>      <corpcode>3101</corpcode>      <corp_name>浙江红狮水泥股份有限公司</corp_name>      <loanfor>周转</loanfor>      <npledgeamount>10000.00</npledgeamount>      <applytype>1</applytype>      <loan_unitid>1035</loan_unitid>      <loan_unitcode>3130</loan_unitcode>      <loan_unitname>兰溪汇鑫小额贷款股份有限公司</loan_unitname>      <business_license></business_license>      <max_loan_balance>250000000.00</max_loan_balance>      <credit_balance>300000000.00</credit_balance>    </BILL>  </BILLS></MBILL>";
		// String xml =
		// "<MBILL>  <BILLS>    <BILL>      <vbillno>XD201509300001</vbillno>      <nloanamount>50000.00</nloanamount>      <repay_type_code>1</repay_type_code>      <repayway>公司代还</repayway>      <dexpiredate>一个月</dexpiredate>      <repaydate>20</repaydate>      <rate>13.50</rate>      <bankname>中国农业银行</bankname>      <bankno>6268481234567890045</bankno>      <accountname>刘陈述</accountname>      <pk_cubasdoc>0001U8100000000WHB2U</pk_cubasdoc>      <custcode>ceshi</custcode>      <pledgecompany>测试客户</pledgecompany>      <businessnumber></businessnumber>      <name>刘陈述</name>      <idnumber>330781199009222317</idnumber>      <phonenum>18551740999</phonenum>      <pk_corp>1002</pk_corp>      <corpcode>3101</corpcode>      <corp_name>浙江红狮水泥股份有限公司</corp_name>      <loanfor>周转</loanfor>      <npledgeamount>10000.00</npledgeamount>      <applytype>1</applytype>      <loan_unitid>1035</loan_unitid>      <loan_unitcode>3130</loan_unitcode>      <loan_unitname>兰溪汇鑫小额贷款股份有限公司</loan_unitname>      <business_license></business_license>      <max_loan_balance>250000000.00</max_loan_balance>      <credit_balance>300000000.00</credit_balance>    </BILL>  </BILLS></MBILL>";
		System.out.println("xml---------------:" + xml);

		Object[] params = { xml };

		String url = "http://" + address + interclass;
		String method = methodname;
		try {
			println("url:" + url);
			Service service = new Service();
			Call call = (Call) service.createCall();

			call.setTargetEndpointAddress(new URL(url));

			// call.setTimeout(3000);

			call.setOperationName(new QName(
					"http://loan.hsll.itf.nc/ILoanWebService", method)); //
			// call.addParameter("pkcorp1",
			// org.apache.axis.encoding.XMLType.XSD_STRING,
			// javax.xml.rpc.ParameterMode.IN);
			// // 设置要调用哪个方法
			for (int i = 0, ilen = paramnames.length; i < ilen; i++) {
				call.addParameter(paramnames[i],
						org.apache.axis.encoding.XMLType.XSD_STRING,
						javax.xml.rpc.ParameterMode.IN);
			}

			call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// （标准的类型）

			Object o = call.invoke(params);

			println("ret--------:" + o);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void t2() throws Exception {
		// String address = "192.168.158.85:83";
		String address = "192.168.10.251:80";
		String interclass = "/uapws/service/nc.itf.hsll.loan.ILoanWebService";
		String methodname = "getCreditLine";
		String[] paramnames = { "param" };

		LoanApprove loan = new LoanApprove();
		loan.setApproveUserid("admin");
		loan.setLoanid("103");
		loan.setStatus("4");
		loan.setMsg("审批不通过，因为不高兴~");
		// String xml = XmlUtil.loanApprove2xml("admin", loan);
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><MBILL><pk_corp></pk_corp><pk_cubasdoc></pk_cubasdoc><code_corp>3301</code_corp><code_cubasdoc>100028</code_cubasdoc></MBILL>";

		Object[] params = { xml };

		String soapaction = address + "/";
		String url = "http://" + address + interclass;
		String method = methodname;
		try {
			println("url:" + url);
			Service service = new Service();
			Call call = (Call) service.createCall();

			call.setTargetEndpointAddress(new URL(url));

			// call.setTimeout(3000);

			call.setOperationName(new QName("192.168.158.85:83", method)); // http://loan.hsll.itf.nc/ILoanWebService
			// call.addParameter("pkcorp1",
			// org.apache.axis.encoding.XMLType.XSD_STRING,
			// javax.xml.rpc.ParameterMode.IN);
			// // 设置要调用哪个方法
			for (int i = 0, ilen = paramnames.length; i < ilen; i++) {
				call.addParameter(paramnames[i],
						org.apache.axis.encoding.XMLType.XSD_STRING,
						javax.xml.rpc.ParameterMode.IN);
			}

			call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// （标准的类型）

			Object o = call.invoke(params);

			println("--------:" + o);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void t1() throws Exception {
		String address = "192.168.158.81:8080/HSSCM";
		String interclass = "/webService/LoanWebServicePort";
		String methodname = "doApprove";
		String[] paramnames = { "arg0" };

		LoanApprove loan = new LoanApprove();
		loan.setApproveUserid("admin");
		loan.setLoanid("17");
		loan.setStatus("2");
		loan.setMsg("审批通过!");
		String xml = XmlUtil.loanApprove2xml("admin", loan);

		// xml =
		// "<?xml version=\"1.0\" encoding=\"utf-8\"?><MBILL>  <flag>0</flag>  <des>success</des>  <BILLS>    <BILL>      <loanid>12412</loanid>      <status>2</status>      <msg>审批通过</msg>    </BILL>  </BILLS></MBILL>";
		println(xml);
		Object[] params = { xml };

		String soapaction = address + "/";
		String url = "http://" + address + interclass;
		String method = methodname;
		try {
			println("url:" + url);
			Service service = new Service();
			Call call = (Call) service.createCall();

			call.setTargetEndpointAddress(new URL(url));

			call.setOperationName(new QName("http://webService.web.fh.com/",
					method)); //
			// call.addParameter("pkcorp1",
			// org.apache.axis.encoding.XMLType.XSD_STRING,
			// javax.xml.rpc.ParameterMode.IN);
			// // 设置要调用哪个方法
			for (int i = 0, ilen = paramnames.length; i < ilen; i++) {
				call.addParameter(paramnames[i],
						org.apache.axis.encoding.XMLType.XSD_STRING,
						javax.xml.rpc.ParameterMode.IN);
			}

			call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// （标准的类型）

			Object o = call.invoke(params);

			println("--------:" + o);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void println(Object obj) {
		System.out.println(obj);
	}

}
