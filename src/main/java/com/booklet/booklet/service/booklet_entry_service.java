package com.booklet.booklet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booklet.booklet.entity.booklet_entry;
import com.booklet.booklet.repository.booklet_entry_repository;   // ✅ THIS WAS MISSING

@Service   // better than @Component
public class booklet_entry_service {

    @Autowired
    private booklet_entry_repository booklet_entry_repository;

    public void saveEntry(booklet_entry booklet_entry) {
        booklet_entry_repository.save(booklet_entry);
    }
}
