package com.mandala.core.interceptors;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jeecgframework.p3.cg.util.HttpsGetUtil;
import org.jeecgframework.p3.core.logger.Logger;
import org.jeecgframework.p3.core.logger.LoggerFactory;
import org.jeecgframework.p3.core.utils.common.PageQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.jeecg.p3.system.vo.LoginUser;
import com.mandala.doctor.entity.SysUserinfo;
import com.mandala.patient.entity.ZyEmrBasy;
import com.mandala.system.vo.LoginUserNew;

public class FrontInterceptor
  implements HandlerInterceptor
{
  public static final Logger logger = LoggerFactory.getLogger(FrontInterceptor.class);
  private List<String> excludeUrls;
  private String mode;
  @Value("#{sysconfig['appid']}")
  private String appid;
  
  @Value("#{sysconfig['secret']}")
  private String secret;
  
  @Value("#{sysconfig['jwid']}")
  private String jwid;

  @Value("#{sysconfig['jlbid']}")
  private String jlbid;
  
  @Value("#{sysconfig['nosubscrible.page']}")
  private String page;  
  
  public List<String> getExcludeUrls()
  {
    return this.excludeUrls;
  }

  public void setExcludeUrls(List<String> excludeUrls) {
    this.excludeUrls = excludeUrls;
  }

  public String getMode() {
    return this.mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)
    throws Exception
  {
  }

  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
    throws Exception
  {
  }

  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object)
    throws Exception
  {
    if ("DEV".equals(this.mode)) {
      return true;
    }
    String requestPath = getRequestPath(request);
    String code = request.getParameter("code");
    if(code !=null){
    	String a ="";
    	a ="1";
    }
    String basePath = request.getContextPath();
    request.setAttribute("basePath", basePath);
    if (this.excludeUrls.contains(requestPath))
    {
      return true;
    }
    if ((requestPath != null) && (requestPath.indexOf(".html") > -1)) {
      if ((requestPath != null) && (requestPath.indexOf("/back/") > -1)) {
    	  LoginUser user = (LoginUser)request.getSession().getAttribute("OPERATE_WEB_LOGIN_USER");
          //张亮增加
          ZyEmrBasy patient = (ZyEmrBasy)request.getSession().getAttribute("PATIENT_LOGIN_USER");
          SysUserinfo doctor = (SysUserinfo) request.getSession().getAttribute("DOCTOR_LOGIN_USER");
          LoginUserNew userNew = (LoginUserNew) request.getSession().getAttribute("LOGIN_USER");
          if (user == null && patient== null && doctor==null && userNew==null) {
            String url = basePath + "/system/login.html";
            response.sendRedirect(url);
            return false;
          }
        return true;
      }
     
      return true;
    }
    return true;
  }

  private String getRequestPath(HttpServletRequest request)
  {
    String requestPath = request.getRequestURI();
    requestPath = requestPath.substring(request.getContextPath().length() + 1);
    return requestPath;
  }

	public String getRequestUrlWithParams(HttpServletRequest request) {
		// TODO Auto-generated method stub
	   	  String backurl = request.getScheme()+"://"+request.getServerName()+request.getRequestURI();
	   	  if(request.getQueryString() !=null){
	   		backurl = backurl+"?"+request.getQueryString();
	   	  }
	   	try {
			backurl = URLEncoder.encode(backurl, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   	  return backurl;
	}
 
}