package com.job.portal.model;

public class UserEntity {
	private User user;
	private JobPortalError error;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public JobPortalError getError() {
		return error;
	}

	public void setError(JobPortalError error) {
		this.error = error;
	}

}
