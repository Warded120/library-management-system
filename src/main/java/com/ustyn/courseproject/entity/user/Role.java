package com.ustyn.courseproject.entity.user;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@Data
@Document(collection = "roles")
public class Role {

    @Id
    private String id;

    @Field(value = "name")
    private String name;
}
