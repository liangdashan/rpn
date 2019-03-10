package com.airwallex.rpn;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

import com.airwallex.rpn.controller.RpnController;
import com.airwallex.rpn.exception.DefaultRetMsg;
import com.airwallex.rpn.exception.RpnException;
import com.airwallex.rpn.service.RpnOperateService;

/**
 * author liangjl
 *
 * date 2019/3/6
 */
public class RpnApp {

	private static Logger logger = Logger.getLogger(RpnApp.class.getClass());

	
	RpnApp() {
		System.out.println("welcome to use RPN !!! \r\nshutdown is the key of out");
	}

	private final RpnController rpnController = new RpnController();
	
	private final LinkedList rpnAllLinkedStack = new LinkedList();
	private final LinkedList rpnRealNumberLinkedStatck = new LinkedList();
	
	private volatile boolean state = true;
	private volatile String inputdata;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();

	public void getInput() {
		lock.lock();
		try {
			while (state) {
				System.out.print("please key in :");
				Scanner scan = new Scanner(System.in);
				inputdata = scan.nextLine();
				if(inputdata.equals("shutdown")) {
					state=false;
					condition.signal();
					break;
				}
				condition.signal();
				condition.await();
			}
			
		} catch (InterruptedException e) {
			logger.info(e.getStackTrace());
		} finally {
			lock.unlock();
		}
	}

	public void dealInput() {
		lock.lock();
		try {
			while (state) {
				condition.await();
				if(inputdata.equals("shutdown")) {
					logger.warn("ths,bye");
					break;
				}
				rpnController.RpnOperator(inputdata, rpnAllLinkedStack, rpnRealNumberLinkedStatck);
				condition.signal();
			}
			
		} catch (InterruptedException e) {
			logger.info(e.getStackTrace());
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		final RpnApp ra = new RpnApp();
		new Thread(new Runnable() {
			public void run() {
				ra.getInput();
			}
		}).start();
		ra.dealInput();
	}
}
