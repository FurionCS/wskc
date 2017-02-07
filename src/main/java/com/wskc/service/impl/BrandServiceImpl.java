package com.wskc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wskc.dao.BrandDao;
import com.wskc.dao.IndustryDao;
import com.wskc.dao.IndustryUserDao;
import com.wskc.dto.IndustryUserDto;
import com.wskc.model.Brand;
import com.wskc.model.Industry;
import com.wskc.service.BrandService;
/**
 * 
 * <p>Title:</p>
 * <p>Description:品牌</p>
 * @author Mr.Cheng
 * @date 2017年1月24日 下午9:09:40
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService{
	@Autowired
	private BrandDao brandDao;

	@Autowired
	private IndustryDao industryDao;
	
	@Autowired
	private IndustryUserDao indsutryUserDao;
	@Override
	public List<Brand> getBrandSerach(String industrys,String str) {
		// 查询品牌列表
		return	brandDao.getBrandSerach(industrys,str);
	}

	@Override
	public int addBrandToPublic(Brand brand) {
		//先判断该用户是否有该行业
		List<IndustryUserDto> li=indsutryUserDao.getIndustryByUserId(brand.getCreaterId());
		boolean isHave=false;
		for(IndustryUserDto iud: li){
			if(iud.getIndustryId()==brand.getIndustryId()){
				isHave=true;
				break;
			}
		}
		//有就获取行业名称添加
		if(isHave){
			Industry industry=industryDao.load(brand.getIndustryId());
			brand.setIndustryName(industry.getName());
			brandDao.add(brand);
			
			return 	1;
		}else{
			return -1;
		}
	}
}
