/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * An Array based list that maintains a log of information. 
 * Implements ILog, thus elements added to the log also cannot be removed.
 * @author Jeremiah Knizley
 * @author Ryan McPhee
 * @param <E> a generic type to work with any type
 *
 */
public class Log<E> implements ILog<E> {

	/** the array of elements in the log */
	private E[] log;
	/** the size of the log */
	private int size;
	/** the initial capacity of created logs */
	public static final int INIT_CAPACITY = 10;
	
	/**
	 * constructor for Log. Constructs log array with INIT_CAPACITY as it's length.
	 * Initializes size to 0
	 */
	public Log() {
		
	}

	/**
	 * Adds an element to the end of the list. Once an element is added, it cannot be removed.
	 * @throws NullPointerException if the parameter is null.
	 */
	@Override
	public void add(E element) {
		
		//Exception message should be "Cannot add null element."
	}

	/**
	 * returns the element at the specified index
	 * @return E the element at the specified index
	 * @throws IndexOutOfBoundsException if index is less than 0 or greater than or equal to size.
	 */
	@Override
	public E get(int idx) {
		return null;
	}

	/**
	 * returns the current size field
	 * @return size the current size field
	 */
	@Override
	public int size() {
		return size;
	}
	
}
