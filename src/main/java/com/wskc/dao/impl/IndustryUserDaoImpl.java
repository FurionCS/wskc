package com.wskc.dao.impl;

import java.util.List;

import org.cs.basic.dao.BaseDao;
import org.springframework.stereotype.Repository;

import com.wskc.dao.IndustryUserDao;
import com.wskc.dto.IndustryUserDto;
import com.wskc.model.Industry;
import com.wskc.model.IndustryUser;

/**
 * 
 * <p>Title:</p>
 * <p>Description:行业用户</p>
 * @author Mr.Cheng
 * @date 2017年1月22日 下午2:33:08
 */
@Repository("industryUserDao")
public class IndustryUserDaoImpl extends BaseDao<IndustryUser> implements IndustryUserDao{

	@Override
	public List<IndustryUserDto> getIndustryByUserId(int userId) {
		String sql=" select iu.id as 'industryUserId',iu.industry_id as 'industryId',iu.modify_time as 'modifyTime',iu.create_time as 'createTime',iu.modify_num as 'modifyNum',iu.user_id as 'userId',ii.`name` as 'industryName' from t_industry_user iu,t_industry_info ii where iu.industry_id=ii.id and iu.user_id=?";
		return this.listBySql(sql, userId, IndustryUserDto.class, false);
	}

	@Override
	public int getIndustryUserNum(int userId) {
		String sql="select count(id) from t_industry_user iu where iu.user_id=?";
		return this.getCountSql(sql, userId);
	}

	@Override
	public IndustryUser getIndustryUserByUI(int userId, int industryId) {
		String hql="from IndustryUser where userId=? and industryId=?";
		return (IndustryUser) this.queryObject(hql,new Object[]{userId,industryId});
	}

	@Override
	public void deleteIndustryUserByUI(int userId, int industryId) {
		String hql="delete from IndustryUser where userId=? and industryId=?";
		this.updateByHql(hql,new Object[]{userId,industryId});
	}

}
