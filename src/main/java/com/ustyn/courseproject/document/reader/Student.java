package com.ustyn.courseproject.document.reader;

import com.ustyn.courseproject.document.Ticket;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class Student extends Reader {
    private String institution;

    public Student(String name, String address, Ticket ticket, LocalDate lastVisitDate, String institution) {
        super(name, address, ticket, lastVisitDate);
        this.institution = institution;
    }
}
