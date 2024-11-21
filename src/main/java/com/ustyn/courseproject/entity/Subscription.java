package com.ustyn.courseproject.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Collection;

// TODO: Can't find a codec for CodecCacheKey{clazz=class com.ustyn.courseproject.entity.Subscription, types=null}
@EqualsAndHashCode
@NoArgsConstructor
@Data
@Document(collection = "subscriptions")
public class Subscription {

    @Id
    private String id;

    @DBRef
    private Collection<String> borrowedLiteratures;

    public Subscription(Collection<String> borrowedLiteratures) {
        this.borrowedLiteratures = borrowedLiteratures;
    }
}
