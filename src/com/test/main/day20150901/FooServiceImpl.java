package com.test.main.day20150901;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @2015年9月1日 by linyj
 */
public class FooServiceImpl {
	private static int count = 0;

	private String id;
	private String name;

	public void m1() {
		try {
			count++;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date now = Calendar.getInstance().getTime();
			long threadId = Thread.currentThread().getId();
			String threadName = Thread.currentThread().getName();
			System.out.println("Thread[" + threadId + "," + threadName
					+ "]:m1()...id:" + id + ",name:" + name
					+ "........is called now is [" + sdf.format(now)
					+ "]   count:" + count + "  "
					+ TestSpringTimer.schedulerMap);
			if (count == 3) {
				SchedulerFactoryBean scheduler = TestSpringTimer.schedulerMap
						.get("scheduler-" + id);
				System.out.println("--------"
						+ scheduler.getObject().getSchedulerName()
						+ ".destroy()");
				scheduler.destroy();
				TestSpringTimer.schedulerMap.remove("scheduler-" + id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
