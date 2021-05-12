package com.app.controller;

import java.security.Principal;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	/*
	 * =============================================
	 *   AUTHENTICATING SINGLE USER IN 3-DIFF WAYS
	 *   - All 3 program does the same thing. 
	 *===============================================
	 */
	 
	/*
	
	@GetMapping("/hello")
	public String hello(@RequestParam String name) {
		return "hello there " + name;
	}
	
	*/
	
	
	/*
	@GetMapping("/hello")
	public String hello(@RequestParam String name, Principal user) {
		return "hello there " + user.getName();
	}
	*/
	
	@GetMapping("/hello")
	public String hello(@RequestParam String name) {
		
		org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return "hello there " + authentication.getName();
	}
	
}