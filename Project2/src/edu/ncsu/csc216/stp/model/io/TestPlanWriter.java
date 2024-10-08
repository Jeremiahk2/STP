/**
 * 
 */
package edu.ncsu.csc216.stp.model.io;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

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
 * @author Ryan McPhee
 *
 */
public class TestPlanWriter {

	/**
	 * Writes a list of plans to a File in the format described in the class description.
	 * @param file a File object that is the File to write to.
	 * @param plans the list of plans to be written in the file
	 * @throws IllegalArgumentException if the file is unable to be saved
	 */
	public static void writeTestPlanFile(File file, ISortedList<TestPlan> plans) {
		PrintWriter fileWriter;
		try {
			fileWriter = new PrintWriter(new FileOutputStream(file));
			
			for (int i = 0; i < plans.size(); i++) {
				fileWriter.println("! " + plans.get(i).getTestPlanName());
				for (int j = 0; j < plans.get(i).getTestCases().size(); j++) {
					if (i == plans.size() - 1 && j == plans.get(i).getTestCases().size() - 1 ) {
						fileWriter.print(plans.get(i).getTestCase(j).toString().trim());   //Logs do not have a toString, you'll need to edit testCases toString to cycle through actualResults
					} else {
						fileWriter.println(plans.get(i).getTestCase(j).toString()); //same problem here
					}
				}
			}
			fileWriter.close();
			
		} catch (IOException e) {
			throw new IllegalArgumentException("Unable to save file.");
		}
	}
}
