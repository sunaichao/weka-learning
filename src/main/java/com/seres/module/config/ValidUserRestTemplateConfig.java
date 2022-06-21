package com.seres.module.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
@ConditionalOnMissingBean(RestTemplate.class)
public class ValidUserRestTemplateConfig {
    @LoadBalanced
    @Bean
    @ConditionalOnMissingBean(RestTemplate.class)
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
