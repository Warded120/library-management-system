package com.ustyn.courseproject.document.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;

@NoArgsConstructor
@Data
@Document(collection = "users")
public class User {

    @Id
    private String id;

    @Field(value = "username")
    private String username;

    @DBRef
    @Field(value = "password")
    private Key password;

    @Field(value = "enabled")
    private boolean enabled = true;

    @DBRef
    @Field(value = "roles")
    private Collection<Role> roles;

    public User(String username, Key password, boolean enabled, Collection<Role> roles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }
}

