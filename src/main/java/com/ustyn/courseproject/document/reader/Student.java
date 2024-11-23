package com.ustyn.courseproject.document.reader;

import com.ustyn.courseproject.document.Ticket;
import com.ustyn.courseproject.dto.ScientistDto;
import com.ustyn.courseproject.dto.StudentDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;

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

    public Student(StudentDto dto) {
        super(new ObjectId(dto.getId()), dto.getName(), dto.getAddress(), dto.getTicketId(), dto.getLastVisitDate());
        this.institution = dto.getInstitution();
    }
}
