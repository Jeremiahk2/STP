/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests TestCase class
 * @author Jeremiah Knizley
 *
 */
class TestCaseTest {

	/**
	 * Test method for TestCase constructor
	 */
	@Test
	void testTestCase() {
		//test valid constructor
		TestCase case1 = new TestCase("TestCaseId", "TestType", "TestDescription", "ExpectedResults");
		assertEquals(null, case1.getTestPlan());
		assertEquals("TestCaseId", case1.getTestCaseId());
		assertEquals("TestType", case1.getTestType());
		assertEquals("TestDescription", case1.getTestType());
		assertEquals("ExpectedResults", case1.getExpectedResults());
	}
	

	/**
	 * Test method for TestCase.getTestCaseId
	 */
	@Test
	void testGetTestCaseId() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for TestCase.getTestType
	 */
	@Test
	void testGetTestType() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for TestCase.getTestDescription
	 */
	@Test
	void testGetTestDescription() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for TestCase.getExpectedResults
	 */
	@Test
	void testGetExpectedResults() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for TestCase.addTestResult
	 */
	@Test
	void testAddTestResult() {
		TestCase case1 = new TestCase("TestCaseId", "TestType", "TestDescription", "ExpectedResults");
		assertDoesNotThrow(() -> case1.addTestResult(true, "ActualResult"));
		
		
	}

	/**
	 * Test method for TestCase.getStatus
	 */
	@Test
	void testGetStatus() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for TestCase.getActualResultsLog
	 */
	@Test
	void testGetActualResultsLog() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for TestCase.isTestCasePassing
	 */
	@Test
	void testIsTestCasePassing() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for TestCase.setTestPlan
	 */
	@Test
	void testSetTestPlan() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for TestCase.getTestPlan
	 */
	@Test
	void testGetTestPlan() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for TestCase.toString
	 */
	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
