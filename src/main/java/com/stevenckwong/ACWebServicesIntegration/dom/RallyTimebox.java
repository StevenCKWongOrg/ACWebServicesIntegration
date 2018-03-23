package com.stevenckwong.ACWebServicesIntegration.dom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RallyTimebox {
	
	private String type;
	private String name;
	private String startDate;
	private String endDate;
	
	public RallyTimebox() {
		this.type="uninitialised";
		this.name="uninitialised";
		this.startDate="uninitialised";
		this.endDate="uninitialised";
	}
	
	public RallyTimebox(String timeboxType, JSONObject json) {

		try {
			this.type = timeboxType;
			this.name = json.optString("Name");
			this.startDate = json.optString("StartDate");
			this.endDate = json.optString("EndDate");
			
		} catch (JSONException je) {
			this.type = "result parsing error";
			this.name = "result parsing error";
			this.startDate = "result parsing error";		
			this.endDate = "result parsing error";
		}
				
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	

}
