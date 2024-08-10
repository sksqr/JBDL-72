package com.example.L19_kafka_demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfig {

    private static Logger LOGGER = LoggerFactory.getLogger(KafkaConfig.class);

    @Value("${kafka.bootstrapAddress}")
    private String bootstrapServers;

    @Bean
    public ProducerFactory getObjectProducerFactory(){
        Map<String,Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapServers);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        //configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory(configs);
    }

    @Bean
    public KafkaTemplate<String,Object> getKafkaTemplate(ProducerFactory producerFactory){
        return new KafkaTemplate<>(producerFactory);
    }

    @KafkaListener(topics = "userCreated", groupId = "sms")
    public void consumeData(Object payload) {
        String value = (String) ((ConsumerRecord)payload).value();
        LOGGER.info("Data Consuming payload: {}",payload);
        LOGGER.info("Data Consuming Value: {}",payload);
    }
}
