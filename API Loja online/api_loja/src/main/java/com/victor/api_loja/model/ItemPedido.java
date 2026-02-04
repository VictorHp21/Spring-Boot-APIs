package com.victor.api_loja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    private BigDecimal preco_produto;
    private Integer quantidade;
    private BigDecimal subTotal;

    public ItemPedido(){}

    @JsonIgnore
    public ItemPedido(Pedido pedido, Produto produto, Integer quantidade) {
        this.pedido = pedido;
        this.produto = produto;
        this.preco_produto = produto.getPreco_unitario();
        this.quantidade = quantidade;
        this.subTotal = preco_produto.multiply(BigDecimal.valueOf(quantidade));
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setPreco_produto(BigDecimal preco_produto) {
        this.preco_produto = preco_produto;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
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
