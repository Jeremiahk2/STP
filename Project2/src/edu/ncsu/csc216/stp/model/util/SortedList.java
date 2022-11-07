/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * Implements the ISortedList interface that represents a list that keeps objects in sorted
 * order as defined by the Comparable interface
 * @author Jeremiah Knizley
 *
 * @param <E> type for SortedList; must implement Comparable
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {

	/** Front node of the list */
	private ListNode front;
	
	/**
	 * Constructor for the SortedList object
	 */
	public SortedList() {
		
	}
	
	@Override
	public void add(E element) {
		
	}

	@Override
	public E remove(int idx) {
		return null;
	}

	@Override
	public boolean contains(E element) {
		return false;
	}

	@Override
	public E get(int idx) {
		return null;
	}

	@Override
	public int size() {
		return 0;
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
