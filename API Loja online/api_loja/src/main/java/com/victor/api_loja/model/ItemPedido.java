package com.victor.api_loja.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Itens_pedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private BigDecimal preco_produto;
    private Integer quantidade;
    private BigDecimal subTotal;

    public ItemPedido(){}

    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {
        this.pedido = pedido;
        this.produto = produto;
        this.preco_produto = produto.getPreco_unitario();
        this.quantidade = quantidade;
        this.subTotal = preco_produto.multiply(BigDecimal.valueOf(quantidade));
    }

    public Long getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public BigDecimal getPreco_produto() {
        return preco_produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }
}
