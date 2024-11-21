package com.ustyn.courseproject.entity.reader;

import com.ustyn.courseproject.entity.Subscription;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
public class Student extends Reader {
    private String institution;

    public Student(String name, String address, Subscription subscription, LocalDate lastVisitDate, String institution) {
        super(name, address, subscription, lastVisitDate);
        this.institution = institution;
    }
}
