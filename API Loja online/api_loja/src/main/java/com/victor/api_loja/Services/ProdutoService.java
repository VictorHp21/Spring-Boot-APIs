package com.victor.api_loja.Services;

import com.victor.api_loja.Repositories.ProdutoRepository;
import com.victor.api_loja.model.Cliente;
import com.victor.api_loja.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    public ProdutoService (ProdutoRepository repository){
        this.repository = repository;
    }

    public List<Produto> listarProdutos(){
        return repository.findAll();
    }

    public Optional<Produto> buscarPorId(Long id){
        return repository.findById(id);
    }

    public Produto cadastrarProduto(Produto produto){
        return repository.save(produto);
    }

    public boolean excluirProduto(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}
