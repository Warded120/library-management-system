package com.ustyn.courseproject.entity.reader;

import com.ustyn.courseproject.entity.Ticket;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@NoArgsConstructor
@Data
@Document(collection = "readers")
public abstract class Reader {
    @Id
    private String id;

    private String name;

    private String address;

    private String ticketId;

    private LocalDate lastVisitDate;

    public Reader(String name, String address, Ticket ticket, LocalDate lastVisitDate) {
        this.name = name;
        this.address = address;
        this.ticketId = ticket.getId();
        this.lastVisitDate = lastVisitDate;
    }
}
