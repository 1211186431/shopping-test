package com.example.demo.exception;
/**
 * 自定义错误类
 * @author dy-xx
 *
 */
public class BizException extends RuntimeException {
	private static final long serialVersionUID = -7293520006679551853L;
	
	private String errorCode;
	
	public BizException(String message, String errorCode) {
		super(message);

		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
