package com.test.main.day20160203;

/**
 * @2016年2月3日 by linyj
 */
public class Bean {

	public synchronized static void t1(String name) {
		System.out
				.println(System.currentTimeMillis() + "t1.......name:" + name);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public synchronized void t2(String name) {
		System.out
				.println(System.currentTimeMillis() + "t2.......name:" + name);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void t3(String name) {
		System.out.println(System.currentTimeMillis()
				+ "--------------t3.......name:" + name);
		synchronized (this) {
			System.out.println(System.currentTimeMillis() + "t3.......name:"
					+ name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(System.currentTimeMillis()
				+ "=================t3.......name:" + name);
	}
}
