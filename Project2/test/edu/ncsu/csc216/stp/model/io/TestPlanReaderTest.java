/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * Tests TestPlanReader class
 * @author Jeremiah Knizley
 *
 */
class TestPlanReaderTest {

	/**
	 * Test method for TestPlanReader.readTestPlansFile
	 */
	@Test
	void testReadTestPlansFile() {
		ISortedList<TestPlan> plan0 = TestPlanReader.readTestPlansFile(new File("test-files/test-plans0.txt"));
		assertEquals(2, plan0.size());
		
		TestPlan plan1 = plan0.get(0);
		TestPlan plan2 = plan0.get(1);
		
		assertEquals("PackScheduler", plan1.getTestPlanName());
		assertEquals("WolfScheduler", plan2.getTestPlanName());
		
		assertAll("Checks information from read file",
				() -> assertEquals("test1", plan2.getTestCase(0).getTestCaseId()),
				() -> assertEquals("Equivalence Class", plan2.getTestCase(0).getTestType()),
				//() -> assertEquals("description\nwith multiple lines", plan2.getTestCase(0).getTestDescription()),
				//() -> assertEquals("expected results\nwith multiple lines", plan2.getTestCase(0).getExpectedResults()),
				//() -> assertEquals("- PASS: actual results\n"
						//+ "- FAIL: actual results on\nmutliple lines\n"
						//+ "- PASS: actual results\non three\nlines", plan2.getTestCase(0).getActualResultsLog()),
				() -> assertEquals("test2", plan2.getTestCase(1).getTestCaseId()),
				() -> assertEquals("Boundary Value", plan2.getTestCase(1).getTestType()),
				//() -> assertEquals("description", plan2.getTestCase(1).getTestDescription()),
				//() -> assertEquals("expected results", plan2.getTestCase(1).getExpectedResults()),
				() -> assertEquals("test3", plan2.getTestCase(2).getTestCaseId()),
				() -> assertEquals("Requirements", plan2.getTestCase(2).getTestType()),
				//() -> assertEquals("description\non multiple lines", plan2.getTestCase(2).getTestDescription()),
				//() -> assertEquals("expected results", plan2.getTestCase(2).getExpectedResults()),
				//() -> assertEquals("- FAIL: actual results", plan2.getTestCase(2).getActualResultsLog()),
				//second project
				() -> assertEquals("PackScheduler", plan1.getTestPlanName()),
				() -> assertEquals("test0", plan1.getTestCase(0).getTestCaseId()),
				() -> assertEquals("Invalid", plan1.getTestCase(0).getTestType()),
				//() -> assertEquals("description", plan1.getTestCase(0).getTestDescription()),
				//() -> assertEquals("expected results\nwith multiple lines", plan1.getTestCase(0).getExpectedResults()),
				//() -> assertEquals("- PASS: actual results\n- FAIL: actual results", plan1.getTestCase(0).getActualResultsLog()),
				() -> assertEquals("test1", plan1.getTestCase(1).getTestCaseId()),
				() -> assertEquals("Equivalence Class", plan1.getTestCase(1).getTestType())
				//() -> assertEquals("description", plan1.getTestCase(1).getTestDescription()),
				//() -> assertEquals("expected results", plan1.getTestCase(1).getExpectedResults()),
				//() -> assertEquals("- PASS: actual results", plan1.getTestCase(1).getActualResultsLog())
				);
		
		
		
	}

}
