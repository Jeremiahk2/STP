/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * The TestPlan class manages a list of TestCases, adding them, returning them, and comparing them.
 * It also extends AbstractTestPlan and so inherits its functionality.
 * @author Jeremiah Knizley
 * @author Ryan McPhee
 *
 */
public class TestPlan extends AbstractTestPlan implements Comparable<TestPlan> {

	/**
	 * Constructor for TestPlan. Creates a TestPlan with the given name using the superclass.
	 * @param testPlanName the name of the test plan
	 * @throws IllegalArgumentException if testPlanName is the same as FailingListTest.FAILING_TEST_LIST_NAME.
	 */
	public TestPlan(String testPlanName) {
		
		//IAE should have the message "Invalid name."
		super(testPlanName);
	}
	
	/**
	 * returns a 2D string array where the first column is the test case ID, the second column is the test type, and the third column is the status. 
	 * Rows, therefore are the TestCases in the list of testCases in the TestPlan
	 * @return String[][] a 2D array representing the TestPlan's test cases
	 */
	public String[][] getTestCasesAsArray() {
		return null;
	}
	
	/**
	 * Overrides addTestCase from AbstractTestPlan.
	 * Adds the test case via a call to super class (AbstractTestPlan), but sets the TestCase's TestPlan to this test plan (explicitly using this keyword).
	 */
	@Override
	public void addTestCase(TestCase t) {
		
	}

	/**
	 * Compares the names of two TestPlans, the comparison is case sensitive.
	 * @param s the TestPlan to be compared to
	 * @return int depending on the comparison. If this TestPlan is less than (Alphabetically) then TestPlan s, a -1 is returned. If they are equal, 0. If this TestPlan is greater, a 1 is returned.
	 */
	@Override
	public int compareTo(TestPlan s) {
		return 0;
	}
	
	
}
