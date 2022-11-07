/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

/**
 * An Array based list that maintains a log of information. 
 * Implements ILog, thus elements added to the log also cannot be removed.
 * Utilizes an array-based approach.
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
	 * Adds the element to the end of the list.
	 * @param element element to add
	 * @throws NullPointerException if element is null 
	 */
	@Override
	public void add(E element) {
		
		//Exception message should be "Cannot add null element."
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
		return size;
	}
	
}
