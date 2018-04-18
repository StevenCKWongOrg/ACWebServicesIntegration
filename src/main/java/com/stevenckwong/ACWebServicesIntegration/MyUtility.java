package com.stevenckwong.ACWebServicesIntegration;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.rallydev.rest.RallyRestApi;
import org.json.*;
import com.stevenckwong.ACWebServicesIntegration.dom.*;

public class MyUtility {
	
	public MyUtility() {
		
	}
	// This method parses the Rally result from logging in and returns the DisplayName
	// field.
	public String parseResultForDisplayName(String result) {
		int startIndex = result.indexOf("\"_refObjectName\": \"");
		startIndex+=19;
		
		int endIndex = result.indexOf("\"", startIndex);
		
		String displayName = result.substring(startIndex, endIndex);
		return displayName;
	}
	
	public int parseJSONResultForTotalResultsCount(String result) {
		int totalResultCount = 0;
		
		JSONObject jObj = new JSONObject(result);
		JSONObject jsonQueryResult = jObj.getJSONObject("QueryResult"); 

		String strResultCount = jsonQueryResult.optString("TotalResultCount");
		if (strResultCount==null) {
			totalResultCount = 0;
		} else {
			totalResultCount = Integer.parseInt(strResultCount);
		}
		
		return totalResultCount;
	}
	
	
	// This method uses the JSON libraries to get the DisplayName from the JSON result
	// retrieved from Rally.
	public String parseJSONResultForDisplayName(String result) {
		String displayName = "Uninitialized";
		JSONObject jObj = new JSONObject(result);
		JSONObject jsonQueryResult = jObj.getJSONObject("QueryResult"); 
		
		try {
			JSONArray jsonArr = jsonQueryResult.getJSONArray("Results");
			if (jsonArr.optJSONObject(0)==null) {
				return "0";
			}
			displayName = jsonArr.optJSONObject(0).optString("_refObjectName");
			
		} catch (JSONException je) {
			return jObj.optString("TotalResultCount");
		}
		
		return displayName;
	}
	
	public String parseJSONResultForFirstName(String result) {
		String firstName = "Uninitialized";
		JSONObject jObj = new JSONObject(result);
		JSONObject jsonQueryResult = jObj.getJSONObject("QueryResult"); 
		
		try {
			JSONArray jsonArr = jsonQueryResult.getJSONArray("Results");
			if (jsonArr.optJSONObject(0)==null) {
				return "0";
			}
			firstName = jsonArr.optJSONObject(0).optString("FirstName");
			
		} catch (JSONException je) {
			return jObj.optString("TotalResultCount");
		}
		
		return firstName;
	}	
	
	public String parseJSONResultForLastName(String result) {
		String lastName = "Uninitialized";
		JSONObject jObj = new JSONObject(result);
		JSONObject jsonQueryResult = jObj.getJSONObject("QueryResult"); 
		
		try {
			JSONArray jsonArr = jsonQueryResult.getJSONArray("Results");
			if (jsonArr.optJSONObject(0)==null) {
				return "0";
			}
			lastName = jsonArr.optJSONObject(0).optString("LastName");
			
		} catch (JSONException je) {
			return jObj.optString("TotalResultCount");
		}
		
		return lastName;
	}	
	
	
	public ArrayList<RallyTestCase> parseJSONResultForListOfTestCases(String json) {
		
		ArrayList<RallyTestCase> rallyTestCases = new ArrayList<RallyTestCase>();
		
		JSONObject jsonResult = new JSONObject(json);
		JSONObject jsonQueryResult = jsonResult.getJSONObject("QueryResult");

		int resultCount = jsonQueryResult.optInt("TotalResultCount");
		if (resultCount==0) {
			RallyTestCase testCaseObject = new RallyTestCase();
			rallyTestCases.add(testCaseObject);
			return rallyTestCases;
		}
		
		try {
			JSONArray jsonArr = jsonQueryResult.getJSONArray("Results");
			for (int i=0; i<resultCount; i++) {
				JSONObject jsonTestCase = jsonArr.getJSONObject(i);
				RallyTestCase testCaseObject = new RallyTestCase(jsonTestCase);
				rallyTestCases.add(testCaseObject);
				}
			
			} catch (JSONException je) {
				RallyTestCase testCaseObkect = new RallyTestCase();
				rallyTestCases.add(testCaseObkect);
				return rallyTestCases;
			}
			
		return rallyTestCases;	
		
	}
	
	
	
	// This method parses the Rally result from logging in and returns the First name field
	public String parseResultForFirstName(String result) {
		return "Stubbed First Name";
	}
	
	
	public RallyRestApi connectToRallyUsingAPIKey(String apiKey) {
		URI uri = URI.create("https://rally1.rallydev.com");
		RallyRestApi rally = new RallyRestApi(uri,apiKey);
		
		return rally;
	}
	
	// Refactored Code: added method to query for Display Name
	public String queryForDisplayName(String apiKey, String username) throws ACWebServicesException {
		
		RallyRestApi rally = this.connectToRallyUsingAPIKey(apiKey);
		
		String QueryString = "(UserName%20%3D%20"+username+")&start=1&pagesize=20";
		String queryURL = "/user?query=" + QueryString + "&order=";	
		String result = new String();
		// boolean authenticated = true;
		try {
			result = rally.getClient().doGet(queryURL);
		} catch (java.io.IOException ioe) {
			String err = ioe.getMessage();
			result = err;
			// Full error message should be: HTTP/1.1 401 Full authentication is required to access this resource
			if (err.contains("401")) {
				ACWebServicesException ace = new ACWebServicesException(ioe);
				ace.setErrorMessage("API Key was not authenticated. Original Error Message: " + err);
				throw ace;
			//	authenticated = false;
			}
		}
		
		return result;

	}
	
	public String queryForUserDetails(String apiKey, String username) throws ACWebServicesException {
		
		RallyRestApi rally = this.connectToRallyUsingAPIKey(apiKey);
		
		String QueryString = "(UserName%20%3D%20"+username+")&fetch=true&start=1&pagesize=20";
		String queryURL = "/user?query=" + QueryString + "&order=";	
		String result = new String();
		// boolean authenticated = true;
		try {
			result = rally.getClient().doGet(queryURL);
		} catch (java.io.IOException ioe) {
			String err = ioe.getMessage();
			result = err;
			// Full error message should be: HTTP/1.1 401 Full authentication is required to access this resource
			if (err.contains("401")) {
				ACWebServicesException ace = new ACWebServicesException(ioe);
				ace.setErrorMessage("API Key was not authenticated. Original Error Message: " + err);
				throw ace;
			//	authenticated = false;
			}
		}
		
		return result;

	}
	
	public String queryForTestCaseDetailsByID(String apiKey, String testCaseID) throws ACWebServicesException {

		RallyRestApi rally = this.connectToRallyUsingAPIKey(apiKey);
		
		String QueryString = "(FormattedID%20%3D%20%22"+testCaseID+"%22)&fetch=true&start=1&pagesize=20";
		String queryURL = "/testcase?query=" + QueryString + "&order=";	
		String jsonTestCaseDetails = "";
		// boolean authenticated = true;
		try {
			jsonTestCaseDetails = rally.getClient().doGet(queryURL);
		} catch (java.io.IOException ioe) {
			String err = ioe.getMessage();
			jsonTestCaseDetails = err;
			// Full error message should be: HTTP/1.1 401 Full authentication is required to access this resource
			if (err.contains("401")) {
				ACWebServicesException ace = new ACWebServicesException(ioe);
				ace.setErrorMessage("API Key was not authenticated. Original Error Message: " + err);
				throw ace;
			//	authenticated = false;
			}
		}
		
		return jsonTestCaseDetails;
	}

	public String queryForTestCaseDetailsByName(String apiKey, String testCaseName) throws ACWebServicesException {

		RallyRestApi rally = this.connectToRallyUsingAPIKey(apiKey);
		String jsonTestCaseDetails = new String();
		String finalQueryString = new String();
		
		try {
			String queryString = "(Name contains \""+testCaseName+"\")";
			String queryURL = "/testcase?query=" + URLEncoder.encode(queryString,"UTF-8") + "&fetch=true&start=1&pagesize=20&order=";
			// String queryURL = "/testcase?query=" + queryString + "&order=";
			finalQueryString = queryURL;
			
			// boolean authenticated = true;
			try {
				jsonTestCaseDetails = rally.getClient().doGet(queryURL);
			} catch (java.io.IOException ioe) {
				String err = ioe.getMessage();
				jsonTestCaseDetails = err;
				// Full error message should be: HTTP/1.1 401 Full authentication is required to access this resource
				if (err.contains("401")) {
					ACWebServicesException ace = new ACWebServicesException(ioe);
					ace.setErrorMessage("API Key was not authenticated. Original Error Message: " + err);
					throw ace;
				//	authenticated = false;
				}
			}
			
			return jsonTestCaseDetails;
			
		} catch (java.io.IOException ioe) {
			String err = ioe.getMessage();
			jsonTestCaseDetails = err;
			// Full error message should be: HTTP/1.1 401 Full authentication is required to access this resource
			if (err.contains("401")) {
				ACWebServicesException ace = new ACWebServicesException(ioe);
				ace.setErrorMessage("API Key was not authenticated. Original Error Message: " + err);
				throw ace;
			//	authenticated = false;
			} else {
				ACWebServicesException ace = new ACWebServicesException(ioe);
				ace.setErrorMessage("IOException encountered. QueryURL = " + finalQueryString + "<br>Original Error Message: " + err);
				throw ace;
			}
		}

	}
	
	public String logTestRunResult(String testID, RallyTestResult testResult, String buildNumber) {
		
		String apiKey = "_CGJbIEnhQDq45u70AWVPFcMsEmGCkO6tZEhYDyg5Dw";

		
		RallyRestApi rally = this.connectToRallyUsingAPIKey(apiKey);

		try {
			
			// added this. 
			
			rally.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		// Updated this to test out the integration with Rally
		
		return "Success";
	}

	
	public ArrayList<RallyTimebox> queryTimeboxes(String apiKey, String projectName, String timeboxType) throws ACWebServicesException {
		
		RallyRestApi rally = this.connectToRallyUsingAPIKey(apiKey);
		ArrayList<RallyTimebox> rallyTimeboxes = new ArrayList<RallyTimebox>();
		String result = new String();			
		String finalQueryString = new String();
		
		
		// boolean authenticated = true;
		try {
			String queryString = "(Project.Name = \""+projectName+"\")";
			String queryURL = "/" + timeboxType + "?query=" + URLEncoder.encode(queryString,"UTF-8") + "&fetch=true&start=1&pagesize=20&order=";	
			finalQueryString = queryURL;
			
			result = rally.getClient().doGet(queryURL);
			JSONObject jsonResult = new JSONObject(result);
			JSONObject jsonQueryResult = jsonResult.getJSONObject("QueryResult");
			
			int resultCount = jsonQueryResult.optInt("TotalResultCount");
			if (resultCount==0) {
				RallyTimebox timeboxObject = new RallyTimebox();
				rallyTimeboxes.add(timeboxObject);
				return rallyTimeboxes;
			}
			
			try {
				JSONArray jsonArr = jsonQueryResult.getJSONArray("Results");
				for (int i=0; i<resultCount; i++) {
					JSONObject jsonTimebox = jsonArr.getJSONObject(i);
					RallyTimebox timeboxObject = new RallyTimebox(timeboxType, jsonTimebox);
					rallyTimeboxes.add(timeboxObject);
				}
				
			return rallyTimeboxes;
			
			} catch (JSONException je) {
				String err = je.getMessage();
				ACWebServicesException ace = new ACWebServicesException(je);
				ace.setErrorMessage("JSONException encountered. Original Error Message: " + err);
				throw ace;
			}
			
		} catch (java.io.IOException ioe) {
			String err = ioe.getMessage();
			result = err;
			// Full error message should be: HTTP/1.1 401 Full authentication is required to access this resource
			if (err.contains("401")) {
				ACWebServicesException ace = new ACWebServicesException(ioe);
				ace.setErrorMessage("API Key was not authenticated. Original Error Message: " + err);
				throw ace;
			//	authenticated = false;
			} else {
				ACWebServicesException ace = new ACWebServicesException(ioe);
				ace.setErrorMessage("IOException encountered. QueryURL = " + finalQueryString + "<br>Original Error Message: " + err);
				throw ace;
			}
		}
		
		// return rallyTimeboxes;

	}
	public ArrayList<RallyTimebox> queryMilestonesForProject(String apiKey, String projectName) throws ACWebServicesException {
		
		RallyRestApi rally = this.connectToRallyUsingAPIKey(apiKey);
		ArrayList<RallyTimebox> rallyTimeboxes = new ArrayList<RallyTimebox>();
		String result = new String();			
		String finalQueryString = new String();
		
		
		// boolean authenticated = true;
		try {
			String queryString = "(Projects.Name contains \""+projectName+"\")";
			String queryURL = "/milestone" + "?query=" + URLEncoder.encode(queryString,"UTF-8") + "&fetch=true&start=1&pagesize=20&order=";	
			finalQueryString = queryURL;
			
			result = rally.getClient().doGet(queryURL);
			JSONObject jsonResult = new JSONObject(result);
			JSONObject jsonQueryResult = jsonResult.getJSONObject("QueryResult");
			
			int resultCount = jsonQueryResult.optInt("TotalResultCount");
			if (resultCount==0) {
				RallyTimebox timeboxObject = new RallyTimebox();
				rallyTimeboxes.add(timeboxObject);
				return rallyTimeboxes;
			}
			
			try {
				JSONArray jsonArr = jsonQueryResult.getJSONArray("Results");
				for (int i=0; i<resultCount; i++) {
					JSONObject jsonTimebox = jsonArr.getJSONObject(i);
					RallyTimebox timeboxObject = new RallyTimebox("milestone", jsonTimebox);
					rallyTimeboxes.add(timeboxObject);
				}
				
			return rallyTimeboxes;
			
			} catch (JSONException je) {
				String err = je.getMessage();
				ACWebServicesException ace = new ACWebServicesException(je);
				ace.setErrorMessage("JSONException encountered. Original Error Message: " + err);
				throw ace;
			}
			
		} catch (java.io.IOException ioe) {
			String err = ioe.getMessage();
			result = err;
			// Full error message should be: HTTP/1.1 401 Full authentication is required to access this resource
			if (err.contains("401")) {
				ACWebServicesException ace = new ACWebServicesException(ioe);
				ace.setErrorMessage("API Key was not authenticated. Original Error Message: " + err);
				throw ace;
			//	authenticated = false;
			} else {
				ACWebServicesException ace = new ACWebServicesException(ioe);
				ace.setErrorMessage("IOException encountered. QueryURL = " + finalQueryString + "<br>Original Error Message: " + err);
				throw ace;
			}
		}
		
		// return rallyTimeboxes;
	
	}
	public String queryForTestCasesByOwnerUsername(String apiKey, String username) throws ACWebServicesException {
	
		RallyRestApi rally = this.connectToRallyUsingAPIKey(apiKey);
		String jsonTestCaseDetails = new String();
		String finalQueryString = new String();
		
		try {
			String queryString = "(Owner.UserName = \""+username+"\")";
			String queryURL = "/testcase?query=" + URLEncoder.encode(queryString,"UTF-8") + "&fetch=true&start=1&pagesize=20&order=";
			// String queryURL = "/testcase?query=" + queryString + "&order=";
			finalQueryString = queryURL;
			
			// boolean authenticated = true;
			try {
				jsonTestCaseDetails = rally.getClient().doGet(queryURL);
			} catch (java.io.IOException ioe) {
				String err = ioe.getMessage();
				jsonTestCaseDetails = err;
				// Full error message should be: HTTP/1.1 401 Full authentication is required to access this resource
				if (err.contains("401")) {
					ACWebServicesException ace = new ACWebServicesException(ioe);
					ace.setErrorMessage("API Key was not authenticated. Original Error Message: " + err);
					throw ace;
				//	authenticated = false;
				}
			}
			
			return jsonTestCaseDetails;
			
		} catch (java.io.IOException ioe) {
			String err = ioe.getMessage();
			jsonTestCaseDetails = err;
			// Full error message should be: HTTP/1.1 401 Full authentication is required to access this resource
			if (err.contains("401")) {
				ACWebServicesException ace = new ACWebServicesException(ioe);
				ace.setErrorMessage("API Key was not authenticated. Original Error Message: " + err);
				throw ace;
			//	authenticated = false;
			} else {
				ACWebServicesException ace = new ACWebServicesException(ioe);
				ace.setErrorMessage("IOException encountered. QueryURL = " + finalQueryString + "<br>Original Error Message: " + err);
				throw ace;
			}
		}
	
	}	
	
}
