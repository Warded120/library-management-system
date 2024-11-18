package com.ustyn.courseproject.entity.user;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@Data
@Document(collection = "keys")
public class Key {

    @Id
    private String id;

    @Field(value = "password")
    private String password;
}
