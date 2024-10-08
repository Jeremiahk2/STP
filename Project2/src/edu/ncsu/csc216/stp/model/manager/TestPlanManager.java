/**
 * 
 */
package edu.ncsu.csc216.stp.model.manager;

import java.io.File;

import edu.ncsu.csc216.stp.model.io.TestPlanReader;
import edu.ncsu.csc216.stp.model.io.TestPlanWriter;
import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.FailingTestList;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * TestPlanManager contains a list of TestPlans, the FailingTestList, and the operations needed to manipulate
 * these lists as well as the test cases and test results contained in them.
 * @author Ryan McPhee
 * @author Jeremiah Knizley
 */
public class TestPlanManager {

	/** SortedList of TestPlans within the manager */
	private ISortedList<TestPlan> testPlans;
	/** FailingTestList object to contain the failing test */
	private FailingTestList failingTestList;
	/** AbstractTestPlan of the currentTestPlan the user is viewing */
	private AbstractTestPlan currentTestPlan;
	/** Boolean variable to see if the state of the system has changed */
	private boolean isChanged;
	
	/**
	 * Constructor for the TestPlanManager, constructs testPlans as an empty list. Constructs failingTestList and sets it as 
	 * the currentTestPlan. isChanged is initialized to false.
	 */
	public TestPlanManager() {
		this.testPlans = new SortedList<TestPlan>();
		this.failingTestList = new FailingTestList();
		this.currentTestPlan = failingTestList;
		isChanged = false;
	}
	
	/**
	 * Loads TestPlans from a given file. Duplicates are not loaded, invalid plans are not added.
	 * @param inputFile file to retrieve TestPlans from
	 */
	public void loadTestPlans(File inputFile) {
		ISortedList<TestPlan> loadPlans = TestPlanReader.readTestPlansFile(inputFile);
		for (int i = 0; i < loadPlans.size(); i++) {
			try {
				testPlans.add(loadPlans.get(i));
			} catch (IllegalArgumentException e) {
				//skip this element, it's a duplicate!
			}
		}
		setCurrentTestPlan(FailingTestList.FAILING_TEST_LIST_NAME);
		isChanged = true;
		getFailingTests();
		
	}
	 
	/**
	 * Saves TestPlans to a given file in the proper format and changes isChanged to false
	 * @param outputFile file to save TestPlans to
	 */
	public void saveTestPlans(File outputFile) {
		TestPlanWriter.writeTestPlanFile(outputFile, testPlans);
		isChanged = false;
	}
	
	/**
	 * Returns the state of the isChanged boolean variable
	 * @return the isChanged variable of either true or false
	 */
	public boolean isChanged() {
		return isChanged;
	}
	
	/**
	 * Add a TestPlan to the TestPlanManager's SortedList of TestPlans
	 * @param testPlanName name of the TestPlan to be added
	 * @throws IllegalArgumentException if testPlanName is "Failing Tests" or a duplicate of an existing testPlan (case insensitive for both)
	 */
	public void addTestPlan(String testPlanName) {
		if (testPlanName == null || "".equals(testPlanName) || currentTestPlan.getTestPlanName().equalsIgnoreCase(testPlanName)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		TestPlan newTestPlan = new TestPlan(testPlanName);
		testPlans.add(newTestPlan);
		setCurrentTestPlan(testPlanName);
		this.isChanged = true;
	}
	
	/**
	 * Returns a String array of the all the TestPlan names within the TestPlanManager
	 * @return String array of TestPlan names
	 */
	public String[] getTestPlanNames() {
		String[] names = new String[testPlans.size() + 1];
		names[0] = FailingTestList.FAILING_TEST_LIST_NAME;
		for (int i = 1; i < testPlans.size() + 1; i++) {
			names[i] = testPlans.get(i - 1).getTestPlanName();
		}
		return names;
	}
	
	/**
	 * Clears the FailingTestList of all of it's test cases, then checks every single test plan for failing tests, and adds them to the FailingTestList
	 */
	private void getFailingTests() {
		failingTestList.clearTests();
		for (int i = 0; i < testPlans.size(); i++) {
			for (int j = 0; j < testPlans.get(i).getTestCases().size(); j++) {
				if (!testPlans.get(i).getTestCases().get(j).isTestCasePassing()) {
					failingTestList.addTestCase(testPlans.get(i).getTestCases().get(j));
				}
			}
		}
	}
	
	/**
	 * Sets the currentTestPlan to the TestPlan with the given name. If a testPlan with testPlanName is not found, 
	 * the failingTestList is made current.
	 * @param testPlanName name of the desired TestPlan to be set as the currentTestPlan
	 */
	public void setCurrentTestPlan(String testPlanName) {
		boolean check = false;
		for (int i = 0; i < testPlans.size(); i++) {
			if (testPlans.get(i).getTestPlanName().equals(testPlanName)) {
				currentTestPlan = testPlans.get(i);
				check = true;
			}
		}
		if (!check) {
			currentTestPlan = failingTestList;
		}
	}
	
	/**
	 * Returns the currentTestPlan
	 * @return the current test plan
	 */
	public AbstractTestPlan getCurrentTestPlan() {
		return currentTestPlan;
	}
	
	/**
	 * Allows the user to edit the current TestPlan name to the given name
	 * @param testPlanName desired name to change the current test plan to
	 * @throws IllegalArgumentException if currentTestPlan is the FailingTestList, or if testPlanName is null, 
	 * empty, equal to "Failing Tests" (case insensitive), already the name of the TestPlan, or already the name
	 * of a TestPlan existing within the testCases list.
	 */
	public void editTestPlan(String testPlanName) {
		if (FailingTestList.FAILING_TEST_LIST_NAME.equalsIgnoreCase(currentTestPlan.getTestPlanName())) {
			throw new IllegalArgumentException("The Failing Tests list may not be edited.");
		}
		if (testPlanName == null || "".equals(testPlanName) || "Failing Tests".equalsIgnoreCase(testPlanName) || 
				currentTestPlan.getTestPlanName().equals(testPlanName)) {
			throw new IllegalArgumentException("Invalid name.");
		}
		for (int i = 0; i < testPlans.size(); i++) {
			if (testPlans.get(i).getTestPlanName().equals(testPlanName)) {
				throw new IllegalArgumentException("Invalid name.");
			}
		}
		currentTestPlan.setTestPlanName(testPlanName);
	}
	
	/**
	 * Removes the current test plan from the manager. Afterwards, the FailingTestList will be the current test plan
	 * @throws IllegalArgumentException if the currentTestPlan is the FailingTestList
	 */
	public void removeTestPlan() {
		if (currentTestPlan == failingTestList) {
			throw new IllegalArgumentException("The Failing Tests list may not be deleted.");
		}
		int idx = 0;
		for (int i = 0; i < testPlans.size(); i++) {
			if (testPlans.get(i).getTestPlanName().equals(currentTestPlan.getTestPlanName())) {
				idx = i;
			}
		}
		setCurrentTestPlan(failingTestList.getTestPlanName());
		testPlans.remove(idx);
	}
	
	/**
	 * Adds a TestCase to the current test plan
	 * @param t desired TestCase to be added to the TestPlan
	 */
	public void addTestCase(TestCase t) {
		if (!currentTestPlan.getTestPlanName().equals(failingTestList.getTestPlanName())) {
			currentTestPlan.addTestCase(t);
			isChanged = true;
			if (!t.isTestCasePassing()) {
				failingTestList.addTestCase(t);
			}
		}
		
	}
	
	/**
	 * Adds TestResult to a TestCase at a given index in the current test plan
	 * @param idx index of the TestCase desired to be updated with the TestResult
	 * @param passing boolean for whether or not the test is passing
	 * @param actualResult desired actual result to be added to the TestCase
	 * @throws IndexOutOfBoundsException if the given index is outside of the allowed range
	 * @throws IllegalArgumentException if the actualResults parameter is null or empty
	 */
	public void addTestResult(int idx, boolean passing, String actualResult) {
		if (idx < 0 || idx >= currentTestPlan.getTestCases().size()) {
			throw new IndexOutOfBoundsException("Invalid index.");
		}
		if (actualResult == null || "".equals(actualResult)) {
			throw new IllegalArgumentException("Invalid actual results.");
		}
		
		currentTestPlan.getTestCases().get(idx).addTestResult(passing, actualResult);
	}
	
	/**
	 * Clears the TestPlans within the TestPlanManager and displays the failing test list
	 */
	public void clearTestPlans() {
		testPlans = new SortedList<TestPlan>();
		setCurrentTestPlan(failingTestList.getTestPlanName());
	}
	
}
