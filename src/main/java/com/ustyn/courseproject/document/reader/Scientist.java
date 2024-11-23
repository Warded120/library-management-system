package com.ustyn.courseproject.document.reader;

import com.ustyn.courseproject.document.Ticket;
import com.ustyn.courseproject.dto.ScientistDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    public Scientist(ScientistDto dto) {
        super(dto.getId(), dto.getName(), dto.getAddress(), dto.getTicketId(), dto.getLastVisitDate());
        this.specialty = dto.getSpecialty();
    }
}
