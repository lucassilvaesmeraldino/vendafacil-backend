package br.com.wmw.vendafacil_backend.domain.pedido.validators;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.wmw.vendafacil_backend.core.exceptions.ValidationException;
import br.com.wmw.vendafacil_backend.domain.pedido.entity.Pedido;
import br.com.wmw.vendafacil_backend.domain.shared.entity.ItemPedido;

public class ValorTotalPedidoValidator {

	public void validate(final Pedido pedido) {
		final Double valorTotalItensPedido = new BigDecimal(
				pedido.getItens().stream().mapToDouble(ItemPedido::getValorTotal).sum())
				.setScale(2, RoundingMode.HALF_UP).doubleValue();
		if (!pedido.getValorTotal().equals(valorTotalItensPedido)) {
			throw new ValidationException("O valor total do pedido difere da soma dos valores dos seus itens.");
		}
	}
}
