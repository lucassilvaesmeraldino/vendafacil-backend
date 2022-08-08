package br.com.wmw.vendafacil_backend.data.models.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.wmw.vendafacil_backend.domain.cliente.usecases.GetCliente;
import br.com.wmw.vendafacil_backend.domain.pedido.entity.Pedido;
import br.com.wmw.vendafacil_backend.domain.pedido.usecases.GetStatusPedido;
import br.com.wmw.vendafacil_backend.domain.produto.usecases.GetProduto;

@SpringBootTest
@ActiveProfiles("teste")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PedidoRequestModelTest {

	@Autowired
	private GetStatusPedido getStatusPedido;

	@Autowired
	private GetProduto getProduto;

	@Autowired
	private GetCliente getCliente;

	private static final LocalDate PEDIDOREQUESTMODEL_DATAEMISSAO = LocalDate.now();
	private static final LocalDate PEDIDOREQUESTMODEL_DATAENTREGA = LocalDate.of(2022, 8, 6);
	private static final double PEDIDOREQUESTMODEL_VALORTOTAL = 75;
	private static final long PEDIDOREQUESTMODEL_CODIGOSTATUSPEDIDO = 1;
	private static final long PEDIDOREQUESTMODEL_CODIGOCLIENTE = 1;

	@Test
	void deveriaConverterUmPedidoRequestModelParaUmPedido() {
		final PedidoRequestModel pedidoRequestModel = new PedidoRequestModel(
				PedidoRequestModelTest.PEDIDOREQUESTMODEL_DATAEMISSAO,
				PedidoRequestModelTest.PEDIDOREQUESTMODEL_DATAENTREGA,
				PedidoRequestModelTest.PEDIDOREQUESTMODEL_CODIGOSTATUSPEDIDO,
				PedidoRequestModelTest.PEDIDOREQUESTMODEL_CODIGOCLIENTE,
				PedidoRequestModelTest.PEDIDOREQUESTMODEL_VALORTOTAL, new ArrayList<>());
		final Pedido pedido = pedidoRequestModel.toPedido(this.getStatusPedido, this.getProduto, this.getCliente);

		assertEquals(pedido.getDataEmissao(), PedidoRequestModelTest.PEDIDOREQUESTMODEL_DATAEMISSAO);
		assertEquals(pedido.getDataEntrega(), PedidoRequestModelTest.PEDIDOREQUESTMODEL_DATAENTREGA);
		assertEquals(pedido.getValorTotal(), PedidoRequestModelTest.PEDIDOREQUESTMODEL_VALORTOTAL);
		assertEquals(pedido.getStatus().getCodigo(), PedidoRequestModelTest.PEDIDOREQUESTMODEL_CODIGOSTATUSPEDIDO);
		assertEquals(pedido.getCliente().getCodigo(), PedidoRequestModelTest.PEDIDOREQUESTMODEL_CODIGOCLIENTE);
	}

}
