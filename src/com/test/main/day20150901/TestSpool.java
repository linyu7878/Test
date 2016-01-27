package com.test.main.day20150901;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;

/**
 * @2015年9月1日 by linyj
 */
public class TestSpool {

	public static void main(String[] args) throws Exception {
		t1();

	}

	public static void t1() throws Exception {
		String drive = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.10.42:1521:racdb1";
		String username = "bap_dw";
		String password = "bap";
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
		String sql = "spool d://stg_bd_corp.txt;";
		sql += "select pk_corp||'|~|'||unitname from stg_bd_corp t;";
		sql += "spool off;";
		ps = conn.prepareStatement(sql);
		int i = ps.executeUpdate();
		println("i:" + i);
		// String sql = "select sysdate from dual";
		// ps = conn.prepareStatement(sql);
		// rs = ps.executeQuery();
		// rs.next();
		// println(rs.getMetaData().getColumnLabel(1) + ":"
		// + sdf.format(rs.getTimestamp(1)));

	}

	private static void println(Object obj) {
		System.out.println(obj);

	}
}
