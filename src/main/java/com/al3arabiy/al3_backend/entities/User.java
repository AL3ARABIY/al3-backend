package com.al3arabiy.al3_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Document
public class User {
    @Id
    private String id;

    private String firstName;
    private String lastName;

    @Transient
    public String getFullName() {
        return firstName + "_" + lastName;
    }

    @Indexed(unique = true)
    private String email;
    private LocalDate birthDate;

    @Indexed(unique = true)
    private String username;
    private String password;
    private LocalDateTime registrationDate;
    private String lastLoginIp;
    private LocalDateTime lastLoginDate;

    private DiscordInfo discordInfo;

    @DBRef
    private Set<Role> roles;

    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}