package com.booklet.booklet.controller;

import java.time.LocalDate;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.booklet.booklet.entity.booklet_entry;
import com.booklet.booklet.service.booklet_entry_service;

@RestController
@RequestMapping("/booklet")
public class bookletcontroller_v2 {
    
    @Autowired
    private booklet_entry_service booklet_entry_service;

    @GetMapping
    public List<booklet_entry> getAllEntries() {
        return booklet_entry_service.getAllEntries();
    }

    @PostMapping
    public booklet_entry createEntry(@RequestBody booklet_entry myentry) {
        myentry.setDate(LocalDate.now());
        booklet_entry_service.saveEntry(myentry);
        return myentry;
    }

    @GetMapping("/id/{myId}")
    public booklet_entry getbyid(@PathVariable ObjectId myId) {
        return booklet_entry_service.findByIdEntry(myId).orElse(null);
    }

    @DeleteMapping("/id/{myId}")
    public boolean deletegetbyid(@PathVariable ObjectId myId) {
        booklet_entry_service.deleteEntry(myId);
        return true;
    }

    @PutMapping("/id/{myId}")
    public booklet_entry updateEntry(@PathVariable ObjectId myId, @RequestBody booklet_entry newEntry) {
        booklet_entry old = booklet_entry_service.findByIdEntry(myId).orElse(null);
       if(old !=null){
        old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")?newEntry.getTitle():old.getTitle());
        old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("")?newEntry.getContent():old.getContent());
       } 
        booklet_entry_service.saveEntry(old);
        return old;
    }
}
