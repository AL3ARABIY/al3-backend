package com.al3arabiy.al3_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import java.util.Set;

@Data
@Document
public class Role {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    @DBRef
    private Set<Permission> permissions;
}