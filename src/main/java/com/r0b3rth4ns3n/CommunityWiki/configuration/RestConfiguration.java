package com.r0b3rth4ns3n.CommunityWiki.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
