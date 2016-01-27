package com.test.main.day20160126;

import java.io.IOException;
import java.io.InputStream;

/**
 * @2016年1月26日 by linyj
 */
public class TestCmd {

	public static void main(String[] args) throws IOException,
			InterruptedException {
		t1();//增加一个注释-test-add
	}

	public static void t1() throws IOException, InterruptedException {
		String batFilePath = "D://test/test.bat";
		exec2(batFilePath);
	}

	public static void exec2(String batFilePath) throws IOException,
			InterruptedException {
		Runtime r = Runtime.getRuntime();
		Process p = r.exec(batFilePath);
		byte[] b = new byte[1024];
		int readbytes = -1;
		StringBuffer sb = new StringBuffer();
		// 读取进程输出值
		// 在JAVA IO中,输入输出是针对JVM而言,读写是针对外部数据源而言
		InputStream in = p.getInputStream();
		try {
			while ((readbytes = in.read(b)) != -1) {
				sb.append(new String(b, 0, readbytes));
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
		System.out.println("--------sb:[" + sb + "]");
		p.waitFor();
		int ret = p.exitValue();
		System.out.println("--------------exec2(" + batFilePath
				+ ") the exitValue() return code is " + ret);
	}

}
