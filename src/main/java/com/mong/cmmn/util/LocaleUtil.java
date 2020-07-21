package com.mong.cmmn.util;

import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class LocaleUtil {
	public static Locale getDefaultLocale() {
		return Locale.KOREAN;
	}
	
	public static Locale getLocale(HttpServletRequest request) {
		Locale locale = null;
		HttpSession session = request.getSession();
		locale = (Locale)session.getAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME);
		
		if (locale == null) {
			locale = getDefaultLocale();
		}
		
		return locale;
	}
}
