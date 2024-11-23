package com.ustyn.courseproject.document.literature;

import com.ustyn.courseproject.dto.literature.BookDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;

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

    public Book(BookDto bookDto) {
        super(new ObjectId(bookDto.getId()), bookDto.getTitle(), bookDto.getAuthor(), bookDto.getInventoryNumber(), bookDto.isAvailable());
        this.pages = bookDto.getPages();
    }
}
