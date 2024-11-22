package com.ustyn.courseproject.entity.reader;

import com.ustyn.courseproject.entity.Ticket;
import com.ustyn.courseproject.entity.library.Library;
import com.ustyn.courseproject.entity.literature.Literature;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collection;

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
