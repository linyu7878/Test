package com.lyj.test.y2017.m08.d22;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;

import com.lyj.test.Test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TestBase64 extends Test {

	public static void main(String[] args) {
		try {
			println("hello test!");
			// String base64Code =
			// encodeBase64File("E:\\work\\2017\\8月\\0822\\微信图片_20170814095426.png");

			String base64Code = "";
			File file = new File("E:\\work\\2017\\8月\\0822\\3.txt");
			BufferedReader br = new BufferedReader(new FileReader((file)));
			while (br.ready()) {
				String line = br.readLine();
				base64Code += line;
			}
			br.close();

			println(base64Code.length());
			decoderBase64File(base64Code, "E:\\work\\2017\\8月\\0822\\2.jpg");
			// toFile(base64Code, "E:\\work\\2017\\8月\\0822\\3.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 将文件转成base64 字符串
	 * 
	 * @param path文件路径
	 * @return *
	 * @throws Exception
	 */

	public static String encodeBase64File(String path) throws Exception {
		File file = new File(path);
		;
		FileInputStream inputFile = new FileInputStream(file);
		byte[] buffer = new byte[(int) file.length()];
		inputFile.read(buffer);
		inputFile.close();
		return new BASE64Encoder().encode(buffer);

	}

	/**
	 * 将base64字符解码保存文件
	 * 
	 * @param base64Code
	 * @param targetPath
	 * @throws Exception
	 */

	public static void decoderBase64File(String base64Code, String targetPath) throws Exception {
		byte[] buffer = new BASE64Decoder().decodeBuffer(base64Code);
		FileOutputStream out = new FileOutputStream(targetPath);
		out.write(buffer);
		out.close();

	}

	/**
	 * 将base64字符保存文本文件
	 * 
	 * @param base64Code
	 * @param targetPath
	 * @throws Exception
	 */

	public static void toFile(String base64Code, String targetPath) throws Exception {

		byte[] buffer = base64Code.getBytes();
		FileOutputStream out = new FileOutputStream(targetPath);
		out.write(buffer);
		out.close();
		File file = new File(targetPath);
		println(file.length());
	}

}
