/**
 * 
 */
package edu.ncsu.csc216.stp.model.manager;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.stp.model.tests.TestCase;

/**
 * Tests TestPlanManager class
 * @author Jeremiah Knizley
 * @author Ryan McPhee
 *
 */
class TestPlanManagerTest {

	/**
	 * Test method for TestPlanManager's constructor
	 */
	@Test
	void testTestPlanManager() {
		TestPlanManager test = new TestPlanManager();
		assertAll("TestPlanManager",
				() -> assertEquals(1, test.getTestPlanNames().length),
				() -> assertEquals("Failing Tests", test.getCurrentTestPlan().getTestPlanName()));
		
	}

	/**
	 * Test method for TestPlanManager.loadTestPlans
	 */
	@Test
	void testLoadTestPlans() {
		TestPlanManager manager = new TestPlanManager();
		manager.addTestPlan("Zebra");
		manager.addTestPlan("PackScheduler");
		assertEquals("PackScheduler", manager.getCurrentTestPlan().getTestPlanName());
		assertDoesNotThrow(() -> manager.loadTestPlans(new File("test-files/test-plans0.txt")));
		String[] names = manager.getTestPlanNames();
		assertEquals("Failing Tests", names[0]);
		assertEquals("PackScheduler", names[1]);
		assertEquals("WolfScheduler", names[2]);
		assertEquals("Zebra", names[3]);
		assertEquals("Failing Tests", manager.getCurrentTestPlan().getTestPlanName());
		
		assertEquals(4, names.length);
		
		assertTrue(manager.isChanged());
	}
	/**
	 * Test method for TestPlanManager.loadTestPlans specifically testing the Failing tests being updated
	 */
	@Test
	void testLoadTestPlans2() {
		TestPlanManager manager = new TestPlanManager();
		manager.loadTestPlans(new File("test-files/test-plans0.txt"));
		assertEquals("Failing Tests", manager.getCurrentTestPlan().getTestPlanName());
		assertEquals(3, manager.getCurrentTestPlan().getTestCasesAsArray().length);
		
		
	}

//	/**
//	 * Test method for Test method for TestPlanManager.saveTestPlans
//	 */
//	@Test
//	void testSaveTestPlans() {
//		fail("Not yet implemented");
//	}

	/**
	 * Test method for TestPlanManager.isChanged
	 */
	@Test
	void testIsChanged() {
		TestPlanManager test = new TestPlanManager();
		assertAll("TestPlanManager",
				() -> assertEquals(1, test.getTestPlanNames().length),
				() -> assertEquals("Failing Tests", test.getCurrentTestPlan().getTestPlanName()));
		
		assertFalse(test.isChanged());
	}

	/**
	 * Test method for TestPlanManager.addTestPlan
	 */
	@Test
	void testAddTestPlan() {
		TestPlanManager test = new TestPlanManager();
		assertAll("TestPlanManager",
				() -> assertEquals(1, test.getTestPlanNames().length),
				() -> assertEquals("Failing Tests", test.getCurrentTestPlan().getTestPlanName()));
		
		test.addTestPlan("Sample Test Plan");
		assertAll("TestPlanManager",
				() -> assertEquals(2, test.getTestPlanNames().length),
				() -> assertEquals("Sample Test Plan", test.getCurrentTestPlan().getTestPlanName())
				);
		
	}

	/**
	 * Test method for TestPlanManager.getTestPlanNames
	 */
	@Test
	void testGetTestPlanNames() {
		TestPlanManager test = new TestPlanManager();
		assertAll("TestPlanManager",
				() -> assertEquals(1, test.getTestPlanNames().length),
				() -> assertEquals("Failing Tests", test.getCurrentTestPlan().getTestPlanName()));
		test.addTestPlan("Sample Test Plan1");
		test.addTestPlan("Sample Test Plan2");
		test.addTestPlan("Sample Test Plan3");
		test.addTestPlan("Sample Test Plan4");
		test.addTestPlan("Sample Test Plan5");
		String[] testPlanNames = test.getTestPlanNames();
		
		assertAll("TestPlanNames",
				() -> assertEquals(6, testPlanNames.length),
				() -> assertEquals("Failing Tests", testPlanNames[0]),
				() -> assertEquals("Sample Test Plan1", testPlanNames[1]),
				() -> assertEquals("Sample Test Plan2", testPlanNames[2]),
				() -> assertEquals("Sample Test Plan3", testPlanNames[3]),
				() -> assertEquals("Sample Test Plan4", testPlanNames[4]),
				() -> assertEquals("Sample Test Plan5", testPlanNames[5]));
		
	}

	/**
	 * Test method for TestPlanManager.setCurrentTestPlan
	 */
	@Test
	void testSetCurrentTestPlan() {
		TestPlanManager test = new TestPlanManager();
		assertAll("TestPlanManager",
				() -> assertEquals(1, test.getTestPlanNames().length),
				() -> assertEquals("Failing Tests", test.getCurrentTestPlan().getTestPlanName()));
		test.addTestPlan("Sample Test Plan1");
		test.addTestPlan("Sample Test Plan2");
		test.addTestPlan("Sample Test Plan3");
		test.addTestPlan("Sample Test Plan4");
		test.addTestPlan("Sample Test Plan5");
		
		test.setCurrentTestPlan("Sample Test Plan1");
		assertEquals("Sample Test Plan1", test.getCurrentTestPlan().getTestPlanName());
		
		test.setCurrentTestPlan("Sample Test Plan2");
		assertEquals("Sample Test Plan2", test.getCurrentTestPlan().getTestPlanName());
		
		test.setCurrentTestPlan("Sample Test Plan3");
		assertEquals("Sample Test Plan3", test.getCurrentTestPlan().getTestPlanName());
		
		test.setCurrentTestPlan("Sample Test Plan4");
		assertEquals("Sample Test Plan4", test.getCurrentTestPlan().getTestPlanName());
		
		test.setCurrentTestPlan("Sample Test Plan5");
		assertEquals("Sample Test Plan5", test.getCurrentTestPlan().getTestPlanName());
		
		test.setCurrentTestPlan("Sample Test Plan6");
		assertEquals("Failing Tests", test.getCurrentTestPlan().getTestPlanName());
	}

//	/**
//	 * Test method for TestPlanManager.getCurrentTestPlan
//	 */
//	@Test
//	void testGetCurrentTestPlan() {
//		fail("Not yet implemented");
//	}

//	/**
//	 * Test method for TestPlanManager.editTestPlan
//	 */
//	@Test
//	void testEditTestPlan() {
//		fail("Not yet implemented");
//	}

	/**
	 * Test method for TestPlanManager.removeTestPlan
	 */
	@Test
	void testRemoveTestPlan() {
		TestPlanManager test = new TestPlanManager();
		assertAll("TestPlanManager",
				() -> assertEquals(1, test.getTestPlanNames().length),
				() -> assertEquals("Failing Tests", test.getCurrentTestPlan().getTestPlanName()));
		test.addTestPlan("Sample Test Plan1");
		test.addTestPlan("Sample Test Plan2");
		test.addTestPlan("Sample Test Plan3");
		test.addTestPlan("Sample Test Plan4");
		test.addTestPlan("Sample Test Plan5");
		String[] testPlanNames = test.getTestPlanNames();
		
		assertAll("TestPlanNames",
				() -> assertEquals("Failing Tests", testPlanNames[0]),
				() -> assertEquals("Sample Test Plan1", testPlanNames[1]),
				() -> assertEquals("Sample Test Plan2", testPlanNames[2]),
				() -> assertEquals("Sample Test Plan3", testPlanNames[3]),
				() -> assertEquals("Sample Test Plan4", testPlanNames[4]),
				() -> assertEquals("Sample Test Plan5", testPlanNames[5]));
		
		test.setCurrentTestPlan("Sample Test Plan3");
		test.removeTestPlan();
		String[] testPlanNames2 = test.getTestPlanNames();
		assertAll("TestPlanNames",
				() -> assertEquals(5, testPlanNames2.length),
				() -> assertEquals("Failing Tests", testPlanNames[0]),
				() -> assertEquals("Sample Test Plan1", testPlanNames2[1]),
				() -> assertEquals("Sample Test Plan2", testPlanNames2[2]),
				() -> assertEquals("Sample Test Plan4", testPlanNames2[3]),
				() -> assertEquals("Sample Test Plan5", testPlanNames2[4]));
		
		test.setCurrentTestPlan("Failing Tests");
		Exception e1 = assertThrows(IllegalArgumentException.class, () -> test.removeTestPlan());
		assertEquals("The Failing Tests list may not be deleted.", e1.getMessage());
	}

	/**
	 * Test method for TestPlanManager.addTestCase
	 */
	@Test
	void testAddTestCase() {
		TestPlanManager test = new TestPlanManager();
		assertAll("TestPlanManager",
				() -> assertEquals(1, test.getTestPlanNames().length),
				() -> assertEquals("Failing Tests", test.getCurrentTestPlan().getTestPlanName()));
		test.addTestPlan("Sample Test Plan1");
		
		TestCase testTestCase = new TestCase("SampleID", "SampleType", "SampleDescription", "SampleExpected");
		test.addTestCase(testTestCase);
		String[][] testCaseArray = test.getCurrentTestPlan().getTestCasesAsArray();
		
		assertAll("TestCase",
				() -> assertEquals(1, testCaseArray.length),
				() -> assertEquals("SampleID", testCaseArray[0][0]),
				() -> assertEquals("SampleType", testCaseArray[0][1]),
				() -> assertEquals("FAIL", testCaseArray[0][2]));	
	}

//	/**
//	 * Test method for TestPlanManager.addTestResult
//	 */
//	@Test
//	void testAddTestResult() {
//		fail("Not yet implemented");
//	}

	/**
	 * Test method for TestPlanManager.clearTestPlans
	 */
	@Test
	void testClearTestPlans() {
		TestPlanManager test = new TestPlanManager();
		assertAll("TestPlanManager",
				() -> assertEquals(1, test.getTestPlanNames().length),
				() -> assertEquals("Failing Tests", test.getCurrentTestPlan().getTestPlanName()));
		test.addTestPlan("Sample Test Plan1");
		test.addTestPlan("Sample Test Plan2");
		test.addTestPlan("Sample Test Plan3");
		test.addTestPlan("Sample Test Plan4");
		test.addTestPlan("Sample Test Plan5");
		String[] testPlanNames = test.getTestPlanNames();
		assertEquals(6, testPlanNames.length);
		test.clearTestPlans();
		String[] testPlanNames2 = test.getTestPlanNames();
		assertEquals(1, testPlanNames2.length);
		assertEquals("Failing Tests", test.getCurrentTestPlan().getTestPlanName());
	}

}
