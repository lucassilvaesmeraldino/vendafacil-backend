package br.com.wmw.vendafacil_backend.domain.pedido.repository;

import br.com.wmw.vendafacil_backend.domain.pedido.entity.Pedido;

public interface PedidoRepository {

	Pedido createPedido(Pedido pedido);

}
