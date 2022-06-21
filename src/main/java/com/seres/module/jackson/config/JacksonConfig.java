//package com.seres.module.jackson.config;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.seres.module.config.RedisRepositoryConfig;
//import com.seres.module.jackson.ser.DictFormatSerializerModifier;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
//
//
//@Configuration
//@ConditionalOnClass(RedisRepositoryConfig.class)
//public class JacksonConfig {
//
//    @Bean
//    public ObjectMapper jacksonObjectMapper(RedisTemplate<String, Object> redisTemplate,Jackson2ObjectMapperBuilder builder) {
//        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
//        objectMapper.setSerializerFactory(objectMapper.getSerializerFactory().withSerializerModifier(new DictFormatSerializerModifier(redisTemplate)));
//        return objectMapper;
//    }
//}
