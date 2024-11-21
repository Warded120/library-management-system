package com.ustyn.courseproject.entity.library;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@Data
@Document(collection = "libraryStaffs")
public class LibraryStaff {
    @Id
    private String id;

    @Field(value = "name")
    private String name;

}
