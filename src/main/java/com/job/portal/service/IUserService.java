package com.job.portal.service;

import com.job.portal.model.User;

public interface IUserService {
	
	User getUserDetails(String username,String password);
	
	int addUser(User user);

}
