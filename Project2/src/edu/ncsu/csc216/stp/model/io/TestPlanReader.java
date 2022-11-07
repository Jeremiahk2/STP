/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;
import java.io.File;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * Processes a file containing test plans with zero to many test cases each with zero to many results
 * @author mcphe
 *
 */
public class TestPlanReader {

	/**
	 * Receives a File with the file to read from. If the file cannot be loaded, an IllegalArgumentException 
	 * is thrown
	 * @param file file to read TestPlan data from
	 * @return SortedList of TestPlans from the 
	 */
	public static ISortedList<TestPlan> readTestPlansFile(File file) {
		
		return null;
	}
	
	/**
	 * Helper method to process the individual TestPlans from the given file
	 * @param testPlan String containing the whole TestPlan as read by the readTestPlansFile method
	 * @return TestPlan recorded within the given String
	 */
	private TestPlan processTestPlan(String testPlan) {
		
		return null;
	}
	
	/**
	 * Helper method to process the individual TestCases from the given TestPlan
	 * @param plan the TestPlan containing the given TestCase that is being read
	 * @param caseString String containing the whole TestCase as read by the processTestPlan method
	 * @return TestCase recorded within the given String
	 */
	private TestCase processTest(AbstractTestPlan plan, String caseString) {
		
		return null;
	}
}
