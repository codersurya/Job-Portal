package com.job.portal.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import com.job.portal.dao.IJobDao;
import com.job.portal.exception.JobPortalException;
import com.job.portal.model.Job;
import com.job.portal.model.User;

public class JobServiceImpl implements IJobService {
	
	private static final Logger logger = LoggerFactory.getLogger(JobServiceImpl.class);
	
	private IJobDao jobDao;

	@Override
	public List<Job> getJobsAppliedByUser(User user) {
		try {
			return jobDao.getJobsAppliedByUser(user.getUserID());
		} catch (DataAccessException dae) {
			logger.error("Error occured while getting the Applied jobs by the User:"+user.getFullname()+" ",dae);
			throw new JobPortalException("An InternalError occured while getting the Applied jobs by the User");
		}
	}

	@Override
	public List<Job> searchJobs(String keyword) {
		try {
			String parameter= "%"+keyword+"%";
			return jobDao.getSelectedJobs(new Object[] {parameter,parameter });
		} catch (DataAccessException dae) {
			logger.error("Error Occured while Searching the Jobs", dae);
			throw new JobPortalException("An Internal Error Occured while Searching the Jobs");
		}
	}

	public IJobDao getJobDao() {
		return jobDao;
	}

	public void setJobDao(IJobDao jobDao) {
		this.jobDao = jobDao;
	}

}
