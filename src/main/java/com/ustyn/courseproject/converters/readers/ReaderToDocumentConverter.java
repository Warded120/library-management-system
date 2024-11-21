package com.ustyn.courseproject.converters.readers;

import com.ustyn.courseproject.entity.reader.Reader;
import com.ustyn.courseproject.entity.reader.Scientist;
import com.ustyn.courseproject.entity.reader.Student;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.stereotype.Component;

@WritingConverter
public class ReaderToDocumentConverter implements Converter<Reader, Document> {
    @Override
    public Document convert(Reader source) {
        Document document = new Document();
        document.put("_id", source.getId());
        document.put("name", source.getName());
        document.put("address", source.getAddress());
        document.put("subscriptions", source.getSubscription());
        document.put("lastVisitDate", source.getLastVisitDate());

        if (source instanceof Scientist) {
            document.put("_class", "Scientist");
            document.put("specialty", ((Scientist) source).getSpecialty());
        } else if (source instanceof Student) {
            document.put("_class", "Student");
            document.put("institution", ((Student) source).getInstitution());
        } else {
            throw new IllegalArgumentException("Unsupported Reader type: " + source.getClass().getName());
        }

        System.out.println(document);
        return document;
    }
}
