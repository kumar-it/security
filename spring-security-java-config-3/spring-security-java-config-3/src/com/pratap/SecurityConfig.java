package com.pratap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.ldapAuthentication().
			userDnPatterns("uid={0},ou=people")
			.groupSearchBase("ou=groups")
			.contextSource().root("dc=springframework,dc=org").ldif("users.ldif")
			//.url("ldap://localhost:8389/dc=devglan,dc=com")
			.and()
		.passwordCompare()
			.passwordEncoder(passwordEncoder())
			.passwordAttribute("userPassword");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// your configuration goes here
		http
			.authorizeRequests()
				.anyRequest().authenticated()
		.and().formLogin()
		.and().httpBasic();
	}

}
