package com.victor.api_loja.Services;

import com.victor.api_loja.Repositories.PedidoRepository;
import com.victor.api_loja.Repositories.ProdutoRepository;
import com.victor.api_loja.model.ItemPedido;
import com.victor.api_loja.model.Pedido;
import com.victor.api_loja.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository repository;

    public PedidoService(PedidoRepository repository){
        this.repository = repository;
    }

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Pedido> listarPedidos(){
        return repository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id){
        return repository.findById(id);
    }

    @Transactional
    public Pedido cadastrarPedido(Pedido pedido){


        if (pedido.getItens() == null || pedido.getItens().isEmpty()) {
            throw new RuntimeException("O pedido deve conter pelo menos um item.");
        }


        for (ItemPedido i: pedido.getItens()){

            Produto produto = produtoRepository.findById(i.getProduto().getId())
                    .orElseThrow(()-> new RuntimeException("Produto não encontrado!"));


            if(produto.getQuantidade_disponivel() < i.getQuantidade()){
                throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome());
            }

            produto.setQuantidade_disponivel(produto.getQuantidade_disponivel() - i.getQuantidade());

            produtoRepository.save(produto);

            i.setPedido(pedido);

            if (i.getSubTotal() == null) {
                i.setPreco_produto(produto.getPreco_unitario());
                i.setSubTotal(produto.getPreco_unitario().multiply(BigDecimal.valueOf(i.getQuantidade())));
            }


        }

        pedido.setValorTotal(pedido.valorPedido());
        pedido.setData_e_hora(LocalDateTime.now());

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
