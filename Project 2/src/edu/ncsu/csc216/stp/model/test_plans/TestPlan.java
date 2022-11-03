/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * @author Ryan McPhee
 *
 */
public class TestPlan extends AbstractTestPlan implements Comparable {

	public TestPlan(String testPlanName) {
		super(testPlanName);
	}
	
	public String[][] getTestCasesAsArray() {
		return null;
	}
	
	public void addTestCase(TestCase t) {
		
	}
	
	public int compareTo(TestCase t) {
		return -1;
	}
	
}
