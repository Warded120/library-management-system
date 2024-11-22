package com.ustyn.courseproject.entity.library;

import com.ustyn.courseproject.entity.Ticket;
import com.ustyn.courseproject.entity.reader.Reader;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Collection;

@NoArgsConstructor
@Data
@Document(collection = "libraries")
public class Library {

    @Id
    private String id;

    String name;

    @DBRef
    Collection<Ticket> tickets;

    @DBRef
    Collection<ReadingRoom> readingRooms;

    @DBRef
    Collection<LibraryStaff> libraryStaffs;

    @DBRef
    Collection<Reader> readers;
}
