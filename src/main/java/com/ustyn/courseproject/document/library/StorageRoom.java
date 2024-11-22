package com.ustyn.courseproject.document.library;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collection;

@NoArgsConstructor
@Data
@Document(collection = "storageRooms")
public class StorageRoom {

    @Id
    private String id;

    @DBRef
    private Collection<StorageLocation> storageLocations;
}
