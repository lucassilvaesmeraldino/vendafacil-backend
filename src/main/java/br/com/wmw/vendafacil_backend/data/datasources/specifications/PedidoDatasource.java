package br.com.wmw.vendafacil_backend.data.datasources.specifications;

import br.com.wmw.vendafacil_backend.data.models.pedido.PedidoModel;

public interface PedidoDatasource {

	PedidoModel createPedido(PedidoModel pedidoModel);
}
