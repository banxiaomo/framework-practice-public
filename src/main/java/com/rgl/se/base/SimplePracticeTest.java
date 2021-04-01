package com.rgl.se.base;

import java.util.LinkedHashSet;
import java.util.Set;

import com.rgl.common.util.BaseUtil;

/**
 * 常规练习
 *
 */
public class SimplePracticeTest {
	public static void main(String[] args) {

		String str = "<<abcdefghijklmn_opqrstuvwxyz>> fasgeewijfjksdfhiuewhhjkoiew";
		String[] strs = { "1", "2", "3", "4", "4", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54" };

		System.out.println("字符去重-----------------------------");
		zfqc(str);

		System.out.println("for循环打乱数组(洗牌)-----------------------------");
		szdla(strs);

		System.out.println("再次打乱(使用递归)-----------------------------");
		szdlb(strs);

		System.out.println("数组去重字符去重-----------------------------");
		strs = szqc(strs);

		System.out.println("打印杨辉三角-----------------------------");
		yhsg(10);

	}

	public static void zfqc(String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			// 获取每个位置的char
			char ch = str.charAt(i);
			// 判断是否在字符串的第一次出现的位置
			if (i == str.indexOf(ch)) {
				sb.append(ch);
			}
		}
		System.out.println(sb);
	}

	public static void szdla(String[] strs) {
		for (int end = strs.length - 1; end > 0; end--) {
			// 获取一个随机位置
			int randomIndex = (int) (Math.random() * (end + 1));
			// 将随机位置的数据和最后一个数据交换
			String temp = strs[randomIndex];
			strs[randomIndex] = strs[end];
			strs[end] = temp;
		}
		BaseUtil.showStrs(strs);
	}

	public static void szdlb(String[] strs) {
		szdlDoWork(strs, strs.length);
		BaseUtil.showStrs(strs);
	}

	private static void szdlDoWork(String[] strs, int end) {
		//递归出口:数组长度小于2(等于1)时,不需要打乱了
		if (end < 2) {
			return;
		}
		int endIndex = end - 1;
		int randomIndex = (int) (Math.random() * end);
		String temp = strs[endIndex];
		strs[endIndex] = strs[randomIndex];
		strs[randomIndex] = temp;
		//递归调用
		szdlDoWork(strs, endIndex);
	}

	public static String[] szqc(String[] strs) {
		Set<String> set = new LinkedHashSet<String>();
		int errNum = 0;
		for (int i = 0; i < strs.length; i++) {
			// 没有添加成功的可进行记录
			if (!set.add(strs[i])) {
				errNum++;
			}
		}
		String[] res = set.toArray(new String[set.size()]);
		System.out.println("去重前数组长度:" + strs.length);
		System.out.println("重复元素数量:" + errNum);
		System.out.println("去重后数组长度:" + res.length);
		BaseUtil.showStrs(res);
		return res;
	}

	public static void yhsg(int i) {
		// 从第1行一直到第i行
		for (int x = 1; x <= i; x++) {
			// 每行的第1列一直到第x列
			for (int y = 1; y <= x; y++) {
				int val = getVal(x, y);
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 第1行时x=y=1
	 * <p>
	 * 第2行时(x=2,y=1),(x=2,y=2)
	 * <p>
	 * 第3行时(x=3,y=1),(x=3,y=2),(x=3,y=3)
	 * <p>
	 * ...
	 * <p>
	 * 按规律可知道:递归出口条件是 y == 1 || y == x
	 * 
	 */
	private static int getVal(int x, int y) {
		if (y == 1 || y == x) {
			// 递归出口
			return 1;
		} else {
			// 调用上一行的两个值相加
			return getVal(x - 1, y - 1) + getVal(x - 1, y);
		}
	}
}
