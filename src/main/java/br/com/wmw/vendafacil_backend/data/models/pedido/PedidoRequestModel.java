package br.com.wmw.vendafacil_backend.data.models.pedido;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import br.com.wmw.vendafacil_backend.domain.cliente.usecases.GetCliente;
import br.com.wmw.vendafacil_backend.domain.pedido.entity.Pedido;
import br.com.wmw.vendafacil_backend.domain.pedido.usecases.GetStatusPedido;
import br.com.wmw.vendafacil_backend.domain.produto.usecases.GetProduto;
import br.com.wmw.vendafacil_backend.domain.shared.entity.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PedidoRequestModel {

	@NotNull(message = "A data de emissão do pedido não pode ser nula.")
	@FutureOrPresent(message = "A data de emissão deve ser igual a presente data ou posterior.")
	private final LocalDate dataEmissao;
	@NotNull(message = "A data de entrega do pedido não pode ser nula.")
	@FutureOrPresent(message = "A data de entrega deve ser igual a presente data ou posterior.")
	private final LocalDate dataEntrega;
	@Positive
	private final Long codigoStatusPedido;
	@Positive
	private final Long codigoCliente;
	@PositiveOrZero(message = "O valor do pedido deve ser zero ou maior que zero.")
	private final Double valorTotal;
	@NotEmpty(message = "O pedido deve ter itens vinculados a ele mesmo.")
	@Valid
	private final List<ItemPedidoRequestModel> itens;

	public Pedido toPedido(final GetStatusPedido getStatusPedido, final GetProduto getProduto,
			final GetCliente getCliente) {
		final List<ItemPedido> itensConverted = this.itens.stream().map(i -> i.toItemPedido(getProduto))
				.collect(Collectors.toList());
		return new Pedido(this.dataEmissao, this.dataEntrega,
				getStatusPedido.execute(this.codigoStatusPedido), this.valorTotal,
				getCliente.execute(this.codigoCliente), itensConverted);
	}

}
