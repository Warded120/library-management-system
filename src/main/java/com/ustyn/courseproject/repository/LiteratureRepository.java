package com.ustyn.courseproject.repository;

import com.ustyn.courseproject.document.literature.Literature;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LiteratureRepository extends MongoRepository<Literature, String> {
    boolean existsByTitle(String title);
    Literature findByTitle(String title);
}
