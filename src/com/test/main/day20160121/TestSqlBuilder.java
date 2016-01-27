package com.test.main.day20160121;

/**
 * @2016年1月21日 by linyj
 */
public class TestSqlBuilder {

	public static void main(String[] args) {
		String s = "uid, invtype, invtitle, comp_name, inv_content, taxnum, reg_address, reg_tel, bankname, bankno, inv_pic01, inv_pic02, inv_pic03, inv_pic04, inv_pic05, inv_pic06, ship_type, rec_name, rec_phoneno, rec_region_id, rec_region_cid, rec_region_cname, rec_address, creator, create_time";

		getProReqPar(s);
		// getSaveMethPar(s);
		// getProPar(s);
		// getProWrap(s);

	}

	public static void getProReqPar(String s) {
		String[] ss = s.split(",");
		String s2 = "";
		for (int i = 0; i < ss.length; i++) {
			String str = ss[i].trim();
			println("String " + str + " = str(\"" + str + "\", request);");
		}
	}

	public static void getSaveMethPar(String s) {
		String[] ss = s.split(",");
		String s2 = "";
		for (int i = 0; i < ss.length; i++) {
			String str = ss[i].trim();
			if (i > 0)
				s2 += ", ";
			s2 += "String " + str;
		}
		println(s2);
	}

	public static void getProPar(String s) {
		String[] ss = s.split(",");
		String s2 = "";
		println("Map<String, Object> par = new HashMap<String, Object>();");
		for (int i = 0; i < ss.length; i++) {
			String str = ss[i].trim();
			println("par.put(\"" + str + "\", " + str + ");");
		}
	}

	public static void getProWrap(String s) {
		String[] ss = s.split(",");
		String s2 = "";
		for (int i = 0; i < ss.length; i++) {
			String str = ss[i].trim();
			if (i > 0)
				s2 += ",";
			s2 += "#{" + str + "}";
		}
		println(s2);
	}

	static void println(Object obj) {
		System.out.println(obj);
	}

}
