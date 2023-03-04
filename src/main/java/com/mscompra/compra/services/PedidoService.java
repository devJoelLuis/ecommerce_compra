package com.mscompra.compra.services;

import com.mscompra.compra.model.Pedido;
import com.mscompra.compra.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProducerService producerService;

    public Pedido salvar(Pedido pedido) {
        pedido.setId(null);
        pedido = pedidoRepository.save(pedido);
        producerService.enviarPedido(pedido);
        return pedido;
    }

}
