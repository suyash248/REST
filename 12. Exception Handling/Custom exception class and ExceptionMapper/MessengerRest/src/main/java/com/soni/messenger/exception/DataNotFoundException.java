package com.soni.messenger.exception;

public class DataNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -8093744045767803031L;
	
	public DataNotFoundException(String msg){
		super(msg);
	}
}
