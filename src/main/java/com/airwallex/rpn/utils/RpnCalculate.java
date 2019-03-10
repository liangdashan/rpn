package com.airwallex.rpn.utils;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.LinkedList;

import com.airwallex.rpn.exception.RpnException;
import static com.airwallex.rpn.exception.DefaultRetMsg.ZERO_EXCEPTION;
import static com.airwallex.rpn.utils.RpnCalculate.DataMulti;
import static com.airwallex.rpn.exception.DefaultRetMsg.SQRT_EXCEPTION;

/*
 * 四则运算
 */
public class RpnCalculate {

	/*
	 * 平方根
	 */
	public static Object DataSqrt(Object data ,  Object... args) throws RpnException {
		BigDecimal deviation = new BigDecimal(String.valueOf(data));
		if(deviation.compareTo(new BigDecimal("0"))<0)
			throw new RpnException(SQRT_EXCEPTION , args[0]);
		BigDecimal num2 = BigDecimal.valueOf(2);
		int precision = 200;
		MathContext mc = new MathContext(precision, RoundingMode.HALF_UP);
		int cnt = 0;
		while (cnt < precision) {
			deviation = (deviation.add(new BigDecimal(String.valueOf(data)).divide(deviation, mc))).divide(num2, mc);
			cnt++;
		}
		if(deviation.compareTo(new BigDecimal("0")) == 0) {
			return 0;
		}
		deviation = deviation.setScale(15, BigDecimal.ROUND_HALF_UP);
		return formatBigDecimal(deviation);
	}

	public static Object DataDiv(Object firstdata, Object seconddata , Object... args) throws RpnException {
		BigDecimal b1 = new BigDecimal(String.valueOf(firstdata));
		BigDecimal b2 = new BigDecimal(String.valueOf(seconddata));
		if(b2.compareTo(new BigDecimal("0")) == 0)
			throw new RpnException(ZERO_EXCEPTION , args[0]);
		if(b1.compareTo(new BigDecimal("0")) == 0) {
			return 0;
		}
		return formatBigDecimal(b1.divide(b2, 15, BigDecimal.ROUND_HALF_UP));
	}

	public static Object DataMinus(Object firstdata, Object seconddata) {
		BigDecimal b1 = new BigDecimal(firstdata.toString());
		BigDecimal b2 = new BigDecimal(seconddata.toString());
		BigDecimal Minus = b1.subtract(b2);
		if(Minus.compareTo(new BigDecimal("0")) == 0) {
			return 0;
		}
		return formatBigDecimal(b1.subtract(b2).setScale(15, BigDecimal.ROUND_HALF_UP));
	}

	public static Object DataMulti(Object firstdata, Object seconddata) {
		BigDecimal b1 = new BigDecimal(String.valueOf(firstdata));
		BigDecimal b2 = new BigDecimal(String.valueOf(seconddata));
		BigDecimal multiply = b1.multiply(b2);
		if(multiply.compareTo(new BigDecimal("0")) == 0) {
			return 0;
		}
		return formatBigDecimal(multiply.setScale(15, BigDecimal.ROUND_HALF_UP));
	}

	public static Object DataPlus(Object firstdata, Object seconddata) {
		BigDecimal b1 = new BigDecimal(firstdata.toString());
		BigDecimal b2 = new BigDecimal(seconddata.toString());
		BigDecimal plus = b1.add(b2);
		if(plus.compareTo(new BigDecimal("0")) == 0) {
			return 0;
		}
		return formatBigDecimal(b1.add(b2).setScale(15, BigDecimal.ROUND_HALF_UP));
	}

	public static Object formatBigDecimal(BigDecimal data) {
		String bakData = data.toString();
		if (data.toString().contains(".")) {
			for (int i = data.toString().length() - 1; i >= 0; i--) {
				if (data.toString().charAt(i) == '.') {
					bakData = bakData.substring(0, i);
					break;
				}
				if (data.toString().charAt(i) != '0') {
					bakData = bakData.substring(0, i+1);
					break;
				}
			}
		}
		return bakData;
	}

	/*
	 * 检查是否是数字
	 */
	public static boolean isNum(String str) {
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}
	
	
	/*
	 * 格式化输出所有的数字
	 */
	public static String outputdata(LinkedList data) {
		String allnumber = "";
		for (Object outdata : (LinkedList) data) {
			Object tempdata ="";
			BigDecimal temp = new BigDecimal(String.valueOf(outdata));
			if (temp.compareTo(new BigDecimal("0")) != 0) {
				tempdata = DataMulti(outdata , "1");
			}else {
				tempdata = 0 ;
			}
			allnumber = allnumber + (tempdata + " ");
		}
		return ("stack:" + allnumber);
	}

}
