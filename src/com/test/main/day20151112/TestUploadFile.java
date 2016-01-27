package com.test.main.day20151112;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @2015年11月12日 by linyj
 */
public class TestUploadFile {
	// 每个post参数之间的分隔。随意设定，只要不会和其他的字符串重复即可。
	private static final String BOUNDARY = "----------HV2ymHFg03ehbqgZCaKO6jyH";

	public static void main(String[] args) throws IOException, Exception {
		t2();
	}

	public static void t2() throws Exception, IOException {
		StringBuffer sb = new StringBuffer();
		String fileName = "D://test/2.jpg";
		File file = new File(fileName);
		String tokenStr = "18093b39695a4d9a9bc25fbd538301b3";
		URL url = new URL("http://192.168.158.88:8080/app/uploadFile.do");
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		// 发送POST请求必须设置如下两行
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setUseCaches(false);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Connection", "Keep-Alive");
		connection.setRequestProperty("Charset", "UTF-8");
		connection.setRequestProperty("Content-Type",
				"multipart/form-data; boundary=" + BOUNDARY);

		// 头
		String boundary = BOUNDARY;
		// 传输内容
		StringBuffer contentBody = new StringBuffer("--" + BOUNDARY);
		// 尾
		String endBoundary = "\r\n--" + boundary + "--\r\n";

		OutputStream out = connection.getOutputStream();

		// 1. 处理普通表单域(即形如key = value对)的POST请求

		contentBody.append("\r\n")
				.append("Content-Disposition: form-data; name=\"token\"")
				.append("\r\n").append("\r\n").append(tokenStr).append("\r\n")
				.append("--").append(boundary);

		contentBody.append("\r\n")
				.append("Content-Disposition: form-data; name=\"oper_type\"")
				.append("\r\n").append("\r\n").append("order_cancel")
				.append("\r\n").append("--").append(boundary);
		String boundaryMessage1 = contentBody.toString();
		sb.append(boundaryMessage1);
		out.write(boundaryMessage1.getBytes("utf-8"));

		// 2. 处理文件上传
		contentBody = new StringBuffer();
		contentBody.append("\r\n")
				.append("Content-Disposition:form-data; name=\"file\"; ")
				.append("filename=\"").append(file.getAbsolutePath() + "\"")
				// 上传文件的文件名，包括目录
				.append("\r\n").append("Content-Type:application/octet-stream")
				.append("\r\n\r\n");

		String boundaryMessage2 = contentBody.toString();
		sb.append(boundaryMessage2);
		out.write(boundaryMessage2.getBytes("utf-8"));

		// System.out.println(sb);
		//
		// System.out.println("1--------------------------");

		// 开始真正向服务器写文件
		File f = new File(file.getAbsolutePath());
		DataInputStream dis = new DataInputStream(new FileInputStream(f));
		int bytes = 0;
		byte[] bufferOut = new byte[(int) f.length()];
		bytes = dis.read(bufferOut);
		for (byte b : bufferOut) {
			sb.append(b);
		}
		out.write(bufferOut, 0, bytes);
		dis.close();
		contentBody.append("------------HV2ymHFg03ehbqgZCaKO6jyH");

		// 3. 写结尾
		sb.append(endBoundary);
		out.write(endBoundary.getBytes("utf-8"));
		out.flush();
		out.close();

		System.out.println(sb);
		System.out.println("2---------------------------------");
		// 4. 从服务器获得回答的内容
		String strLine = "";
		String strResponse = "";

		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		while ((strLine = reader.readLine()) != null) {
			strResponse += strLine + "\n";
		}
		System.out.print(strResponse);
	}

}
