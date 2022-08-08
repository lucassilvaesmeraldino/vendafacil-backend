package br.com.wmw.vendafacil_backend.data.models.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import br.com.wmw.vendafacil_backend.domain.cliente.entity.TipoPessoa;
import br.com.wmw.vendafacil_backend.domain.pedido.entity.Pedido;
import br.com.wmw.vendafacil_backend.domain.pedido.entity.StatusPedido;

class PedidoResponseModelTest {

	private static final long CLIENTE_CODIGO = 1;
	private static final String CLIENTE_NOME = "Lucas";
	private static final String CLIENTE_TELEFONE = "(48)99999-9999";
	private static final String CLIENTE_EMAIL = "lucas@gmail.com";
	private static final String CLIENTE_CPFCNPJ = "888.888.888-88";
	private static final long TIPOPESSOA_CODIGO = 1;
	private static final String TIPOPESSOA_DESCRICAO = "Física";

	private static final long STATUSPEDIDO_CODIGO = 1;
	private static final String STATUSPEDIDO_DESCRICAO = "Emitido";

	private static final long PEDIDO_NUMERO = 1;
	private static final LocalDate PEDIDO_DATAEMISSAO = LocalDate.now();
	private static final LocalDate PEDIDO_DATAENTREGA = LocalDate.of(2022, 8, 6);
	private static final double PEDIDO_VALORTOTAL = 75;

	@Test
	void deveriaConverterUmPedidoParaUmPedidoResponseModel() {
		final Pedido pedido = new Pedido(PedidoResponseModelTest.PEDIDO_NUMERO,
				PedidoResponseModelTest.PEDIDO_DATAEMISSAO, PedidoResponseModelTest.PEDIDO_DATAENTREGA,
				new StatusPedido(PedidoResponseModelTest.STATUSPEDIDO_CODIGO,
						PedidoResponseModelTest.STATUSPEDIDO_DESCRICAO),
				PedidoResponseModelTest.PEDIDO_VALORTOTAL,
				new Cliente(PedidoResponseModelTest.CLIENTE_CODIGO, PedidoResponseModelTest.CLIENTE_NOME,
						PedidoResponseModelTest.CLIENTE_TELEFONE, PedidoResponseModelTest.CLIENTE_EMAIL,
						PedidoResponseModelTest.CLIENTE_CPFCNPJ,
						new TipoPessoa(PedidoResponseModelTest.TIPOPESSOA_CODIGO,
								PedidoResponseModelTest.TIPOPESSOA_DESCRICAO)),
				null);
		final PedidoResponseModel pedidoResponseModel = new PedidoResponseModel(pedido);

		assertEquals(pedidoResponseModel.getNumero(), PedidoResponseModelTest.PEDIDO_NUMERO);
		assertEquals(pedidoResponseModel.getDataEmissao(), PedidoResponseModelTest.PEDIDO_DATAEMISSAO);
		assertEquals(pedidoResponseModel.getStatusPedido(), PedidoResponseModelTest.STATUSPEDIDO_DESCRICAO);
		assertEquals(pedidoResponseModel.getCpfCnpjCliente(), PedidoResponseModelTest.CLIENTE_CPFCNPJ);
		assertEquals(pedidoResponseModel.getValorTotal(), PedidoResponseModelTest.PEDIDO_VALORTOTAL);
	}

}
