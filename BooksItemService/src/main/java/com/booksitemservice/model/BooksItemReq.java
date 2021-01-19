package com.booksitemservice.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

/**
 * @author Soujanya Pagala
 *
 */
public class BooksItemReq implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private long bookCode;

	@NotNull
	private String bookName;

	@NotNull
	private int bookQuantity;

	@NotNull
	private String bookAuthor;
	
	@NotNull
	private String publishedBy;

	public long getBookCode() {
		return bookCode;
	}

	public void setBookCode(long bookCode) {
		this.bookCode = bookCode;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookQuantity() {
		return bookQuantity;
	}

	public void setBookQuantity(int bookQuantity) {
		this.bookQuantity = bookQuantity;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getPublishedBy() {
		return publishedBy;
	}

	public void setPublishedBy(String publishedBy) {
		this.publishedBy = publishedBy;
	}
	
}