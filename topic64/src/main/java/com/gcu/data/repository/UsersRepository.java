package com.gcu.data.repository;

import com.gcu.data.entity.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository 
public interface UsersRepository extends MongoRepository<UserEntity, String>{
	
	UserEntity findByUsername(String username);
}
