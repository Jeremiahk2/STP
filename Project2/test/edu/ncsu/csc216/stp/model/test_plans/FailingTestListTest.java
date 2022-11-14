/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Tests FailingTestList class
 * @author Jeremiah Knizley
 *
 */
class FailingTestListTest {

	/**
	 * Test method for FailingTestList.addTestCase
	 */
	@Test
	void testAddTestCase() {
		FailingTestList plan = new FailingTestList();
		TestCase passingCase = new TestCase("ID", "Type", "Description", "Expected");
		passingCase.addTestResult(true, "Passes");
		TestCase failingCase = new TestCase("ID1", "Type1", "Description1", "Expected1");
		failingCase.addTestResult(false, "Fails");
		assertThrows(IllegalArgumentException.class, () -> plan.addTestCase(passingCase));
		assertDoesNotThrow(() -> plan.addTestCase(failingCase));
	}

	/**
	 * Test method for FailingTestList.getTestCasesAsArray
	 */
	@Test
	void testGetTestCasesAsArray() {
		FailingTestList plan = new FailingTestList();
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
		plan.getTestCase(0).setTestPlan(new TestPlan("Plan1"));
		plan.getTestCase(1).setTestPlan(new TestPlan("Plan2"));
		plan.getTestCase(2).setTestPlan(new TestPlan("Plan3"));
		plan.getTestCase(3).setTestPlan(new TestPlan("Plan4"));
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
				() -> assertEquals("Plan1", cases[0][2]),
				() -> assertEquals("Plan2", cases[1][2]),
				() -> assertEquals("Plan3", cases[2][2]),
				() -> assertEquals("Plan4", cases[3][2])
				);
		plan.clearTests();
		assertEquals(0, plan.getTestCases().size());
	}

	/**
	 * Test method for FailingTestList constructor
	 */
	@Test
	void testFailingTestList() {
		FailingTestList plan = new FailingTestList();
		assertEquals("Failing Tests", plan.getTestPlanName());
		assertThrows(IllegalArgumentException.class, () -> plan.setTestPlanName("NotProperName"));
	}

}
