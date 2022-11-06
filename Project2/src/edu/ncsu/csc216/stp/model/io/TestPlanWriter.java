/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;
import java.io.File;

import edu.ncsu.csc216.stp.model.test_plans.TestPlan;
import edu.ncsu.csc216.stp.model.util.ISortedList;

/**
 * Contains static method for writing TestPlans to files.
 * The format for the file will look like this:
 * ! (Test plan name)
 * # (Test case name), (Test case type)
 * * (Test Description)     //may contain multiple lines, if so they will be numbered: 1. (Test description line 1)\n 2. (Test description line 2)
 * * (Expected results)
 * This continues for each case, and subsequently, each plan.
 * @author Jeremiah Knizley
 *
 */
public class TestPlanWriter {

	/**
	 * Writes a list of plans to a File in the format described in the class description.
	 * @param file a File object that is the File to write to.
	 * @param plans the list of plans to be written in the file
	 */
	public static void writeTestPlanFile(File file, ISortedList<TestPlan> plans) {
		
	}
}
