package br.com.wmw.vendafacil_backend.data.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;
import br.com.wmw.vendafacil_backend.domain.produto.repository.ProdutoRepository;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProdutoRepositoryImplementationTest {

	private static final long CODIGO_PRODUTO1 = 1;
	private static final String NOME_PRODUTO1 = "Suporte para celular Samsung";
	private static final double PRECO_PRODUTO1 = 19.99;

	private static final long CODIGO_PRODUTO2 = 2;
	private static final String NOME_PRODUTO2 = "Capinha para celular Samsung S10 Plus";
	private static final double PRECO_PRODUTO2 = 59.89;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Test
	void deveriaRetornarTodosOsProdutos() {
		final List<Produto> produtoList = this.produtoRepository.getProdutos();

		assertEquals(2, produtoList.size());

		final Produto produto1 = produtoList.stream()
				.filter(p -> p.getCodigo() == ProdutoRepositoryImplementationTest.CODIGO_PRODUTO1).findFirst().get();
		assertEquals(produto1.getNome(), ProdutoRepositoryImplementationTest.NOME_PRODUTO1);
		assertEquals(produto1.getPreco(), ProdutoRepositoryImplementationTest.PRECO_PRODUTO1);

		final Produto produto2 = produtoList.stream()
				.filter(p -> p.getCodigo() == ProdutoRepositoryImplementationTest.CODIGO_PRODUTO2).findFirst().get();
		assertEquals(produto2.getNome(), ProdutoRepositoryImplementationTest.NOME_PRODUTO2);
		assertEquals(produto2.getPreco(), ProdutoRepositoryImplementationTest.PRECO_PRODUTO2);

	}

}
