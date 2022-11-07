/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * Implements the ISwapList interface that represents a list that changes the position of elements
 * through swap operations
 * @author Jeremiah Knizley
 * @author Ryan McPhee
 *
 * @param <E> type for the SwapList
 */
public class SwapList<E> implements ISwapList<E> {
	
	/** Constant for the initial capacity of the SwapList */
	private static final int INITIAL_CAPACITY = 10;
	/** Type list for the SwapList */
	private E[] list;
	/** Size of the list */
	private int size;
	
	/**
	 * Constructor for the SwapList object
	 */
	public SwapList() {
		
	}
	
	/**
	 * Adds the element to the end of the list.
	 * @param element element to add
	 * @throws NullPointerException if element is null
	 * @throws IllegalArgumentException if element cannot be added 
	 */
	@Override
	public void add(E element) {
		
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
		return null;
	}

	/**
	 * Moves the element at the given index to index-1. If the element is already at the front of the list, the list
	 * is not changed.
	 * @param idx index of the element to move up
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	@Override
	public void moveUp(int idx) {
		
		
	}

	/**
	 * Moves the element at the given index to index+!. If the element is already at the front of the list, the list
	 * is not changed
	 * @param idx index of the element to move down
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	@Override
	public void moveDown(int idx) {
		
		
	}

	/**
	 * Moves the element at the given index to index 0.  If the element is
	 * already at the front of the list, the list is not changed.
	 * @param idx index of element to move to the front
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	@Override
	public void moveToFront(int idx) {
		
	}

	/**
	 * Moves the element at the given index to size-1.  If the element is
	 * already at the end of the list, the list is not changed.
	 * @param idx index of element to move to the back
	 * @throws IndexOutOfBoundsException if the idx is out of bounds
	 * 		for the list
	 */
	@Override
	public void moveToBack(int idx) {
		
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
		return null;
	}

	/**
	 * Returns the number of elements in the list.
	 * @return number of elements in the list
	 */
	@Override
	public int size() {
		return 0;
	}

}
