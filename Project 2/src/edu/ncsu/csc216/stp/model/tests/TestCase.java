/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;

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
	
	public TestCase(String testCaseId, String testType, String testDescription, String expectedResults) {
		setTestCaseId(testCaseId);
		setTestType(testType);
		setTestDescription(testDescription);
		setExpectedResults(expectedResults);
	}
	
	public String getTestCaseId() {
		return testCaseId;
	}
	
	private void setTestCaseId(String testCaseId) {
		
	}
	
	public String getTestType() {
		return testType;
	}
	
	private void setTestType(String testType) {
		
	}
	
	public String getTestDescription() {
		return testDescription;
	}
	
	private void setTestDescription(String testDescription) {
		
	}
	
	public String getExcpetedResults() {
		return expectedResults;
	}
	
 	private void setExpectedResults(String expectedResults) {
 		
 	}
 	
 	public void addTestResult(boolean passing, String actualResults) {
 		
 	}
 	
 	public String getStatus() {
 		return null;
 	}
 	
 	public String getActualResultsLog() {
 		return null;
 	}
 	
 	public void setTestPlan(TestPlan testPlan) {
 		
 	}
 	
 	public TestPlan getTestPlan() {
 		return testPlan;
 	}
 	
 	public String toString() {
 		return null;
 	}
 	
 	
 	
	
}
