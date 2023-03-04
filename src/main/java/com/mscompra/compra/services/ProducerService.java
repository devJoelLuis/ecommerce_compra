package com.mscompra.compra.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mscompra.compra.model.Pedido;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.amqp.core.Queue;


@Service
public class ProducerService {


    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Queue queue;
    @Autowired
    private ObjectMapper objectMapper;


    @SneakyThrows
    @PostMapping
    public void enviarPedido(Pedido pedido) {
        rabbitTemplate.convertAndSend(queue.getName(), objectMapper.writeValueAsString(pedido));
    }

}
