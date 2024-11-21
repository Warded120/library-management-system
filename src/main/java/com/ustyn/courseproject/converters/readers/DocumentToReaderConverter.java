package com.ustyn.courseproject.converters.readers;

import com.ustyn.courseproject.entity.reader.Reader;
import com.ustyn.courseproject.entity.reader.Scientist;
import com.ustyn.courseproject.entity.reader.Student;
import com.ustyn.courseproject.entity.Subscription;
import org.bson.Document;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@ReadingConverter
public class DocumentToReaderConverter implements Converter<Document, Reader> {
    @Override
    public Reader convert(Document source) {
        String type = source.getString("_class"); // Assuming `_class` identifies the subclass
        if ("Scientist".equals(type)) {
            Scientist scientist = new Scientist();
            scientist.setSpecialty(source.getString("specialty"));
            setCommonFields(source, scientist);
            return scientist;
        } else if ("Student".equals(type)) {
            Student student = new Student();
            student.setInstitution(source.getString("institution"));
            setCommonFields(source, student);
            return student;
        }
        throw new IllegalArgumentException("Unsupported Reader type: " + type);
    }

    private void setCommonFields(Document source, Reader reader) {
        reader.setId(source.getObjectId("_id").toString());
        reader.setName(source.getString("name"));
        reader.setAddress(source.getString("address"));
        reader.setSubscription(source.get("subscription", Subscription.class));
        reader.setLastVisitDate(source.get("lastVisitDate", LocalDate.class));
    }
}
