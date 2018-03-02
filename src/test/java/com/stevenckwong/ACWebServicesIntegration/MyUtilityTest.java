package com.stevenckwong.ACWebServicesIntegration;

import org.junit.Assert;

import org.junit.Test;

import com.rallydev.rest.RallyRestApi;
import com.stevenckwong.ACWebServicesIntegration.*;
import com.stevenckwong.ACWebServicesIntegration.dom.*;

// import junit.framework.Assert;

public class MyUtilityTest {
	
	@Test
	public void test1() {
		// fail("Not yet implemented");
		
		try {
			testGetDisplayName();
			testGetFirstName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		// fail("Not yet implemented");
		
		try {
			testGetFirstName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	@Test
	public void test3() {
		// fail("Not yet implemented");
		
		try {
			testGetLastName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
	
	
	@Test
	public void test4() {
		// fail("Not yet implemented");
		
		try {
			testGetTestCaseByID();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}		
		
	
	private void testGetDisplayName() throws Exception {
		
		// TODO: hardcoded data - to be replaced with dynamic data read from file later.
		TestUtility util = new TestUtility();
		
		String username = "tm1-a1@stevenckwong.com";
		String apikey = util.getTestApiKey();
		
		MyUtility myUtil = new MyUtility();
		
		String result = myUtil.queryForUserDetails(apikey, username);
		String displayName = myUtil.parseJSONResultForDisplayName(result);
		Assert.assertEquals("Allan (Activity Manager)", displayName);
		
	}
	
	private void testGetFirstName() throws Exception {
		
		// TODO: hardcoded data - to be replaced with dynamic data read from file later.
		TestUtility util = new TestUtility();
		
		String username = "tm1-a1@stevenckwong.com";
		String apikey = util.getTestApiKey();
		
		MyUtility myUtil = new MyUtility();
		
		String result = myUtil.queryForUserDetails(apikey, username);
		String firstName = myUtil.parseJSONResultForFirstName(result);
		
		Assert.assertEquals("Allan", firstName);
		
	}
	
	private void testGetLastName() throws Exception {
		
		// TODO: hardcoded data - to be replaced with dynamic data read from file later.
		TestUtility util = new TestUtility();
		
		String username = "tm1-a1@stevenckwong.com";
		String apikey = util.getTestApiKey();
		
		MyUtility myUtil = new MyUtility();
		
		String result = myUtil.queryForUserDetails(apikey, username);
		String lastName = myUtil.parseJSONResultForLastName(result);
		
		Assert.assertEquals("TM", lastName);
		
	}
	
	private void testGetTestCaseByID() throws Exception {
		TestUtility util = new TestUtility();
		
		String tcid = "TC50";
		String apikey = util.getTestApiKey();
		
		MyUtility myUtil = new MyUtility();
		
		String result = myUtil.queryForTestCaseDetails(apikey, tcid);
		
		RallyTestCase testCaseObject = new RallyTestCase(result);
		
		Assert.assertEquals("TC50",testCaseObject.getFormattedID());
		Assert.assertEquals("Submit valid Test Case ID, get Test Case Details", testCaseObject.getName());
		
	}
		
}


