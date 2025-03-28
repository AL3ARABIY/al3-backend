package com.al3arabiy.al3_backend.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration @Getter @Setter
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "al3-security")
public class AL3Security {
    private String[] permissibleRequests;
}
