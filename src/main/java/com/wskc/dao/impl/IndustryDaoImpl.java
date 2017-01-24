package com.wskc.dao.impl;

import java.util.List;

import org.cs.basic.dao.BaseDao;
import org.springframework.stereotype.Repository;

import com.wskc.dao.IndustryDao;
import com.wskc.model.Industry;
/**
 * 
 * <p>Title:</p>
 * <p>Description:行业</p>
 * @author Mr.Cheng
 * @date 2017年1月22日 下午4:32:53
 */
@Repository("industryDao")
public class IndustryDaoImpl extends BaseDao<Industry> implements IndustryDao{

	@Override
	public List<Industry> getIndustryList() {
		String hql="from Industry";
		return this.list(hql);
	}

	@Override
	public void updateIndustryUserNum(int num,int industryId) {
		String hql="update Industry set userNum=userNum+? where id=?";
		this.updateByHql(hql, new Object[]{num,industryId});
	}
}
