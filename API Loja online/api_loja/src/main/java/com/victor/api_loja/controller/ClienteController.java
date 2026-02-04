package com.victor.api_loja.controller;

import com.victor.api_loja.Services.ClienteService;
import com.victor.api_loja.model.Cliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService service;

    public ClienteController (ClienteService service){
        this.service = service;
    }

    @GetMapping
    public List<Cliente> listar(){
        return service.listarClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cliente cadastrar(@RequestBody Cliente cliente){
        return service.cadastrarCliente(cliente);
    }

    @DeleteMapping("/{id}")
    public String excluirCliente(@PathVariable Long id){
        boolean removido = service.excluirCliente(id);
        return removido ? "Cliente excluído com sucesso!!" : "**ERRO** Cliente não cadastrado";
    }


}
