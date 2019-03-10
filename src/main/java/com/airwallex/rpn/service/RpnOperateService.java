package com.airwallex.rpn.service;

import java.util.LinkedList;

import com.airwallex.rpn.exception.RpnException;

public interface RpnOperateService {

	public void calculate(Object data, LinkedList rpnAllLinkedStack, LinkedList rpnRealNumberLinkedStatck, Object... args) throws Exception ;

}
