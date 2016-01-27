package com.test.main.day20151217;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import org.apache.shiro.crypto.hash.SimpleHash;

import com.runlion.shop.common.util.EncryptUtil;

/**
 * @2015年12月17日 by linyj
 */
public class TestMysqlJDBC {

	public static void main(String[] args) throws Exception {
		t1();

	}

	public static void t1() throws Exception {
		String drive = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://www.hongshids.com:3306/hsshop_formal?Unicode=true&amp;characterEncoding=utf8&zeroDateTimeBehavior=convertToNull";
		String username = "ShopUser";
		String password = "9fa868193c74";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Connection conn = null;
		PreparedStatement ps;
		ResultSet rs;
		Statement st;
		// 初始化驱动包
		Class.forName(drive);
		// 根据数据库连接字符，名称，密码给conn赋值
		conn = DriverManager.getConnection(url, username, password);
		println(conn);
		String sql = "select * from bsp_adminuser order by 1 ";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		while (rs.next()) {
			String uid = rs.getString("uid");
			String uname = rs.getString("username");
			String pwd = rs.getString("password");
			String realName = rs.getString("realname");
			pwd = EncryptUtil.decrypt(pwd);
			pwd = new SimpleHash("SHA-1", uname, pwd).toString();
			if ("admin".equals(uname))
				continue;
			String str = "insert into sys_user(user_id, username,password,name,rights,role_id,status,skin) values ('"
					+ uid
					+ "','"
					+ uname
					+ "','"
					+ pwd
					+ "','"
					+ realName
					+ "','1133671055321055258374707980945218933803269864762743594642571294','2','0','default');";
			println(str);
		}
		rs.close();
		ps.close();
		conn.close();

	}

	private static void println(Object obj) {
		System.out.println(obj);

	}
}
