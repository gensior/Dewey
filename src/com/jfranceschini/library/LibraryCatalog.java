package com.jfranceschini.library;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class LibraryCatalog {
	
	/** Map of LibraryItems */
	private HashMap<UUID, LibraryItem> libraryItems = new HashMap<UUID, LibraryItem>();

	/** The instance of the LibraryCatalog */
	private static final LibraryCatalog theInstance = new LibraryCatalog();

	private LibraryCatalog(){ }
	
	public LibraryItem getLibraryItem(UUID id) {
		return libraryItems.get(id);
	}
	
	public void addLibraryItem(LibraryItem libraryItem) {
		libraryItems.put(libraryItem.getId(), libraryItem);
	}
	
	public static LibraryCatalog getInstance() {
		return theInstance;
	}
	
	public boolean contains(UUID id) {
		return libraryItems.containsKey(id);
	}
	
	public Collection<LibraryItem> getLibraryItems() {
		return libraryItems.values();
	}
}
