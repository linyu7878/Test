package com.lyj.test.y2017.m08.d22;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

import com.lyj.test.Test;

public class TestFace extends Test {

	public static void main(String[] args) {
		t1();
	}

	public static void t1() {
		String str = "asdsa[/f001]assssad,a[/f123]as和";
		String str2 = filter(str);
		println("-------str2:" + str2);
	}

	public static String filter(String str) {
		if (StringUtils.isEmpty(str))
			return "";
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			String group = matcher.group();
			String name = group.substring(2, 6);
			String facePng = getFacePng(name);
			str = matcher.replaceFirst(facePng);
			matcher = pattern.matcher(str);
		}
		return str;
	}

	public static String getFacePng(String name) {
		return "<img src=\"/im/img/Face/" + name + ".png\" />";
	}

	public static String reg = "\\[/f[0-9]{3}\\]";// 表情判断正则表达式
	public static Pattern pattern = Pattern.compile(reg);

}
