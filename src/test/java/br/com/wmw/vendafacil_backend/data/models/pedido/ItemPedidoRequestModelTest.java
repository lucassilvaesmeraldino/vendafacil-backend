package br.com.wmw.vendafacil_backend.data.models.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.wmw.vendafacil_backend.domain.produto.usecases.GetProduto;
import br.com.wmw.vendafacil_backend.domain.shared.entity.ItemPedido;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ItemPedidoRequestModelTest {

	@Autowired
	private GetProduto getProduto;

	private static final long ITEMPEDIDOREQUESTMODEL_NUMEROSEQUENCIA = 1;
	private static final int ITEMPEDIDOREQUESTMODEL_QUANTIDADE = 2;
	private static final double ITEMPEDIDOREQUESTMODEL_PRECOUNITARIO = 19.99;
	private static final double ITEMPEDIDOREQUESTMODEL_DESCONTO = 0;
	private static final double ITEMPEDIDOREQUESTMODEL_VALORTOTAL = 39.98;
	private static final long ITEMPEDIDOREQUESTMODEL_CODIGOPRODUTO = 1;

	@Test
	void deveriaConverterUmItemPedidoRequestModelEmUmItemPedido() {
		final ItemPedidoRequestModel itemPedidoRequestModel = new ItemPedidoRequestModel(
				ItemPedidoRequestModelTest.ITEMPEDIDOREQUESTMODEL_NUMEROSEQUENCIA,
				ItemPedidoRequestModelTest.ITEMPEDIDOREQUESTMODEL_QUANTIDADE,
				ItemPedidoRequestModelTest.ITEMPEDIDOREQUESTMODEL_PRECOUNITARIO,
				ItemPedidoRequestModelTest.ITEMPEDIDOREQUESTMODEL_DESCONTO,
				ItemPedidoRequestModelTest.ITEMPEDIDOREQUESTMODEL_VALORTOTAL,
				ItemPedidoRequestModelTest.ITEMPEDIDOREQUESTMODEL_CODIGOPRODUTO);
		final ItemPedido itemPedido = itemPedidoRequestModel.toItemPedido(this.getProduto);

		assertEquals(itemPedido.getNumeroSequencia(),
				ItemPedidoRequestModelTest.ITEMPEDIDOREQUESTMODEL_NUMEROSEQUENCIA);
		assertEquals(itemPedido.getQuantidade(), ItemPedidoRequestModelTest.ITEMPEDIDOREQUESTMODEL_QUANTIDADE);
		assertEquals(itemPedido.getPrecoUnitario(), ItemPedidoRequestModelTest.ITEMPEDIDOREQUESTMODEL_PRECOUNITARIO);
		assertEquals(itemPedido.getDesconto(), ItemPedidoRequestModelTest.ITEMPEDIDOREQUESTMODEL_DESCONTO);
		assertEquals(itemPedido.getValorTotal(), ItemPedidoRequestModelTest.ITEMPEDIDOREQUESTMODEL_VALORTOTAL);
		assertEquals(itemPedido.getProduto().getCodigo(),
				ItemPedidoRequestModelTest.ITEMPEDIDOREQUESTMODEL_CODIGOPRODUTO);
	}

}
