package com.ustyn.courseproject.entity.reader;

import com.ustyn.courseproject.entity.Ticket;
import com.ustyn.courseproject.entity.literature.Literature;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;

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
