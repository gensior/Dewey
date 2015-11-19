package com.jfranceschini.library;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

/**
 * Item
 * 
 * The abstract class that other library items inherit from
 * 
 * This class handles the basic attributes of a library item.
 * 
 * @author Jesse Franceschini
 *
 */
public abstract class Item {
	protected String title;
	/** When the book was published */
	protected Date publishedDate;
	/** Who published the book */
	protected String publisher;
	/** Boolean to say if the book is checked out */
	protected boolean checkedOut;
	/** LibraryMember object that checked out the book */
	protected LibraryMember checkerOuter;
	/** String that represents the book's sbnNumber */
	protected UUID id;
	/** When the item is due back to the library */
	protected Date dueDate;
	/** The type of media the item is */
	protected MediaType mediaType;
	
	/**
	 * Prints whether the item is checked out or not.
	 */
	public void printStatus() {
		if (this.checkedOut) {
			System.out.println("\"" + title + "\" is checked out.");
		} else {
			System.out.println("\"" + title + "\" is not checked out.");
		}
	}
	
	/**
	 * The preferred constructor
	 * 
	 * @param title a String of the item's title
	 * @param publisher a String of the item's publisher
	 * @param publishedDate a Date of when the item was published
	 * @param mediaType a MediaType of what kind of media the item is
	 */
	public Item(String title, String publisher, Date publishedDate, MediaType mediaType) {
		this.title = title;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.mediaType = mediaType;
		// the id is generated automatically
		this.id = UUID.randomUUID();
		// by default, the item is not already checked out
		this.checkedOut = false;
	}
	
	// Getters / Setters
	// Title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	// Published Date
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	// Publisher
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	// Library Member
	public LibraryMember getCheckerOuter() {
		return checkerOuter;
	}
	public void setCheckerOuter(LibraryMember checkerOuter) {
		this.checkerOuter = checkerOuter;
	}
	// SBN Number
	public String getId() {
		return this.id.toString();
	}
	// Checked Out
	public boolean isCheckedOut() {
		return checkedOut;
	}
	/**
	 * setCheckedOut
	 * 
	 * This handles automatically calculating or clearing out the due date when the item is checked out or returned.
	 * @param checkedOut a boolean of whether the item is checked out or not
	 */
	public void setCheckedOut(boolean checkedOut) {
		this.checkedOut = checkedOut;
		if (checkedOut) {
			this.dueDate = calculateDueDate();
		} else {
			this.dueDate = null;
		}
	}
	// Due Date
	public Date getDueDate() {
		return this.dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	// Media Type
	public MediaType getMediaType() {
		return mediaType;
	}
	public void setMediaType(MediaType mediaType) {
		this.mediaType = mediaType;
	}
	
	protected String getCheckedOutString() {
		StringBuilder statusBuilder = new StringBuilder();
		if (checkedOut) {
			statusBuilder.append(" due on ");
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			statusBuilder.append(sdf.format(dueDate));
		} else {
			statusBuilder.append(" not checked out.");
		}
		return statusBuilder.toString();
	}
	
	/**
	 * calculateDueDate
	 * 
	 * Determines the due date by referencing the implemented determineCheckOutLength in the subClass
	 * 
	 * @return a Date of when the item is due
	 */
	public Date calculateDueDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, determineCheckOutLength());
		// this.dueDate = calendar.getTime();
		return calendar.getTime();
	}
	
	/**
	 * This must be implemented in further subClasses
	 * @return an int of how many days in the future the item must be returned by
	 */
	public abstract int determineCheckOutLength();

	/**
	 * hashCode only uses the UUID id attribute to generate a hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/**
	 * Equality only depends on the UUID id attribute
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
