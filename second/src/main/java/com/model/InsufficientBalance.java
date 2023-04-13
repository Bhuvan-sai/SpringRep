package com.model;

public class InsufficientBalance extends Exception {
	private String message;
	
    public InsufficientBalance(String message) {
        super(message);
    }
    
    @Override
    public String toString() {
    	return "InsufficientBalance [message="+message+"]";
    }
}
