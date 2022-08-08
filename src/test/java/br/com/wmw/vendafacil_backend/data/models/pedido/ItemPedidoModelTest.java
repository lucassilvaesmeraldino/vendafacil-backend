package br.com.wmw.vendafacil_backend.data.models.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.wmw.vendafacil_backend.data.models.produto.ProdutoModel;
import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;
import br.com.wmw.vendafacil_backend.domain.shared.entity.ItemPedido;

class ItemPedidoModelTest {

	private static final long PRODUTO_CODIGO = 1;
	private static final String PRODUTO_NOME = "Carteira de couro Bennesh";
	private static final double PRODUTO_PRECO = 30;

	private static final long ITEMPEDIDO_CODIGO = 1;
	private static final long ITEMPEDIDO_NUMEROSEQUENCIA = 1;
	private static final int ITEMPEDIDO_QUANTIDADE = 2;
	private static final double ITEMPEDIDO_PRECOUNITARIO = 25;
	private static final double ITEMPEDIDO_DESCONTO = 5;
	private static final double ITEMPEDIDO_VALORTOTAL = 50;

	@Test
	void deveriaConverterUmItemPedidoEmUmItemPedidoModel() {
		final ItemPedido itemPedido = new ItemPedido(
				ItemPedidoModelTest.ITEMPEDIDO_NUMEROSEQUENCIA, ItemPedidoModelTest.ITEMPEDIDO_QUANTIDADE,
				ItemPedidoModelTest.ITEMPEDIDO_PRECOUNITARIO, ItemPedidoModelTest.ITEMPEDIDO_DESCONTO,
				ItemPedidoModelTest.ITEMPEDIDO_VALORTOTAL, new Produto(ItemPedidoModelTest.PRODUTO_CODIGO,
						ItemPedidoModelTest.PRODUTO_NOME, ItemPedidoModelTest.PRODUTO_PRECO));
		final ItemPedidoModel itemPedidoModel = ItemPedidoModel.toItemPedidoModel(itemPedido);

		assertEquals(itemPedidoModel.getNumeroSequencia(), ItemPedidoModelTest.ITEMPEDIDO_NUMEROSEQUENCIA);
		assertEquals(itemPedidoModel.getQuantidade(), ItemPedidoModelTest.ITEMPEDIDO_QUANTIDADE);
		assertEquals(itemPedidoModel.getPrecoUnitario(), ItemPedidoModelTest.ITEMPEDIDO_PRECOUNITARIO);
		assertEquals(itemPedidoModel.getDesconto(), ItemPedidoModelTest.ITEMPEDIDO_DESCONTO);
		assertEquals(itemPedidoModel.getValorTotal(), ItemPedidoModelTest.ITEMPEDIDO_VALORTOTAL);
		assertEquals(itemPedidoModel.getProduto().getCodigo(), ItemPedidoModelTest.PRODUTO_CODIGO);
		assertEquals(itemPedidoModel.getProduto().getNome(), ItemPedidoModelTest.PRODUTO_NOME);
		assertEquals(itemPedidoModel.getProduto().getPreco(), ItemPedidoModelTest.PRODUTO_PRECO);
	}

	@Test
	void deveriaConverterUmItemPedidoModelEmUmItemPedido() {
		final ItemPedidoModel itemPedidoModel = new ItemPedidoModel(ItemPedidoModelTest.ITEMPEDIDO_CODIGO,
				new ProdutoModel(ItemPedidoModelTest.PRODUTO_CODIGO, ItemPedidoModelTest.PRODUTO_NOME,
						ItemPedidoModelTest.PRODUTO_PRECO),
				ItemPedidoModelTest.ITEMPEDIDO_NUMEROSEQUENCIA, ItemPedidoModelTest.ITEMPEDIDO_QUANTIDADE,
				ItemPedidoModelTest.ITEMPEDIDO_PRECOUNITARIO, ItemPedidoModelTest.ITEMPEDIDO_DESCONTO,
				ItemPedidoModelTest.ITEMPEDIDO_VALORTOTAL);
		final ItemPedido itemPedido = itemPedidoModel.toItemPedido();

		assertEquals(itemPedido.getCodigo(), ItemPedidoModelTest.ITEMPEDIDO_CODIGO);
		assertEquals(itemPedido.getNumeroSequencia(), ItemPedidoModelTest.ITEMPEDIDO_NUMEROSEQUENCIA);
		assertEquals(itemPedido.getQuantidade(), ItemPedidoModelTest.ITEMPEDIDO_QUANTIDADE);
		assertEquals(itemPedido.getPrecoUnitario(), ItemPedidoModelTest.ITEMPEDIDO_PRECOUNITARIO);
		assertEquals(itemPedido.getDesconto(), ItemPedidoModelTest.ITEMPEDIDO_DESCONTO);
		assertEquals(itemPedido.getValorTotal(), ItemPedidoModelTest.ITEMPEDIDO_VALORTOTAL);
		assertEquals(itemPedido.getProduto().getCodigo(), ItemPedidoModelTest.PRODUTO_CODIGO);
		assertEquals(itemPedido.getProduto().getNome(), ItemPedidoModelTest.PRODUTO_NOME);
		assertEquals(itemPedido.getProduto().getPreco(), ItemPedidoModelTest.PRODUTO_PRECO);

	}

}
