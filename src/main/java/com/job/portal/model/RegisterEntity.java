package com.job.portal.model;

import java.io.Serializable;

public class RegisterEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean isUserAdded;
	private JobPortalError error;

	public boolean isUserAdded() {
		return isUserAdded;
	}

	public void setUserAdded(boolean isUserAdded) {
		this.isUserAdded = isUserAdded;
	}

	public JobPortalError getError() {
		return error;
	}

	public void setError(JobPortalError error) {
		this.error = error;
	}

}
