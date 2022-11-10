package com.tcs.rmg.data;

public class Response {

	private String message;
	private String responseCode;
	private String token;

	public Response(String message, String responseCode) {
		super();
		this.message = message;
		this.responseCode = responseCode;
	}
	
	public Response(String message, String responseCode, String token) {
		super();
		this.message = message;
		this.responseCode = responseCode;
		this.token = token;
	}

	public Response(){
		
	}
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "ResponseVO [message=" + message + ", responseCode=" + responseCode + ", token=" + token + "]";
	}
}
