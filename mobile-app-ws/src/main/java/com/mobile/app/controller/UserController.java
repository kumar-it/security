package com.mobile.app.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobile.app.model.reponse.UserRest;
import com.mobile.app.model.request.UserDetailsRequestModel;
import com.mobile.app.service.UserService;
import com.mobile.app.shared.dto.UserDto;

@RestController
@RequestMapping(path="users")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String getUser() {
		return "get";
	}
	
	
	/*
	 * POST:
	 * -> Read body from HTTP request & convert JSON body into java object we need to use: @RequestBody
	 * 
	 * -> Response back data to the user after successfully creating the account use:
	 * 
	 */
	@PostMapping
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) {
		
		//return value to the user. 
		UserRest returnValue = new UserRest();
		
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);//source, target
		
		UserDto createdUser = userService.createUser(userDto);
		//copy the information from created user object into the return value object.  
		BeanUtils.copyProperties(createdUser, returnValue);
		
		//finally return value to the calling client. 
		return returnValue; //i.e postman
		
	}
	
	@PutMapping
	public String updateUser() {
		return "put";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "delete";
	}
	

}
