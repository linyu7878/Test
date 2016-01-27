package com.test.main.day20151120;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.runlion.shop.common.token.Token;
import com.runlion.shop.common.util.MemcachedUtil;

/**
 * @2015年11月20日 by linyj
 */
public class TestMemcached {

	public static void main(String[] args) {
		t4();
		Object o = MemcachedUtil.get("token_a8c34d04998d4a9a8890d063523f86c2");
		System.out.println("----------o:" + o);
		// boolean b = MemcachedUtil.delete("key");
		// System.out.println("----------b:" + b);
		// t3();
		// t2();
		// t1();

	}

	public static void t4() {
		String[] keys = allkeys("192.168.158.208", 11211).split("\n");
		Arrays.sort(keys);
		for (String s : keys) {
			System.out.println(s);
		}
		System.out.println(telnet("192.168.158.208", 11211, "stats"));
	}

	public static void t3() {
		boolean b = MemcachedUtil.set("123", "在萨达");
		System.out.println(b);
		// b = MemcachedUtil.delete(token.getUuid());
		// System.out.println(b);
		String t = (String) MemcachedUtil.get("123");
		System.out.println(t);

	}

	public static void t2() {
		Token token = new Token();
		token.setUuid("123qwe4");
		token.setUid(11);
		token.setUsername("中文测试啊123");
		boolean b = MemcachedUtil.set(token.getUuid(), token);
		System.out.println(b);
		b = MemcachedUtil.delete(token.getUuid());
		System.out.println(b);
		Token t = (Token) MemcachedUtil.get("123qwe4");
		System.out.println(t);
	}

	public static void t1() {
		Map<String, Map<String, String>> status = MemcachedUtil.status();
		System.out.println(status);
	}

	public static String allkeys(String host, int port) {
		StringBuffer r = new StringBuffer();
		try {
			Socket socket = new Socket(host, port);
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			os.println("stats items");
			os.flush();
			String l;
			while (!(l = is.readLine()).equals("END")) {
				r.append(l).append("\n");
			}
			String rr = r.toString();
			Set<String> ids = new HashSet<String>();
			if (rr.length() > 0) {
				r = new StringBuffer();// items
				rr.replace("STAT items", "");
				for (String s : rr.split("\n")) {
					ids.add(s.split(":")[1]);
				}
				if (ids.size() > 0) {
					r = new StringBuffer();//
					for (String s : ids) {
						os.println("stats cachedump " + s + " 0");
						os.flush();
						while (!(l = is.readLine()).equals("END")) {
							r.append(l.split(" ")[1]).append("\n");
						}
					}
				}
			}

			os.close();
			is.close();
			socket.close();
		} catch (Exception e) {
			System.out.println("Error" + e);
		}
		return r.toString();
	}

	public static String telnet(String host, int port, String cmd) {
		StringBuffer r = new StringBuffer();
		try {
			Socket socket = new Socket(host, port);
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			BufferedReader is = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			os.println(cmd);
			os.flush();
			String l;
			while (!(l = is.readLine()).equals("END")) {
				r.append(l).append("\n");
			}
			os.close();
			is.close();
			socket.close();
		} catch (Exception e) {
			System.out.println("Error" + e);
		}
		return r.toString();
	}
}
