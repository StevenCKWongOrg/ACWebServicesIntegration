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
		
		RallyRestApi rally = myUtil.connectToRallyUsingAPIKey(apikey);
		
		String QueryString = "(UserName%20%3D%20"+username+")&start=1&pagesize=20";
		String queryURL = "/user?query=" + QueryString + "&order=";	
		
		String result = rally.getClient().doGet(queryURL);
		
		String displayName = myUtil.parseResultForDisplayName(result);

		rally.close();
		
		Assert.assertEquals("Allan (Activity Manager)", displayName);
		
	}
		
}


