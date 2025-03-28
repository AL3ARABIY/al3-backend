package com.al3arabiy.al3_backend.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import lombok.Data;

@Data
public class DiscordInfo {
    @Id
    private String id;

    @Indexed(unique = true)
    private String officialDiscordId;

    @Indexed(unique = true)
    private String username;

    private String avatarLink;

    @Indexed(unique = true)
    private String email;
}
