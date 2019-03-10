package com.airwallex.rpn.utils;

public class RpnLoadClass {

	public static Object loadImpl(String classname) {
		Object OperatorClass = null;
		try {
			OperatorClass = Class
					.forName(classname).newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return OperatorClass;
		
	}
}
