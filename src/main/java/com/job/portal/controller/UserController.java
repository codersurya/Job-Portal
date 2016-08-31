package com.job.portal.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.job.portal.model.JobPortalError;
import com.job.portal.model.JobSearchEntity;
import com.job.portal.model.RegisterEntity;
import com.job.portal.model.User;
import com.job.portal.model.UserEntity;
import com.job.portal.service.IJobService;
import com.job.portal.service.IUserService;

/**
 * Handles requests for the Employee service.
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	@Autowired
	private IJobService jobService;

	private static final Logger USER_LOGGER = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public UserEntity authenticateEmployee(final @RequestBody User user) {
		UserEntity entity = new UserEntity();
		try {
			entity.setUser(userService.getUserDetails(user.getUsername(),
					user.getPassword()));
		} catch (RuntimeException e) {
			JobPortalError jpe = new JobPortalError();
			jpe.setMessage(e.getMessage());
			entity.setError(jpe);
		}
		return entity;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public RegisterEntity registerEmployee(final @RequestBody User user) {
		RegisterEntity registerEntity=new RegisterEntity();
		try {
			int rowsReflected = userService.addUser(user);
			if (rowsReflected > 0) {
				registerEntity.setUserAdded(true);
			}
		} catch (RuntimeException re) {
				JobPortalError jpe=new JobPortalError();
				jpe.setMessage(re.getMessage());
				registerEntity.setError(jpe);
		}
		return registerEntity;
	}

	@RequestMapping(value = "/jobsearch/{keyword}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public JobSearchEntity searchJobs(@PathVariable final String keyword) {
		JobSearchEntity jobSearchEntity = new JobSearchEntity();
		try {
			jobSearchEntity.setJobs(jobService.searchJobs(keyword));
		} catch (RuntimeException re) {
			JobPortalError jpe = new JobPortalError();
			jpe.setMessage(re.getMessage());
			jobSearchEntity.setError(jpe);
		}
		return jobSearchEntity;
	}
}

