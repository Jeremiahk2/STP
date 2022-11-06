/**
 * 
 */
package edu.ncsu.csc216.stp.model.manager;

import java.io.File;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.FailingTestList;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.tests.TestResult;
import edu.ncsu.csc216.stp.model.util.ILog;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * @author Ryan McPhee
 *
 */
public class TestPlanManager {

	private ISortedList<TestPlan> testPlans;
	
	private FailingTestList failingTestList;
	
	private AbstractTestPlan currentTestPlan;
	
	private boolean isChanged;
	
	
	public TestPlanManager() {
		
	}
	
	public void loadTestPlans(File inputFile) {
		
	}
	
	public void saveTestPlans(File outputFile) {
		
	}
	
	public boolean isChanged() {
		return false;
	}
	
	public void addTestPlan(String testPlanName) {
		
	}
	
	public String[] getTestPlanNames() {
		return null;
	}
	
	private void getFailingTests() {
		
	}
	
	public void setCurrentTestPlan(String testPlanName) {
		
	}
	
	public AbstractTestPlan getCurrentTestPlan() {
		return null;
	}
	
	public void editTestPlan(String testPlanName) {
		
	}
	
	public void removeTestPlan() {
		
	}
	
	public void addTestCase(TestCase t) {
		
	}
	
	public void addTestResult(int idx, boolean passing, String actualResult) {
		
	}
	
	public void clearTestPlans() {
		
	}

	
}
