package com.job.portal.dao;

import java.util.List;

import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.job.portal.model.Job;
import com.job.portal.sql.IJobPoralSQL;

public class JobDaoImpl extends JdbcDaoSupport implements IJobDao {

	@Override
	public List<Job> getJobsAppliedByUser(int userID) {
		return getJdbcTemplate().query(IJobPoralSQL.GET_JOBS_APPLIED_BY_USER, new Object[]{userID},ParameterizedBeanPropertyRowMapper.newInstance(Job.class));
	}

	@Override
	public List<Job> getSelectedJobs(Object[] parametrs) {
		return getJdbcTemplate().query(IJobPoralSQL.GET_JOBS, parametrs,ParameterizedBeanPropertyRowMapper.newInstance(Job.class));
	}

}
