package com.airwallex.rpn.service.impl;

import com.airwallex.rpn.exception.RpnException;
import com.airwallex.rpn.service.RpnOperateService;

import static com.airwallex.rpn.exception.DefaultRetMsg.OPERATOR_EXCEPTION;
import static com.airwallex.rpn.utils.RpnCalculate.DataSqrt;
import static com.airwallex.rpn.utils.RpnCalculate.DataSqrt;

import java.util.LinkedList;

public class RpnOperateSqrtServiceImpl implements RpnOperateService {

	/*
	 * 平方根
	 */

	public void calculate(Object data, LinkedList rpnAllLinkedStack, LinkedList rpnRealNumberLinkedStatck, Object... args) throws RpnException {
		if (rpnRealNumberLinkedStatck.size() == 0)
			throw new RpnException(OPERATOR_EXCEPTION , args[0]);
		rpnAllLinkedStack.addLast(data);
		Object realdata = rpnRealNumberLinkedStatck.pollLast();
		rpnRealNumberLinkedStatck.addLast(realdata);
		rpnRealNumberLinkedStatck.addLast(DataSqrt(realdata));
		Object adddata = rpnRealNumberLinkedStatck.pollLast();
		realdata = rpnRealNumberLinkedStatck.pollLast();
		rpnRealNumberLinkedStatck.addLast(adddata);
	}
}
