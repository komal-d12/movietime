package com.kd.movietime.exceptionhandling;

public class ExceptionResponse {

	private String errorMessage;

	private String callerURL;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String message) {
		errorMessage = message;
	}

	public String getCallerURL() {
		return callerURL;
	}

	public void setCallerURL(String callerURL) {
		this.callerURL = callerURL;
	}

}
