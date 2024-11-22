package com.ustyn.courseproject.service.reader;

import com.ustyn.courseproject.document.reader.Reader;

import java.util.Collection;

public interface ReaderService {
    Reader save(Reader reader);
    boolean existsByName(String name);

    Collection<Reader> findAll();
}
