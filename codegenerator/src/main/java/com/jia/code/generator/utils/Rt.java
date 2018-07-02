package com.jia.code.generator.utils;

public class Rt<T> {
	
	/**
	 * 响应编码
	 */
	private int code;
	
	/**
	 * 错误或者 提示消息
	 */
	private String mes;
	
	/**
	 * 业务数据
	 */
	private T data;
	
	private T page;
	
	public T getPage() {
		return page;
	}

	public void setPage(T page) {
		this.page = page;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public boolean isOk() {
		return 200 == code;
	}
	
	
	
	
	public Rt() {
		super();
	}
	
	public Rt(T data) {
		super();
		this.data = data;
	}

	public static <T>  Rt<T> ok(T data) {
		Rt<T> result = new Rt<T>();
		if(data instanceof String) {
			result.mes = (String) data;
		}else if(data instanceof RtPageUtils ) {
			result.page = data;
		}else {
			result.data = data;
		}
		result.setCode(200);
		return result;
	}
	
	
	public static  <T>  Rt<T> error(String data) {
		Rt<T> result = new Rt<T>();
		result.setMes(data);
		result.setCode(500);
		return (Rt<T>) result;
	}
}
