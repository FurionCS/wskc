package org.cs.basic.test.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import junit.framework.Assert;

import org.cs.basic.test.util.AbstractDbUnitTestCase;
import org.dbunit.DatabaseUnitException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.wskc.dao.UserBrandPUserDao;
import com.wskc.dto.UserBrandPUserDto;
import com.wskc.model.UserBrandPUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestUserBrandPUserDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private UserBrandPUserDao userBrandPUserDao;
	@Before
	public void setUp() throws SQLException, IOException, DatabaseUnitException {
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
//		this.backupAllTable();
//		IDataSet ds = createDateSet("t_vote_info");
//		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon,ds);
	}
	
	@Test
	public void testGetUserBrandPUser(){
		List<UserBrandPUser> lubp=userBrandPUserDao.getUserBrandPUserByIndustry(1, 8);
		Assert.assertNotNull(lubp);
		Assert.assertEquals(1, lubp.size());
	}
	@Test
	public void testGetUBPUDAll(){
		List<UserBrandPUserDto> lubpd=userBrandPUserDao.getUBPUDAll(1);
		Assert.assertNotNull(lubpd);
	}
	
	@Test
	public void testGetUBPUByUB(){
		UserBrandPUser ubpu=userBrandPUserDao.getUBPUByUB(1, 1);
		Assert.assertNotNull(ubpu);
	}
	
	@Test
	public void testDeleteUBPU(){
		userBrandPUserDao.deleteUBPUByUB(1, 1);
	}
	@Test
	public void testUpdateubpu(){
		userBrandPUserDao.updateUBPUNum(2,5, -1);
	}
	@Test
	public void testGetUBPUDByP(){
		userBrandPUserDao.getUBPUDByP(1,"贴");
	}
	@After
	public void tearDown() throws Exception {
		SessionHolder holder = (SessionHolder) TransactionSynchronizationManager.getResource(sessionFactory);
		Session s = holder.getSession(); 
		s.flush();
		TransactionSynchronizationManager.unbindResource(sessionFactory);
//		this.resumeTable();
	}
}
