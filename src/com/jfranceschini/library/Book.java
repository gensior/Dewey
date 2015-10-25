package com.jfranceschini.library;

import java.util.Date;
import java.util.GregorianCalendar;

public class Book {
	private String title;
	private String author;
	private Date publishedDate;
	private String publisher;
	private boolean checkedOut;
	private LibraryMember checkerOuter;

	public Book(String title, String author, String publisher, int year, int month, int day) {
		this.title = title;
		if (author != null && author.length() > 0) {
			this.author = author;
		} else {
			this.author = "Anonymous";
		}
		this.publisher = publisher;
		if (year == 0){
			this.publishedDate = new GregorianCalendar().getTime();
		} else {
			this.publishedDate = new GregorianCalendar(year, month, day).getTime();
		}
		this.checkedOut = false;
	}
	
	public Book(String title, String author, String publisher) {
		this(title, author, publisher, 0, 0, 1);
	}
	
	public Book(String title, String author, String publisher, int year) {
		this(title, author, publisher, year, 0, 1);
	}
	
	public Book(String title, String author, String publisher, int year, int month) {
		this(title, author, publisher, year, month, 1);
	}
	
	public void printStatus() {
		if (this.checkedOut) {
			System.out.println("\"" + title + "\" is checked out.");
		} else {
			System.out.println("\"" + title + "\" is not checked out.");
		}
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Date getPublishedDate() {
		return publishedDate;
	}
	
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public boolean isCheckedOut() {
		return checkedOut;
	}
	
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
	}
	
	public LibraryMember getCheckerOuter() {
		return checkerOuter;
	}

	public void setCheckerOuter(LibraryMember checkerOuter) {
		this.checkerOuter = checkerOuter;
	}

	@Override
	public String toString() {
		return "*******Book*******" +
				"\nTitle: " + title + 
				"\nAuthor: " + author + 
				"\nPublished At: " + publishedDate + 
				"\nPublisher: " + publisher + 
				"\nChecked Out: " + checkedOut;
	}
}
