package com.airwallex.rpn.service.impl;


import com.airwallex.rpn.exception.RpnException;
import com.airwallex.rpn.service.RpnOperateService;

import static com.airwallex.rpn.exception.DefaultRetMsg.OPERATOR_EXCEPTION;
import static com.airwallex.rpn.utils.RpnCalculate.DataMinus;
import static com.airwallex.rpn.utils.RpnCalculate.DataSqrt;

import java.util.LinkedList;
import java.util.List;

public class RpnOperateMinusServiceImpl implements RpnOperateService {

	/*
	 *弹出最后两位，做减法 
	 */


	public void calculate(Object data, LinkedList rpnAllLinkedStack, LinkedList rpnRealNumberLinkedStatck, Object... args) throws RpnException  {
		if (rpnRealNumberLinkedStatck.size() == 1)
			throw new RpnException(OPERATOR_EXCEPTION , args[0]);
		rpnAllLinkedStack.addLast(data);
		Object firstdata = rpnRealNumberLinkedStatck.pollLast();
		Object seconddata = rpnRealNumberLinkedStatck.pollLast();
		rpnRealNumberLinkedStatck.addLast(DataMinus(seconddata, firstdata));
	}
}
