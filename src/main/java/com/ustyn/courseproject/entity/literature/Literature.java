package com.ustyn.courseproject.entity.literature;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@EqualsAndHashCode
@NoArgsConstructor
@Data
@Document(collection = "literatures")
public abstract class Literature {

    @Id
    private String id;
    private String title;
    private String author;
    private String inventoryNumber;
    private boolean available;


    public Literature(String title, String author, String inventoryNumber, boolean available) {
        this.title = title;
        this.author = author;
        this.inventoryNumber = inventoryNumber;
        this.available = available;
    }
}
