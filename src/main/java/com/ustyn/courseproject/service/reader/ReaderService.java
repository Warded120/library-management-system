package com.ustyn.courseproject.service.reader;

import com.ustyn.courseproject.document.reader.Reader;

public interface ReaderService {
    Reader save(Reader reader);
    boolean existsByName(String name);
}
