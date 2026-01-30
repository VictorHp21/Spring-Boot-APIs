package com.victor.api_loja.controller;

import com.victor.api_loja.Services.ProdutoService;
import com.victor.api_loja.model.Produto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService service;

    public ProdutoController (ProdutoService service){
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto cadastrar(@RequestBody Produto produto){
        return service.cadastrarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id){
        boolean removido = service.excluirProduto(id);
        return removido ? "Produto excluído com sucesso!" : "Erro produto não encontrado!";
    }

}
