package com.booklet.booklet.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.booklet.booklet.entity.User;


public interface user_repository extends MongoRepository<User, ObjectId>{
	User findByUsername(String username);

}
