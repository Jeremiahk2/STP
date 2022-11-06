/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * 
 * @author Jeremiah Knizley
 *
 * @param <E>
 */
public class SortedList<E extends Comparable<E>> implements ISortedList<E> {

	private ListNode front;
	
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
	 * @author Jeremiah Knizley
	 *
	 */
	public class ListNode {

		public ListNode next;
		
		public E data;
		
		public ListNode(E element, ListNode next) {
			
		}
		
	}


}
