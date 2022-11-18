/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Tests TestPlan class
 * @author Jeremiah Knizley
 *
 */
class TestPlanTest {

	/**
	 * Test method for TestPlan.addTestCase
	 */
	@Test
	void testAddTestCase() {
		TestPlan plan = new TestPlan("Plan");
		assertThrows(NullPointerException.class, () -> plan.addTestCase(null));
		assertDoesNotThrow(() -> plan.addTestCase(new TestCase("ID1", "Type1", "Description1", "Expected1")));
		assertEquals(plan, plan.getTestCase(0).getTestPlan());
	}

	/**
	 * Test method for TestPlan.getTestCasesAsArray
	 */
	@Test
	void testGetTestCasesAsArray() {
		TestPlan plan = new TestPlan("Plan");
		plan.addTestCase(new TestCase("ID1", "Type1", "Description1", "Expected1"));
		plan.addTestCase(new TestCase("ID2", "Type2", "Description2", "Expected2"));
		plan.addTestCase(new TestCase("ID3", "Type3", "Description3", "Expected3"));
		plan.addTestCase(new TestCase("ID4", "Type4", "Description4", "Expected4"));
		plan.getTestCase(1).addTestResult(true, "Passed");
		plan.getTestCase(2).addTestResult(true, "Passed");
		assertDoesNotThrow(() -> plan.getTestCasesAsArray());
		String[][] cases = plan.getTestCasesAsArray();
		assertEquals(4, cases.length);
		
		assertAll("Verifies correct test case array",
				() -> assertEquals("ID1", cases[0][0]),
				() -> assertEquals("ID2", cases[1][0]),
				() -> assertEquals("ID3", cases[2][0]),
				() -> assertEquals("ID4", cases[3][0]),
				() -> assertEquals("Type1", cases[0][1]),
				() -> assertEquals("Type2", cases[1][1]),
				() -> assertEquals("Type3", cases[2][1]),
				() -> assertEquals("Type4", cases[3][1]),
				() -> assertEquals("FAIL", cases[0][2]),
				() -> assertEquals("PASS", cases[1][2]),
				() -> assertEquals("PASS", cases[2][2]),
				() -> assertEquals("FAIL", cases[3][2]),
				() -> assertEquals(4, cases.length)
				);
	}

	/**
	 * Test method for TestPlan constructor
	 */
	@Test
	void testTestPlan() {
		TestPlan plan = new TestPlan("Plan");
		assertEquals("Plan", plan.getTestPlanName());
		assertEquals(0, plan.getTestCases().size());
		
		assertThrows(IllegalArgumentException.class, () -> new TestPlan(""));
		assertThrows(IllegalArgumentException.class, () -> new TestPlan(null));
	}

	/**
	 * Test method for TestPlan.compareTo
	 */
	@Test
	void testCompareTo() {
		TestPlan apple = new TestPlan("apple");
		TestPlan astaroth = new TestPlan("astaroth");
		TestPlan cerce = new TestPlan("cerce");
		TestPlan kilik = new TestPlan("Kilik");
		TestPlan maxi = new TestPlan("Maxi");
		TestPlan abbott = new TestPlan("Abbott");
		TestPlan cerce1 = new TestPlan("cerce");
		TestPlan longAbbott = new TestPlan("Abbotter");
		
		
		assertTrue(apple.compareTo(abbott) > 0);
		assertTrue(apple.compareTo(cerce) < 0);
		assertTrue(apple.compareTo(kilik) < 0);
		assertTrue(apple.compareTo(maxi) < 0);
		assertTrue(apple.compareTo(astaroth) < 0);
		
		assertTrue(astaroth.compareTo(apple) > 0);
		assertTrue(astaroth.compareTo(cerce) < 0);
		assertTrue(astaroth.compareTo(kilik) < 0);
		assertTrue(astaroth.compareTo(maxi) < 0);
		assertTrue(astaroth.compareTo(abbott) > 0);
		
		assertTrue(cerce.compareTo(kilik) < 0);
		assertTrue(cerce.compareTo(apple) > 0);
		assertTrue(cerce.compareTo(astaroth) > 0);
		assertTrue(cerce.compareTo(maxi) < 0);
		assertTrue(cerce.compareTo(abbott) > 0);
		
		assertEquals(0, cerce.compareTo(cerce));
		assertEquals(0, cerce.compareTo(cerce1));
		assertEquals(0, cerce1.compareTo(cerce));
		
		assertTrue(abbott.compareTo(longAbbott) < 0);
		assertTrue(longAbbott.compareTo(abbott) > 0);
		
	}

}
