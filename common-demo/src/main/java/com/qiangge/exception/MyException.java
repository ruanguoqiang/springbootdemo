package com.qiangge.exception;


/**
 * 验证异常
 * 
 * @author Joe
 */
public class MyException extends ApplicationException {

	private static final long serialVersionUID = 5214146953001236471L;

	public static final String MESSAGE = "验证异常";

	public MyException() {
		super(MESSAGE);
	}

	public MyException(String message) {
		super(message);
		this.code =0000;
	}

	public MyException(int code, String message) {
		super(message);
		this.code = code;
	}

	public MyException(String message, Throwable cause) {
		super(message, cause);
		this.code = 00000;
	}

	public MyException(int code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public MyException(Throwable cause) {
		super(cause);
		this.code = 0000;
	}
}
