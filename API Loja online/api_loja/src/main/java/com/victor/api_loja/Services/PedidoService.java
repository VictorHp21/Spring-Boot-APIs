package com.victor.api_loja.Services;

import com.victor.api_loja.Repositories.PedidoRepository;
import com.victor.api_loja.Repositories.ProdutoRepository;
import com.victor.api_loja.model.Pedido;
import com.victor.api_loja.model.Produto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository){
        this.repository = repository;
    }

    public List<Pedido> listarPedidos(){
        return repository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id){
        return repository.findById(id);
    }

    public Pedido cadastrarPedido(Pedido pedido){
        return repository.save(pedido);
    }

    public boolean excluirPedido(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

}
