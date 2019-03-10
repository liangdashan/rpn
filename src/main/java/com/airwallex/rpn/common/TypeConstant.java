package com.airwallex.rpn.common;


/*
 * @author liangjl
 * @date 2019/3/9
 * 所有操作
 * 可动态添加
 */
public enum TypeConstant {
	PLUS("+" , "Plus"),
	MINUS("-" , "Minus"),
	MULTI("*" , "Multi"),
	DIV("/" , "Div"),
	SQRT("sqrt" , "Sqrt"),
	UNDO("undo" , "Undo"),
	CLEAR("clear" , "Clear");
	
	private String key;
	private String value;
	
	TypeConstant(String key , String value) {
		this.key = key;
		this.value = value;
	}

	public String getKey() {
		return key;
	}

	public String getValue() {
		return value;
	}
	
}
