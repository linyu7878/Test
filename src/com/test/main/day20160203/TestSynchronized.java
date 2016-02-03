package com.test.main.day20160203;

/**
 * @2016年2月3日 by linyj
 */
public class TestSynchronized {

	public static void main(String[] args) throws Exception {
		t3();
		// t2();
		// t1();

	}

	public static void t3() throws Exception {
		final Bean b2 = new Bean();
		Thread t1 = new Thread() {
			public void run() {
				b2.t3("333333");
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				b2.t3("4444444444444444");
			}
		};
		t1.start();
		t2.start();
	}

	public static void t2() throws Exception {
		final Bean b2 = new Bean();
		Thread t1 = new Thread() {
			public void run() {
				b2.t1("11111");
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				b2.t2("222222222");
			}
		};
		t1.start();
		t2.start();
	}

	public static void t1() throws Exception {
		Thread t1 = new Thread() {
			public void run() {
				Bean.t1("t1");
			}
		};
		Thread t2 = new Thread() {
			public void run() {
				Bean.t1("t2");
			}
		};
		t1.start();
		t2.start();
	}
}
