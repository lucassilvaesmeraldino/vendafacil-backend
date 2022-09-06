package br.com.wmw.vendafacil_backend.data.models.pedido;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

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
	private final LocalDate dataEmissao;
	@NotNull(message = "A data de entrega do pedido não pode ser nula.")
	private final LocalDate dataEntrega;
	@Positive
	@NotNull
	private final Long codigoStatusPedido;
	@Positive
	@NotNull
	private final Long codigoCliente;
	@Positive(message = "O valor do pedido deve ser maior que zero.")
	@NotNull
	private final Double valorTotal;
	@NotEmpty(message = "O pedido deve ter itens vinculados a ele mesmo.")
	@Valid
	private final List<ItemPedidoRequestModel> itens;

	public Pedido toPedido(final GetStatusPedido getStatusPedido, final GetProduto getProduto,
			final GetCliente getCliente) {
		final List<ItemPedido> itensConverted = this.itens.stream().map(i -> i.toItemPedido(getProduto))
				.toList();
		return new Pedido(this.dataEmissao, this.dataEntrega,
				getStatusPedido.execute(this.codigoStatusPedido), this.valorTotal,
				getCliente.execute(this.codigoCliente), itensConverted);
	}

}
