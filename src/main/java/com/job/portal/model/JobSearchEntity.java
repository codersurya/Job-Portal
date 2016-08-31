package com.job.portal.model;

import java.io.Serializable;
import java.util.List;

public class JobSearchEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Job> jobs;
	private JobPortalError error;

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	public JobPortalError getError() {
		return error;
	}

	public void setError(JobPortalError error) {
		this.error = error;
	}

}
