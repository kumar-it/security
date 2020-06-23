package com.mobile.app.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobile.app.UserRepository;
import com.mobile.app.io.Entity.UserEntity;
import com.mobile.app.service.UserService;
import com.mobile.app.shared.dto.UserDto;


//Here we write all the business logics. 
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDto createUser(UserDto user) {
		
		UserEntity userEntity = new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		//Just hard code because it does't allow null according to our written definition in UserEntity
		userEntity.setEncryptedPassword("test");
		userEntity.setUserId("testUser");
		
		
		UserEntity storedUserDetails = userRepository.save(userEntity);//it will save into the database 
		
		UserDto returnValue = new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		return returnValue;
	}

}
