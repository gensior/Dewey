package com.jfranceschini.library;

import java.util.HashSet;
import java.util.Set;

/**
 * Library Member
 * @author Jesse Franceschini
 *
 */
public class LibraryMember {
	/** First name of library member */
	private String firstName;
	/** Last name of library member */
	private String lastName;
	private String address;
	private String phoneNumber;
	private String socialSecurityNumber;
	private String title;
	private String gender;
	private String middleName;
	/** A set of items that the library member has currently checked out */
	private Set<LibraryItem> checkedOutItems = new HashSet<LibraryItem>();
	
	/**
	 * Constructor for the LibraryMember
	 * 
	 * By default, LibraryMembers cannot have a book checked out when they are created.
	 * 
	 * @param firstName String of the first name
	 * @param lastName String of the last name
	 */
	public LibraryMember(LibraryMemberBuilder lmb) {
		// Sets the first name of the library member
		this.firstName = lmb.firstName;
		// Sets the last name of the library member
		this.lastName = lmb.lastName;
		this.address = lmb.address;
		this.phoneNumber = lmb.phoneNumber;
		this.socialSecurityNumber = lmb.socialSecurityNumber;
		this.title = lmb.title;
		this.gender = lmb.gender;
		this.middleName = lmb.middleName;
	}
	
	/**
	 * LibraryMemberBuilder
	 * @author Jesse Franceschini
	 *
	 */
	public static class LibraryMemberBuilder {
		/** First name of library member */
		private String firstName;
		/** Last name of library member */
		private String lastName;
		/** Address of the library member */
		private String address;
		/** Phone Number of the library member */
		private String phoneNumber;
		/** Social Security Number of the library member */
		private String socialSecurityNumber;
		/** Title of the library member */
		private String title;
		/** Gender of the library member */
		private String gender;
		/** Middle Name of the library member */
		private String middleName;
		
		/**
		 * Default constructor
		 * @param firstName a String of the library member's first name
		 * @param lastName a String of the library member's last name
		 */
		public LibraryMemberBuilder(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}
		
		/**
		 * Edits the first name
		 * @param firstName a String of the library member's first name
		 * @return the LibraryMemberBuilder instance
		 */
		public LibraryMemberBuilder withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		/**
		 * Edits the last name
		 * @param lastName a String of the library member's last name
		 * @return the LibraryMemberBuilder instance
		 */
		public LibraryMemberBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		/**
		 * Edits the address
		 * @param address a String of the library member's address
		 * @return the LibraryMemberBuilder instance
		 */
		public LibraryMemberBuilder withAddress(String address) {
			this.address = address;
			return this;
		}
		
		/**
		 * Edits the phone number
		 * @param phoneNumber a String of the library member's phone number
		 * @return the LibraryMemberBuilder instance
		 */
		public LibraryMemberBuilder withPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}
		
		/**
		 * Edits the social security number
		 * @param socialSecurityNumber a String of the library member's social security number
		 * @return the LibraryMemberBuilder instance
		 */
		public LibraryMemberBuilder withSocialSecurityNumber(String socialSecurityNumber) {
			this.socialSecurityNumber = socialSecurityNumber;
			return this;
		}
		
		/**
		 * Edits the title
		 * @param tritle a String of the library member's title
		 * @return the LibraryMemberBuilder instance
		 */
		public LibraryMemberBuilder withTitle(String title) {
			this.title = title;
			return this;
		}
		
		/**
		 * Edits the gender
		 * @param gender a String of the library member's gender
		 * @return the LibraryMemberBuilder instance
		 */
		public LibraryMemberBuilder withGender(String gender) {
			this.gender = gender;
			return this;
		}
		
		/**
		 * Edits the middle name
		 * @param middleName a String of the library member's middle name
		 * @return the LibraryMemberBuilder instance
		 */
		public LibraryMemberBuilder withMiddleName(String middleName) {
			this.middleName = middleName;
			return this;
		}
		
		/**
		 * Builds the LibraryMember based on attributes of the builder
		 * @return a LibraryMember
		 */
		public LibraryMember build() {
			return new LibraryMember(this);
		}
	}
	
	/**
	 * Checks out a book for the LibraryMember
	 * 
	 * Books can only be checked out if they aren't already checked out.
	 * LibraryMembers can only check out one book at a time.
	 * 
	 * @param item the Item object to be checked out
	 */
	public void checkOutItem(LibraryItem item) {
		item.setCheckedOut(checkedOutItems.add(item));
		System.out.println(this.firstName + " " + this.lastName + " checked out " + item.getTitle());
	}
	
	/**
	 * returnItem
	 * 
	 * Removes an Item from the checkedOutItems set and sets the item's checkedOut boolean to false.
	 * 
	 * If the member hadn't checked out the item, it will return false
	 * 
	 * @param item an Item object to return
	 * @return a boolean of whether removing the book from the checkedOutBooks set was successful
	 */
	public boolean returnItem(LibraryItem item) {
		if (checkedOutItems.contains(item)) {
			item.setCheckedOut(false);
			System.out.println(this.firstName + " " + this.lastName + " returned " + item.getTitle());
			return checkedOutItems.remove(item);
		} else {
			System.out.println(this.firstName + " " + this.lastName + " did not check out " + item.getTitle());
			return false;
		}
		
	}
	// Getters / Setters
	// First Name
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	// Last Name
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	// Checked Out Books
	public Set<LibraryItem> getCheckedOutItems() {
		return this.checkedOutItems;
	}

	/**
	 * Allows for tailored representation to the console.
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.title + " " + this.firstName + " " + this.middleName + " " + this.lastName + "\n");
		stringBuilder.append("Gender: " + this.gender + "\n");
		stringBuilder.append("Address: " + this.address + "\n");
		stringBuilder.append("Phone Number: " + this.phoneNumber + "\n");
		stringBuilder.append("SSN: " + this.socialSecurityNumber + "\n");
		stringBuilder.append("Check out items:\n");
		if (this.checkedOutItems.isEmpty()) {
			stringBuilder.append("no items checked out");
		} else {
			for (LibraryItem item : this.checkedOutItems) {
				stringBuilder.append(item.toString() + "\n");
			}
		}
		return stringBuilder.toString();
	}

	/**
	 * HashCode only uses firstName and lastName to generate a hash code
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
	/**
	 * Equality is based on the firstName and lastName, not the checkedOutBook set
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LibraryMember other = (LibraryMember) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}
}
