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
		list.add("Mango");
		list.add("Orange");
		assertEquals("Mango", list.get(2));
		assertEquals("Orange", list.get(3));
		
		Exception e1 = assertThrows(NullPointerException.class, () -> list.add(null));
		assertEquals("Cannot add null element.", e1.getMessage());
		
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> list.add("Apple"));
		assertEquals("Invalid name.", e2.getMessage());
		
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
		list.add("Mango");
		list.add("Orange");
		//Genric tests for remove operations, checking contents each time.
		assertEquals("Banana", list.remove(1));
		assertEquals(4, list.size());
		assertEquals("Apple", list.get(0));
		assertEquals("Mango", list.get(1));
		assertEquals("Orange", list.get(2));
		assertEquals("Pear", list.get(3));
		assertEquals("Pear", list.remove(3));
		assertEquals("Apple", list.get(0));
		assertEquals("Mango", list.get(1));
		assertEquals("Orange", list.get(2));
		assertEquals(3, list.size());
		
		//invalid checks
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
		assertEquals("Invalid index.", e1.getMessage());
		
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
		assertEquals("Invalid index.", e2.getMessage());
		
		//Testing removing at several different indexes including 0, recreation of jenkins failing tests.
		SortedList<String> list2 = new SortedList<>();
		list2.add("banana");
		list2.add("apple");
		list2.add("orange");
		list2.add("eggplant");
		//order should be:
		//apple
		//banana
		//eggplant
		//orange
		assertEquals("banana", list2.remove(1));
		assertEquals(3, list2.size());
		assertEquals("apple", list2.get(0));
		assertEquals("eggplant", list2.get(1));
		assertEquals("orange", list2.get(2));
		//order should be:
		//apple
		//eggplant
		//orange
		assertEquals("orange", list2.remove(2));
		assertEquals(2, list2.size());
		assertEquals("apple", list2.get(0));
		assertEquals("eggplant", list2.get(1));
		//order should be:
		//apple
		//eggplant
		assertEquals("apple", list2.remove(0));
		assertEquals(1, list2.size());
		assertEquals("eggplant", list2.get(0));
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
