package com.job.portal.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.util.CollectionUtils;

import com.job.portal.model.User;
import com.job.portal.sql.IJobPoralSQL;

public class UserDaoImpl extends SimpleJdbcDaoSupport implements IUserDao {

	private HibernateTemplate hibernateTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jobportal.dao.ILoginDao#getUserDetails(java.lang.Object[])
	 */
	@Override
	public User getUserDetails(Object[] parameters) {
		List<User> users = getJdbcTemplate().query(
				IJobPoralSQL.GET_USER_DETAILS, parameters,
				ParameterizedBeanPropertyRowMapper.newInstance(User.class));
		return CollectionUtils.isEmpty(users) ? null : users.get(0);
	}

	@Override
	public int insertUser(User user) {
		SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(user);
		return getSimpleJdbcTemplate().update(IJobPoralSQL.INSERT_USER,sqlParameterSource);
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
