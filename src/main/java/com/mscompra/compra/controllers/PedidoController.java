package com.mscompra.compra.controllers;

import com.mscompra.compra.model.Pedido;
import com.mscompra.compra.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody @Valid Pedido pedido) {
        pedido = pedidoService.salvar(pedido);
        return ResponseEntity.ok(pedido);
    }

}
