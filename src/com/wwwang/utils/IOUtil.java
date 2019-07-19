package com.wwwang.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IOUtil {
	public static List<String> getLineList(String txtFilePath, String encoding)
			throws Exception {
		// 将文本文件通过JavaIO读取成一个行数据集合
		FileInputStream fis = new FileInputStream(txtFilePath);
		InputStreamReader isr = new InputStreamReader(fis, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		String line = null;
		List<String> lineList = new ArrayList<String>();
		while ((line = br.readLine()) != null) {
			lineList.add(line);
		}
		br.close();
		return lineList;
	}
}
