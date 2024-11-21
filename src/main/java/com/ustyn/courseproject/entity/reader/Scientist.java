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
public class Scientist extends Reader{
    private String specialty;

    public Scientist(String name, String address, Subscription subscription, LocalDate lastVisitDate, String specialty) {
        super(name, address, subscription, lastVisitDate);
        this.specialty = specialty;
    }
}
