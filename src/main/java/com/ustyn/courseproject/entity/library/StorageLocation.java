package com.ustyn.courseproject.entity.library;

import com.ustyn.courseproject.entity.literature.Literature;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@NoArgsConstructor
@Data
@Document(collection = "storageLocations")
public class StorageLocation {

    @Id
    private String id;

    private String roomNumber;

    private String shelfNumber;

    private String sectionNumber;

    @DBRef
    private Collection<Literature> literatures;
}
