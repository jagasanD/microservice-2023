package com.example.photoAppUser.utility;

import org.springframework.stereotype.Component;

//@Component
public class ResponsePayLoad {

	private String message;
	private String statusCode;
	private Object payload;
	public ResponsePayLoad(String message, String statusCode, Object payload) {
		super();
		this.message = message;
		this.statusCode = statusCode;
		this.payload = payload;
	}
	
	public ResponsePayLoad(String message, String statusCode) {
		super();
		this.message = message;
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public Object getPayload() {
		return payload;
	}

	public void setPayload(Object payload) {
		this.payload = payload;
	}
	
	
	
}
