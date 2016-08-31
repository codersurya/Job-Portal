package com.job.portal.service;

import junit.framework.TestCase;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.job.portal.model.User;


public class TestUserService extends TestCase {
	
	private static ApplicationContext applicationContext = null;
	
	private IUserService userService;
	
	/**
	 * Loads spring application context.
	 */
	@Before(value = "")
	public void setUp() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext("/applicationContext-test.xml");
		userService = (IUserService) applicationContext.getBean("userService");
	}
	
	@Test
	public void testGetUserDetails(){
		String username="gmanmadh";
		String password="mogly";
		userService=new UserServiceImpl();
		User user=userService.getUserDetails(username, password);
		System.out.println("User Full Name is:"+user.getFullname());
		System.out.println("User Email is:"+user.getEmail());
		
	}

}
