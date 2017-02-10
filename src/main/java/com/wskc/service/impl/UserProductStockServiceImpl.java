package com.wskc.service.impl;

import java.util.Date;
import java.util.List;

import org.cs.basic.model.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wskc.dao.ProductAllocationDao;
import com.wskc.dao.ProductDao;
import com.wskc.dao.SoleDao;
import com.wskc.dao.UserProductStockDao;
import com.wskc.dto.ProductAgentDto;
import com.wskc.dto.ProductAgentInfoDto;
import com.wskc.dto.ProductAgentTree;
import com.wskc.dto.ProductDto;
import com.wskc.dto.ProductStockWarnDto;
import com.wskc.dto.UserProductDto;
import com.wskc.model.BasicException;
import com.wskc.model.UserProductStock;
import com.wskc.service.UserProductStockService;

/**
 * 
 * <p>Title:</p>
 * <p>Description:用户产品库存</p>
 * @author Mr.Cheng
 * @date 2017年1月30日 下午2:46:31
 */
@Service("userProductStockSerice")
public class UserProductStockServiceImpl implements UserProductStockService {
	
	@Autowired
	private UserProductStockDao userProductStockDao;
	
	@Autowired
	private SoleDao soleDao;
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private ProductAllocationDao productAllocationDao;

	@Override
	public Pager<UserProductDto> findUserProductStock(
			int userId, int brandId) {
		return userProductStockDao.findUserProductStock(userId, brandId);
	}

	@Override
	public Integer getUserProductNum(int userId, int brandId) {
		return userProductStockDao.getUserProductNum(userId, brandId);
	}

	@Override
	public UserProductDto showUserProductStock(int stockId) {
		return userProductStockDao.showUserProductStock(stockId);
	}

	@Override
	public void updateUserProductStatus(int stockId, int status) {
		if(status==0){  //如果原来是停用
			status=1;   //修改为启用
		}else{
			status=0;
		}
		 userProductStockDao.updateUserProductStatus(stockId, status);
	}

	@Override
	public UserProductStock addUserProductStock(
			UserProductStock userProductStock) {
		userProductStock.setStatus(1);
		userProductStock.setCreateTime(new Date());
		userProductStock.setModifyTime(new Date());
		ProductDto productDto=productDao.getProductDto(userProductStock.getProductId());
		userProductStock.setBrandId(productDto.getBrandId());
		userProductStock.setBrandName(productDto.getBrandName());
		userProductStock.setProductName(productDto.getName() );
		return userProductStockDao.add(userProductStock);
	}

	@Override
	public List<UserProductDto> getUserProductByq(int userId,
			 String str) {
		List<UserProductDto> lupd=userProductStockDao.getUserProductByq(userId, str);
		for(UserProductDto upd:lupd){
			int soleNum=soleDao.getUserProudctSoleStratusZ(upd.getUserId(), upd.getProductId());
			int allocationz=productAllocationDao.getAllocationStratusZ(upd.getUserId(), upd.getProductId(), "调出");
			upd.setSoleNum(upd.getNum()-soleNum-allocationz);
		}
		return lupd;
	}

	@Override
	public Pager<UserProductDto> findUserProductStockForSerach(int userId,
			String str) {
		Pager<UserProductDto> pupd=userProductStockDao.findUserProductStockForSerach(userId, str);
		for(UserProductDto upd:pupd.getDatas()){
			int soleNum=soleDao.getUserProudctSoleStratusZ(upd.getUserId(), upd.getProductId());
			int allocationz=productAllocationDao.getAllocationStratusZ(upd.getUserId(), upd.getProductId(), "调出");
			upd.setSoleNum(upd.getNum()-soleNum-allocationz);
		}
		return pupd;
	}

	@Override
	public UserProductStock getUserProductStock(int userId, int productId) {
		return userProductStockDao.getUserProductStock(userId, productId);
	}

	@Override
	public List<ProductAgentDto> getProductAgentDto(int brandId, int userId,
			int productId) {
		if(brandId<0||userId<1){
			throw new BasicException("品牌id,用户id,不能为空");
		}
		return userProductStockDao.getProductAgentDto(brandId, userId, productId);
	}

	@Override
	public Pager<ProductAgentInfoDto> findProductAgentInfoDto(int brandId,
			int userId, int productId) {
		if(brandId<1||userId<1||productId<1){
			return null;
		}else{
			return userProductStockDao.findProductAgentInfoDto(brandId, userId, productId);
		}
	}

	@Override
	public List<ProductAgentTree> listProductAgentTree(int brandId, int userId,
			int productId) {
		if(brandId<1||userId<1||productId<1){
			return null;
		}else{
			List<ProductAgentTree> lpat=userProductStockDao.listProductAgentTree(brandId, userId, productId);
			for(ProductAgentTree pat:lpat){
				pat.setPid(userId);
				pat.setName(pat.getName()+"(库存:"+pat.getNum()+")");
				if(pat.getAgentNum()>0){
					pat.setIsParent("true");
				}else{
					pat.setIsParent("false");
					pat.setIcon("../resources/css/tree/img/diy/11.png");
				}
			}
			return lpat;
		}
	}

	@Override
	public List<ProductStockWarnDto> listProductStockWarn(int userId) {
		return userProductStockDao.listProductStockWarn(userId);
	}

	@Override
	public boolean updateProductStockWarn(int stockId, int warnNum) {
		UserProductStock ups=userProductStockDao.load(stockId);
		if(ups!=null){
			ups.setWarnNum(warnNum);
			userProductStockDao.update(ups);
		}
		return true;
	}

}
