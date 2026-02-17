package com.booklet.booklet.service;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull;

import com.booklet.booklet.entity.User;
import com.booklet.booklet.entity.booklet_entry;
import com.booklet.booklet.repository.booklet_entry_repository;

@Service
public class booklet_entry_service {
     @Autowired
     private user_service user_service;
    @Autowired
    private booklet_entry_repository booklet_entry_repository;

    public void saveEntry(@NonNull booklet_entry booklet_entry,String userName) {
        User user=user_service.findByUsername(userName);
        booklet_entry.setDate(LocalDateTime.now().toLocalDate());
        booklet_entry saved = booklet_entry_repository.save(booklet_entry);
        user.getEntries().add(saved);
        user_service.saveEntry(user);
    }

   public List<booklet_entry> getAllEntries() {
        return booklet_entry_repository.findAll();
    }
   public Optional<booklet_entry> findByIdEntry(ObjectId id) {
        return booklet_entry_repository.findById(id);
    }
   public void deleteEntry(ObjectId id) {
        booklet_entry_repository.deleteById(id);
    }
}
