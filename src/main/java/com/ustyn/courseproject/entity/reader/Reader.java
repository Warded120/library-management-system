package com.ustyn.courseproject.entity.reader;

import com.ustyn.courseproject.entity.Subscription;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@Data
@Document(collection = "readers")
public abstract class Reader {
    @Id
    private String id;

    private String name;

    private String address;

    @DBRef
    private Subscription subscription;

    private LocalDate lastVisitDate;

    public Reader(String name, String address, Subscription subscription, LocalDate lastVisitDate) {
        this.name = name;
        this.address = address;
        this.subscription = subscription;
        this.lastVisitDate = lastVisitDate;
    }
}
