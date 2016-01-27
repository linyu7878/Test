package com.test.main.day20150710;

/**
 * @2015年7月10日 by linyj
 */
public class MailTest {

	public static void main(String[] args) throws Exception {
		testMail();

	}

	public static void testMail() throws Exception {
		String to = "87928731@qq.com", from = "13957180842@139.com";
		String userName = "13957180842@139.com", password = "lyj87928731";// lin6988822,lyj87928731
		String subject = "红狮商场帮你找回您的账户密码";
		String content = "测试test!";
		SimpleMailSender sender = new SimpleMailSender(userName, password);
		sender.send(to, subject, content);

	}
}
