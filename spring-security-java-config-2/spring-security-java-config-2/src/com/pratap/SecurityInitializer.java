package com.pratap;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

public class SecurityInitializer extends AbstractSecurityWebApplicationInitializer {
	public SecurityInitializer() {
		// configuration classes to be loaded into the root container
		super(RootConfig.class , SecurityConfig.class); 
		
	}
}
