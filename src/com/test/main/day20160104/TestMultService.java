package com.test.main.day20160104;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.fastjson.JSON;
import com.runlion.shop.entity.BspProducts;
import com.runlion.shop.entity.BspShipaddresses;
import com.runlion.shop.entity.ProductComboInfo;
import com.runlion.shop.service.business.MultlQueryService;
import com.runlion.shop.service.system.SequenceService;
import com.runlion.shop.vo.home2.ProductPrice;
import com.runlion.shop.vo.home2.SettlePickWay;
import com.runlion.shop.vo.home2.SkuGroup;

/**
 * @2016年1月4日 by linyj
 */
public class TestMultService {

	public static void main(String[] args) throws Exception {

		queryUserInvoices();
		// addUserInvoice();
		// queryProductCommentsLimit();
		// queryShopcart();
		// getSettlePickWay();
		// querySettlePickWay();
		// queryUserShipAddress();
		// queryProductPrice();
		// queryPidBySkuAttr();
		// queryProductSkus();
		// queryProductsByMid();
		// queryProductsLimit();
		// queryIndexProduct();
		// queryIndexCyclopedia();
		// queryPlaceByBrand();
		// queryAttrInit();
		System.exit(0);
	}

	public static void queryUserInvoices() throws Exception {
		MultlQueryService s = (MultlQueryService) getBean("multlQueryService");
		long b = System.currentTimeMillis();
		List<Map<String, Object>> list = s.queryUserInvoices(132, null, 1);
		long use = System.currentTimeMillis() - b;
		println("------------use:[" + use + "]ms");
		String str = JSON.toJSONString(list);
		println(str);
	}

	public static void addUserInvoice() throws Exception {
		MultlQueryService s = (MultlQueryService) getBean("multlQueryService");
		long b = System.currentTimeMillis();
		int id = s.addUserInvoice(132, 1, null, null, null, null, null, null,
				null, null, null, null, null, null, null, null, 1, null, null,
				1, null, null, null, null);
		long use = System.currentTimeMillis() - b;
		println("------------use:[" + use + "]ms");
		String str = JSON.toJSONString(id);
		println(str);
	}

	public static void queryProductCommentsLimit() throws Exception {
		MultlQueryService s = (MultlQueryService) getBean("multlQueryService");
		long b = System.currentTimeMillis();
		List<Map<String, Object>> list = s.queryProductCommentsLimit(1059, "",
				30, 10);
		int cnt = s.countProductComments(727, "");
		Map<String, Object> map = s.queryProductCommentsScores(727);
		long use = System.currentTimeMillis() - b;
		println("------------use:[" + use + "]ms");
		String str = JSON.toJSONString(list);
		println("cnt:" + cnt + ", " + str);
		String str2 = JSON.toJSONString(map);
		println("---------str2:" + str2);
	}

	public static void queryShopcart() throws Exception {
		MultlQueryService s = (MultlQueryService) getBean("multlQueryService");
		long b = System.currentTimeMillis();
		List<Map<String, Object>> list = s.queryShopcart(132);
		long use = System.currentTimeMillis() - b;
		println("------------use:[" + use + "]ms");
		String str = JSON.toJSONString(list);
		println(str);
	}

	public static void getSettlePickWay() throws Exception {
		MultlQueryService s = (MultlQueryService) getBean("multlQueryService");
		long b = System.currentTimeMillis();
		SettlePickWay list = s.getSettlePickWay(2, "1060_1,", 192229, -1);
		long use = System.currentTimeMillis() - b;
		println("------------use:[" + use + "]ms");
		String str = JSON.toJSONString(list);
		println(str);
	}

	public static void querySettlePickWay() throws Exception {
		MultlQueryService s = (MultlQueryService) getBean("multlQueryService");
		long b = System.currentTimeMillis();
		List<SettlePickWay> list = s.querySettlePickWay("1059_5,1050_10",
				192229, 45);
		long use = System.currentTimeMillis() - b;
		println("------------use:[" + use + "]ms");
		String str = JSON.toJSONString(list);
		println(str);
	}

	public static void queryUserShipAddress() throws Exception {
		MultlQueryService s = (MultlQueryService) getBean("multlQueryService");
		long b = System.currentTimeMillis();
		List<BspShipaddresses> list = s.queryUserShipAddress(132, 214787);
		long use = System.currentTimeMillis() - b;
		println("------------use:[" + use + "]ms");
		String str = JSON.toJSONString(list);
		println(str);
	}

	public static void queryProductPrice() throws Exception {
		MultlQueryService s = (MultlQueryService) getBean("multlQueryService");
		long b = System.currentTimeMillis();
		ProductPrice p = s.queryProductPrice(1050, 192229, 45);
		long use = System.currentTimeMillis() - b;
		println("------------use:[" + use + "]ms");
		String str = JSON.toJSONString(p);
		println(str);
	}

	public static void queryPidBySkuAttr() throws Exception {
		MultlQueryService s = (MultlQueryService) getBean("multlQueryService");
		long b = System.currentTimeMillis();
		int p = s.queryPidBySkuAttr(-1, 1051, 52, 223);
		long use = System.currentTimeMillis() - b;
		println("------------use:[" + use + "]ms");
		String str = JSON.toJSONString(p);
		println(str);
	}

	public static void queryProductSkus() throws Exception {
		MultlQueryService s = (MultlQueryService) getBean("multlQueryService");
		long b = System.currentTimeMillis();
		List<SkuGroup> list = s.queryProductSkus(1051, 118, 2142227, true);
		long use = System.currentTimeMillis() - b;
		println("------------use:[" + use + "]ms");
		String str = JSON.toJSONString(list);
		println(str);
	}

	public static void queryProductsByMid() throws Exception {
		MultlQueryService s = (MultlQueryService) getBean("multlQueryService");
		long b = System.currentTimeMillis();
		List<Map<String, Object>> list = s.queryProductsByMid(1051, 192228,
				null);
		long use = System.currentTimeMillis() - b;
		println("------------use:[" + use + "]ms");
		String str = JSON.toJSONString(list);
		println(str);
	}

	public static void queryProductsLimit() throws Exception {
		MultlQueryService s = (MultlQueryService) getBean("multlQueryService");
		long b = System.currentTimeMillis();
		List<Integer> attrIds = new ArrayList<Integer>();
		// attrIds.add(199);
		// List<Map<String, Object>> list = s.queryProductsLimit(192229, null,
		// attrIds, null, "pid desc", 0, 8);
		int list = s.countProductsLimit(192229, 1051, attrIds, null, null);
		long use = System.currentTimeMillis() - b;
		println("------------use:[" + use + "]ms");
		String str = JSON.toJSONString(list);
		println(str);
	}

	public static void queryIndexProduct() throws Exception {
		MultlQueryService s = (MultlQueryService) getBean("multlQueryService");
		long b = System.currentTimeMillis();
		List<BspProducts> list = s.queryIndexProduct(1, 0, 0, 4);
		long use = System.currentTimeMillis() - b;
		println("------------use:[" + use + "]ms");
		String str = JSON.toJSONString(list);
		println(str);
	}

	public static void queryIndexCyclopedia() throws Exception {
		MultlQueryService s = (MultlQueryService) getBean("multlQueryService");
		long b = System.currentTimeMillis();
		List<Map<String, Object>> list = s.queryIndexCyclopedia();
		long use = System.currentTimeMillis() - b;
		println("------------use:[" + use + "]ms");
		String str = JSON.toJSONString(list);
		println(str);
	}

	public static void queryPlaceByBrand() throws Exception {
		MultlQueryService s = (MultlQueryService) getBean("multlQueryService");
		long b = System.currentTimeMillis();
		ProductComboInfo c = s.queryPlaceByBrand(214877, 224);
		long use = System.currentTimeMillis() - b;
		println("------------use:[" + use + "]ms");
		String str = JSON.toJSONString(c);
		println(str);
	}

	public static void queryAttrInit() throws Exception {
		MultlQueryService s = (MultlQueryService) getBean("multlQueryService");
		long b = System.currentTimeMillis();
		List<Short> attridList = new ArrayList<Short>();
		attridList.add((short) 49);
		attridList.add((short) 47);
		List<ProductComboInfo> list = s.queryAttrInit(214877, 76, null, null,
				true, false);
		long use = System.currentTimeMillis() - b;
		println("------------use:[" + use + "]ms");
		String str = JSON.toJSONString(list);
		println(str);
	}

	public static void t1() throws Exception {
		SequenceService s = (SequenceService) getBean("sequenceService");
		println(s);
		int id = s.getSeqNo("test_t1");
		println(id);
	}

	public static Object getBean(String bean) {
		String path = "file:E://Porject/Workspaces/HSSNSHOPADMIN/resources/spring/";
		String[] configLocations = { path + "spring-dao.xml",
				path + "spring-servlet.xml", path + "spring-mvc.xml" };
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				configLocations);

		// ClassPathXmlApplicationContext
		println("------------------------init:" + ctx);
		return ctx.getBean(bean);
	}

	public static void println(Object obj) {
		System.out.println(obj);
	}
}
