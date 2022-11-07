/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import java.util.Objects;

import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISwapList;

/**
 * Abstract class for different kinds of TestPlans.
 * Main functionality is in managing it's list of TestCases, as well as providing access
 * to the TestCase's methods. Maintains a name for comparison to other classes that extend this one.
 * @author Jeremiah Knizley
 * @author Ryan McPhee
 *
 */
public abstract class AbstractTestPlan {
	
	/** the name of the test plan */
	private String testPlanName;
	/** the SwapList of testCases in the TestPlan */
	private ISwapList<TestCase> testCases;
	
	
	/**
	 * Constructor for AbstractTestPlan, sets testPlanName field to parameter.
	 * Constructs testCases as an empty list.
	 * @param testPlanName the name of the test plan
	 * @throws IllegalArgumentException if testPlanName is null or an empty string
	 */
	public AbstractTestPlan(String testPlanName) {
		
	}
	
	/**
	 * sets the test plan name, musn't be null or an empty string.
	 * @param testPlanName the name of the test plan.
	 * @throws IllegalArgumentException if testPlanName is null or an empty string
	 */
	public void setTestPlanName(String testPlanName) {
		
		//IAE should have the message "Invalid name."
	}
	
	/**
	 * Returns the name of the TestPlan
	 * @return name of the TestPlan
	 */
	public String getTestPlanName() {
		return null;
	}
	
	/**
	 * adds the given TestCase to the end of the list. May throw exceptions from TestCase constructor
	 * @param t the test case to be added to the plan.
	 * @throws NullPointerException if t is null
	 * @throws IllegalArgumentException if t cannot be added
	 */
	public void addTestCase(TestCase t) {
		
	}
	
	/**
	 * removes the TestCase from the list of test cases at the specified index. The removed TestCase is returned
	 * @param idx the index at which to remove from the testCases list.
	 * @return TestCase the test case that was removed from the list
	 * @throws IndexOutOfBoundsException if idx is out of bounds
	 */
	public TestCase removeTestCase(int idx) {
		return null;
	}

	/**
	 * returns the number of failing tests in the test plan
	 * @return the number of failing tests in the test plan.
	 */
	public int getNumberOfFailingTests() {
		return -1;
	}
	
	/**
	 * Adds a new TestResult to the log of the testCase at the given idx in the testCases list.
	 * @param idx the index in the list at which the TestResult will be added to
	 * @param passing a boolean representing whether or not the TestResult is passing
	 * @param actualResult the actualResults of the testResult
	 * @throws IllegalArgumentException if actualResult is null or an empty string
	 * @throws NullPointerException if the element to add is null
	 * @throws IndexOutOfBoundsException if idx is not in bounds
	 */
	public void addTestResult(int idx, boolean passing, String actualResult) {
		
	}
	
	/**
	 * Returns a 2D String array representing the TestCases in the testCases list
	 * @return a 2D String array representing the TestCases in the testCases list
	 */
	public abstract String[][] getTestCasesAsArray();

	/**
	 * Returns the TestCase at the given index
	 * @param idx index of the desired TestCase to be retrieved
	 * @return TestCase at the given index
	 * @throws IndexOutOfBoundsException if index is out of bounds
	 */
	public TestCase getTestCase(int idx) {
		return null;
	}
	
	/**
	 * Returns SwapList of TestCases within a TestPlan
	 * @return SwapList of TestCases within a TestPlan
	 */
	public ISwapList<TestCase> getTestCases() {
		
		return null;
	}
	/**
	 * default override of Object.hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(testPlanName);
	}
	/**
	 * Overrides equals to make it compare testPlanName only.
	 * testPlanNames are compared case-sensitively.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractTestPlan other = (AbstractTestPlan) obj;
		return Objects.equals(testPlanName, other.testPlanName);
	}
	
	
	
 }

