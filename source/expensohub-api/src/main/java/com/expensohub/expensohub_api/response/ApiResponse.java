package com.expensohub.expensohub_api.response;

public class ApiResponse {

	public Object obj;
	public String message;
	private int StatusCode;
	private boolean success;

	public ApiResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApiResponse(Object obj, String message, int statusCode, boolean success) {
		super();
		this.obj = obj;
		this.message = message;
		StatusCode = statusCode;
		this.success = success;
	}

	public ApiResponse(String message, int statusCode, boolean success) {
		super();

		this.message = message;
		StatusCode = statusCode;
		this.success = success;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatusCode() {
		return StatusCode;
	}

	public void setStatusCode(int statusCode) {
		StatusCode = statusCode;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
