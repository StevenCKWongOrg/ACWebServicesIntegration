package com.stevenckwong.ACWebServicesIntegration;

public class ACWebServicesException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Exception originalException;
	private String errorMessage;
	
	public ACWebServicesException(Exception e) {
		this.errorMessage = "No specific error message recorded";
		this.originalException = e;
	}
	
	public Exception getOriginalException() {
		return this.originalException;
	}
	
	public void setErrorMessage(String message) {
		this.errorMessage = message;
	}
	
	public String getErrorMessage() {
		return this.errorMessage;
	}

}
