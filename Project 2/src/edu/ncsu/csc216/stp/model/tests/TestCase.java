/**
 * 
 */
package edu.ncsu.csc216.stp.model.tests;

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
		
	}
	
	public String getTestCaseId() {
		return null;
	}
	
	private void setTestCaseId(String testCaseId) {
		
	}
	
	public String getTestType() {
		return null;
	}
	
	private void setTestType(String testType) {
		
	}
	
	public String getTestDescription() {
		return null;
	}
	
	private void setTestDescription(String testDescription) {
		
	}
	
	public String getExcpetedResults() {
		return null;
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
 		return null;
 	}
 	
 	public String toString() {
 		return null;
 	}
 	
 	
 	
	
}
