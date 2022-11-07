/**
 * 
 */
package edu.ncsu.csc216.stp.model.manager;

import java.io.File;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.FailingTestList;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * Contains a list of TestPlans, the FailingTestList, and the operations needed to manipulate
 * these lists.
 * @author Ryan McPhee
 *
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
	 * Constructor for the TestPlanManager object
	 */
	public TestPlanManager() {
		
	}
	
	/**
	 * Loads TestPlans from a given file
	 * @param inputFile file to retrieve TestPlans from
	 */
	public void loadTestPlans(File inputFile) {
		
	}
	 
	/**
	 * Saves TestPlans to a given file in the proper format
	 * @param outputFile file to save TestPlans to
	 */
	public void saveTestPlans(File outputFile) {
		
	}
	
	/**
	 * Returns the state of the isChanged boolean variable
	 * @return the isChanged variable of either true or false
	 */
	public boolean isChanged() {
		return false;
	}
	
	/**
	 * Add a TestPlan to the TstPlanManager's SortedList of TestPlans
	 * @param testPlanName name of the TestPlan to be added
	 */
	public void addTestPlan(String testPlanName) {
		
	}
	
	/**
	 * Returns a String array of the all the TestPlan names within the TestPlanManager
	 * @return String array of TestPlan names
	 */
	public String[] getTestPlanNames() {
		return null;
	}
	
	/**
	 * Returns the failing tests within the TestPlanManager
	 */
	private void getFailingTests() {
		
	}
	
	/**
	 * Sets the currentTestPlan to the TestPlan with the given name
	 * @param testPlanName name of the desired TestPlan to be set as the currentTestPlan
	 */
	public void setCurrentTestPlan(String testPlanName) {
		
	}
	
	/**
	 * Returns an AbstractTestPlan of the currentTestPlan
	 * @return AbstractTestPlan of the currentTestPlan
	 */
	public AbstractTestPlan getCurrentTestPlan() {
		return null;
	}
	
	/**
	 * Allows the user to edit the TestPlan of the given name
	 * @param testPlanName name of the desired TestPlan to be edited
	 */
	public void editTestPlan(String testPlanName) {
		
	}
	
	/**
	 * Removes TestPlan from the TestPlanManager
	 */
	public void removeTestPlan() {
		
	}
	
	/**
	 * Adds a TestCase to a TestPlan
	 * @param t desired TestCase to be added to the TestPlan
	 */
	public void addTestCase(TestCase t) {
		
	}
	
	/**
	 * Adds TestResult to a TestCase at a given index
	 * @param idx index of the TestCase desired to be updated with the TestResult
	 * @param passing boolean for whether or not the test is passing
	 * @param actualResult desired actual result to be added to the TestCase
	 */
	public void addTestResult(int idx, boolean passing, String actualResult) {
		
	}
	
	/**
	 * Clears the TestPlans within the TestPlanManager and displays the failing test list
	 */
	public void clearTestPlans() {
		
	}

	
}
