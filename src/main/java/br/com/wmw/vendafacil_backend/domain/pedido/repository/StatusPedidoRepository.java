package br.com.wmw.vendafacil_backend.domain.pedido.repository;

import br.com.wmw.vendafacil_backend.domain.pedido.entity.StatusPedido;

public interface StatusPedidoRepository {

	StatusPedido getStatusPedidoByCodigo(Long codigo);
}
