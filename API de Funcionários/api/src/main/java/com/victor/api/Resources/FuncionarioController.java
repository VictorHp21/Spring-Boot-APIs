package com.victor.api.Resources;

import com.victor.api.Services.FuncionarioService;
import com.victor.api.model.Funcionario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService service;

    public FuncionarioController(FuncionarioService service){
        this.service = service;
    }

    @GetMapping
    public List<Funcionario> listar(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)// ResponseEntity.ok() cria uma resposta HTTP 200 (OK) contendo o objeto no corpo.
                .orElse(ResponseEntity.notFound().build()); // senão encontrar o funcionário o orElse irá criar uma resposta HTTP 404 (Not Found).
    }

    @PostMapping
    public Funcionario cadastrar(@RequestBody Funcionario funcionario){
        return service.cadastrar(funcionario);
    }


    @DeleteMapping("/{id}")
    public String excluir(@PathVariable Long id){
        boolean removido = service.excluir(id);
        return removido ? "Funcionário removido com sucesso! ✅" : "Funcionário não encontrado! ⚠️";
    }


}
