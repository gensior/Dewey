package com.jfranceschini.library;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Library {
	public final static int CHECKOUT_LIMIT = 3;
	private String name;
	
	private Map<String, Book> bookMap = new HashMap<String, Book>();

	private Set<LibraryMember> members = new HashSet<LibraryMember>();
	
	public Library(String name) {
		this.name = name;
	}

	public void checkoutBook(LibraryMember member, String sbnNumber) {
		
		// Double membership already taken care of by set
		members.add(member);
		
		Book book = bookMap.get(sbnNumber);
		
		if (book != null && !book.isCheckedOut() && member.getCheckedOutBooks().size() < CHECKOUT_LIMIT) {
			member.checkOutBook(book);
		} else {
			System.out.println("Error");
		}
	}
	
	public void returnBook(LibraryMember member, Book book) {
		if (member.returnBook(book)) {
			book.setCheckedOut(false);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Library: " + this.name + "\n");
		stringBuilder.append("Books:\n");
		for (Book book : bookMap.values()) {
			stringBuilder.append("-- " + book.toString() + "\n");
		}
		for (LibraryMember member: members) {
			stringBuilder.append(member.toString() + "\n");
		}
		return stringBuilder.toString();
	}
}
