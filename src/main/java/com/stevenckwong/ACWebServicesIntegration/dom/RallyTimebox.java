package com.stevenckwong.ACWebServicesIntegration.dom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RallyTimebox {
	
	private String type;
	private String name;
	private String startDate;
	private String endDate;
	private String projectRef;
	
	public RallyTimebox() {
		this.type="uninitialised";
		this.name="uninitialised";
		this.startDate="uninitialised";
		this.endDate="uninitialised";
		this.projectRef="uninitialised";
	}
	
	public RallyTimebox(String timeboxType) {
		this.type = timeboxType;
		this.name = "uninitialised";
		this.startDate = "uninitialised";
		this.endDate = "uninitialised";
		this.projectRef = "uninitialised";
	}
	
	public RallyTimebox(String timeboxType, JSONObject json) {

		try {
			this.type = timeboxType;
			this.name = json.optString("Name");
			
			if (timeboxType.equalsIgnoreCase("iteration")) {
				this.startDate = json.optString("StartDate");
				this.endDate = json.optString("EndDate");
			} else if (timeboxType.equals("release")) {
				this.startDate = json.optString("ReleaseStartDate");
				this.endDate = json.optString("ReleaseDate");
			} else {
				this.startDate = "";
				this.endDate = "";
			}
			
			
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
	
	public String getJSON() {
		
		/** This is a sample JSON structure for Release 
		 * { 
			"Release": {
				"Name":"timebox name",
				"Notes":"timebox notes",
				"State":"Planning",
				"PlannedVelocity": 63.0,
				"ReleaseStartDate":"2018-04-13",
				"ReleaseDate":"2018-04-27",
				"Project": {
					"_ref": "https://rally1.rallydev.com/slm/webservice/v2.0/project/196111739164"
					}
				}		 
			}
		 * 
		 */
		
		
		JSONObject containerJSON = new JSONObject();
		JSONObject projectJSON = new JSONObject();
		JSONObject timeboxJSON = new JSONObject();

		
		projectJSON.put("_ref", this.getProjectRef());
		
		if (this.getType().equals("release")) {
			timeboxJSON.put("Name", this.getName());
			timeboxJSON.put("Notes", "created via Web Services call");
			timeboxJSON.put("State", "Planning");
			timeboxJSON.put("PlannedVelocity", 0);
			timeboxJSON.put("ReleaseStartDate", this.getStartDate());
			timeboxJSON.put("ReleaseDate", this.getEndDate());
			timeboxJSON.put("Project", projectJSON);
			containerJSON.put("Release",timeboxJSON);
		} else if (this.getType().equals("iteration")) {
			timeboxJSON.put("Name", this.getName());
			timeboxJSON.put("Notes", "created via Web Services call");
			timeboxJSON.put("State", "Planning");
			timeboxJSON.put("PlannedVelocity", 0);
			timeboxJSON.put("StartDate", this.getStartDate());
			timeboxJSON.put("EndDate", this.getEndDate());
			timeboxJSON.put("Project", projectJSON);
			containerJSON.put("Iteration",timeboxJSON);
		}
		
		return containerJSON.toString();

	}

	public String getProjectRef() {
		return projectRef;
	}

	public void setProjectRef(String projectRef) {
		this.projectRef = projectRef;
	}

}
