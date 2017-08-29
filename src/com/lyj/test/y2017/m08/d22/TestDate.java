package com.lyj.test.y2017.m08.d22;

import java.util.Calendar;

import com.lyj.test.Test;

public class TestDate extends Test {

	public static void main(String[] args) {
		t1();

	}

	public static void t1() {
		Calendar cal = Calendar.getInstance();
		println(cal.get(Calendar.YEAR));
		println(cal.get(Calendar.MONTH) + 1);
		println(cal.get(Calendar.DATE));

	}

}
