package com.test.main.day20151130;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.runlion.shop.service.system.SequenceService;

/**
 * @2015年11月30日 by linyj
 */
public class TestService {

	public static void main(String[] args) throws Exception {
		t1();

	}

	public static void t2() throws Exception {
		SequenceService s = (SequenceService) getBean("sequenceService");
		int id = s.getSeqNo("test_t1");
		println(id);
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
