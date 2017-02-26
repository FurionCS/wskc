package com.wskc.config;

import com.alibaba.druid.util.DruidPasswordCallback;





import java.util.Properties;

import org.apache.commons.lang.StringUtils;
import org.cs.basic.util.SecurityUtil;

/**
 * 数据库密码回调解密
 */
@SuppressWarnings("serial")
public class DBPasswordCallback extends DruidPasswordCallback {

    public void setProperties(Properties properties) {
        super.setProperties(properties);
        String pwd = properties.getProperty("password");
        if (StringUtils.isNotBlank(pwd)) { 
            try {
                //这里的password是将jdbc.properties配置得到的密码进行解密之后的值
                //所以这里的代码是将密码进行解密
                // 将pwd进行解密;
                String password =  SecurityUtil.desEncrypt(pwd, "ABCE1234ABCD8765", "ABCE1234ABCD8765"); 
                System.out.println(password);
                setPassword(password.toCharArray());
            } catch (Exception e) {
                setPassword(pwd.toCharArray());
            }
        }
    }

    // 请使用该方法加密后，把密文写入classpath:/config/jdbc.properties
    public static void main(String[] args) throws Exception {
        System.out.println(SecurityUtil.encrypt("cs123456", "ABCE1234ABCD8765","ABCE1234ABCD8765"));
    }
}