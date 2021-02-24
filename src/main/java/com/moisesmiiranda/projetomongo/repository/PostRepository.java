package com.moisesmiiranda.projetomongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.moisesmiiranda.projetomongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
}
