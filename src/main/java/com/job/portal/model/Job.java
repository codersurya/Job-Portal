package com.job.portal.model;

import java.io.Serializable;

public class Job implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String jobID;
	private String jobTitle;
	private String jobDesc;
	private String jobLink;
	private String companyName;
	private String location;
	

	public String getJobID() {
		return jobID;
	}

	public void setJobID(String jobID) {
		this.jobID = jobID;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public String getJobLink() {
		return jobLink;
	}

	public void setJobLink(String jobLink) {
		this.jobLink = jobLink;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	

}
