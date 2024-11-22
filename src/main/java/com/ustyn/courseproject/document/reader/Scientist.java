package com.ustyn.courseproject.document.reader;

import com.ustyn.courseproject.document.Ticket;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class Scientist extends Reader{
    private String specialty;

    public Scientist(String name, String address, Ticket ticket, LocalDate lastVisitDate, String specialty) {
        super(name, address, ticket, lastVisitDate);
        this.specialty = specialty;
    }
}
