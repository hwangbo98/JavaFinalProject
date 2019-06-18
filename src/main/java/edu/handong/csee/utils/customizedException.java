package edu.handong.csee.utils;

public class customizedException extends Exception {
	
	public customizedException() {
		super("Exception can be occured!");
	}
	
	public customizedException(String sendMsg) {
		super(sendMsg);
	}

}
