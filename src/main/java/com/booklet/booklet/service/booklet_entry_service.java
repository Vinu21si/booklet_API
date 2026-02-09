package com.booklet.booklet.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.lang.NonNull;

import com.booklet.booklet.entity.booklet_entry;
import com.booklet.booklet.repository.booklet_entry_repository;

@Service
public class booklet_entry_service {

    @Autowired
    private booklet_entry_repository booklet_entry_repository;

    public void saveEntry(@NonNull booklet_entry booklet_entry) {
        booklet_entry_repository.save(booklet_entry);
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
