package com.test.main.day20150805;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fh.service.system.sets.SysSetsService;
import com.fh.util.PageData;

/**
 * @2015年8月5日 by linyj
 */
public class TestSysSetsService {
	public static void main(String[] args) throws Exception {
		t1();

	}

	public static void t1() throws Exception {
		SysSetsService s = (SysSetsService) getBean("sysSetsService");
		PageData set = s.selectSysSetsByCode("JY");
		println(set);
	}

	public static Object getBean(String bean) {
		String[] configLocations = { "spring/ApplicationContext.xml",
				"file:E://Porject/Workspaces/HSSCM/resources/spring/ApplicationContext-mvc.xml" };
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
