package com.booklet.booklet.controller;

import java.util.List;

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
        return null;
    }

    @PostMapping
    public boolean createEntry(@RequestBody booklet_entry myentry) {
        booklet_entry_service.saveEntry(myentry);
        return true;
    }

    @GetMapping("/id/{myId}")
    public booklet_entry getbyid(@PathVariable Long myId) {
        return null;
    }

    @DeleteMapping("/id/{myId}")
    public booklet_entry deletegetbyid(@PathVariable Long myId) {
        return null;
    }

    @PutMapping("/id/{myId}")
    public booklet_entry updateEntry(@PathVariable Long myId, @RequestBody booklet_entry myentry) {
        return null;
    }
}
