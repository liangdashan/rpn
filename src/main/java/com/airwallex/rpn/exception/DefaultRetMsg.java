package com.airwallex.rpn.exception;

public enum DefaultRetMsg implements RetMsg {
	
	DEFAULT_EXCEPTION("error","异常"),
	DATA_NULL_EXCEPTION("data null ","数据空指针"),
	OPERATOR_EXCEPTION("operator * (position: ","): insucient parameters "),
	ZERO_EXCEPTION("operator * (position: ","): the last number is 0"),
	DATA_EXCEPTION("not number , not operate ","不可识别字符串"),
	SQRT_EXCEPTION("operator * (position: ","): the last number is negative");
	
    /** 错误码code*/
    private String code;
    /** 错误码描述*/
    private String message;
    
	DefaultRetMsg(){
		
	}
	DefaultRetMsg(String code , String message){
		this.code = code ;
		this.message = message ;
	}
	
	public String getCode() {
		// TODO Auto-generated method stub
		return code;
	}

	public void setCode(String errCode) {
		// TODO Auto-generated method stub
		this.code = errCode;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

	public void setMessage(String errMsg) {
		// TODO Auto-generated method stub
		this.message = errMsg;
	}

}
