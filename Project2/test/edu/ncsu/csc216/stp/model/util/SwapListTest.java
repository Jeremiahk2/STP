/**
 * 
 */
package edu.ncsu.csc216.stp.model.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests SwapList class
 * @author Jeremiah Knizley
 *
 */
class SwapListTest {

	/**
	 * Test method for SwapList constructor
	 */
	@Test
	void testSwapList() {
		SwapList<String> list = new SwapList<>();
		assertEquals(0, list.size());
	}

	/**
	 * Test method for SwapList.add
	 */
	@Test
	void testAdd() {
		SwapList<String> list = new SwapList<>();
		list.add("Banana");
		list.add("Pear");
		assertEquals("Banana", list.get(0));
		assertEquals("Pear", list.get(1));
		list.add("Apple");
		list.add("Mango");
		list.add("Orange");
		
		assertEquals(5, list.size());
		
		assertEquals("Banana", list.get(0));
		assertEquals("Pear", list.get(1));
		assertEquals("Apple", list.get(2));
		assertEquals("Mango", list.get(3));
		assertEquals("Orange", list.get(4));
		
		Exception e1 = assertThrows(NullPointerException.class, () -> list.add(null));
		assertEquals("Cannot add null element.", e1.getMessage());
		
		//test adding past capacity
		list.add("Wolf");
		list.add("Dog");
		list.add("Animal");
		assertDoesNotThrow(() -> list.add("Blue"));
		assertDoesNotThrow(() -> list.add("Da"));
		assertDoesNotThrow(() -> list.add("Ba"));
	}

	/**
	 * Test method for SwapList.remove
	 */
	@Test
	void testRemove() {
		SwapList<String> list = new SwapList<>();
		list.add("Cherry");
		list.add("Pineapple");
		list.add("Words");
		list.add("Fists");
		list.add("Sandwich");
		
		//try removing from the beginning of the list
		assertEquals("Words", list.remove(2));
		
		assertEquals("Cherry", list.get(0));
		assertEquals("Pineapple", list.get(1));
		assertEquals("Fists", list.get(2));
		assertEquals("Sandwich", list.get(3));
		assertEquals(4, list.size());
		
		//try removing from the end of the list
		assertEquals("Sandwich", list.remove(3));
		
		assertEquals("Cherry", list.get(0));
		assertEquals("Pineapple", list.get(1));
		assertEquals("Fists", list.get(2));
		assertEquals(3, list.size());
		
		//try removing from the front of the list
		assertEquals("Cherry", list.remove(0));
		
		assertEquals("Pineapple", list.get(0));
		assertEquals("Fists", list.get(1));
		assertEquals(2, list.size());
		
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
		assertEquals("Invalid index.", e1.getMessage());
		
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> list.remove(2));
		assertEquals("Invalid index.", e2.getMessage());
		
		//test removing at capacity
		list.add("Grenn");
		list.add("Monopoly");
		list.add("Fourteen");
		list.add("Wow");
		list.add("Sell");
		list.add("Confidence");
		list.add("Trade");
		list.add("Money");
		
		assertDoesNotThrow(() -> list.remove(9));
	}

	/**
	 * Test method for SwapList.moveUp
	 */
	@Test
	void testMoveUp() {
		SwapList<String> list = new SwapList<>();
		list.add("Courtesy");
		list.add("Integrity");
		list.add("Perserverance");
		list.add("Azeroth");
		list.add("Draenor");
		
		//try moving up the front element
		list.moveUp(0);
		assertEquals("Courtesy", list.get(0));
		assertEquals("Integrity", list.get(1));
		assertEquals("Perserverance", list.get(2));
		assertEquals("Azeroth", list.get(3));
		assertEquals("Draenor", list.get(4));
		
		//try moving up a middle element
		list.moveUp(2);
		assertEquals("Courtesy", list.get(0));
		assertEquals("Perserverance", list.get(1));
		assertEquals("Integrity", list.get(2));
		assertEquals("Azeroth", list.get(3));
		assertEquals("Draenor", list.get(4));
		
		//try moving up back element
		list.moveUp(4);
		assertEquals("Courtesy", list.get(0));
		assertEquals("Perserverance", list.get(1));
		assertEquals("Integrity", list.get(2));
		assertEquals("Draenor", list.get(3));
		assertEquals("Azeroth", list.get(4));
		
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> list.moveUp(-1));
		assertEquals("Invalid index.", e1.getMessage());
		
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> list.moveUp(5));
		assertEquals("Invalid index.", e2.getMessage());

	}

	/**
	 * Test method for SwapList.moveDown
	 */
	@Test
	void testMoveDown() {
		SwapList<String> list = new SwapList<>();
		list.add("Courtesy");
		list.add("Integrity");
		list.add("Perserverance");
		list.add("Azeroth");
		list.add("Draenor");
		
		//try moving down the back element
		list.moveDown(4);
		assertEquals("Courtesy", list.get(0));
		assertEquals("Integrity", list.get(1));
		assertEquals("Perserverance", list.get(2));
		assertEquals("Azeroth", list.get(3));
		assertEquals("Draenor", list.get(4));
		
		//try moving down a middle element
		list.moveDown(2);
		assertEquals("Courtesy", list.get(0));
		assertEquals("Integrity", list.get(1));
		assertEquals("Azeroth", list.get(2));
		assertEquals("Perserverance", list.get(3));
		assertEquals("Draenor", list.get(4));
		
		//try moving down front element
		list.moveDown(0);
		assertEquals("Integrity", list.get(0));
		assertEquals("Courtesy", list.get(1));
		assertEquals("Azeroth", list.get(2));
		assertEquals("Perserverance", list.get(3));
		assertEquals("Draenor", list.get(4));
		
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> list.moveDown(-1));
		assertEquals("Invalid index.", e1.getMessage());
		
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> list.moveDown(5));
		assertEquals("Invalid index.", e2.getMessage());
	}

	/**
	 * Test method for SwapList.moveToFront
	 */
	@Test
	void testMoveToFront() {
		SwapList<String> list = new SwapList<>();
		list.add("Alexstrasza");
		list.add("Ysera");
		list.add("Tyrande");
		list.add("Anduin");
		list.add("Varian");
		
		//try moving front element to front
		list.moveToFront(0);
		
		assertEquals("Alexstrasza", list.get(0));
		assertEquals("Ysera", list.get(1));
		assertEquals("Tyrande", list.get(2));
		assertEquals("Anduin", list.get(3));
		assertEquals("Varian", list.get(4));
		assertEquals(5, list.size());
		
		//try moving middle element to front
		list.moveToFront(2);
		assertEquals("Tyrande", list.get(0));
		assertEquals("Ysera", list.get(1));
		assertEquals("Alexstrasza", list.get(2));
		assertEquals("Anduin", list.get(3));
		assertEquals("Varian", list.get(4));
		assertEquals(5, list.size());
		
		//try moving back element to front
		list.moveToFront(4);
		assertEquals("Varian", list.get(0));
		assertEquals("Ysera", list.get(1));
		assertEquals("Alexstrasza", list.get(2));
		assertEquals("Anduin", list.get(3));
		assertEquals("Tyrande", list.get(4));
		assertEquals(5, list.size());
		
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> list.moveToFront(-1));
		assertEquals("Invalid index.", e1.getMessage());
		
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> list.moveToFront(5));
		assertEquals("Invalid index.", e2.getMessage());
	}

	/**
	 * Test method for SwapList.moveToBack
	 */
	@Test
	void testMoveToBack() {
		SwapList<String> list = new SwapList<>();
		list.add("Thirain");
		list.add("Wei");
		list.add("Ealyn");
		list.add("Inanna");
		list.add("Nia");
		
		//try moving back element to back
		list.moveToBack(4);
		assertEquals("Thirain", list.get(0));
		assertEquals("Wei", list.get(1));
		assertEquals("Ealyn", list.get(2));
		assertEquals("Inanna", list.get(3));
		assertEquals("Nia", list.get(4));
		assertEquals(5, list.size());
		
		//try moving middle element to back
		list.moveToBack(2);
		assertEquals("Thirain", list.get(0));
		assertEquals("Wei", list.get(1));
		assertEquals("Nia", list.get(2));
		assertEquals("Inanna", list.get(3));
		assertEquals("Ealyn", list.get(4));
		assertEquals(5, list.size());
		
		//try moving front element to back
		list.moveToBack(0);
		assertEquals("Ealyn", list.get(0));
		assertEquals("Wei", list.get(1));
		assertEquals("Nia", list.get(2));
		assertEquals("Inanna", list.get(3));
		assertEquals("Thirain", list.get(4));
		assertEquals(5, list.size());
		
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> list.moveToBack(-1));
		assertEquals("Invalid index.", e1.getMessage());
		
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> list.moveToBack(5));
		assertEquals("Invalid index.", e2.getMessage());
	}

	/**
	 * Test method for SwapList.get
	 */
	@Test
	void testGet() {
		SwapList<String> list = new SwapList<>();
		list.add("Yogg");
		list.add("Nzoth");
		list.add("Stormrage");
		list.add("Firekeeper");
		list.add("Blacksmith");
		Exception e1 = assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
		assertEquals("Invalid index.", e1.getMessage());
		
		Exception e2 = assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
		assertEquals("Invalid index.", e2.getMessage());
	}

}
