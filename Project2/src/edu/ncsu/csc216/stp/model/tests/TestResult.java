/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

/**
 * Class that contains the information about the results of a single execution of a TestCase. Knows if is
 * passing or failing and has details about the actual results from execution.
 * @author Jeremiah Knizley
 * @author Ryan McPhee
 *
 */
public class TestResult {

	/** A string used for passing tests */
	public static final String PASS = "PASS";
	/** A string used for failing test */
	public static final String FAIL = "FAIL";
	/** a boolean representing whether or not the test is passing */
	private boolean passing;
	/** a string containing the actual results of the test */
	private String actualResults;
	
	/**
	 * Constructor for TestResult, sets passing and actualResults based on client parameters
	 * @param passing whether or not the test is passing.
	 * @param actualResults The actual results from running the test
	 * @throws IllegalArgumentException if actualResults is null or an empty string
	 */
	public TestResult(boolean passing, String actualResults) {
		setPassing(passing);
		setActualResults(actualResults);
	}
	
	/**
	 * Sets the actualResults parameter with the given string
	 * @param actualResults The actual results from running the test
	 * @throws IllegalArgumentException if actualResults is null or empty string
	 */
	private void setActualResults(String actualResults) {
		
		
		//When making the exception, it should have the message "Invalid test results."
	}

	/**
	 * returns the actualResults field
	 * @return actualResults the actual results from running the test
	 */
	public String getActualResults() {
		return null;
	}
	
	/**
	 * Sets the passing status of the test
	 * @param passing a boolean representing whether or not the test is passing.
	 */
	private void setPassing(boolean passing) {
		
	}
	
	/**
	 * Returns the field passing
	 * @return passing a boolean representing whether or not the test is passing.
	 */
	public boolean isPassing() {
		return false;
	}
	
	/**
	 * returns a string representation of the TestResult
	 * If the test is passing, it prints "PASS: " + actualResults. 
	 * If the test is failing, it prints "FAIL: " + actualResults.
	 * @return String the string representation of the TestResult
	 */
	@Override
	public String toString() {
		
		//Use public constants for PASS and FAIL
		return null;
	}
	
}
