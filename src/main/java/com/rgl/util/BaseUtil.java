package com.rgl.util;

public class BaseUtil {

	/**
	 * 控制台打印字符串数组
	 */
	public static void showStrs(String[] strs) {
		if (strs == null || strs.length <= 0) {
			return;
		}
		StringBuffer showStrs = new StringBuffer();
		showStrs.append("{\"");
		for (int i = 0; i < strs.length; i++) {
			if (i != strs.length - 1) {
				showStrs.append(strs[i]);
				showStrs.append("\",\"");
			} else {
				showStrs.append(strs[i]);
				showStrs.append("\"}");
			}
		}
		System.out.println(showStrs.toString());
	}
}
