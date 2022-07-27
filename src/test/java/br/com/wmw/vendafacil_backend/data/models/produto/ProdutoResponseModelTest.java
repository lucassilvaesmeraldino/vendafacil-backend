package br.com.wmw.vendafacil_backend.data.models.produto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;

@SpringBootTest
class ProdutoResponseModelTest {

	private static final long CODIGO_PRODUTO1 = 1;
	private static final String NOME_PRODUTO1 = "Monitor Samsung 24 polegadas";
	private static final double PRECO_PRODUTO1 = 1200.89;

	private static final long CODIGO_PRODUTO2 = 2;
	private static final String NOME_PRODUTO2 = "Celular Iphone 8 Plus";
	private static final double PRECO_PRODUTO2 = 4000.00;

	@Test
	void deveriaConverterUmProdutoEmUmProdutoResponseModel() {
		final Produto produto = new Produto(ProdutoResponseModelTest.CODIGO_PRODUTO1,
				ProdutoResponseModelTest.NOME_PRODUTO1, ProdutoResponseModelTest.PRECO_PRODUTO1);

		final ProdutoResponseModel produtoResponseModel = new ProdutoResponseModel(produto);

		assertEquals(produtoResponseModel.getCodigo(), ProdutoResponseModelTest.CODIGO_PRODUTO1);
		assertEquals(produtoResponseModel.getNome(), ProdutoResponseModelTest.NOME_PRODUTO1);
		assertEquals(produtoResponseModel.getPreco(), ProdutoResponseModelTest.PRECO_PRODUTO1);
	}

	@Test
	void deveriaConverterUmaListaDeProdutosParaUmaListaDeProdutosResponseModel() {
		final Produto produto1 = new Produto(ProdutoResponseModelTest.CODIGO_PRODUTO1,
				ProdutoResponseModelTest.NOME_PRODUTO1, ProdutoResponseModelTest.PRECO_PRODUTO1);
		final Produto produto2 = new Produto(ProdutoResponseModelTest.CODIGO_PRODUTO2,
				ProdutoResponseModelTest.NOME_PRODUTO2, ProdutoResponseModelTest.PRECO_PRODUTO2);

		final List<ProdutoResponseModel> produtoResponseModelList = ProdutoResponseModel
				.convert(List.of(produto1, produto2));

		final ProdutoResponseModel produtoResponseModel1 = produtoResponseModelList.stream()
				.filter(prm -> prm.getCodigo() == ProdutoResponseModelTest.CODIGO_PRODUTO1).findFirst().get();
		assertEquals(produtoResponseModel1.getNome(), ProdutoResponseModelTest.NOME_PRODUTO1);
		assertEquals(produtoResponseModel1.getPreco(), ProdutoResponseModelTest.PRECO_PRODUTO1);

		final ProdutoResponseModel produtoResponseModel2 = produtoResponseModelList.stream()
				.filter(prm -> prm.getCodigo() == ProdutoResponseModelTest.CODIGO_PRODUTO2).findFirst().get();
		assertEquals(produtoResponseModel2.getNome(), ProdutoResponseModelTest.NOME_PRODUTO2);
		assertEquals(produtoResponseModel2.getPreco(), ProdutoResponseModelTest.PRECO_PRODUTO2);

	}

}
