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
		String[][] testCaseArray = new String[getTestCases().size()][3];
		
		for (int i = 0; i < testCaseArray.length; i++) {
			testCaseArray[i][0] = getTestCases().get(i).getTestCaseId();
			testCaseArray[i][1] = getTestCases().get(i).getTestType();
			testCaseArray[i][2] = getTestCases().get(i).getStatus();
		}
		
		return testCaseArray;
	}
	
	/**
	 * Overrides addTestCase from AbstractTestPlan.
	 * Adds the test case via a call to super class (AbstractTestPlan), but sets the TestCase's TestPlan to this test plan (explicitly using this keyword).
	 * @param t the test case to be added to the list
	 * @throws NullPointerException if t is null
	 * @throws IllegalArgumentException if t cannot be added
	 */
	@Override
	public void addTestCase(TestCase t) {
		if (t == null) {
			throw new NullPointerException("Null TestCase.");
		}
		super.addTestCase(t);
		t.setTestPlan(this);
		//getTestCases().add(t);
	}

	/**
	 * Compares the names of two TestPlans, the comparison is case insensitive.
	 * @param s the TestPlan to be compared to
	 * @return int depending on the comparison. If this TestPlan is less than (Alphabetically) then TestPlan s, a -1 is returned. If they are equal, 0. If this TestPlan is greater, a 1 is returned.
	 */
	@Override
	public int compareTo(TestPlan s) {
		String name = s.getTestPlanName().toLowerCase();
		String thisName = getTestPlanName().toLowerCase();
		char[] nameCharacters = name.toCharArray();
		char[] thisCharacters = thisName.toCharArray();
		int commonLength = Math.min(thisCharacters.length, nameCharacters.length);
		int comparison = 0;
		for (int i = 0; i < commonLength; i++) {
			if (Character.getNumericValue(nameCharacters[i]) > Character.getNumericValue(thisCharacters[i])) {
				comparison = -1;
				break;
			}
			else if (Character.getNumericValue(nameCharacters[i]) < Character.getNumericValue(thisCharacters[i])) {
				comparison = 1;
				break;
			}
		}
		if (comparison == 0 && nameCharacters.length > thisCharacters.length) {
			comparison = -1;
		}
		else if (comparison == 0 && nameCharacters.length < thisCharacters.length) {
			comparison = 1;
		}
		return comparison;
	}
	
	
}
