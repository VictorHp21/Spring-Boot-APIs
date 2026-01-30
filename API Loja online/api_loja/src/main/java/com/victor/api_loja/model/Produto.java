package com.victor.api_loja.model;

import jakarta.persistence.*;
import org.hibernate.annotations.AnyDiscriminatorImplicitValues;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String descricao;
    private BigDecimal preco_unitario;
    private Integer quantidade_disponivel;

    @OneToMany(mappedBy = "produtos", cascade = CascadeType.ALL)
    private List<ItemPedido> itensPedidos;


    public Produto (){}

    public Produto(String nome, String descricao, BigDecimal preco_unitario, Integer quantidade_disponivel) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco_unitario = preco_unitario;
        this.quantidade_disponivel = quantidade_disponivel;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getPreco_unitario() {
        return preco_unitario;
    }

    public Integer getQuantidade_disponivel() {
        return quantidade_disponivel;
    }

    public List<ItemPedido> getItensPedidos() {
        return itensPedidos;
    }
}
