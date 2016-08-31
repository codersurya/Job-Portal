package com.job.portal.service;

import java.sql.SQLIntegrityConstraintViolationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import com.job.portal.dao.IUserDao;
import com.job.portal.exception.JobPortalException;
import com.job.portal.exception.UnAuthorizedAccessException;
import com.job.portal.model.User;

public class UserServiceImpl implements IUserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	private IUserDao userDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jobportal.service.IUserService#getUserDetails(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public User getUserDetails(String username, String password) {
		try {
			User user = userDao.getUserDetails(new Object[] { username,password });
			if (user != null) {
				return user;
			} else {
				logger.error("There is no user in Database with the specified Username and password.");
				throw new UnAuthorizedAccessException("Invalid Username or Password.");
			}
		} catch (DataAccessException dae) {
			logger.error("Error Occured while logging into the Job portal Application:"+ dae);
			throw new JobPortalException("Internal Error occured while logging into the Application");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jobportal.service.IUserService#addUser(com.jobportal.dto.User)
	 */
	@Override
	public int addUser(User user) {
		try {
			return userDao.insertUser(user);
		} catch (DataAccessException dae) {
			logger.error("Error Occured while adding a new User to the database",dae);
			throw new JobPortalException("An Internal Error Occured while adding a User to the Database");
		}
	}

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

}
