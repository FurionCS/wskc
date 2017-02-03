package com.wskc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wskc.util.MessageUtil;

public class WeiXinEvent extends HttpServlet {

	/**
	 *
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * 微信消息处理
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			 // 默认返回的文本消息内容  
            String respContent = "请求处理异常，请稍候尝试！";
			// xml请求解析  
            Map<String, String> requestMap=MessageUtil.parseXml(request);
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            System.out.println("openidopenid:"+fromUserName);
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
            // 消息内容
            String content = requestMap.get("Content");
            //获得场景值
    		String encrypt = (String)requestMap.get("EventKey"); 
    		String openId = (String)requestMap.get("FromUserName"); 
    		
    		if(msgType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
    			respContent = "快说你是程小胜的谁";
    			System.out.println("你好,Mr.Cheng");
    			//TODO 
    		}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("微信消息处理");
	}

}
