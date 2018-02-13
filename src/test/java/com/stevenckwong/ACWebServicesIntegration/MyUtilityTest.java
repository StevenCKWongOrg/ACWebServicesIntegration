package com.stevenckwong.ACWebServicesIntegration;

import org.junit.Assert;

import org.junit.Test;

import com.rallydev.rest.RallyRestApi;

// import junit.framework.Assert;

public class MyUtilityTest {

	@Test
	public void test() {
		// fail("Not yet implemented");
		
		try {
			testGetDisplayName();
			testGetFirstName();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void testGetDisplayName() throws Exception {
		
		// TODO: hardcoded data - to be replaced with dynamic data read from file later.
		String username = "tm1-a1@stevenckwong.com";
		String apikey = "_fkTPqTeS62D6PfCEbDViMRT2lotBkskiBlxd677GM";
		
		MyUtility myUtil = new MyUtility();
		
		String result = myUtil.queryForUserDetails(apikey, username);
		String displayName = myUtil.parseJSONResultForDisplayName(result);
		Assert.assertEquals("Allan (Activity Manager)", displayName);
		
	}
	
	private void testGetFirstName() throws Exception {
		
		// TODO: hardcoded data - to be replaced with dynamic data read from file later.
		String username = "tm1-a1@stevenckwong.com";
		String apikey = "_fkTPqTeS62D6PfCEbDViMRT2lotBkskiBlxd677GM";
		
		MyUtility myUtil = new MyUtility();
		
		String result = myUtil.queryForUserDetails(apikey, username);
		String firstName = myUtil.parseJSONResultForFirstName(result);
		
		Assert.assertEquals("Allan", firstName);
		
	}
		
}


