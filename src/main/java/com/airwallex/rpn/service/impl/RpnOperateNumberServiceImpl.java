package com.airwallex.rpn.service.impl;

import java.util.LinkedList;

import com.airwallex.rpn.service.RpnOperateService;

public class RpnOperateNumberServiceImpl implements RpnOperateService {

	/*
	 * 直接入栈
	 */
	public void calculate(Object data, LinkedList rpnAllLinkedStack, LinkedList rpnRealNumberLinkedStatck, Object... args) {
		rpnRealNumberLinkedStatck.addLast(data);
		rpnAllLinkedStack.addLast(data);
	}

}
