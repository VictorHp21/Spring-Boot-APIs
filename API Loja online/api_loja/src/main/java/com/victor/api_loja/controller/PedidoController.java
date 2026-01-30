package com.victor.api_loja.controller;

import com.victor.api_loja.Services.PedidoService;
import com.victor.api_loja.Services.ProdutoService;
import com.victor.api_loja.model.Pedido;
import com.victor.api_loja.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class PedidoController {

    private final PedidoService service;

    public PedidoController(PedidoService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Pedido cadastrar(@RequestBody Pedido pedido){
        return service.cadastrarPedido(pedido);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id){
        boolean removido = service.excluirPedido(id);
        return removido ? "Pedido excluído com sucesso!" : "Erro pedido não encontrado!";
    }

}
