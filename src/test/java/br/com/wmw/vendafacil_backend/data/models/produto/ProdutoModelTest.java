package br.com.wmw.vendafacil_backend.data.models.produto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;

class ProdutoModelTest {

	private static final long CODIGO_PRODUTO1 = 1;
	private static final String NOME_PRODUTO1 = "Monitor Samsung 24 polegadas";
	private static final double PRECO_PRODUTO1 = 1200.89;

	private static final long CODIGO_PRODUTO2 = 2;
	private static final String NOME_PRODUTO2 = "Celular Iphone 8 Plus";
	private static final double PRECO_PRODUTO2 = 4000.00;

	@Test
	void deveriaConverterUmaListaDeProdutosModelEmUmaListaDeProdutos() {
		final ProdutoModel produtoModel1 = new ProdutoModel(ProdutoModelTest.CODIGO_PRODUTO1,
				ProdutoModelTest.NOME_PRODUTO1, ProdutoModelTest.PRECO_PRODUTO1);
		final ProdutoModel produtoModel2 = new ProdutoModel(ProdutoModelTest.CODIGO_PRODUTO2,
				ProdutoModelTest.NOME_PRODUTO2, ProdutoModelTest.PRECO_PRODUTO2);

		final List<Produto> produtoList = ProdutoModel.convertToProdutoList(List.of(produtoModel1, produtoModel2));

		final Produto produto1 = produtoList.stream().filter(p -> p.getCodigo() == ProdutoModelTest.CODIGO_PRODUTO1)
				.findFirst().get();
		assertEquals(ProdutoModelTest.NOME_PRODUTO1, produto1.getNome());
		assertEquals(ProdutoModelTest.PRECO_PRODUTO1, produto1.getPreco());

		final Produto produto2 = produtoList.stream().filter(p -> p.getCodigo() == ProdutoModelTest.CODIGO_PRODUTO2)
				.findFirst().get();
		assertEquals(ProdutoModelTest.NOME_PRODUTO2, produto2.getNome());
		assertEquals(ProdutoModelTest.PRECO_PRODUTO2, produto2.getPreco());

	}

}
