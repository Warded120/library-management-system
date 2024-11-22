package com.ustyn.courseproject.document.literature;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@ToString(callSuper = true)
public class Book extends Literature {
    private int pages;

    public Book(String title, String author, String inventoryNumber, boolean available, int pages) {
        super(title, author, inventoryNumber, available);
        this.pages = pages;
    }
}
