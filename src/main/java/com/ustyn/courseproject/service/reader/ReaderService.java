package com.ustyn.courseproject.service.reader;

import com.ustyn.courseproject.document.reader.Reader;

import java.util.List;

public interface ReaderService {
    Reader save(Reader reader);
    boolean existsByName(String name);
    List<Reader> findAll();
    Reader findById(String id);
    void deleteById(String id);
    void delete(Reader reader);
}
