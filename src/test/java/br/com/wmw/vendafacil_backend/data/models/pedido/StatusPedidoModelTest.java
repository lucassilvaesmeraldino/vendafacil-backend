package br.com.wmw.vendafacil_backend.data.models.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.wmw.vendafacil_backend.domain.pedido.entity.StatusPedido;

class StatusPedidoModelTest {

	private static final long CODIGO_STATUSPEDIDO = 1;
	private static final String DESCRICAO_STATUSPEDIDO = "Emitido";


	@Test
	void deveriaConverterUmStatusPedidoParaUmStatusPedidoModel() {
		final StatusPedido statusPedido = new StatusPedido(StatusPedidoModelTest.CODIGO_STATUSPEDIDO,
				StatusPedidoModelTest.DESCRICAO_STATUSPEDIDO);
		final StatusPedidoModel statusPedidoModel = StatusPedidoModel.convert(statusPedido);

		assertEquals(StatusPedidoModelTest.CODIGO_STATUSPEDIDO, statusPedidoModel.getCodigo());
		assertEquals(StatusPedidoModelTest.DESCRICAO_STATUSPEDIDO, statusPedidoModel.getDescricao());

	}

	@Test
	void deveriaConverterUmStatusPedidoModelParaUmStatusPedido() {
		final StatusPedidoModel statusPedidoModel = new StatusPedidoModel(
				StatusPedidoModelTest.CODIGO_STATUSPEDIDO, StatusPedidoModelTest.DESCRICAO_STATUSPEDIDO);
		final StatusPedido statusPedido = statusPedidoModel.toStatusPedido();

		assertEquals(StatusPedidoModelTest.CODIGO_STATUSPEDIDO, statusPedido.getCodigo());
		assertEquals(StatusPedidoModelTest.DESCRICAO_STATUSPEDIDO, statusPedido.getDescricao());

	}

}
