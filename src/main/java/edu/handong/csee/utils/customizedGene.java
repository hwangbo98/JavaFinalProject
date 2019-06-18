package edu.handong.csee.utils;

public class customizedGene<T> {
	
	public T data;
	
	private Object[] element;
	private int num;
	
	public void setData(T newValue) {
		element = new Object[0];
		element[num++] = newValue;
		
	}
	
	public T getData() {
		return (T) element[num];
	}
	
	public int num() {
		return num;
	}

}
