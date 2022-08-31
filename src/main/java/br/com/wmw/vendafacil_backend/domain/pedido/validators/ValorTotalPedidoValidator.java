package br.com.wmw.vendafacil_backend.domain.pedido.validators;

import br.com.wmw.vendafacil_backend.core.exceptions.ValidationException;
import br.com.wmw.vendafacil_backend.domain.pedido.entity.Pedido;
import br.com.wmw.vendafacil_backend.domain.shared.entity.ItemPedido;

public class ValorTotalPedidoValidator {

	public void validate(final Pedido pedido) {
		final Double valorTotalItensPedido = 
				pedido.getItens().stream().mapToDouble(ItemPedido::getValorTotal).sum();
		if (!pedido.getValorTotal().equals(valorTotalItensPedido)) {
			throw new ValidationException("O valor total do pedido difere da soma dos valores dos seus itens.");
		}
	}
}
