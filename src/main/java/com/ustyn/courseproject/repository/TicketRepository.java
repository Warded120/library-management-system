package com.ustyn.courseproject.repository;

import com.ustyn.courseproject.entity.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, String> {
}
