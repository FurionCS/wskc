package com.wskc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wskc.dao.UserBrandPUserDao;
import com.wskc.model.UserBrandPUser;
import com.wskc.service.UserBrandPUserService;
/**
 * 
 * <p>Title:</p>
 * <p>Description:用户品牌上家</p>
 * @author Mr.Cheng
 * @date 2017年1月23日 下午4:02:06
 */
@Service("userBrandPUserService")
public class UserBrandPUserServiceImpl implements UserBrandPUserService{

	@Autowired
	private UserBrandPUserDao userBrandPUserDao;
	@Override
	public List<UserBrandPUser> getUserBrandPUserByIndustry(int userId,
			int industryId) {
		return userBrandPUserDao.getUserBrandPUserByIndustry(userId, industryId);
	}

}
