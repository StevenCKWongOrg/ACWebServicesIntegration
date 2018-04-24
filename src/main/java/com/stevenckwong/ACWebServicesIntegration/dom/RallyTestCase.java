package com.stevenckwong.ACWebServicesIntegration.dom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.stevenckwong.ACWebServicesIntegration.ACWebServicesException;

public class RallyTestCase {
	
	private String objectID;
	private String formattedID;
	private String name;
	private String description;
	private String workProduct;
	private String owner;
	
	public RallyTestCase() {
		objectID = "uninitialised";
		formattedID = "uninitialised";
		name = "uninitialised";
		description = "uninitialised";		
		workProduct = "uninitialised";
		owner = "uninitialised";
	}

	public RallyTestCase(String rallyJSONObject) {
		// construct a RallyTestCase object from the JSON object returned from a Rally Web Services query
		JSONObject jObj = new JSONObject(rallyJSONObject);
		JSONObject jsonQueryResult = jObj.getJSONObject("QueryResult"); 
		
		try {
			JSONArray jsonArr = jsonQueryResult.getJSONArray("Results");
			if (jsonArr.optJSONObject(0)==null) {
				// no results returned. Set all values to "no results";
				objectID = "no results";
				formattedID = "no results";
				name = "no results";
				description = "no results";		
				workProduct = "no results";
			}
			/*
			this.setObjectID(jsonArr.optJSONObject(0).optString("ObjectID"));
			this.setFormattedID(jsonArr.optJSONObject(0).optString("FormattedID"));
			this.setName(jsonArr.optJSONObject(0).optString("_refObjectName"));
			this.setDescription(jsonArr.optJSONObject(0).optString("Description"));
			this.setWorkProduct(jsonArr.optJSONObject(0).getJSONObject("WorkProduct").optString("_refObjectName", "no associated work product"));
			this.setOwner(jsonArr.optJSONObject(0).getJSONObject("Owner").optString("_refObjectName", "no associated owner"));
			*/

			JSONObject jsonTestCase = jsonArr.optJSONObject(0);
			
			objectID = jsonTestCase.optString("ObjectID");
			formattedID = jsonTestCase.optString("FormattedID");
			name = jsonTestCase.optString("_refObjectName");
			description = jsonTestCase.optString("Description");
			workProduct = jsonTestCase.getJSONObject("WorkProduct").optString("_refObjectName", "no associated work product");
			owner = jsonTestCase.getJSONObject("Owner").optString("_refObjectName", "no associated owner");
			
		} catch (JSONException je) {
			objectID = "null";
			formattedID = "null";
			name = "null";
			description = "raw result: " + rallyJSONObject;		
			workProduct = "null";
			owner = "null";
			
		} catch (NullPointerException ne) {
			objectID = "null";
			formattedID = "null";
			name = "null";
			description = "raw result: " + rallyJSONObject;		
			workProduct = "null";
			owner = "null";
		} finally {
			// do nothing.
		}
		
	}
	
	public RallyTestCase(JSONObject jsonObject) {
		try {
			this.objectID = jsonObject.optString("ObjectID");
			this.formattedID = jsonObject.optString("FormattedID");
			this.name = jsonObject.optString("Name");
			this.description = jsonObject.optString("Description");
			if (jsonObject.optJSONObject("WorkProduct") != null) {
				this.workProduct = jsonObject.optJSONObject("WorkProduct").optString("_refObjectName");
			} else {
				this.workProduct = "No Associated Work Product";
			}
			if (jsonObject.optJSONObject("Owner") != null) {
				this.workProduct = jsonObject.optJSONObject("Owner").optString("_refObjectName");
			} else {
				this.workProduct = "No Associated Owner";
			}
			
		} catch (JSONException je) {
			this.objectID = "result parsing error";
			this.name = "result parsing error";
			this.formattedID = "result parsing error";		
			this.description = "result parsing error";
			this.workProduct = "result parsing error";
			this.owner = "result parsing error";
		}
						
	}
	
	public String getObjectID() {
		return objectID;
	}

	public void setObjectID(String objectID) {
		this.objectID = objectID;
	}

	public String getFormattedID() {
		return formattedID;
	}

	public void setFormattedID(String formattedID) {
		this.formattedID = formattedID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWorkProduct() {
		return workProduct;
	}

	public void setWorkProduct(String workProduct) {
		this.workProduct = workProduct;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
