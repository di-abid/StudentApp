package com.student.exceptions;

public class BookNotFoundException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookNotFoundException(){
		super();
	}
	
	public BookNotFoundException(String subCode){
		super("Book Not Found for the subCode : " + subCode + ". Check with library department.");
	}
}
