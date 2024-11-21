package com.ustyn.courseproject.converters.literatures;

import com.ustyn.courseproject.entity.literature.Article;
import com.ustyn.courseproject.entity.literature.Book;
import com.ustyn.courseproject.entity.literature.Literature;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

@WritingConverter
public class LiteratureToDocumentConverter implements Converter<Literature, Document> {
    @Override
    public Document convert(Literature source) {
        Document document = new Document();
        document.put("_id", source.getId());
        document.put("title", source.getTitle());
        document.put("author", source.getAuthor());
        document.put("inventoryNumber", source.getInventoryNumber());
        document.put("available", source.isAvailable());

        if (source instanceof Book) {
            document.put("_class", "Book");
            document.put("pages", ((Book) source).getPages());
        } else if (source instanceof Article) {
            document.put("_class", "Article");
            document.put("publishDate", ((Article) source).getPublishDate());
        } else {
            throw new IllegalArgumentException("Unsupported type: " + source.getClass().getName());
        }

        return document;
    }
}
