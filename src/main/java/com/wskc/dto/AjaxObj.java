package com.wskc.dto;
/**
 * 专门用来返回ajax 处理之后结果json数据对象
 * @author Mr.Cheng
 *
 */
public class AjaxObj {
	/**
	 * 0表示失败
	 * 1:表示成功
	 */
	private int result;
	/**
	 * 提示信息
	 */
	private String msg;
	/**
	 * 附加对象，用户存储对象
	 */
	private Object obj;
	
	
	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public Object getObj() {
		return obj;
	}


	public void setObj(Object obj) {
		this.obj = obj;
	}


	public AjaxObj() {
		super();
	}


	public AjaxObj(int result) {
		super();
		this.result = result;
	}


	public AjaxObj(int result, String msg) {
		super();
		this.result = result;
		this.msg = msg;
	}


	public AjaxObj(int result, String msg, Object obj) {
		super();
		this.result = result;
		this.msg = msg;
		this.obj = obj;
	}
	
	
	
}
