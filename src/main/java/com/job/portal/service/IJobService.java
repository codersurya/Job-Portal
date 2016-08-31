package com.job.portal.service;

import java.util.List;

import com.job.portal.model.Job;
import com.job.portal.model.User;

public interface IJobService {

	List<Job> getJobsAppliedByUser(User user);
	
	List<Job> searchJobs(String keyword);
	
}
