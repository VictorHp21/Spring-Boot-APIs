package com.victor.api_loja.controller;

import com.victor.api_loja.Services.ItemPedidoService;
import com.victor.api_loja.model.ItemPedido;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/itens_pedido")
public class ItemPedidoController {

    private final ItemPedidoService service;

    public ItemPedidoController (ItemPedidoService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemPedido> buscarPorid(@PathVariable Long id){
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ItemPedido cadastrarItem(@RequestBody ItemPedido itemPedido){
        return service.cadastrarItemPedido(itemPedido);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id){
        boolean removido = service.excluirItem(id);
        return removido ? "Item excluído com sucesso!" : "Erro item de pedido não encontrado!";
    }




}
