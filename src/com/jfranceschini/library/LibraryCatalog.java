package com.jfranceschini.library;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

/**
 * LibraryCatalog
 * @author Jesse Franceschini
 *
 */
public class LibraryCatalog {
	
	/** Map of LibraryItems */
	private HashMap<UUID, LibraryItem> libraryItems = new HashMap<UUID, LibraryItem>();
	/** The instance of the LibraryCatalog */
	private static final LibraryCatalog theInstance = new LibraryCatalog();

	/**
	 * Default constructor
	 */
	private LibraryCatalog(){ }
	
	/**
	 * Retrieves a libraryItem from the libraryItems hashmap
	 * @param id a UUID of the item to retrieve
	 * @return a LibraryItem
	 */
	public LibraryItem getLibraryItem(UUID id) {
		return libraryItems.get(id);
	}
	
	/**
	 * Adds a LibraryItem to the libraryItems hashmap
	 * @param libraryItem a LibraryItem to add
	 */
	public void addLibraryItem(LibraryItem libraryItem) {
		libraryItems.put(libraryItem.getId(), libraryItem);
	}
	
	/**
	 * Gets the singleton instance of the LibraryCatalog
	 * @return a singleton of LibraryCatalog
	 */
	public static LibraryCatalog getInstance() {
		return theInstance;
	}
	
	/**
	 * Determines if the libraryItems hashmap contains a key
	 * @param id a UUID of the item to look for
	 * @return a boolean, true if the item exists, false if it does not
	 */
	public boolean contains(UUID id) {
		return libraryItems.containsKey(id);
	}
	
	/**
	 * Gets the libraryItems hashmap
	 * @return a Collection of LibraryItems
	 */
	public Collection<LibraryItem> getLibraryItems() {
		return libraryItems.values();
	}
}
