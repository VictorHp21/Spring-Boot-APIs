package com.victor.api_loja.Services;

import com.victor.api_loja.Repositories.ItemPedidoRepository;
import com.victor.api_loja.model.ItemPedido;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPedidoService {

    private final ItemPedidoRepository repository;

    public ItemPedidoService (ItemPedidoRepository repository){
        this.repository = repository;
    }

    public List<ItemPedido> listarPedidos(){
        return repository.findAll();
    }

    public Optional<ItemPedido> buscarPorId(Long id){
        return repository.findById(id);
    }

    public ItemPedido cadastrarItemPedido(ItemPedido itemPedido){
        return repository.save(itemPedido);
    }

    public boolean excluirItem(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }

        return false;
    }

}
