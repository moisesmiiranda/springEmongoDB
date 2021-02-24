package com.moisesmiiranda.projetomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.moisesmiiranda.projetomongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}
