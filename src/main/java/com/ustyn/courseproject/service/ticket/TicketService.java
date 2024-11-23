package com.ustyn.courseproject.service.ticket;

import com.ustyn.courseproject.document.Ticket;

public interface TicketService {
    Ticket save(Ticket ticket);
    Ticket findById(String id);
    void deleteById(String id);
}
