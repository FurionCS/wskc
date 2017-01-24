package com.wskc.dao.impl;

import java.util.List;

import org.cs.basic.dao.BaseDao;
import org.springframework.stereotype.Repository;

import com.wskc.dao.UserBrandPUserDao;
import com.wskc.dto.UserBrandPUserDto;
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

	@Override
	public List<UserBrandPUserDto> getUBPUDAll(int userId) {
		String sql="select ubp.id,ubp.user_id as 'userId',ubp.brand_id as 'brandId',ubp.brand_name as 'brandName',ubp.puser_id as 'puserId',ubp.auth_code as 'authCode',ubp.puser_remark as 'puserRemark',ubp.create_time as 'createTime',bi.industry_name as 'industryName' from t_user_brand_puser ubp,t_brand_info bi where bi.id=ubp.brand_id and ubp.user_id=?";
		return this.listBySql(sql, userId, UserBrandPUserDto.class, false);
	}

	@Override
	public List<UserBrandPUserDto> getUBPUDByIndustry(int userId, int industryId) {
		String sql="select ubp.id,ubp.user_id as 'userId',ubp.brand_id as 'brandId',ubp.brand_name as 'brandName',ubp.puser_id as 'puserId',ubp.auth_code as 'authCode',ubp.puser_remark as 'puserRemark',ubp.create_time as 'createTime',bi.industry_name as 'industryName' from t_user_brand_puser ubp,t_brand_info bi where bi.id=ubp.brand_id and ubp.user_id=? and bi.industry_id=?";
		return this.listBySql(sql, new Object[]{userId,industryId}, UserBrandPUserDto.class, false);
	}

	@Override
	public UserBrandPUser getUBPUByUB(int userId, int brandId) {
		String hql="from UserBrandPUser where userId=? and brandId=?";
		return (UserBrandPUser) this.queryObject(hql,new Object[]{userId,brandId});
	}

	@Override
	public UserBrandPUser getUBPUByCode(String authCode) {
		String hql="from UserBrandPUser where authCode=?";
		return (UserBrandPUser) this.queryObject(hql,authCode);
	}

}
