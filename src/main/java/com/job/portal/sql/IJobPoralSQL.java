package com.job.portal.sql;

public interface IJobPoralSQL {
	
	String GET_USER_DETAILS = "select iUserId userID,vcName fullname,vcuserName username,vcEmail email,vcMobile mobile from tbl_Users where vcuserName=? and vcPassword=sha1(?)";
	
	String INSERT_USER = new StringBuilder().append("insert into tbl_Users ")
									.append(" (vcName,vcUserName,vcPassword,vcEmail,vcMobile) values ")
									.append("(:fullname,:username,sha1(:password),:email,:mobile) ").toString();
	
	String GET_JOBS_APPLIED_BY_USER=new StringBuilder().append("select job.vcJobTitle jobTitle,job.vcJobDesc jobDesc,job.vcJobLink jobLink from tbl_Applied_Jobs appliedjobs  ")
									.append("join tbl_Jobs job on job.iJobID=appliedjobs.iUserId ")
									.append(" where appliedjobs.iUserId=? ").toString();
	
	String GET_JOBS="select vcJobTitle jobTitle,vcJobDesc jobDesc,vcJobLink jobLink,vcLocation location from tbl_Jobs where  ((upper(vcJobTitle) like ?) or (upper(upper(vcJobDesc) like ?)))";
	
String IS_USER_NAME_AVILABLE="select vcUserName from tbl_Users where vcUserName =?  ";

}
