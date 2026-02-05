package com.booklet.booklet.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booklet.booklet.entity.booklet_entry;

@RestController
@RequestMapping("/booklet")
public class bookletcontroller {
    private Map<Long, booklet_entry> entries = new HashMap<>();


      @GetMapping()
      public List<booklet_entry> getAllEntries() {//localhost:8080/booklet GET
        
        return new ArrayList<>(entries.values());
   }
   @PostMapping
    public boolean createEntry(@RequestBody booklet_entry myentry) { //localhost:8080/booklet POST
        entries.put(myentry.getId(), myentry);
        return true;
    }
   @GetMapping("id/{myId}")
   public booklet_entry getbyid (@PathVariable Long myId) {//localhost:8080/booklet/id/1 GET
    return  entries.get(myId);

   }
   @DeleteMapping("id/{myId}")
   public booklet_entry deletegetbyid (@PathVariable Long myId) {//localhost:8080/booklet/id/1 delete
    return  entries.remove(myId);

   }
   @PutMapping("/id/{myId}")
   public booklet_entry updateEntry (@PathVariable Long myId, @RequestBody booklet_entry myentry){
    return entries.put(myId, myentry);
   }

}