package com.connecting;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ConfigurationPages extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] configClassArray = { ConnectingEndtoEnd.class };
		return configClassArray;
		
	}

	@Override
	protected String[] getServletMappings() {
		String[] urlMappings = { "/explore/*" };
		return urlMappings;
		
		
	}

}
