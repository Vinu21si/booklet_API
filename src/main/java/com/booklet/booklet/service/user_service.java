package com.booklet.booklet.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull;

import com.booklet.booklet.entity.User;
import com.booklet.booklet.repository.user_repository;

@Service
public class user_service {

    @Autowired
    private user_repository user_repository;

    public void saveUser(@NonNull com.booklet.booklet.entity.User user) {
        user_repository.save(user);
    }

   public List<com.booklet.booklet.entity.User> getAllUsers() {
        return user_repository.findAll();
    }
   public Optional<com.booklet.booklet.entity.User> findByIdUser(ObjectId id) {
        return user_repository.findById(id);
    }
   public void deleteUser(ObjectId id) {
        user_repository.deleteById(id);
    }
    public User findByUsername(String username) {
        return user_repository.findByUsername(username);
    }
}
