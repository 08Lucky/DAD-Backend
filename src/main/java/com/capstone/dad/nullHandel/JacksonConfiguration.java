package com.capstone.dad.nullHandel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfiguration {
    @Bean
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.build();
        
        // Configure a custom NullKeySerializer
        objectMapper.getSerializerProvider().setNullKeySerializer(new NullKeySerializer());
        
        return objectMapper;
    }
}
