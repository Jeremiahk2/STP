/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tests TestResult class
 * @author Jeremiah Knizley
 *
 */
class TestResultTest {

	/**
	 * Test method for TestResult constructor
	 */
	@Test
	void testTestResult() {
		TestResult result = new TestResult(false, "ActualResults");
		assertEquals(false, result.isPassing());
		assertEquals("ActualResults", result.getActualResults());
		
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> new TestResult(false, null));
		assertEquals("Invalid test results.", e1.getMessage());
		
		Exception e2 = assertThrows(IllegalArgumentException.class, () -> new TestResult(true, ""));
		assertEquals("Invalid test results.", e2.getMessage());
	}

	/**
	 * Test method for TestResult.toString
	 */
	@Test
	void testToString() {
		TestResult result1 = new TestResult(false, "ActualResults");
		TestResult result2 = new TestResult(true, "TrueResults");
		
		assertEquals("FAIL: ActualResults", result1.toString());
		assertEquals("PASS: TrueResults", result2.toString());
	}

}
