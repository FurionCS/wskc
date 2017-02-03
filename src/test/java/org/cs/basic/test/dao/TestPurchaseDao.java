package org.cs.basic.test.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import junit.framework.Assert;

import org.cs.basic.model.Pager;
import org.cs.basic.test.util.AbstractDbUnitTestCase;
import org.cs.basic.util.DateUtils;
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

import com.wskc.dao.PurchaseDao;
import com.wskc.dto.PurchaseDto;
import com.wskc.model.Purchase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class TestPurchaseDao extends AbstractDbUnitTestCase{
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private PurchaseDao purchaseDao;
	
	@Before
	public void setUp() throws SQLException, IOException, DatabaseUnitException {
		Session s = sessionFactory.openSession();
		TransactionSynchronizationManager.bindResource(sessionFactory, new SessionHolder(s));
//		this.backupAllTable();
//		IDataSet ds = createDateSet("t_vote_info");
//		DatabaseOperation.CLEAN_INSERT.execute(dbunitCon,ds);
	}
	
	@Test
	public void testPurchaseNo(){
		System.out.println(DateUtils.stringOfDate(new Date()).replace("-", ""));
	}
	
	@Test
	public void testFindPurchaseList(){
		Pager<Purchase> pp=purchaseDao.findPurchaseList(1, "艾");
		Assert.assertNotNull(pp);
		Assert.assertEquals(3, pp.getSize());
	}
	
	@Test
	public void testGetPurchaseDtoById(){
		PurchaseDto pd=purchaseDao.getPurchaseDtoById(1);
		Assert.assertNotNull(pd);
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
