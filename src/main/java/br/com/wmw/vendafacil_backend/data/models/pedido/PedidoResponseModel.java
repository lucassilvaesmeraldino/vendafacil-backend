package br.com.wmw.vendafacil_backend.data.models.pedido;

import java.time.LocalDate;

import br.com.wmw.vendafacil_backend.domain.pedido.entity.Pedido;
import lombok.Getter;

@Getter
public class PedidoResponseModel {

	private final Long numero;
	private final LocalDate dataEmissao;
	private final String statusPedido;
	private final String cpfCnpjCliente;
	private final Double valorTotal;

	public PedidoResponseModel(final Pedido pedido) {
		this.numero = pedido.getNumero();
		this.dataEmissao = pedido.getDataEmissao();
		this.statusPedido = pedido.getStatus().getDescricao();
		this.cpfCnpjCliente = pedido.getCliente().getCpfCnpj();
		this.valorTotal = pedido.getValorTotal();
	}

}
