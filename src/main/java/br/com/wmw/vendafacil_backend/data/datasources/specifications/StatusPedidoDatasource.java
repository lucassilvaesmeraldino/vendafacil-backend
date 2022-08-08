package br.com.wmw.vendafacil_backend.data.datasources.specifications;

import java.util.Optional;

import br.com.wmw.vendafacil_backend.data.models.pedido.StatusPedidoModel;

public interface StatusPedidoDatasource {

	Optional<StatusPedidoModel> getStatusPedidoByCodigo(Long codigo);
}
