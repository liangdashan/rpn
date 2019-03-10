package com.airwallex.rpn.exception;

/*
 * @author liangjl
 * @date 2019/3/8
 * 自定义异常类
 */
public class RpnException extends Exception{


	private static final long serialVersionUID = 2072499345586764714L;

	private RetMsg resultCode;
	
	private String errorDesc ;
	
	
	
	
	/**
     * 构造函数
     * @param errorDesc 异常信息
     */
    public RpnException(String errorDesc) {
        super(errorDesc);
        this.resultCode = DefaultRetMsg.DEFAULT_EXCEPTION;
    }

    /**
     * 构造函数
     * @param errorDesc 异常信息
     */
    public RpnException(String errCode, String errorDesc) {
        super(errorDesc);
        this.resultCode = DefaultRetMsg.DEFAULT_EXCEPTION;
        resultCode.setCode(errCode);
        resultCode.setMessage(errorDesc);
    }

    /**
     * 构造函数
     * @param resultCode 错误码
     */
    public RpnException(RetMsg resultCode) {
        super(resultCode.getCode() + ":" + resultCode.getMessage());
        this.resultCode = resultCode;
        this.errorDesc = resultCode.getMessage();

    }

    /**
     * 构造函数
     * 可覆盖resultCode的errorDesc
     * @param resultCode 错误码
     * @param errorDesc 错误信息
     */
    public RpnException(RetMsg resultCode, Object errorIndex) {
        super(resultCode.getCode() + errorIndex + resultCode.getMessage());
    }

    /**
     * 带异常的构造函数
     * @param resultCode 错误码
     * @param throwable 异常
     */
    public RpnException(RetMsg resultCode, Throwable throwable) {
        super(resultCode.getCode() + ":" + resultCode.getMessage(), throwable);
        this.resultCode = resultCode;
        this.errorDesc = resultCode.getMessage();
    }

    /**
     * 带异常的构造函数
     * @param resultCode 错误码
     * @param errorDesc 错误信息
     * @param throwable 异常
     */
    public RpnException(RetMsg resultCode, String errorDesc, Throwable throwable) {
        super(resultCode.getCode() + ":" + errorDesc, throwable);
        this.resultCode = DefaultRetMsg.DEFAULT_EXCEPTION;
        this.errorDesc = errorDesc;
    }




	public RetMsg getResultCode() {
		return resultCode;
	}




	public void setResultCode(RetMsg resultCode) {
		this.resultCode = resultCode;
	}




	public String getErrorDesc() {
		return errorDesc;
	}




	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}
	
	
	
}
