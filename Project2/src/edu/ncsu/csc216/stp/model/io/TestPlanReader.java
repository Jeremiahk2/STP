/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.ncsu.csc216.stp.model.test_plans.AbstractTestPlan;
import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.tests.TestResult;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * Processes a file containing test plans with zero to many test cases each with zero to many results
 * The format for the file should look like this:
 * ! (Test plan name)
 * # (Test case name), (Test case type)
 * * (Test Description)     //may contain multiple lines, if so they will be numbered: 1. (Test description line 1)\n 2. (Test description line 2)
 * * (Expected results)
 * This continues for each case, and subsequently, each plan.
 * @author Ryan McPhee
 * @author Jeremiah Knizley
 *
 */
public class TestPlanReader {

	/**
	 * Receives a File with the file to read from. If the file cannot be loaded, an IllegalArgumentException 
	 * is thrown
	 * @param file file to read TestPlan data from the given file
	 * @return SortedList of TestPlans from the given file
	 * @throws IllegalArugmentException if the file cannot be loaded
	 */
	public static ISortedList<TestPlan> readTestPlansFile(File file) {
		boolean exists = file.exists();
		if (!exists) {
			throw new IllegalArgumentException("Unable to load file.");
		}
		//String contents = file.toString();
		ISortedList<TestPlan> plans = new SortedList<TestPlan>();
		
		Scanner processor;
		try {
			processor = new Scanner(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to load file");
		}
		processor.useDelimiter("\\r?\\n?[!]");
		while (processor.hasNext()) {
			TestPlan newTestPlan = processTestPlan(processor.next());
			if (newTestPlan != null) {
				plans.add(newTestPlan);
			}
		}
		processor.close();
		return plans;
	}
	
	/**
	 * Helper method to process the individual TestPlans from the given file
	 * @param testPlan String containing the whole TestPlan as read by the readTestPlansFile method
	 * @return TestPlan recorded within the given String
	 */
	private static TestPlan processTestPlan(String testPlan) {
		Scanner testPlanProcessor = new Scanner(testPlan);
//		testPlanProcessor.useDelimiter("\n");
//		String planName = testPlanProcessor.next();
		String planName = testPlanProcessor.nextLine().substring(1);
		testPlanProcessor.useDelimiter("\\r?\\n?[#]");
		
		TestPlan newTestPlan = new TestPlan(planName);
		
		while (testPlanProcessor.hasNext()) {
			newTestPlan.addTestCase(processTest(newTestPlan, testPlanProcessor.next()));
		}
		testPlanProcessor.close();
		return newTestPlan;
	}
	
	/**
	 * Helper method to process the individual TestCases from the given TestPlan
	 * @param plan the TestPlan containing the given TestCase that is being read
	 * @param caseString String containing the whole TestCase as read by the processTestPlan method
	 * @return TestCase recorded within the given String
	 */
	private static TestCase processTest(AbstractTestPlan plan, String caseString) {
		Scanner testProcessor = new Scanner(caseString);
		testProcessor.useDelimiter(",");
		String testCaseID = testProcessor.next().trim();
		testProcessor.useDelimiter("\n");
		String testType = testProcessor.next().trim().substring(1);
		testProcessor.useDelimiter("\\r?\\n?[-]");
		
		Scanner descriptionProcessor = new Scanner(testProcessor.next());
		descriptionProcessor.useDelimiter("\\r?\\n?[*]");
		String testDescription = descriptionProcessor.next(); //.trim();
		String expectedResults = descriptionProcessor.next(); //.trim();
		
		TestCase newTestCase = new TestCase(testCaseID, testType, testDescription, expectedResults);
		while (testProcessor.hasNext()) {
			//Scanner resultReader = new Scanner(testProcessor.next());
			//
			String results = testProcessor.next();
			String bool = results.substring(1, 5);
			if (bool.equals(TestResult.PASS)) {
				newTestCase.addTestResult(true, results.substring(7));
			}
			else {
				newTestCase.addTestResult(false, results.substring(7));
			}
			//
			//newTestCase.addTestResult(resultReader.nextBoolean(), resultReader.next());
			//resultReader.close();
		}
		descriptionProcessor.close();
		testProcessor.close();
		return newTestCase;
	}
}
