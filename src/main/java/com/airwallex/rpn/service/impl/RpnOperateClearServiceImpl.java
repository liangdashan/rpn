package com.airwallex.rpn.service.impl;

import com.airwallex.rpn.exception.RpnException;
import com.airwallex.rpn.service.RpnOperateService;

import java.util.LinkedList;

public class RpnOperateClearServiceImpl implements RpnOperateService {

	/*
	 * 清空父链与子链
	 */
	public void calculate(Object data, LinkedList rpnAllLinkedStack, LinkedList rpnRealNumberLinkedStatck, Object... args) {
		rpnAllLinkedStack.clear();
		rpnRealNumberLinkedStatck.clear();
	}

}
