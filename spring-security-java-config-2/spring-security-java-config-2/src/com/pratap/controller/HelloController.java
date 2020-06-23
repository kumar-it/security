package com.pratap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	@GetMapping("/hello")
	public String sayHello() {
		return "hellopage";
	}
	@GetMapping("/")
	public String home() {
		return "home";
	}
}
