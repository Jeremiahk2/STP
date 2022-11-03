/**
 * 
 */
package edu.ncsu.csc216.stp.model.test_plans;

import java.util.Objects;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * @author Ryan McPhee
 *
 */
public abstract class AbstractTestPlan implements Comparable{

	private String testPlanName;
	
	public AbstractTestPlan(String testPlanName) {
		
	}
	
	public void setTestPlanName(String testPlanName) {
		
	}
	
	public void addTestCase(TestCase t) {
		
	}
	
	public void removeTestCase(int idx) {
		
	}

	public int getNumberOfFailingTests() {
		return -1;
	}
	
	public void addTestResult(int idx, boolean passing, String actualResult) {
		
	}
	
	public abstract String[][] getTestCasesAsArray();

	@Override
	public int hashCode() {
		return Objects.hash(testPlanName);
	}

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

