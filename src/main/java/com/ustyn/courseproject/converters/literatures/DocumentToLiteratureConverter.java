package com.ustyn.courseproject.converters.literatures;

import com.ustyn.courseproject.entity.literature.Article;
import com.ustyn.courseproject.entity.literature.Book;
import com.ustyn.courseproject.entity.literature.Literature;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@ReadingConverter
public class DocumentToLiteratureConverter implements Converter<Document, Literature> {
    @Override
    public Literature convert(Document source) {
        String type = source.getString("_class");
        if ("Book".equals(type)) {
            Book book = new Book();
            book.setPages(source.getInteger("pages"));
            setCommonFields(source, book);
            return book;
        } else if ("Article".equals(type)) {
            Article article = new Article();
            article.setPublishDate(source.get("publishDate", LocalDate.class));
            setCommonFields(source, article);
            return article;
        }
        throw new IllegalArgumentException("Unsupported type: " + type);
    }

    private void setCommonFields(Document source, Literature literature) {
        literature.setId(source.getObjectId("_id").toString());
        literature.setTitle(source.getString("title"));
        literature.setAuthor(source.getString("author"));
        literature.setInventoryNumber(source.getString("inventoryNumber"));
        literature.setAvailable(source.getBoolean("available"));
    }
}