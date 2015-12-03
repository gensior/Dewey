package com.jfranceschini.library;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.jfranceschini.library.exception.LibraryItemAlreadyExistsException;
import com.jfranceschini.library.exception.LibraryItemDoesNotExistException;
import com.jfranceschini.library.exception.LibraryMemberDoesNotExistException;

/**
 * Library
 * @author Jesse Franceschini
 *
 */
public class Library {
	/** The name of the library */
	private String name;
	/** A map of books that the library has in its collection */
	private Map<String, Item> itemMap = new HashMap<String, Item>();
	/** A set of library member that belong to the library */
	private Set<LibraryMember> members = new HashSet<LibraryMember>();
	/** A constant to limit the number of items the library allows one user to check out */
	public final static int CHECKOUT_LIMIT = 3;
	
	/**
	 * Constructor for the Library class
	 * 
	 * @param name a String to represent the name of the library
	 */
	public Library(String name) {
		this.name = name;
	}
	
	public void addLibraryMember(LibraryMember libraryMember) {
		members.add(libraryMember);
	}
	
	/**
	 * addItem
	 * 
	 * Adds an item to the library's itemMap Map.
	 * @param item an Item object to add to the library
	 * @throws LibraryItemAlreadyExistsException 
	 */
	public void addItem(Item item) throws LibraryItemAlreadyExistsException {
		// If the bookMap doesn't already contain a book with the same SbnNumber
		if (!itemMap.containsKey(item.getId())) {
			// Add the item to the itemMap
			itemMap.put(item.getId(), item);
			// System.out.println("Added item: " + item.getTitle());
		} else {
			// the library item already exists
			throw new LibraryItemAlreadyExistsException(item.getId() + " already exists in " + this.name + ".");
		}
	}
	
	/**
	 * checkOutItem
	 * 
	 * If the item isn't null, isn't already checked out, and the member checking out the item hasn't reached their checkout limit, then check the item out.
	 * @param member a LibraryMember trying to check out a book
	 * @param itemId a String referencing an item in the itemMap
	 * @throws LibraryMemberDoesNotExistException 
	 * @throws LibraryItemDoesNotExistException 
	 */
	public void checkoutItem(LibraryMember member, String itemId) throws LibraryMemberDoesNotExistException, LibraryItemDoesNotExistException {
		if (!members.contains(member)) {
			// If the member isn't in the library's members Set
			throw new LibraryMemberDoesNotExistException("Library Member " + member.getFirstName() + " " + member.getLastName() + " does not exist.");
		}
		// Get the book object from the bookMap
		Item item = itemMap.get(itemId);
		// Check if the book isn't null, isn't checked out, and if the member can still check out books
		if (item != null && !item.isCheckedOut() && member.getCheckedOutItems().size() < CHECKOUT_LIMIT) {
			// Check out that book
			member.checkOutItem(item);
		} else {
			// the library item does not exist
			throw new LibraryItemDoesNotExistException("Library Item " + itemId.toString() + " does not exist.");
		}
	}
	
	/**
	 * returnItem
	 * 
	 * Returns an item to the library if the item exists in the library's itemMap and the item exists in the member's item set.
	 * @param member a LibraryMember trying to return an item
	 * @param itemId itemId a String referencing an item in the itemMap
	 * @throws LibraryItemDoesNotExistException 
	 * @throws LibraryMemberDoesNotExistException 
	 */
	public void returnItem(LibraryMember member, String itemId) throws LibraryItemDoesNotExistException, LibraryMemberDoesNotExistException {
		if (itemMap.containsKey(itemId)) {
			if (members.contains(member)) {
				Item itemToReturn = itemMap.get(itemId);
				member.returnItem(itemToReturn);	
			} else {
				throw new LibraryMemberDoesNotExistException("Library Member " + member.getFirstName() + " " + member.getLastName() + " does not exist.");
			}
		} else {
			throw new LibraryItemDoesNotExistException("Library Item " + itemId.toString() + " does not exist.");
		}
	}
	
	/**
	 * Prints out the library's name, members, and what items they've checked out
	 */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("Library: " + this.name + "\n");
		stringBuilder.append("Library Books:\n");
		for (Item item : itemMap.values()) {
			stringBuilder.append("-- " + item.toString() + "\n");
		}
		stringBuilder.append("\nLibrary Members:\n");
		if (members.size() > 0) {
			for (LibraryMember member: members) {
				stringBuilder.append(member.toString() + "\n");
			}
		} else {
			stringBuilder.append("none\n");
		}
		return stringBuilder.toString();
	}
}
