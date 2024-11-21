package com.ustyn.courseproject.entity.literature;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@ToString(callSuper = true)
public class Article extends Literature {
    private LocalDate publishDate;

    public Article(String title, String author, String inventoryNumber, boolean available, LocalDate publishDate) {
        super(title, author, inventoryNumber, available);
        this.publishDate = publishDate;
    }
}
