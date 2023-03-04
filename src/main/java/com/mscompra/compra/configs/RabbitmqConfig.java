package com.mscompra.compra.configs;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitmqConfig {

    @Value("${queue.name}")
    private String queueName;

    @Bean
    Queue queue() {

        return new Queue(queueName, true);
    }

}
