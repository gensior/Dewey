package com.jfranceschini;

import java.util.Date;

import com.jfranceschini.library.Book;

public class LibraryDriver {
	public static void main(String[] args) {
		Book book1 = new Book("Green Eggs and Ham", 
				"Dr. Seuss", 
				"Scholastic", 
				new Date(111111111));
		System.out.println(book1);
		Book book2 = new Book("Hello World",
				"",
				"",
				new Date(222222222));
		System.out.println(book2);
	}
}
