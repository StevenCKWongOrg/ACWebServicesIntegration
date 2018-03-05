package com.stevenckwong.ACWebServicesIntegration.dom;

import java.util.ArrayList;

public class RallyTestResult {
	
	private String objectID;
	private String formattedID;
	private String dateString;
	private String verdict;
	private String notes;
	private String build;
	private String testSetID;
	private String duration;
	private ArrayList attachments;
		
	public RallyTestResult() {
		
		this.objectID = "uninitialised";
		this.formattedID = "uninitialised";
		this.dateString = "uninitialised";
		this.verdict = "uninitialised";
		this.notes = "uninitialised";
		this.build = "uninitialised";
		this.testSetID = "uninitialised";
		this.duration = "uninitialised";
		this.attachments = new ArrayList();
		
	}

	public RallyTestResult(String JSONresult) {
		// populate the object from a JSON object.
		this.objectID = "";
		this.formattedID = "";
		this.dateString = "";
		this.verdict = "";
		this.notes = "";
		this.build = "";
		this.testSetID = "";
		this.duration = "";
		this.attachments = new ArrayList();
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

	public String getDateString() {
		return dateString;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public String getVerdict() {
		return verdict;
	}

	public void setVerdict(String verdict) {
		this.verdict = verdict;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getBuild() {
		return build;
	}

	public void setBuild(String build) {
		this.build = build;
	}

	public String getTestSetID() {
		return testSetID;
	}

	public void setTestSetID(String testSetID) {
		this.testSetID = testSetID;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public ArrayList getAttachments() {
		return attachments;
	}

	public void setAttachments(ArrayList attachments) {
		this.attachments = attachments;
	}
	
	public void addAttachment(String attachmentID) {
		this.attachments.add(attachmentID);
	}
	
	public String getAttachment(String id) {
		// find the attachment and return it.
		
		return new String();
	}

	public String toJSON() {
		String jsonRepresentation = new String();
		
		return jsonRepresentation;
	}

}
