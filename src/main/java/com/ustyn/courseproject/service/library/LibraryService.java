package com.ustyn.courseproject.service.library;

import com.ustyn.courseproject.document.library.Library;
import com.ustyn.courseproject.document.user.User;
import org.bson.types.ObjectId;

import java.util.List;

public interface LibraryService {
    Library save(Library library);
    List<Library> findAll();
    Library findById(ObjectId id);
    void deleteById(ObjectId id);
}
