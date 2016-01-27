package com.test.main.day20151224;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.runlion.shop.entity.nc.PresellAccountDetailPOJO;
import com.runlion.shop.entity.nc.TransferTypePOJO;
import com.runlion.shop.entity.nc.YSKPOJO;
import com.runlion.shop.service.ncinterface.NcInterface;
import com.runlion.shop.service.presell.PresellService;

/**
 * @2015年12月24日 by linyj
 */
public class TestNcInterface {

	public static void main(String[] args) throws Exception {
		queryIncomeDetailLimit();
		// getReceiptTypeInfo();
		// queryInType();
		// queryOutType();
		// queryAccountDetial();
		// t1();
		// t2();

	}

	public static void queryIncomeDetailLimit() throws Exception {
		String pk_corp = "1002";
		String cropName = "";
		String cubasdocid = "0001U8100000001ICS01";
		String bgdate = "2015-12-12";
		String eddate = "2015-12-29";
		int pagesize = 15;
		int curPageNo = 2;
		String typename = "临时预收款";

		PresellService ps = new PresellService();
		Map<String, Object> map = ps.queryIncomeDetailLimit(pk_corp, cropName,
				cubasdocid, bgdate, eddate, pagesize, curPageNo, typename);
		String str = JSON.toJSONString(map);
		System.out.println(str);
	}

	public static void getReceiptTypeInfo() throws Exception {
		String pk_corp = "";
		String cubasdocid = "0001U8100000001ICS01";
		String code = "";

		PresellService ps = new PresellService();
		List<YSKPOJO> list = ps.getReceiptTypeInfo(cubasdocid);
		String str = JSON.toJSONString(list);
		System.out.println(str);
	}

	public static void queryInType() throws Exception {
		String pk_corp = "1002";
		String cubasdocid = "";
		String flag = "1";

		PresellService ps = new PresellService();
		List<TransferTypePOJO> list = ps.queryInType(cubasdocid, pk_corp, flag);
		String str = JSON.toJSONString(list);
		System.out.println(str);
	}

	public static void queryOutType() throws Exception {
		String pk_corp = "1002";
		String cubasdocid = "0001U8100000001ICS01";
		String flag = "2";

		PresellService ps = new PresellService();
		List<TransferTypePOJO> list = ps
				.queryOutType(cubasdocid, pk_corp, flag);
		String str = JSON.toJSONString(list);
		System.out.println(str);
	}

	public static void queryAccountDetial() throws Exception {
		PresellService ps = new PresellService();
		List<PresellAccountDetailPOJO> list = ps.queryAccountDetial("1002",
				"兰溪超级锋", "0001U8100000001ICS01");
		String str = JSON.toJSONString(list);
		System.out.println(str);
	}

	public static void t2() throws Exception {
		String methodname = "getAllAccountInfo";
		String[] paramnames = new String[] { "pk_corp", "cubasdocid", "curdate" };
		Object[] params = new Object[] { "1002", "0001U8100000001ICS01",
				"2015-12-24" };

		Object obj = NcInterface.callWebServiceIMobile(methodname, paramnames,
				params, false);
		System.out.println(obj);
	}

	public static void t1() throws Exception {
		String methodname = "getCurReceiptInfos";
		String[] paramnames = new String[] { "pk_corp", "cubasdocid", "curdate" };
		Object[] params = new Object[] { "1002", "0001U8100000001ICS01",
				"2015-12-24" };

		Object obj = NcInterface.callWebServiceIMobile(methodname, paramnames,
				params, false);
		System.out.println(obj);
	}
}
