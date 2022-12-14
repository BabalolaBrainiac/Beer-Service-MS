package com.babalola.beerservicems.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;


@Configuration
public class JMSConfig {
    public static final String BEER_INVENTORY_QUEUE = "BEER_INVENTORY_QUEUE";
    public static final String BEER_BREWING_QUEUE = "BEER_BREWING_QUEUE";

    @Bean
    public MessageConverter jmsConverter(ObjectMapper objectMapper) {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");

        converter.setObjectMapper(objectMapper);
        return converter;
    }
}
