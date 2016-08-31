package com.job.portal.dao;

import org.springframework.dao.DataAccessException;

import com.job.portal.model.User;

public interface IUserDao {
	
	User getUserDetails(Object[] parameters) throws DataAccessException;
	
	int insertUser(User user) throws DataAccessException;
	
}
