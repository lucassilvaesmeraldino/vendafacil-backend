package br.com.wmw.vendafacil_backend.data.models.produto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;

class ProdutoResponseModelTest {

	private static final long CODIGO_PRODUTO = 1;
	private static final String NOME_PRODUTO = "Monitor Samsung 24 polegadas";
	private static final double PRECO_PRODUTO = 1200.89;

	private static final long CODIGO_PRODUTO2 = 2;
	private static final String NOME_PRODUTO2 = "Celular Iphone 8 Plus";
	private static final double PRECO_PRODUTO2 = 4000.00;

	@Test
	void deveriaConverterUmProdutoEmUmProdutoResponseModel() {
		final Produto produto = new Produto(ProdutoResponseModelTest.CODIGO_PRODUTO,
				ProdutoResponseModelTest.NOME_PRODUTO, ProdutoResponseModelTest.PRECO_PRODUTO);

		final ProdutoResponseModel produtoResponseModel = new ProdutoResponseModel(produto);

		assertEquals(ProdutoResponseModelTest.CODIGO_PRODUTO, produtoResponseModel.getCodigo());
		assertEquals(ProdutoResponseModelTest.NOME_PRODUTO, produtoResponseModel.getNome());
		assertEquals(ProdutoResponseModelTest.PRECO_PRODUTO, produtoResponseModel.getPreco());
	}

	@Test
	void deveriaConverterUmaListaDeProdutosEmUmaListaDeProdutosResponseModel() {
		final Produto produto1 = new Produto(ProdutoResponseModelTest.CODIGO_PRODUTO,
				ProdutoResponseModelTest.NOME_PRODUTO, ProdutoResponseModelTest.PRECO_PRODUTO);
		final Produto produto2 = new Produto(ProdutoResponseModelTest.CODIGO_PRODUTO2,
				ProdutoResponseModelTest.NOME_PRODUTO2, ProdutoResponseModelTest.PRECO_PRODUTO2);

		final List<ProdutoResponseModel> produtoResponseModelList = ProdutoResponseModel
				.convert(List.of(produto1, produto2));

		final ProdutoResponseModel produtoResponseModel1 = produtoResponseModelList.stream()
				.filter(prm -> prm.getCodigo() == ProdutoResponseModelTest.CODIGO_PRODUTO).findFirst().get();
		assertEquals(ProdutoResponseModelTest.NOME_PRODUTO, produtoResponseModel1.getNome());
		assertEquals(ProdutoResponseModelTest.PRECO_PRODUTO, produtoResponseModel1.getPreco());

		final ProdutoResponseModel produtoResponseModel2 = produtoResponseModelList.stream()
				.filter(prm -> prm.getCodigo() == ProdutoResponseModelTest.CODIGO_PRODUTO2).findFirst().get();
		assertEquals(ProdutoResponseModelTest.NOME_PRODUTO2, produtoResponseModel2.getNome());
		assertEquals(ProdutoResponseModelTest.PRECO_PRODUTO2, produtoResponseModel2.getPreco());

	}

}
