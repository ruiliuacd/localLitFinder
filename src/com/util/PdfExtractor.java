package com.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.util.PDFTextStripper;

public class PdfExtractor {
	static String filename = "k:/kaks.pdf";
	static File file = new File(filename);
	public static void main(String args[]) throws Exception
	{
		String content = getText(file);
		System.out.println(content);
	}
	public static String getText(File file) throws Exception {
		// 是否排序
		boolean sort = false;
		// 返回文本
		String outStr = null;
		// 开始提取页数
		int startPage = 1;
		// 结束提取页数
		int endPage = 10;
		// 内存中存储的PDF DOcument
		PDDocument document = null;
		try {
			try {
				// 当作一个URL来装载文件
				document = PDDocument.load(file);
			} catch (MalformedURLException e) {
			}
			// 用PDFTextStripper来提取文本
			PDFTextStripper stripper = new PDFTextStripper();
			// 设置是否排序
			stripper.setSortByPosition(sort);
			// 设置起始页
			stripper.setStartPage(startPage);
			// 设置结束页
			stripper.setEndPage(endPage);

			outStr = stripper.getText(document);

			return (outStr);
		} catch (Exception e) {
			return "";
		} finally {
			if (document != null) {
				document.close();
			}
		}
	}
	

}
