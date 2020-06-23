package com.pratap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.pratap")
public class AppConfig {

	@Bean
	public ViewResolver resolver() {
		return new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
	}
}
