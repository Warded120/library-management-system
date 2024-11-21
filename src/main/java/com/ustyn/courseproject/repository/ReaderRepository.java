package com.ustyn.courseproject.repository;

import com.ustyn.courseproject.entity.reader.Reader;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReaderRepository extends MongoRepository<Reader, String> {
    boolean existsByName(String name);
}
