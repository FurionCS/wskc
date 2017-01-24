package com.wskc.service;

import java.util.List;

import com.wskc.model.Resource;
import com.wskc.model.User;
/**
 * 
 * <p>Title:</p>
 * <p>Description:用户service接口</p>
 * @author Mr.Cheng
 * @date 2017年1月20日 上午9:45:31
 */
public interface UserService {
	/**
	 * 登入
	 * @param userName
	 * @param password
	 * @return
	 */
	User login(String userName,String password);
	/**
	 * 获得所有资源
	 * @param uid
	 * @return
	 */
	List<Resource> listAllResource(int uid);
	
	
}
