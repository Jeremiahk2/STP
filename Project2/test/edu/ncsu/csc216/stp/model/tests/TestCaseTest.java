/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;

/**
 * Tests TestCase class
 * @author Jeremiah Knizley
 *
 */
class TestCaseTest {

	/**
	 * Test method for TestCase constructor and setters
	 */
	@Test
	void testTestCase() {
		//test valid constructor
		TestCase case1 = new TestCase("TestCaseId", "TestType", "TestDescription", "ExpectedResults");
		assertEquals(null, case1.getTestPlan());
		assertEquals("TestCaseId", case1.getTestCaseId());
		assertEquals("TestType", case1.getTestType());
		assertEquals("TestDescription", case1.getTestDescription());
		assertEquals("ExpectedResults", case1.getExpectedResults());
		
		assertThrows(IllegalArgumentException.class, () -> new TestCase(null, "TestType", "TestDescription", "ExpectedResults"));
		assertThrows(IllegalArgumentException.class, () -> new TestCase("", "TestType", "TestDescription", "ExpectedResults"));
		assertThrows(IllegalArgumentException.class, () -> new TestCase("TestCaseId", null, "TestDescription", "ExpectedResults"));
		assertThrows(IllegalArgumentException.class, () -> new TestCase("TestCaseId", "", "TestDescription", "ExpectedResults"));
		assertThrows(IllegalArgumentException.class, () -> new TestCase("TestCaseId", "TestType", null, "ExpectedResults"));
		assertThrows(IllegalArgumentException.class, () -> new TestCase("TestCaseId", "TestType", "", "ExpectedResults"));
		assertThrows(IllegalArgumentException.class, () -> new TestCase("TestCaseId", "TestType", "TestDescription", null));
		assertThrows(IllegalArgumentException.class, () -> new TestCase("TestCaseId", "TestType", "TestDescription", ""));
	}
	

	

	/**
	 * Test method for TestCase.addTestResult
	 */
	@Test
	void testAddTestResult() {
		TestCase case1 = new TestCase("TestCaseId", "TestType", "TestDescription", "ExpectedResults");
		assertDoesNotThrow(() -> case1.addTestResult(true, "ActualResult"));
		
		assertEquals("- PASS: ActualResult", case1.getActualResultsLog());
		
		assertDoesNotThrow(() -> case1.addTestResult(false, "BananaResults"));
		
		assertEquals("- PASS: ActualResult\n- FAIL: BananaResults", case1.getActualResultsLog());
		
		assertThrows(IllegalArgumentException.class, () -> case1.addTestResult(false, null));
		
		assertThrows(IllegalArgumentException.class, () -> case1.addTestResult(false, ""));
		
		assertEquals(TestResult.FAIL, case1.getStatus());
		
		assertDoesNotThrow(() -> case1.addTestResult(true, "GoodResults"));
		
		assertEquals(TestResult.PASS, case1.getStatus());
	}

//	/**
//	 * Test method for TestCase.getStatus
//	 */
//	@Test
//	void testGetStatus() {
//		fail("Not yet implemented");
//	}

//	/**
//	 * Test method for TestCase.getActualResultsLog
//	 */
//	@Test
//	void testGetActualResultsLog() {
//		fail("Not yet implemented");
//	}

	/**
	 * Test method for TestCase.isTestCasePassing
	 */
	@Test
	void testIsTestCasePassing() {
		TestCase case1 = new TestCase("TestCaseId", "TestType", "TestDescription", "ExpectedResults");
		assertFalse(case1.isTestCasePassing());
	}

	/**
	 * Test method for TestCase.setTestPlan
	 */
	@Test
	void testSetTestPlan() {
		TestCase case1 = new TestCase("TestCaseId", "TestType", "TestDescription", "ExpectedResults");
		
		assertThrows(IllegalArgumentException.class, () -> case1.setTestPlan(null));
		TestPlan plan = new TestPlan("Good Test Plan");
		TestPlan badPlan = new TestPlan("Failing Test Plan");
		assertDoesNotThrow(() -> case1.setTestPlan(plan));
		
		assertEquals(plan, case1.getTestPlan());
		
		assertDoesNotThrow(() -> case1.setTestPlan(badPlan));
		
		assertEquals(badPlan, case1.getTestPlan());
		
	}
//	/**
//	 * Test method for TestCase.toString
//	 */
//	@Test
//	void testToString() {
//		//Should be covered by TestPlanWriter
//		//TODO: Verify
//		fail("Not yet implemented");
//		
//	}

}
