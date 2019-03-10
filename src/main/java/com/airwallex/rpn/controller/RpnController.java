package com.airwallex.rpn.controller;

import com.airwallex.rpn.RpnApp;
import com.airwallex.rpn.service.RpnOperateService;
import static com.airwallex.rpn.utils.RpnConfirm.typeConfirm;
import static com.airwallex.rpn.utils.RpnDealData.dealInputData;
import static com.airwallex.rpn.utils.RpnDealData.findInputDataIndex;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;
import static com.airwallex.rpn.utils.RpnCalculate.outputdata;

/*
 * @author liangjl
 * @date 2019/3/8
 * 通过反射动态调用不同的serviceImpl
 */
public class RpnController {

	private static Logger logger = Logger.getLogger(RpnController.class.getClass());

	/*
	 * 操作impl
	 */
	private RpnOperateService ros;

	public void RpnOperator(Object data, LinkedList rpnAllLinkedStack, LinkedList rpnRealNumberLinkedStatck) {
		// 全部入栈的标志
		boolean allin = true;
		// 每次剩余的字符串
		String[] lastdata = null;
		try {
			// 一个一个压入栈中
			int dataorder = 0;
			for (Object nodedata : dealInputData(data.toString())) {
				dataorder++;
				lastdata = findInputDataIndex(dataorder, data.toString());
				String objectType = typeConfirm(nodedata, lastdata[0], lastdata[1]);
				Class OperatorClass = null;
				OperatorClass = Class
						.forName("com.airwallex.rpn.service.impl." + "RpnOperate" + objectType + "ServiceImpl");
				ros = (RpnOperateService) OperatorClass.newInstance();
				ros.calculate(nodedata, rpnAllLinkedStack,  rpnRealNumberLinkedStatck,
						lastdata[0], lastdata[1]);
			}
		} catch (Exception e) {
			allin = false;
			System.out.println(e.getMessage());
			logger.info(e.getStackTrace());
		} finally {
			// 输出realnumber
			System.out.println(outputdata(rpnRealNumberLinkedStatck));
			// 输出未入栈
			try {
				if (!allin) {
					System.out.println(
							"(" + lastdata[1] + ")  were not pushed on to the stack due to the previous error");
				}
			} catch (Exception e) {
				logger.info(e.getStackTrace());
			}
		}

	}

}
