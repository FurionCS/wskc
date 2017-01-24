package com.wskc.model;
/**
 * 
 * <p>Title:全局异常对象</p>
 * <p>Description:所有异常都通过这个类抛出</p>
 * @author Mr.Cheng
 * @date 2017年1月19日 下午8:12:58
 */
public class BasicException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BasicException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BasicException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public BasicException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BasicException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BasicException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
