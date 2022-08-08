package br.com.wmw.vendafacil_backend.domain.pedido.usecases;

import br.com.wmw.vendafacil_backend.domain.pedido.entity.Pedido;
import br.com.wmw.vendafacil_backend.domain.pedido.repository.PedidoRepository;
import br.com.wmw.vendafacil_backend.domain.pedido.validators.ValorTotalPedidoValidator;
import br.com.wmw.vendafacil_backend.domain.shared.validator.DescontoItemPedidoValidator;

public class CreatePedido {

	private final PedidoRepository pedidoRepository;

	private final ValorTotalPedidoValidator valorTotalPedidoValidator;

	private final DescontoItemPedidoValidator descontoItemValidator;

	public CreatePedido(final PedidoRepository pedidoRepository,
			final ValorTotalPedidoValidator valorTotalPedidoValidator,
			final DescontoItemPedidoValidator descontoItemValidator) {
		this.pedidoRepository = pedidoRepository;
		this.valorTotalPedidoValidator = valorTotalPedidoValidator;
		this.descontoItemValidator = descontoItemValidator;
	}

	public Pedido execute(final Pedido pedido) {
		executeValidations(pedido);
		return this.pedidoRepository.createPedido(pedido);
	}

	private void executeValidations(final Pedido pedido) {
		pedido.getItens().forEach(item -> this.descontoItemValidator.validate(item));
		this.valorTotalPedidoValidator.validate(pedido);
	}
}
