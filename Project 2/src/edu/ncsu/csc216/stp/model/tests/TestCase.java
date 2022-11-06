/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.ILog;

/**
 * Class that contains the information about each individual test case including the testCaseId,
 * testType, testDescription, expectedResults, and Ilog of TestResults
 * @author Ryan McPhee
 *
 */
public class TestCase {

	
	/** testCaseId for the TestCase */
	private String testCaseId;
	/** testType for the TestCase */
	private String testType;
	/** testDescription for the TestCase */
	private String testDescription;
	/** exceptedResults for the TestCase */
	private String expectedResults;
	/** testPlan for the TestCase */
	private TestPlan testPlan;
	/** a log of testResults for this test case */
	private ILog<TestResult> testResults;
	
	/**
	 * Constructs a testCase, setting each parameter as its appropriate field. 
	 * testResults is constructed as an empty log, testPlan is set to null.
	 * Uses appropriate setters to set parameterized fields.
	 * @param testCaseId  the ID of the test case
	 * @param testType the type of test case
	 * @param testDescription the description of the test case
	 * @param expectedResults the expected results of the test case
	 */
	public TestCase(String testCaseId, String testType, String testDescription, String expectedResults) {
		setTestCaseId(testCaseId);
		setTestType(testType);
		setTestDescription(testDescription);
		setExpectedResults(expectedResults);
		//Still need to do construction of testResults and set testPlan to null
	}
	
	/**
	 * returns the testCaseID
	 * @return the testCaseID
	 */
	public String getTestCaseId() {
		return testCaseId;
	}
	
	/**
	 * sets the testCaseID, cannot be null or empty string
	 * @param testCaseId the testCaseID to be set
	 * @throws IllegalArgumentException if testCaseID is null or empty string
	 */
	private void setTestCaseId(String testCaseId) {
		
	}
	
	/**
	 * returns the testType
	 * @return the testType
	 */
	public String getTestType() {
		return testType;
	}
	
	/**
	 * sets the test type, musn't be null or an empty string
	 * @param testType the type of test to be set
	 * @throws IllegalArgumentEcception if testType is null or an empty string
	 */
	private void setTestType(String testType) {
		
	}
	
	/**
	 * returns the test's description
	 * @return testDescription the description of the test case
	 */
	public String getTestDescription() {
		return testDescription;
	}
	
	/**
	 * sets the testDescription, musn't be null or an empty string
	 * @param testDescription the description of the test case
	 * @throws IllegalArgumentException if testDescription is null or an empty string
	 */
	private void setTestDescription(String testDescription) {
		
	}
	
	/**
	 * returns the expectedResults
	 * @return the expectedResults
	 */
	public String getExcpetedResults() {
		return expectedResults;
	}
	
	/**
	 * sets the expectedResults, musn't be null or an empty string
	 * @param expectedResults the expected results of the test case
	 * @throws IllegalArgumentException if expectedResults is null or an empty string
	 */
 	private void setExpectedResults(String expectedResults) {
 		
 	}
 	
 	/**
 	 * creates a TestResult from the parameters and adds it to the testResults Log.
 	 * @param passing the status of the TestResult when it is created
 	 * @param actualResults the actual results of the TestResult
 	 * @throws IllegalArgumentException if the TestResult cannot be constructed
 	 */
 	public void addTestResult(boolean passing, String actualResults) {
 		
 	}
 	
 	/**
 	 * returns the status of the testCase ass "PASS" or "FAIL", depending on the passing field
 	 * @return String depending on the passing field.
 	 */
 	public String getStatus() {
 		
 		//Be sure to use constants from TestResult for PASS and FAIL
 		return null;
 	}
 	
 	/**
 	 * Returns a string representation of the testResults log. 
 	 * Format is as follows: A "-" character followed by a space, then the TestResult.toString() method, followed by a new line.
 	 * This pattern continues for every result in the log.
 	 * @return String actualResults Log as a string
 	 */
 	public String getActualResultsLog() {
 		return null;
 	}
 	
 	/**
 	 * Returns true if the last TestResult in the log is passing. 
 	 * Returns false if there are no TestResults in the log
 	 * @return boolean depending on the testResults Log
 	 */
 	public boolean isTestCasePassing() {
 		return false;
 	}
 	
 	/**
 	 * sets the testPlan field to the given TestPlan. testPlan musn't be null.
 	 * @param testPlan the TestPlan to be put in the testPlan field.
 	 * @throws IllegalArgumentException if the parameter testPlan is null.
 	 */
 	public void setTestPlan(TestPlan testPlan) {
 		
 	}
 	
 	/**
 	 * returns the TestPlan in the testPlan field
 	 * @return the Test plan in the testPlan field
 	 */
 	public TestPlan getTestPlan() {
 		return testPlan;
 	}
 	
 	public String getExpectedResults() {
		
		return null;
	}
 	
 	/**
 	 * returns a string representation of the TestCase, specifically for printing to a file.
 	 * @return String the string representation of the TestCase
 	 */
 	public String toString() {
 		//See data formatting part of the design to find out how to make this.
 		return null;
 	}
}
