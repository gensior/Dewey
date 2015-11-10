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

	
}
