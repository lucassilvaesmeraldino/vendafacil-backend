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

		assertEquals(ItemPedidoModelTest.ITEMPEDIDO_NUMEROSEQUENCIA, itemPedidoModel.getNumeroSequencia());
		assertEquals(ItemPedidoModelTest.ITEMPEDIDO_QUANTIDADE, itemPedidoModel.getQuantidade());
		assertEquals(ItemPedidoModelTest.ITEMPEDIDO_PRECOUNITARIO, itemPedidoModel.getPrecoUnitario());
		assertEquals(ItemPedidoModelTest.ITEMPEDIDO_DESCONTO, itemPedidoModel.getDesconto());
		assertEquals(ItemPedidoModelTest.ITEMPEDIDO_VALORTOTAL, itemPedidoModel.getValorTotal());
		assertEquals(ItemPedidoModelTest.PRODUTO_CODIGO, itemPedidoModel.getProduto().getCodigo());
		assertEquals(ItemPedidoModelTest.PRODUTO_NOME, itemPedidoModel.getProduto().getNome());
		assertEquals(ItemPedidoModelTest.PRODUTO_PRECO, itemPedidoModel.getProduto().getPreco());
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

		assertEquals(ItemPedidoModelTest.ITEMPEDIDO_CODIGO, itemPedido.getCodigo());
		assertEquals(ItemPedidoModelTest.ITEMPEDIDO_NUMEROSEQUENCIA, itemPedido.getNumeroSequencia());
		assertEquals(ItemPedidoModelTest.ITEMPEDIDO_QUANTIDADE, itemPedido.getQuantidade());
		assertEquals(ItemPedidoModelTest.ITEMPEDIDO_PRECOUNITARIO, itemPedido.getPrecoUnitario());
		assertEquals(ItemPedidoModelTest.ITEMPEDIDO_DESCONTO, itemPedido.getDesconto());
		assertEquals(ItemPedidoModelTest.ITEMPEDIDO_VALORTOTAL, itemPedido.getValorTotal());
		assertEquals(ItemPedidoModelTest.PRODUTO_CODIGO, itemPedido.getProduto().getCodigo());
		assertEquals(ItemPedidoModelTest.PRODUTO_NOME, itemPedido.getProduto().getNome());
		assertEquals(ItemPedidoModelTest.PRODUTO_PRECO, itemPedido.getProduto().getPreco());

	}

}
