package com.mandala.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;




import com.mandala.util.LogUtil;


public class TimerListener implements ServletContextListener{  
    public TimerListener(){  
    }  

    //这个方法在ServletContext将要关闭的时候调用  
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    //该方法在ServletContext启动之后调用，并准备好处理客户端请求  
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		  LogUtil.info("===================启动监听 开始===================");
 
		  LogUtil.info("===================启动监听 结束===================");
	}  
} 
