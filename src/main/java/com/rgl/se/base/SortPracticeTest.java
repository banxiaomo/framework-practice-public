package com.rgl.se.base;

import java.util.Random;

import com.rgl.common.util.BaseUtil;

/**
 * 排序算法
 * <p>
 * 包含4种排序算法:冒泡,插入(直接插入/二分法插入),快速,并归
 *
 */
public class SortPracticeTest {

	/**
	 * 并归排序需要用到的数组
	 */
	private static String[] leftArray;

	public static void main(String[] args) {
		String[] strs = { "1", "2", "3", "4", "4", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54" };

		// 打乱数组
		System.out.println("数组排序前-----------------------------");
		SimplePracticeTest.szdla(strs);

		System.out.println("数组排序后-----------------------------");
//		bubbleSort(strs);
//		crpx(strs);
//		insertSort(strs);
//		quickSort(strs);
		mergeSort(strs);
		BaseUtil.showStrs(strs);
	}

	/**
	 * 冒泡排序
	 * 
	 * @param strs
	 */
	public static void bubbleSort(String[] strs) {
		for (int end = strs.length - 1; end > 0; end--) {
			int swapIndex = 1;
			for (int begin = 0; begin < end; begin++) {
				if (Integer.valueOf(strs[begin]) > Integer.valueOf(strs[begin + 1])) {
					String temp = strs[begin + 1];
					strs[begin + 1] = strs[begin];
					strs[begin] = temp;
					swapIndex = begin + 1;
				}
			}
			end = swapIndex;
		}
	}

	/**
	 * 插入排序
	 * 
	 * @param strs
	 */
	public static void crpx(String[] strs) {
		for (int end = 1; end < strs.length; end++) {
			int begin = end - 1;
			String temp = strs[end];
			while (begin >= 0 && Integer.valueOf(strs[begin]) > Integer.valueOf(temp)) {
				strs[begin + 1] = strs[begin];
				begin--;
			}
			strs[begin + 1] = temp;
		}
	}

	/**
	 * 插入排序(二分法)
	 * 
	 * @param strs
	 */
	public static void insertSort(String[] strs) {
		for (int end = 1; end < strs.length; end++) {
			int begin = end - 1;
			String temp = strs[end];
			int insertIndex = findInsertIndex(strs, end);
			while (begin >= insertIndex) {
				strs[begin + 1] = strs[begin];
				begin--;
			}
			strs[insertIndex] = temp;
		}
	}

	private static int findInsertIndex(String[] strs, int end) {
		String temp = strs[end];
		int begin = 0;
		while (begin < end) {
			int mid = (begin + end) >> 1;
			if (Integer.valueOf(strs[mid]) > Integer.valueOf(temp)) {
				end = mid;
			} else {
				begin = mid + 1;
			}
		}
		return begin;
	}

	/**
	 * 快速排序
	 * 
	 * @param strs
	 */
	public static void quickSort(String[] strs) {
		quickDoWork(strs, 0, strs.length);
	}

	private static void quickDoWork(String[] strs, int begin, int end) {
		if (end - begin < 2) {
			return;
		}
		int pivotIndex = makePivotIndex(strs, begin, end);
		quickDoWork(strs, begin, pivotIndex);
		quickDoWork(strs, pivotIndex + 1, end);
	}

	private static int makePivotIndex(String[] strs, int begin, int end) {
		Random random = new Random();
		int randomIndex = begin + random.nextInt(end - begin);
		String temp = strs[randomIndex];
		strs[randomIndex] = strs[begin];
		end--;
		while (begin < end) {
			while (begin < end) {
				if (Integer.valueOf(strs[end]) > Integer.valueOf(temp)) {
					end--;
				} else {
					strs[begin++] = strs[end];
					break;
				}
			}
			while (begin < end) {
				if (Integer.valueOf(strs[begin]) < Integer.valueOf(temp)) {
					begin++;
				} else {
					strs[end--] = strs[begin];
					break;
				}
			}
		}
		strs[begin] = temp;
		return begin;
	}

	/**
	 * 并归排序
	 * 
	 * @param strs
	 */
	public static void mergeSort(String[] strs) {
		leftArray = new String[strs.length >> 1];
		mergeDoWork(strs, 0, strs.length);
	}

	private static void mergeDoWork(String[] strs, int begin, int end) {
		if (end - begin < 2) {
			return;
		}
		int mid = (begin + end) >> 1;
		mergeDoWork(strs, begin, mid);
		mergeDoWork(strs, mid, end);
		merge(strs, begin, mid, end);
	}

	private static void merge(String[] strs, int begin, int mid, int end) {
		int li = 0, le = mid - begin;
		int ri = mid, re = end;
		int ai = begin;
		for (int i = 0; i < le; i++) {
			leftArray[i] = strs[ai + i];
		}
		while (li < le) {
			if (ri < re && Integer.valueOf(strs[ri]) < Integer.valueOf(leftArray[li])) {
				strs[ai++] = strs[ri++];
			} else {
				strs[ai++] = leftArray[li++];
			}
		}
	}
}
