package org.cs.basic.test.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

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

import com.wskc.dao.IndustryDao;
import com.wskc.dao.SoleDao;
import com.wskc.service.IndustryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml","classpath:/applicationContext-redis.xml"})
public class TestSoleDao extends AbstractDbUnitTestCase{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private SoleDao soleDao;
	@Before
	public void setUp() throws SQLException, IOException, DatabaseUnitException {
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
//		this.backupAllTable();
//		IDataSet ds = createDateSet("t_vote_info");
//		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon,ds);
	}
	
	
	@Test
	public void testGetUPSSZ(){
		System.out.println(soleDao.getUserProudctSoleStratusZ(1, 3));
	}
	
	@Test
	public void testCode(){
		String code=Long.toHexString(new Date().getTime());
		System.out.println(code);
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
