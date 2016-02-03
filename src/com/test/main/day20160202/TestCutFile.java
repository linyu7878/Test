package com.test.main.day20160202;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @2016年2月2日 by linyj
 */
public class TestCutFile {
	public static long max_line = 100 * 10000;
	public static long max_size = 100 * 1024 * 1024;

	public static void main(String[] args) throws Exception {
		cut1();

	}

	public static void cut1() throws Exception {
		String file_path = "D://work/2月/catalina.out";
		File file = new File(file_path);
		String tmp_file_path = file.getPath() + "_tmp";

		File tmp_file = new File(file_path);
		tmp_file.mkdir();

		long len = file.length();
		int loop = 1;
		if (len > max_size)
			loop = (int) (len % max_size == 0 ? len / max_size
					: (len / max_size) + 1);

		BufferedReader br = new BufferedReader(new FileReader(file));
		for (int i = 0; i < loop; i++) {
			String ft1 = tmp_file_path + "/" + i + ".txt";
			System.out.println("------len:" + len + ", ft1:" + ft1);
			File tmp_ft1 = new File(ft1);
			if (!tmp_ft1.exists())
				tmp_ft1.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(tmp_ft1));
			long count = 0;
			while (br.ready()) {
				if (count > max_size)
					break;
				// br.skip(loop * max_size);
				char c = (char) br.read();
				bw.write(c);
				count++;
			}
			bw.close();
		}
		br.close();
	}
}
