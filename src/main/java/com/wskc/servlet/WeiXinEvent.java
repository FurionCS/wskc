package com.wskc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wskc.util.MessageUtil;
import com.wskc.util.WeixinSignUtils;

public class WeiXinEvent extends HttpServlet {

	/**
	 *
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // 微信加密签名  
        String signature = request.getParameter("signature");  
        // 时间戳  
        String timestamp = request.getParameter("timestamp");  
        // 随机数  
        String nonce = request.getParameter("nonce");  
        // 随机字符串  
        String echostr = request.getParameter("echostr");  
  
        PrintWriter out = response.getWriter();  
        // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败  
        if (WeixinSignUtils.checkSignature(signature, timestamp, nonce)) {  
            out.print(echostr);  
        }  
        out.close();  
        out = null;
	}

	/**
	 * 微信消息处理
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String respContent = "请求处理异常，请稍候尝试！";
		try {
			 // 默认返回的文本消息内容  
           
            System.out.println("进来了");
//			// xml请求解析  
            Map<String, String> requestMap=MessageUtil.parseXml(request);
            // 发送方帐号（open_id）  
            String fromUserName = requestMap.get("FromUserName");  
            System.out.println("openidopenid:"+fromUserName);
            // 公众帐号  
            String toUserName = requestMap.get("ToUserName");  
            // 消息类型  
            String msgType = requestMap.get("MsgType");  
            //事件类型
            String event=requestMap.get("Event");
            // 消息内容
            String content = requestMap.get("Content");
            //获得场景值
    		String encrypt = (String)requestMap.get("EventKey"); 
    		String openId = (String)requestMap.get("FromUserName"); 
    		System.out.println("事件类型："+event);
    		if(event.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
    			respContent = "快说你是程小胜的谁";
    			System.out.println("你好,Mr.Cheng");
    			//TODO 
    		//	response.sendRedirect("/weixin/authGz");
    		}else if(event.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)){
    			System.out.println("地理位置处理");
    		}
    		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("异常处理："+e.getMessage());
		}
		System.out.println("微信消息处理");
	}

}
