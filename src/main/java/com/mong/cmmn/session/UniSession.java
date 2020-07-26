package com.mong.cmmn.session;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.mong.cmmn.util.NumberUtil;

public class UniSession {
	
	static Logger log = Logger.getLogger(UniSession.class);
	
	public static Object getSessionAttribute(HttpSession session, String attrName) {
		return session.getAttribute(attrName);
	}

    public static Object getSessionAttribute(String attrName){
        return RequestContextHolder.getRequestAttributes().getAttribute(attrName, RequestAttributes.SCOPE_SESSION);
    }
    
    public static void setSessionAttribute(String attrName, Object attrValue) {
        RequestContextHolder.getRequestAttributes().setAttribute(attrName, attrValue, RequestAttributes.SCOPE_SESSION);
    }

    public static LoginUserSession getLoginUserSession() {
    	return (LoginUserSession)getSessionAttribute("user");
    }

    public static String getLoginUserId(){
    	LoginUserSession loginUserSession = UniSession.getLoginUserSession();

        return loginUserSession == null ? null : loginUserSession.getUserId();
    }

    public static int getLoginUserIdx(){
    	LoginUserSession loginUniSession = UniSession.getLoginUserSession();

        return loginUniSession == null ? 0 : NumberUtil.toInt(loginUniSession.getUserIdx());
    }

    public static int getLoginMgIdx(){
    	LoginUserSession loginUniSession = UniSession.getLoginUserSession();

        return loginUniSession == null ? 0 : NumberUtil.toInt(loginUniSession.getUserGroup());
    }

    public static String getLoginUserName(){
    	LoginUserSession loginUniSession = UniSession.getLoginUserSession();

        return loginUniSession == null ? null : loginUniSession.getUserName();
    }

    public static boolean isLogined(){
    	LoginUserSession loginInfo = getLoginUserSession();

        return loginInfo == null ? false : true;
    }

    public static boolean isNotLogined() {
        return !isLogined();
    }

    
}
