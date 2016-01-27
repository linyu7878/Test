package com.test.main.day20150921;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @2015年9月21日 by linyj
 */
public class BookReaderTest {

	public static void main(String[] args) throws IOException {
		testFileReader(786);

	}

	private static void testFileReader(int page) throws IOException {
		String fileName = "D://work/9月/frxxz.txt";
		File file = new File(fileName);
		if (!file.exists()) {
			println(file.getAbsolutePath() + " is not exists");
			return;
		}
		long length = file.length();
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream(fileName), "GBK"));
		int base = 2060000;
		int per = 5000;
		br.skip(base + per * page);
		int i = 0;
		int ch = 0;
		int maxSize = 60;
		int size = 0;
		int sum = 0;
		while (ch != -1) {
			ch = br.read();
			char c = (char) ch;
			if (c == '\r') {
				size = 0;
			} else {
				sum++;
			}
			if (size > 0 && size % maxSize == 0) {
				System.out.println();
			}
			if (sum > 0 && sum % 100000 == 0) {
				// System.out.println("sum:" + sum);
			}

			System.out.print(c);
			i++;
			size++;
			if (i >= per)
				break;
		}
		// System.out.println("\n end sum:" + sum);
		br.close();
	}

	public static void println(Object obj) {
		System.out.println(obj);
	}
}
