/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests SortedList class
 * @author Jeremiah Knizley
 *
 */
class SortedListTest {

	/**
	 * Test method for SortedList constructor
	 */
	@Test
	void testSortedList() {
		SortedList<String> list = new SortedList<>();
		assertEquals(0, list.size());
	}

	/**
	 * Test method for SortedList.add
	 */
	@Test
	void testAdd() {
		SortedList<String> list = new SortedList<>();
		list.add("Banana");
		list.add("Pear");
		list.add("Apple");
		assertEquals("Apple", list.get(0));
		assertEquals("Banana", list.get(1));
		assertEquals("Pear", list.get(2));
		assertEquals(3, list.size());
		
		Exception e1 = assertThrows(NullPointerException.class, () -> list.add(null));
		assertEquals("Cannot add null element.", e1.getMessage());
		
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> list.add("Apple"));
		assertEquals("Cannot add duplicate element", e2.getMessage());
		
	}

	/**
	 * Test method for SortedList.remove
	 */
	@Test
	void testRemove() {
		SortedList<String> list = new SortedList<>();
		list.add("Banana");
		list.add("Pear");
		list.add("Apple");
		assertEquals("Apple", list.get(0));
		assertEquals("Banana", list.get(1));
		assertEquals("Pear", list.get(2));
		assertEquals(3, list.size());
		
		assertEquals("Banana", list.remove(1));
		assertEquals("Apple", list.get(0));
		assertEquals("Pear", list.get(1));
		assertEquals(2, list.size());
		
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
		assertEquals("Invalid index.", e1.getMessage());
		
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
		assertEquals("Invalid index.", e2.getMessage());
		
		
	}

	/**
	 * Test method for SortedList.contains
	 */
	@Test
	void testContains() {
		SortedList<String> list = new SortedList<>();
		list.add("Banana");
		list.add("Pear");
		list.add("Apple");
		assertEquals("Apple", list.get(0));
		assertEquals("Banana", list.get(1));
		assertEquals("Pear", list.get(2));
		assertEquals(3, list.size());
		
		assertTrue(list.contains("Banana"));
		assertTrue(list.contains("Apple"));
		assertTrue(list.contains("Pear"));
		assertFalse(list.contains("somethingElse"));
		
	}

	/**
	 * Test method for SortedList.get
	 */
	@Test
	void testGet() {
		SortedList<String> list = new SortedList<>();
		list.add("Banana");
		list.add("Pear");
		list.add("Apple");
		
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
		assertEquals("Invalid index.", e1.getMessage());
		
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
		assertEquals("Invalid index.", e2.getMessage());
	}

}
