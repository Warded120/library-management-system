package com.ustyn.courseproject.service.library;

import com.ustyn.courseproject.document.library.Library;
import java.util.List;

public interface LibraryService {
    Library save(Library library);
    List<Library> findAll();
    Library findById(String id);
    void deleteById(String id);
    boolean existsByName(String name);
}
