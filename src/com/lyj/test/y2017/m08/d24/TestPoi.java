package com.lyj.test.y2017.m08.d24;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFCreationHelper;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.IOUtils;

import com.lyj.test.Test;

public class TestPoi extends Test {
	public static String file_name = "E:\\work\\2017\\8月\\0824\\泰国poc功能开发计划2.xlsx";
	public static String base_url = "http://localhost:8080";
	public static String base_path = "E:\\workspaces\\space_poc\\im_web\\src\\main\\webapp";

	public static void main(String[] args) {
		t1();

	}

	public static void t1() {
		try {
			File file = new File(file_name);
			boolean exists = file.exists();
			println(exists);
			println(file.length());

			HSSFWorkbook wb = new HSSFWorkbook();
			Sheet sheet1 = wb.createSheet("Sheet1");
			sheet1.setDefaultRowHeight((short) 400);
			sheet1.setDefaultColumnWidth(20);
			sheet1.setColumnWidth(1, 8000);
			sheet1.setColumnWidth(2, 20000);
			CellStyle style0 = wb.createCellStyle();
			style0.setAlignment(CellStyle.ALIGN_LEFT);
			style0.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			style0.setWrapText(true);

			Font font = wb.createFont();
			font.setFontName("Courier New");
			font.setFontHeightInPoints((short) 12);

			style0.setFont(font);

			CellStyle style1 = wb.createCellStyle();
			style1.setAlignment(CellStyle.ALIGN_LEFT);
			style1.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
			style1.setWrapText(true);

			Font font1 = wb.createFont();
			font1.setFontName("Courier New");
			font1.setFontHeightInPoints((short) 12);
			font1.setUnderline(HSSFFont.U_SINGLE);
			font1.setColor(HSSFColor.BLUE.index);

			style1.setFont(font1);

			HSSFCreationHelper helper = (HSSFCreationHelper) wb.getCreationHelper();

			Row row0 = sheet1.createRow(0);
			row0.setHeight((short) 500);
			Cell cell0 = row0.createCell(0);
			cell0.setCellValue("用户");
			cell0.setCellStyle(style0);
			Cell cell1 = row0.createCell(1);
			cell1.setCellValue("时间");
			cell1.setCellStyle(style0);
			Cell cell2 = row0.createCell(2);
			cell2.setCellValue("内容");
			cell2.setCellStyle(style0);

			for (int i = 1; i < 10; i++) {
				Row row = sheet1.createRow(i);
				for (int j = 0; j < 5; j++) {
					// 添加单元格
					Cell cell = row.createCell(j);
					cell.setCellValue("你好hello------:" + (i + 1));
					if (j == 1) {
						cell.setCellValue("2017-08-24 16:07:22");
					}
					if (i == 2 & j == 2) {
						String str = "<img src=\"/im/upload/image/2017/8/24/u=3318631203,3378682391&fm=26&gp=0.jpg\" />";
						makeImageCell(cell, str, helper, style0, wb);
					}

					if (i == 5 && j >= 3) {
						String str = "<video width=\"400\" height=\"40\" controls=\"controls\"><source src=\"/im/upload/voice/2017/8/24/RHpcb-29_1503555668347.mp4\" type=\"video/mp4\">your browers not support</video>";
						makeUrlCell(cell, str, helper, style1);

					} else {
						cell.setCellStyle(style0);
					}
				}
				if (i == 2) {
					row.setHeight((short) 2000);
				} else {
					row.setHeight((short) 500);
				}
			}

			FileOutputStream out = new FileOutputStream(file_name);
			wb.write(out);
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void makeImageCell(Cell cell, String str, HSSFCreationHelper helper, CellStyle style, HSSFWorkbook wb) throws Exception {
		int start = str.indexOf("src=");
		if (start < 0)
			return;
		str = str.substring(start + 5);
		int end = str.indexOf("\"");
		if (end < 0)
			return;
		str = str.substring(0, end).replaceFirst("/im", "");
		println(str);
		String img_file = base_path + str;
		File file = new File(img_file);

		FileInputStream jpeg = new FileInputStream(file);
		byte[] bytes = IOUtils.toByteArray(jpeg);
		int pictureIndex = wb.addPicture(bytes, HSSFWorkbook.PICTURE_TYPE_JPEG);
		jpeg.close();

		HSSFPatriarch patriarch = (HSSFPatriarch) (wb.getSheetAt(0)).createDrawingPatriarch();
		HSSFClientAnchor clientAnchor = helper.createClientAnchor();
		clientAnchor.setCol1(cell.getColumnIndex());
		clientAnchor.setRow1(cell.getRowIndex());
		clientAnchor.setCol2(cell.getColumnIndex() + 1);
		clientAnchor.setRow2(cell.getRowIndex() + 1);
		patriarch.createPicture(clientAnchor, pictureIndex);

	}

	public static void makeUrlCell(Cell cell, String str, HSSFCreationHelper helper, CellStyle style) {
		int start = str.indexOf("src=");
		if (start < 0)
			return;
		str = str.substring(start + 5);
		int end = str.indexOf("\"");
		if (end < 0)
			return;
		str = str.substring(0, end);
		String url = base_url + str;
		HSSFHyperlink link = helper.createHyperlink(HSSFHyperlink.LINK_URL);
		link.setAddress(url);
		cell.setHyperlink(link);
		cell.setCellStyle(style);
	}

}
