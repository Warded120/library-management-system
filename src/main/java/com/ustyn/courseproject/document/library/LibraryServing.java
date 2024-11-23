package com.ustyn.courseproject.document.library;

import com.ustyn.courseproject.document.literature.Literature;
import com.ustyn.courseproject.document.reader.Reader;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class LibraryServing {

    @Id
    private String id;

    @DBRef
    private LibraryStaff libraryStaff;

    @DBRef
    private Reader reader;

    @DBRef
    private Literature literature;
}
