package com.victor.api_loja.Services;

import com.victor.api_loja.Repositories.ClienteRepository;
import com.victor.api_loja.model.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteService(ClienteRepository repository){
        this.repository = repository;
    }

    public List<Cliente> listarClientes(){
        return repository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id){
        return repository.findById(id);
    }

    public Cliente cadastrarCliente(Cliente cliente){
        return  repository.save(cliente);
    }

    public boolean excluirCliente(Long id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }

        return false;
    }

}
