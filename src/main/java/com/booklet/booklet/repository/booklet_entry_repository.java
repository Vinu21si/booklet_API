package com.booklet.booklet.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.booklet.booklet.entity.booklet_entry;

public interface booklet_entry_repository extends MongoRepository<booklet_entry, String>{
	

}
