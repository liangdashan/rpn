package com.airwallex.rpn.utils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import static com.airwallex.rpn.utils.RpnCalculate.DataMulti;
/*
 * 输入的字符串的处理
 */
public class RpnDealData {

	public static String[] dealInputData(String inputdata) {
		String[] nulldata = {};
		if(inputdata.equals("")) {
			return nulldata;
		}
		return inputdata.split(" ");
	}

	public static String[] findInputDataIndex(int number, String inputdata) {
		char[] tempdata = inputdata.toCharArray();
		int j = 0;
		for (int i = 0; i < inputdata.length(); i++) {
			if (tempdata[i] == ' ') {
				j++;
			}
			if (j == number) {
				String[] data = { String.valueOf(i), inputdata.substring(i) };
				return data;
			}
		}
		// 输出最后一位
		String[] lastdata = { String.valueOf(inputdata.length()), inputdata.substring(inputdata.length() - 1) };
		return lastdata;
	}

}
