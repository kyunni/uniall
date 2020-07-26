package com.mong.uniall.cmmn.config;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContext implements ApplicationContextAware {

	private static ApplicationContext CONTEXT;
	
	private Logger log = Logger.getLogger(SpringApplicationContext.class);
	
	public SpringApplicationContext() {
		log.info("init SpringApplicationContext");
	}
	
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		CONTEXT = context;
	}
	
	public static <T> T getBean(Class<T> requiredType) {
		return CONTEXT.getBean(requiredType);
	}

	public static Object getBean(String name) {
		return CONTEXT.getBean(name);
	}
	
	public static <T> Map<String,T> getBeansOfType(Class<T> requiredType){
		return CONTEXT.getBeansOfType(requiredType);
	}
}