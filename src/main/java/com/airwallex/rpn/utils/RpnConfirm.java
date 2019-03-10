package com.airwallex.rpn.utils;

import static com.airwallex.rpn.utils.RpnCalculate.isNum;

import org.apache.commons.lang.StringUtils;

import com.airwallex.rpn.common.TypeConstant;
import com.airwallex.rpn.exception.RpnException;
import static com.airwallex.rpn.exception.DefaultRetMsg.DATA_NULL_EXCEPTION;
import static com.airwallex.rpn.exception.DefaultRetMsg.DATA_EXCEPTION;

public class RpnConfirm {

	public static String typeConfirm(Object data, Object... args) throws RpnException {
		for (TypeConstant typeConstant : TypeConstant.values()) {
			if (typeConstant.getKey().equals(data.toString()))
				return typeConstant.getValue();
		}
		if (StringUtils.isBlank(data.toString())) {
			throw new RpnException(DATA_NULL_EXCEPTION, "postion is " + args[0] + " ,");
		} else if (isNum(data.toString())) {
			return "Number";
		} else {
			throw new RpnException(DATA_EXCEPTION, "postion is " + args[0] + " ,");
		}

	}
}
