package com.test.main.day20150901;

import java.util.HashMap;
import java.util.Map;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @2015年9月1日 by linyj
 */
public class TestSpringTimer {
	public static Map<String, SchedulerFactoryBean> schedulerMap = new HashMap<String, SchedulerFactoryBean>();

	public static void main(String[] args) throws Exception {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(5);
		executor.setMaxPoolSize(50);
		executor.setQueueCapacity(500);
		executor.afterPropertiesSet();

		for (int i = 1; i <= 2; i++) {
			FooServiceImpl fs = new FooServiceImpl();
			fs.setId("100" + i);
			fs.setName("测试名称-100" + i);

			MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
			jobDetail.setTargetObject(fs);
			jobDetail.setTargetMethod("m1");
			jobDetail.setConcurrent(false);
			jobDetail.setName("jobDetail-1001");
			jobDetail.afterPropertiesSet();

			String expression = i + "/5 * * * * ?";
			if (i == 1) {
				expression = "0/10 * * * * ?";
			}
			CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
			cronTriggerFactoryBean.setName("trigger-100" + i);
			cronTriggerFactoryBean.setJobDetail(jobDetail.getObject());
			cronTriggerFactoryBean.setCronExpression(expression);
			cronTriggerFactoryBean.afterPropertiesSet();

			SchedulerFactoryBean scheduler = new SchedulerFactoryBean();
			scheduler.setTaskExecutor(executor);
			scheduler.setBeanName("scheduler-100" + i);
			scheduler.setJobDetails(jobDetail.getObject());
			scheduler.setTriggers(cronTriggerFactoryBean.getObject());
			scheduler.afterPropertiesSet();
			scheduler.start();
			System.out.println("--------"
					+ scheduler.getObject().getSchedulerName() + ".start()");

			schedulerMap.put(scheduler.getObject().getSchedulerName(),
					scheduler);
		}

	}
}
