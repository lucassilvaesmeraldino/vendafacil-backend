package br.com.wmw.vendafacil_backend.data.models.pedido;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import br.com.wmw.vendafacil_backend.domain.produto.usecases.GetProduto;
import br.com.wmw.vendafacil_backend.domain.shared.entity.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ItemPedidoRequestModel {

	@NotNull
	@Positive(message = "O numero da sequencia do item deve ser um valor positivo.")
	private final Long numeroSequencia;
	@NotNull
	@Positive(message = "A quantidade do item deve ser um valor positivo.")
	private final Integer quantidade;
	@NotNull
	@PositiveOrZero(message = "O preco unitário do item deve ser um valor positivo ou zero.")
	private final Double precoUnitario;
	@NotNull
	@PositiveOrZero(message="O desconto do item deve ser um valor positivo ou zero.")
	private final Double desconto;
	@NotNull
	@PositiveOrZero(message = "O valor total do item deve ser um valor positivo ou zero.")
	private final Double valorTotal;
	@NotNull
	@Positive
	private final Long codigoProduto;

	public ItemPedido toItemPedido(final GetProduto getProduto) {
		return new ItemPedido(this.numeroSequencia, this.quantidade, this.precoUnitario, this.desconto, this.valorTotal,
				getProduto.execute(this.codigoProduto));
	}

}
