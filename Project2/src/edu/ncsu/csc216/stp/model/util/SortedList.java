/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * Implements the ISortedList interface that represents a list that keeps objects in sorted
 * order as defined by the Comparable interface. Utilizes a LinkedList approach
 * @author Jeremiah Knizley
 *
 * @param <E> type for SortedList; must implement Comparable
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {

	/** Front node of the list */
	private ListNode front;
	/** the current size of the list */
	private int size;
	
	/**
	 * Constructor for the SortedList object, initializes front to null and size to 0
	 */
	public SortedList() {
		front = null;
		size = 0;
	}
	
	/**
	 * Adds the element to the list in sorted order.
	 * @param element element to add
	 * @throws NullPointerException if element is null
	 * @throws IllegalArgumentException if element is a duplicate of one already in the list
	 */
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		if (contains(element)) {
			throw new IllegalArgumentException("Cannot add duplicate element.");
		}
		if (size() == 0) {
			front = new ListNode(element, null);
			size++;
		}
		else {
			ListNode current = front;
			if (element.compareTo(current.data) < 0) {
				front = new ListNode(element, current);
				size++;
			}
			else {
				for (int i = 0; i < size; i++) {
					int comparison = 0;
					try {
						comparison = element.compareTo(current.next.data);
					} catch (NullPointerException e) {
						break;
					}
					if (comparison < 0) {
						break;
					}
					current = current.next;
				}
				current.next = new ListNode(element, current.next);
				size++;
			}
		}
		
	}

	/**
	 * Returns the element from the given index.  The element is
	 * removed from the list.
	 * @param idx index to remove element from
	 * @return element at given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	@Override
	public E remove(int idx) {
		checkIndex(idx);
		
		ListNode current = front;
		E rtnElement;
		if (idx == 0) {
			rtnElement = front.data;
			front = front.next;
			size--;
			return rtnElement;
		}
		for (int i = 0; i < idx - 1; i++) {
			current = current.next;
		}
		rtnElement = current.next.data;
		current.next = current.next.next;
		size--;
		return rtnElement;
	}
	
	/**
	 * Checks the index to see if it is valid or not.
	 * @param idx the index to be checked
	 * @throws IndexOutOfBoundsException if the index is not within bounds (less than 0, at size or greater).
	 */
	private void checkIndex(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
	}

	/**
	 * Returns true if the element is in the list.
	 * @param element element to search for
	 * @return true if element is found
	 */
	@Override
	public boolean contains(E element) {
		ListNode current = front;
		for (int i = 0; i < size; i++) {
			int comparison = current.data.compareTo(element);
			if (comparison == 0) {
				return true;
			}
			current = current.next;
		}
		return false;
	}

	/**
	 * Returns the element at the given index.
	 * @param idx index of the element to retrieve
	 * @return element at the given index
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	@Override
	public E get(int idx) {
		checkIndex(idx);
		ListNode current = front;
		for (int i = 0; i < idx; i++) {
			current = current.next;
		}
		return current.data;
	}

	/**
	 * Returns the number of elements in the list.
	 * @return number of elements in the list
	 */
	@Override
	public int size() {
		return size;
	}
	
	/**
	 * Inner class for the ListNode object 
	 * @author Jeremiah Knizley
	 * @author Ryan McPhee
	 *
	 */
	public class ListNode {

		/** Node linked to the current node */
		public ListNode next;
		
		/** Data of any type for the node to hold */
		public E data;
		
		/**
		 * Constructor for the ListNode object
		 * @param element data held within the node in the data private variable
		 * @param next the next node that is linked to the current node being created
		 */
		public ListNode(E element, ListNode next) {
			this.data = element;
			this.next = next;
		}
		
	}


}
