package com.test.main.day20151027;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.namespace.QName;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;

import com.alibaba.fastjson.JSON;

/**
 * @2015年10月27日 by linyj
 */
public class TestNCService {

	public static void main(String[] args) throws Exception {
		// t3();
		// t2();
		t1();

	}

	public static void t3() throws Exception {
		String method = "orderConfirmB2b";
		Map<String, Object> par = new HashMap<String, Object>();
		par.put("ncoid", "DSAP1510280006");// 订单号
		par.put("operator", "吴军海");// 操作人姓名

		String parStr = JSON.toJSONString(par);
		System.out.println(parStr);
		Object obj = callWebService(method, parStr);
		System.out.println(obj);
	}

	public static void t2() throws Exception {
		String method = "orderConfirmB2b";
		Map<String, Object> par = new HashMap<String, Object>();
		par.put("ncoid", "DSAP1510280006");// 订单号
		par.put("operator", "吴军海");// 操作人姓名

		String parStr = JSON.toJSONString(par);
		System.out.println(parStr);
		Object obj = callWebService(method, parStr);
		System.out.println(obj);
	}

	public static void t1() throws Exception {
		String method = "orderSendB2b";
		Map<String, Object> par = new HashMap<String, Object>();
		par.put("ncoid", "DSAP1510280014");// 订单号
		par.put("sendCount", 1);// 发货数量
		par.put("sendBatch", "1qaz2wsx");// 水泥编号
		par.put("sendDesc", "发货打算说明123qweqweq!NC");// 发货说明
		par.put("engineNo", "12321321");// 发动机号
		par.put("maxLoad", "5.5吨");// 最大载重量
		par.put("sender", "吴军海");// 发货人姓名

		String parStr = JSON.toJSONString(par);
		System.out.println(parStr);
		Object obj = callWebService(method, parStr);
		System.out.println(obj);
	}

	public static Object callWebService(String methodname, String parStr)
			throws Exception {
		String targetNamespace = "http://www.hongshids.com/NCService";
		// String url = "http://192.168.158.88:8080//services/NCService";
		String url = "http://devtest.hongshids.com//services/NCService";
		String method = methodname;
		Object o = null;
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setTargetEndpointAddress(new URL(url));

			call.setOperationName(new QName(targetNamespace, method)); //
			// call.addParameter("pkcorp1",
			// org.apache.axis.encoding.XMLType.XSD_STRING,
			// javax.xml.rpc.ParameterMode.IN);
			// // 设置要调用哪个方法
			Object[] params = { parStr };
			call.addParameter("in0",
					org.apache.axis.encoding.XMLType.XSD_STRING,
					javax.xml.rpc.ParameterMode.IN);
			call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// （标准的类型）
			o = call.invoke(params);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return o;
	}

}
