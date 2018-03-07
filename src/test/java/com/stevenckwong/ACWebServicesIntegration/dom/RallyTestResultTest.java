package com.stevenckwong.ACWebServicesIntegration.dom;

import static org.junit.Assert.*;

import org.junit.Test;

public class RallyTestResultTest {

	@Test
	public void testUninitialisedResult() {
		
		RallyTestResult testObject = new RallyTestResult();
		try {
			assertEquals(testObject.getObjectID(),"uninitialised");
			assertEquals(testObject.getFormattedID(),"uninitialised");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// fail("Not yet implemented");
	}

}
