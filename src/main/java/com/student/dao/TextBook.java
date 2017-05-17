package com.student.dao;

import org.springframework.stereotype.Component;

@Component
public class TextBook {
	private String isbn;
	private String subCode;
	private String bookName;
	private String bookAuthor;
	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return the subCode
	 */
	public String getSubCode() {
		return subCode;
	}
	/**
	 * @param subCode the subCode to set
	 */
	public void setSubCode(String subCode) {
		this.subCode = subCode;
	}
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * @return the bookAuthor
	 */
	public String getBookAuthor() {
		return bookAuthor;
	}
	/**
	 * @param bookAuthor the bookAuthor to set
	 */
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	
}
