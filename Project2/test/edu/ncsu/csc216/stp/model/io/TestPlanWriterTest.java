/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.tests.TestCase;
import edu.ncsu.csc216.stp.model.util.ISortedList;
import edu.ncsu.csc216.stp.model.util.SortedList;

/**
 * Tests TestPlanWriter class
 * @author Jeremiah Knizley
 *
 */
class TestPlanWriterTest {

	/**
	 * Test method for TestPlanWriter.writeTestPlanFile
	 */
	@Test
	void testWriteTestPlanFile() {
		TestPlan wolfScheduler = new TestPlan("WolfScheduler");
		TestCase case1 = new TestCase("test1", "Equivalence Class", "description\n with multiple lines", "expected results\nwith multiple lines");
		wolfScheduler.addTestCase(case1);
		wolfScheduler.addTestResult(0, true, "actual results");
		wolfScheduler.addTestResult(0,  false, "actual results on\nmultiple lines");
		wolfScheduler.addTestResult(0, false, "actual results\non three\nlines");
		
		TestCase case2 = new TestCase("test2", "Boundary Value", "description", "expected results");
		wolfScheduler.addTestCase(case2);
		
		TestCase case3 = new TestCase("test3", "Requirements", "description\non multiple lines", "expected results");
		wolfScheduler.addTestCase(case3);
		wolfScheduler.addTestResult(2, false, "actual results");
		
		TestPlan packScheduler = new TestPlan("PackScheduler");
		TestCase case4 = new TestCase("test0", "Invalid", "description", "expected results\nwith multiple lines");
		packScheduler.addTestCase(case4);
		packScheduler.addTestResult(0, true, "actual results");
		packScheduler.addTestResult(0, false, "actual results");
		
		TestCase case5 = new TestCase("test1", "Equivalence Class", "description", "expected results");
		packScheduler.addTestCase(case5);
		packScheduler.addTestResult(1, true, "actual results");
		
		ISortedList<TestPlan> list = new SortedList<>();
		
		list.add(wolfScheduler);
		list.add(packScheduler);
		assertEquals(2, list.size());
		
		TestPlanWriter.writeTestPlanFile(new File("test-files/actual-written-files1"), list);
		
		checkFiles("test-files/expected-written-files1", "test-files/actual-written-files1");
		
	}

	
	
	/**
	 * Helper method to determine if two files match each other
	 * @param expFile the file that has the expected results
	 * @param actFile the actual file due to the method
	 */
	private void checkFiles(String expFile, String actFile) {
		try (Scanner expScanner = new Scanner(new File(expFile));
			 Scanner actScanner = new Scanner(new File(actFile));) {
			
			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}
			
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			fail("Error reading files.");
		}
	}
}
