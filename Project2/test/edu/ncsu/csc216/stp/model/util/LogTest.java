/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests Log class
 * @author Jeremiah Knizley
 *
 */
class LogTest {

	/**
	 * Test method for Log constructor
	 */
	@Test
	void testLog() {
		Log<String> log = new Log<>();
		assertEquals(0, log.size());
	}

	/**
	 * Test method for Log.add
	 */
	@Test
	void testAdd() {
		Log<String> log = new Log<>();
		assertDoesNotThrow(() -> log.add("Banana"));
		assertEquals(1, log.size());
		//Check for adding null element
		Exception e1 = assertThrows(NullPointerException.class, () -> log.add(null));
		assertEquals("Cannot add null element.", e1.getMessage());
		//check that size wasn't increased after adding null element
		assertEquals(1, log.size());
		assertDoesNotThrow(() -> log.add("Grape"));
		//Check size and contents after adding things.
		assertEquals(2, log.size());
		assertEquals("Banana", log.get(0));
		assertEquals("Grape", log.get(1));
		
		//Check that adding after the capacity is accepted.
		for (int i = 0; i < 9; i++) {
			assertDoesNotThrow(() -> log.add("Grape"));
		}
		
		
	}

	/**
	 * Test method for Log.get
	 */
	@Test
	void testGet() {
		Log<String> log = new Log<>();
		assertDoesNotThrow(() -> log.add("Banana"));
		assertDoesNotThrow(() -> log.add("Banana"));
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> log.get(2));
		assertEquals("Invalid index.", e1.getMessage());
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> log.get(-1));
		assertEquals("Invalid index.", e2.getMessage());
	}

}
