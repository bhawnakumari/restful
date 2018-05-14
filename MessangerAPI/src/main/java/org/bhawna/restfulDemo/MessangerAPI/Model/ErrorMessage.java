package org.bhawna.restfulDemo.MessangerAPI.Model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	private String errorMessage;
	private int statusCode;
	
	public ErrorMessage(){
		
	}
	
	public ErrorMessage( String errorMessage, int statusCode ){
		super();
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	

}
