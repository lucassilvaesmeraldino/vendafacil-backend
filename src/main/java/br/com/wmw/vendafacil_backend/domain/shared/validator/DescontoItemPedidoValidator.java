package br.com.wmw.vendafacil_backend.domain.shared.validator;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.wmw.vendafacil_backend.core.exceptions.ValidationException;
import br.com.wmw.vendafacil_backend.domain.shared.entity.ItemPedido;

public class DescontoItemPedidoValidator {

	public void validate(final ItemPedido itemPedido) {
		validatePrecoUnitario(itemPedido);
		validateValorTotal(itemPedido);
	}

	private void validatePrecoUnitario(final ItemPedido itemPedido) {
		final Double precoUnitarioCorreto = itemPedido.getProduto().getPreco() - itemPedido.getDesconto();
		if (!itemPedido.getPrecoUnitario().equals(precoUnitarioCorreto)) {
			throw new ValidationException(String.format(
					"O preco unitário do item de NUMERO SEQUENCIA %d não está com o desconto aplicado corretamente.",
					itemPedido.getNumeroSequencia()));
		}
	}

	private void validateValorTotal(final ItemPedido itemPedido) {
		final Double precoUnitarioCorreto = itemPedido.getProduto().getPreco() - itemPedido.getDesconto();
		final Double valorTotalCorreto = new BigDecimal(precoUnitarioCorreto * itemPedido.getQuantidade())
				.setScale(2, RoundingMode.HALF_UP).doubleValue();
		if (!itemPedido.getValorTotal().equals(valorTotalCorreto)) {
			throw new ValidationException(String.format(
					"O valor total do item de NUMERO SEQUENCIA %d não está corretamente calculado.",
					itemPedido.getNumeroSequencia()));
		}
	}
}
