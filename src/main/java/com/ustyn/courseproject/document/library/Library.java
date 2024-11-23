package com.ustyn.courseproject.document.library;

import com.ustyn.courseproject.document.literature.Literature;
import com.ustyn.courseproject.document.reader.Reader;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@NoArgsConstructor
@Data
@Document(collection = "libraries")
public class Library {

    @Id
    private ObjectId id;

    String name;

    @DBRef
    List<Literature> literatures;

    @DBRef
    List<LibraryStaff> libraryStaffs;

    @DBRef
    List<Reader> readers;
}
