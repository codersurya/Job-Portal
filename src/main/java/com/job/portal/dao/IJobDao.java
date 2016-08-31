package com.job.portal.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.job.portal.model.Job;

public interface IJobDao {

	List<Job> getJobsAppliedByUser(int userID) throws DataAccessException;

	List<Job> getSelectedJobs(Object[] parameters)  throws DataAccessException;

}
