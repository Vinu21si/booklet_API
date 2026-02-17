package com.booklet.booklet.entity;



import java.time.LocalDate;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "booklet_entries")
@Data
@NoArgsConstructor
public class booklet_entry {
    @Id
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDate date;
    
    
    
}
