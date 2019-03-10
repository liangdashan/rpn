package com.airwallex.rpn.exception;

public interface RetMsg {

	/**
     * 获取结果码code
     * @return 结果码
     */
    String getCode();

    void setCode(String errCode);

    /**
     * 获取描述信息
     * @return 描述信息
     */
    String getMessage();


    void setMessage(String errMsg);
}
