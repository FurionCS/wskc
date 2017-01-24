package com.wskc.dao.impl;

import java.util.List;

import org.cs.basic.dao.BaseDao;
import org.springframework.stereotype.Repository;

import com.wskc.dao.UserBrandPUserDao;
import com.wskc.model.UserBrandPUser;
/**
 * 
 * <p>Title:</p>
 * <p>Description:用户品牌上家实现</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:29:22
 */
@Repository("userBrandPUserDao")
public class UserBrandPUserDaoImpl extends BaseDao<UserBrandPUser> implements UserBrandPUserDao{

	@Override
	public List<UserBrandPUser> getUserBrandPUserByIndustry(int userId, int industryId) {
		String hql="from UserBrandPUser where userId=? and brandId in (select id from Brand where industryId=?)";
		return this.list(hql, new Object[]{userId,industryId});
	}

}
