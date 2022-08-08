package br.com.wmw.vendafacil_backend.domain.pedido.usecases;

import br.com.wmw.vendafacil_backend.domain.pedido.entity.StatusPedido;
import br.com.wmw.vendafacil_backend.domain.pedido.repository.StatusPedidoRepository;

public class GetStatusPedido {

	private final StatusPedidoRepository statusPedidoRepository;

	public GetStatusPedido(final StatusPedidoRepository statusPedidoRepository) {
		this.statusPedidoRepository = statusPedidoRepository;
	}

	public StatusPedido execute(final Long codigo) {
		return this.statusPedidoRepository.getStatusPedidoByCodigo(codigo);
	}
}
