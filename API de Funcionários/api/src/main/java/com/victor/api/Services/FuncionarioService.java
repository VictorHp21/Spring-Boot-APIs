package com.victor.api.Services;

import com.victor.api.Repositories.FuncionarioRepository;
import com.victor.api.model.Funcionario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<Funcionario> listarTodos(){
        return repository.findAll();
    }

    public Optional<Funcionario> buscarPorId(Long id){
        return repository.findById(id);
    }

    public Funcionario cadastrar(Funcionario funcionario){
        return repository.save(funcionario);
    }

    public boolean excluir(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}
