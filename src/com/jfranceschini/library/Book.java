package com.jfranceschini.library;

import java.util.Date;

public class Book {
	private String title;
	private String author;
	private Date published_date;
	private String publisher;
	private boolean checked_out;
	
	public Book(String title, String author, String publisher, Date published_date) {
		this.title = title;
		if (author != null && author.length() > 0) {
			this.author = author;
		} else {
			this.author = "Anonymous";
		}
		this.publisher = publisher;
		this.published_date = published_date;
		this.checked_out = false;
	}
	
	public void printStatus() {
		if (this.checked_out) {
			System.out.println("Book is checked out.");
		} else {
			System.out.println("Book is not checked out.");
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
	public Date getPublished_date() {
		return published_date;
	}
	public void setPublished_date(Date published_date) {
		this.published_date = published_date;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public boolean isChecked_out() {
		return checked_out;
	}
	public void setChecked_out(boolean checked_out) {
		this.checked_out = checked_out;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", published_date=" + published_date + ", publisher="
				+ publisher + ", checked_out=" + checked_out + "]";
	}
	
	
}
