package edu.ncsu.csc216.stp.model.test_plans;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Extends AbstractTestPlan and holds the failing test cases for all projects currently available 
 * in the system
 * @author Ryan McPhee
 * @author Jeremiah Knizley
 */
public class FailingTestList extends AbstractTestPlan {

	/** Constant for the name of the FailingTestList name */
	public static final String FAILING_TEST_LIST_NAME = "Failing Tests";
	
	/**
	 * Constructor for FailingTestList, sets the name as FAILING_TEST_LIST_NAME
	 */
	public FailingTestList() {
		super(FAILING_TEST_LIST_NAME);
	}
	
	/**
	 * Adds a TestCase to the FailingTestList
	 * 
	 * @param t TestCase to be added to the list
	 * @throws IllegalArgumentException if the TestCase is null or if the TestCase to be added is passing
	 */
	@Override
	public void addTestCase(TestCase t) {
		if (t == null ) {
			throw new IllegalArgumentException("Invalid element.");
		}
		if (t.isTestCasePassing()) {
			throw new IllegalArgumentException("Cannot add passing test case.");
		}
		super.addTestCase(t);
	}
	
	/**
	 * Sets the TestPlan name to the parameter
	 * 
	 * @param testPlanName name of the TestPlan
	 * @throws IllegalArgumentException if testPlanName is not the same as FAILING_TEST_LIST_NAME (Case insensitive)
	 */
	@Override
	public void setTestPlanName(String testPlanName) {
		if (!FAILING_TEST_LIST_NAME.equalsIgnoreCase(testPlanName)) {
			throw new IllegalArgumentException("The Failing Tests list cannot be edited.");
		}
		super.setTestPlanName(testPlanName);
	}
	
	/**
	 * Returns a two dimensional String array of the TestCases within the FailingTestList. First column
	 * contains the test case id, the second column is the test type, and the third column is the test plan
	 * name associated with the TestCase
	 * 
	 * @return 2D String array containing the TestCase's id, type, and associated TestPlan name
	 */
	public String[][] getTestCasesAsArray() {
		String[][] testCaseArray = new String[getTestCases().size()][3];
		
		for (int i = 0; i < testCaseArray.length; i++) {
			testCaseArray[i][0] = getTestCases().get(i).getTestCaseId();
			testCaseArray[i][1] = getTestCases().get(i).getTestType();
			if (getTestCases().get(i).getTestPlan() == null) {
				testCaseArray[i][2] = "";
			}
			else {
				testCaseArray[i][2] = getTestCases().get(i).getTestPlan().getTestPlanName();
			}
		}
		
		return testCaseArray;
	}
	
	/**
	 * Clears the tests within the FailingTestList
	 */
	public void clearTests() {
		int size = getTestCases().size();
		for (int i = 0; i < size; i++) {
			removeTestCase(0);
		}
	}
}
