package com.ustyn.courseproject.repository;

import com.ustyn.courseproject.entity.Subscription;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
}
