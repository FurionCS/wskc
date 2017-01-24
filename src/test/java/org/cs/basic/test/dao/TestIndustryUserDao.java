package org.cs.basic.test.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.cs.basic.test.util.AbstractDbUnitTestCase;
import org.dbunit.DatabaseUnitException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.SessionHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionSynchronizationManager;


import com.wskc.dao.IndustryUserDao;
import com.wskc.dto.IndustryUserDto;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestIndustryUserDao extends AbstractDbUnitTestCase{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private IndustryUserDao industryUserDao;
	@Before
	public void setUp() throws SQLException, IOException, DatabaseUnitException {
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
//		this.backupAllTable();
//		IDataSet ds = createDateSet("t_vote_info");
//		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon,ds);
	}
	
	@Test
	public void testGetIndustryUserByUserId(){
		List<IndustryUserDto> liud=industryUserDao.getIndustryByUserId(1);
		Assert.assertNotNull(liud);
	}
	
	@Test
	public void testGetIndustryUserCountByUserId(){
		int num=industryUserDao.getIndustryUserNum(1);
		Assert.assertNotNull(num);
		Assert.assertEquals(1, num);
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
