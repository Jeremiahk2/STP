/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Tests AbstractTestPlan class
 * @author Jeremiah Knizley
 *
 */
class AbstractTestPlanTest {

	/**
	 * Test method for AbstractTestPlan.hashCode
	 */
	@Test
	void testHashCode() {
		TestPlan plan1 = new TestPlan("ThisIsTheGreatestPlan");
		TestPlan plan2 = new TestPlan("ThisIsTheGreatestPlan");
		assertEquals(plan1.hashCode(), plan2.hashCode());
	}

	/**
	 * Test method for AbstractTestPlan.addTestCase
	 */
	@Test
	void testAddTestCase() {
		FailingTestList failures = new FailingTestList();
		assertThrows(IllegalArgumentException.class, () -> failures.addTestCase(null));
	}

	/**
	 * Test method for AbstractTestPlan.removeTestCase
	 */
	@Test
	void testRemoveTestCase() {
		TestPlan plan1 = new TestPlan("Plan");
		assertThrows(IndexOutOfBoundsException.class, () -> plan1.removeTestCase(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> plan1.removeTestCase(1));
	}

	/**
	 * Test method for AbstractTestPlan.getNumberOfFailingTests
	 */
	@Test
	void testGetNumberOfFailingTests() {
		TestPlan plan = new TestPlan("Plan");
		TestCase case1 = new TestCase("ID1", "Type1", "Description1", "Expected1");
		TestCase case2 = new TestCase("ID2", "Type2", "Description2", "Expected2");
		TestCase case3 = new TestCase("ID3", "Type3", "Description3", "Expected3");
		TestCase case4 = new TestCase("ID4", "Type4", "Description4", "Expected4");
		plan.addTestCase(case1);
		plan.addTestCase(case2);
		plan.addTestCase(case3);
		plan.addTestCase(case4);
		plan.addTestResult(0, false, "Failed");
		plan.addTestResult(1, false, "Failed");
		plan.addTestResult(2, false, "Failed");
		plan.addTestResult(3, false, "Failed");
		assertEquals(4, plan.getNumberOfFailingTests());
		plan.addTestResult(1, true, "Passes");
		plan.addTestResult(2, true, "Passes");
		assertEquals(2, plan.getNumberOfFailingTests());
	}

	/**
	 * Test method for AbstractTestPlan.addTestResult
	 */
	@Test
	void testAddTestResult() {
		TestPlan plan = new TestPlan("Plan");
		TestCase case1 = new TestCase("ID1", "Type1", "Description1", "Expected1");
		plan.addTestCase(case1);
		assertThrows(IndexOutOfBoundsException.class, () -> plan.addTestResult(-1, true, "Passes"));
		assertThrows(IndexOutOfBoundsException.class, () -> plan.addTestResult(1, true, "Passes"));
		assertThrows(IllegalArgumentException.class, () -> plan.addTestResult(0, true, null));
		assertThrows(IllegalArgumentException.class, () -> plan.addTestResult(0, true, ""));
	}

	/**
	 * Test method for AbstractTestPlan.getTestCase
	 */
	@Test
	void testGetTestCase() {
		TestPlan plan = new TestPlan("Plan");
		TestCase case1 = new TestCase("ID1", "Type1", "Description1", "Expected1");
		plan.addTestCase(case1);
		assertThrows(IndexOutOfBoundsException.class, () -> plan.getTestCase(-1));
		assertThrows(IndexOutOfBoundsException.class, () -> plan.getTestCase(1));
	}

	/**
	 * Test method for AbstractTestPlan.equals
	 */
	@Test
	void testEqualsObject() {
		TestPlan plan = new TestPlan("Plan");
		plan.addTestCase(new TestCase("ID1", "Type1", "Description1", "Expected1"));
		TestPlan plan1 = new TestPlan("AnotherPlan");
		TestPlan plan2 = new TestPlan("Plan");
		TestPlan badPlan = null;
		assertFalse(plan.equals(plan1));
		assertFalse(plan.equals(badPlan));
		assertTrue(plan.equals(plan));
		assertTrue(plan.equals(plan2));
		
	}

}
