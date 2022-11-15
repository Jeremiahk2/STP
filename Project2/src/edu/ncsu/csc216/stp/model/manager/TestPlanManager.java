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
 * Contains a list of TestPlans, the FailingTestList, and the operations needed to manipulate
 * these lists.
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
		getFailingTests();
		this.currentTestPlan = failingTestList;
		isChanged = false;
	}
	
	/**
	 * Loads TestPlans from a given file. Duplicates are not loaded, invalid plans are not added.
	 * @param inputFile file to retrieve TestPlans from
	 */
	public void loadTestPlans(File inputFile) {
		testPlans = TestPlanReader.readTestPlansFile(inputFile);
	}
	 
	/**
	 * Saves TestPlans to a given file in the proper format
	 * @param outputFile file to save TestPlans to
	 */
	public void saveTestPlans(File outputFile) {
		TestPlanWriter.writeTestPlanFile(outputFile, testPlans);
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
		if (testPlanName == null || "".equals(testPlanName)) {
			throw new IllegalArgumentException("Failing Tests.");
		}
		testPlans.add(new TestPlan(testPlanName));
	}
	
	/**
	 * Returns a String array of the all the TestPlan names within the TestPlanManager
	 * @return String array of TestPlan names
	 */
	public String[] getTestPlanNames() {
		String[] names = new String[testPlans.size()];
		for (int i = 0; i < testPlans.size(); i++) {
			names[i] = testPlans.get(i).getTestPlanName();
		}
		return names;
	}
	
	/**
	 * Returns the failing tests within the TestPlanManager
	 */
	private void getFailingTests() {
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
	 * Returns the currentTestPlan as an AbstractTestPlan
	 * @return AbstractTestPlan of the currentTestPlan
	 */
	public AbstractTestPlan getCurrentTestPlan() {
		return currentTestPlan;
	}
	
	/**
	 * Allows the user to edit the TestPlan of the given name
	 * @param testPlanName name of the desired TestPlan to be edited
	 * @throws IllegalArgumentException if currentTestPlan is the FailingTestList, or if testPlanName is null, 
	 * empty, or equal to "Failing Tests" (case insensitive)
	 */
	public void editTestPlan(String testPlanName) {
		if (FailingTestList.FAILING_TEST_LIST_NAME.equals(currentTestPlan.getTestPlanName())) {
			throw new IllegalArgumentException("Invalid test plan to edit.");
		}
		if (testPlanName == null || "".equals(testPlanName) || "Failing Tests".equalsIgnoreCase(testPlanName)) {
			throw new IllegalArgumentException("Invalid test plan to edit.");
		}
	}
	
	/**
	 * Removes TestPlan from the TestPlanManager
	 * @throws IllegalArgumentException if the currentTestPlan is the FailingTestList
	 */
	public void removeTestPlan() {
		if (currentTestPlan == failingTestList) {
			throw new IllegalArgumentException("Cannot delete test plan.");
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
	 * Adds a TestCase to a TestPlan
	 * @param t desired TestCase to be added to the TestPlan
	 */
	public void addTestCase(TestCase t) {
		if (t == null) {
			throw new IllegalArgumentException("Null test case.");
		}
		currentTestPlan.addTestCase(t);
	}
	
	/**
	 * Adds TestResult to a TestCase at a given index
	 * @param idx index of the TestCase desired to be updated with the TestResult
	 * @param passing boolean for whether or not the test is passing
	 * @param actualResult desired actual result to be added to the TestCase
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
