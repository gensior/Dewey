package com.jfranceschini;

import java.util.Date;

import com.jfranceschini.library.Book;
import com.jfranceschini.library.LibraryMember;

public class LibraryDriver {
	public static void main(String[] args) {
		Book book1 = new Book("Green Eggs and Ham", 
				"Dr. Seuss", 
				"Scholastic", 
				new Date(111111111));
		// System.out.println(book1);
		Book book2 = new Book("Hello World",
				"",
				"",
				new Date(222222222));
		// System.out.println(book2);
		Book book3 = new Book("How to Serve Man",
				"Kodos",
				"Intergalactic Press",
				new Date(999999999));
		// System.out.println(book3);
		Book book4 = new Book("Stuff and Things",
				"Mr. Guy",
				"Book Publishers",
				new Date(333333333));
		// System.out.println(book4);
		LibraryMember member1 = new LibraryMember("Jesse", "Franceschini");
		LibraryMember member2 = new LibraryMember("Homer", "Simpson");
		LibraryMember member3 = new LibraryMember("Lisa", "Simpson");
		LibraryMember member4 = new LibraryMember("Marge", "Simpson");
		LibraryMember member5 = new LibraryMember("Bart", "Simpson");
		// System.out.println(member1);
		member1.checkOutBook(book1);
		member1.checkOutBook(book2);
		member2.checkOutBook(book2);
		member3.checkOutBook(book3);
		member4.checkOutBook(book4);
		member5.checkOutBook(book1);
		// System.out.println(member1);
		// System.out.println(book1);
	}
}
