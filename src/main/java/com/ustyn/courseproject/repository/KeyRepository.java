package com.ustyn.courseproject.repository;

import com.ustyn.courseproject.entity.user.Key;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyRepository extends MongoRepository<Key, String> {
}
