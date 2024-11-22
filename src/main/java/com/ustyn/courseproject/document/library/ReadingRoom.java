package com.ustyn.courseproject.document.library;

import com.ustyn.courseproject.document.literature.Literature;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@NoArgsConstructor
@Data
@Document(collection = "readingRooms")
public class ReadingRoom {

    @Id
    private String id;

    @DBRef
    private Collection<Literature> literatures;

    @DBRef
    private Collection<LibraryStaff> staffs;
}
