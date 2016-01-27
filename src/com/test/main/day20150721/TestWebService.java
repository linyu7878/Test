package com.test.main.day20150721;

import com.fh.app.controller.service.WebService;
import com.fh.app.controller.service.model.WebServiceAddress;
import com.runlion.api.product.hssn.ContractBO;

/**
 * @2015年7月21日 by linyj
 */
public class TestWebService {

	public static void main(String[] args) throws Exception {
		t3();

	}

	public static void t3() throws Exception {
		String interClass = "/uapws/service/com.cxbj.mobile.service.IMobileWebService";
		String method = "pubmethod";
		println(interClass);
		println(method);
		String rest = WebService.callWebServiceJSON(interClass, method,
				new String[] { "param1", "param2", "param3" }, new Object[] {
						"1002G1100000000ZMQ7Z", "DisAgreeDzdzd", "不愿意结算！" });// 1002G1100000000ZMQ7Z,1002G110000000137JU5
		println(rest);
	}

	public static void t2() throws Exception {
		String interClass = WebServiceAddress.getContract();
		String method = WebServiceAddress.getContractam();
		println(interClass);
		println(method);
		String rest = WebService.callWebServiceJSON(interClass, method,
				new String[] { "pk_corp", "pk_cubasdoc", "startdate",
						"enddate", "startNo", "maxCount" }, new Object[] { "",
						"", "", "", "", "" });
		println(rest);
	}

	public static void t1() {
		ContractBO bo = new ContractBO();
		bo.findContractAll("", "", "", "", "");

	}

	public static void println(Object o) {
		System.out.println(o);
	}
}
