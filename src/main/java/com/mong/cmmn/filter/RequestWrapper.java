package com.mong.cmmn.filter;

import com.mong.cmmn.util.StringUtil;
import org.apache.log4j.Logger;
import javax.servlet.http.*;

public class                                                                                                                                                                         RequestWrapper extends HttpServletRequestWrapper {

	static Logger log = Logger.getLogger(RequestWrapper.class);

	private HttpServletResponse response = null;

	public RequestWrapper(HttpServletRequest servletRequest) {
		super(servletRequest);
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public String[] getParameterValues(String parameter) {       

		String[] values = super.getParameterValues(parameter);       

		if (values==null)  {                  
			return null;          
		}
	  
		int count = values.length;      
	  
		String[] encodedValues = new String[count];  
	  
		for (int i = 0; i < count; i++) {                
			encodedValues[i] = cleanXSS(values[i]);        
		}       
	  
		return encodedValues;    
	}     
	  
	public String getParameter(String parameter) {           

		String value = super.getParameter(parameter);           
	  
		if (value == null) {                  
	   
			return null;                   
	   
		}           
	  
		return cleanXSS(value);     
	  
	}     
	 
	public String getHeader(String name) {         
	 
		String value = super.getHeader(name);         
	  
		if (value == null){             
			return null;         
		}
	   
		return cleanXSS(value);     
	}     
	 
	private String cleanXSS(String value) {

		 //You'll need to remove the spaces from the html entities below
		 //System.out.println("You'll need to remove the spaces from the html entities below ");
		 //System.out.println(value);
  
		 //value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
		 
		 //value = StringUtil.cleanScript(value);
		 //value = StringUtil.stripXSS(value);
  	   
		 return value;

	  
	}
/*
	public HttpSession getSession() {
		HttpSession session = super.getSession();
		processSessionCookie(session);
		return session;
	}

	public HttpSession getSession(boolean create) {
	 	HttpSession session = super.getSession(create);
		processSessionCookie(session);
		return session;
	}

	private void processSessionCookie(HttpSession session) {
		if (session == null || response == null) {
			return;
		}

		try {
			log.info("==================================== RequestWrapper =====================================");
			log.info("getRequestURI : " + getRequestURI());
			log.info("getRequestURL : " + getRequestURL());

			Object cookieOverWritten = getAttribute("COOKIE_OVERWRITTEN_FLAG");

			log.info(cookieOverWritten);
			log.info("isSecure : " + isSecure());
			log.info("isRequestedSessionIdFromCookie : " + isRequestedSessionIdFromCookie());
			log.info("session.isNew : " + session.isNew());

			if (cookieOverWritten == null
					&& session.isNew()) {

				Cookie cookie = new Cookie("JSESSIONID", session.getId());
				cookie.setMaxAge(-1);
				String contextPath = getContextPath();
				cookie.setSecure(!isSecure());

				if (contextPath != null && contextPath.length() > 0) {
					cookie.setPath(contextPath);
				} else {
					cookie.setPath("/");
				}

				log.info("secure : " + cookie.getSecure());
				log.info("path : " + cookie.getPath());
                log.info(cookie);

				response.addCookie(cookie);
				setAttribute("COOKIE_OVERWRITTEN_FLAG", "true");
			}

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	*/
}
