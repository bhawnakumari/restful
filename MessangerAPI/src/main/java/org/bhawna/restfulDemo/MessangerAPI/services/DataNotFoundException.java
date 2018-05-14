package org.bhawna.restfulDemo.MessangerAPI.services;

public class DataNotFoundException  extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException(String message){
		super(message);
	}

}
