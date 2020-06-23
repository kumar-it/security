package com.mobile.app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.app.io.Entity.UserEntity;

//Spring data JPA Framework it's make very easy for CRUD operations. 

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	//Need to write custom login for finduserbyid, deletebyid, ..etc
	
	//UserEntity findUseByEmail(String email);
	

}
