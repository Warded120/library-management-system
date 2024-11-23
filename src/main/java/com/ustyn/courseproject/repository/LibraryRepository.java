package com.ustyn.courseproject.repository;

import com.ustyn.courseproject.document.library.Library;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends MongoRepository<Library, String> {
}
