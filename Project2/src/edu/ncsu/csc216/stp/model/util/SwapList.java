/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * Implements the ISwapList interface that represents a list that changes the position of elements
 * through swap operations. Utilizes an Array-based approach to lists.
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
	 * Constructor for the SwapList object, initializes size to 0 and the array to an empty array with INITIAL_CAPACITY
	 */
	@SuppressWarnings("unchecked")
	public SwapList() {
		list = (E[]) new Object[INITIAL_CAPACITY];
		size = 0;
	}
	
	/**
	 * Adds the element to the end of the list.
	 * @param element element to add
	 * @throws NullPointerException if element is null
	 * @throws IllegalArgumentException if element cannot be added 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void add(E element) {
		if (element == null) {
			throw new NullPointerException("Cannot add null element.");
		}
		list[size()] = element;
		size++;
		if (list.length == size()) {
			E[] tempArray = (E[]) new Object[size() * 2];
			for (int i = 0; i < size(); i++) {
				tempArray[i] = list[i];
			}
			list = tempArray;
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
		if (idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		E element = get(idx);
		for (int i = idx; i < size(); i++) {
			list[i] = list[i + 1];
		}
		list[size() - 1] = null;
		size--;
		return element;
	}

	/**
	 * Moves the element at the given index to index-1. If the element is already at the front of the list, the list
	 * is not changed.
	 * @param idx index of the element to move up
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	@Override
	public void moveUp(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		if (idx != 0) {
			E element = list[idx];
			list[idx] = list[idx - 1];
			list[idx - 1] = element;
		}
		
	}

	/**
	 * Moves the element at the given index to index+1. If the element is already at the front of the list, the list
	 * is not changed
	 * @param idx index of the element to move down
	 * @throws IndexOutOfBoundsException if the idx is out of bounds for the list
	 */
	@Override
	public void moveDown(int idx) {
		if (idx < 0 || idx >= size) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		if (idx != size() - 1) {
			E element = list[idx];
			list[idx] = list[idx + 1];
			list[idx + 1] = element;
		}
		
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
		if (idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		if (idx != 0) {
			E element = list[idx];
			list[idx] = list[0];
			list[0] = element;
		}
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
		if (idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		if (idx != size() - 1) {
			E element = list[idx];
			list[idx] = list[size() - 1];
			list[size() - 1] = element;
		}
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
		if (idx < 0 || idx >= size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		return list[idx];
	}

	/**
	 * Returns the number of elements in the list.
	 * @return number of elements in the list
	 */
	@Override
	public int size() {
		return size;
	}

}
