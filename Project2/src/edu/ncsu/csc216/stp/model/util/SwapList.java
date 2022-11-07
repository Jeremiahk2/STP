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
	
	@Override
	public void add(E element) {
		
	}

	@Override
	public E remove(int idx) {
		return null;
	}

	@Override
	public void moveUp(int idx) {
		
		
	}

	@Override
	public void moveDown(int idx) {
		
		
	}

	@Override
	public void moveToFront(int idx) {
		
	}

	@Override
	public void moveToBack(int idx) {
		
	}

	@Override
	public E get(int idx) {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

}
