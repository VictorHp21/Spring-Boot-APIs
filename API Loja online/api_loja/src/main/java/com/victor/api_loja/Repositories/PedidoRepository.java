package com.victor.api_loja.Repositories;

import com.victor.api_loja.model.Pedido;
import com.victor.api_loja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
