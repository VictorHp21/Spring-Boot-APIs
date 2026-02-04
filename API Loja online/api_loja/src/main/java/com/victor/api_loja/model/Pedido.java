package com.victor.api_loja.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Pedidos")
public class Pedido {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime data_e_hora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ItemPedido> itens;

    private BigDecimal valorTotal;


    public Pedido(){}

    public Pedido(LocalDateTime data_e_hora, Cliente cliente, List<ItemPedido> itens) {
        this.data_e_hora = data_e_hora;
        this.cliente = cliente;
        this.itens = itens;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getData_e_hora() {
        return data_e_hora;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }



    // para valor total criar um metodo que multiple produto * quantidade a cada item_pedido e depois some tudo.

    public BigDecimal valorPedido(){
        BigDecimal valorTotal = BigDecimal.ZERO;


        for (ItemPedido i : itens){
           valorTotal = valorTotal.add(i.getSubTotal()) ;
        }

        return valorTotal;
    }

}
