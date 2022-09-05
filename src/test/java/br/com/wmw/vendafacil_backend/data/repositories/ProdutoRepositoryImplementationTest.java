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

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProdutoRepositoryImplementationTest {

	private static final long CODIGO_PRODUTO1 = 1;
	private static final String NOME_PRODUTO1 = "Suporte para celular Samsung";
	private static final double PRECO_PRODUTO1 = 19.99;

	private static final long CODIGO_PRODUTO2 = 2;
	private static final String NOME_PRODUTO2 = "Capinha para celular Samsung S10 Plus";
	private static final double PRECO_PRODUTO2 = 59.89;
	
	private static final long CODIGO_PRODUTO3 = 3;
	private static final String NOME_PRODUTO3 = "Oleo Extraordinario Elseve Tratamento";
	private static final double PRECO_PRODUTO3 = 40.49;
	
	private static final long CODIGO_PRODUTO4 = 4;
	private static final String NOME_PRODUTO4 = "Revlon Professional Uniq";
	private static final double PRECO_PRODUTO4 = 79.90;
	
	private static final long CODIGO_PRODUTO5 = 5;
	private static final String NOME_PRODUTO5 = "Samsung Galaxy A03 Dual SIM";
	private static final double PRECO_PRODUTO5 = 949;
	
	private static final long CODIGO_PRODUTO6 = 6;
	private static final String NOME_PRODUTO6 = "Notebook Asus X515JA slate gray";
	private static final double PRECO_PRODUTO6 = 2499;
	
	private static final long CODIGO_PRODUTO7 = 7;
	private static final String NOME_PRODUTO7 = "Camiseta Paris Reserva";
	private static final double PRECO_PRODUTO7 = 105.90;
	
	private static final long CODIGO_PRODUTO8 = 8;
	private static final String NOME_PRODUTO8 = "Calca Jeans Masculina Slim Tijuca Reserva";
	private static final double PRECO_PRODUTO8 = 125.90;
	
	private static final long CODIGO_PRODUTO9 = 9;
	private static final String NOME_PRODUTO9 = "Tenis New Balance 393 | Casual Feminino";
	private static final double PRECO_PRODUTO9 = 279.99;

	private static final long CODIGO_PRODUTO10 = 10;
	private static final String NOME_PRODUTO10 = "Bolsa Feminina Estilo Bucket/bau 2 Alcas Fashion";
	private static final double PRECO_PRODUTO10 = 200;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Test
	void deveriaRetornarTodosOsProdutos() {
		final List<Produto> produtoList = this.produtoRepository.getProdutos();

		assertEquals(10, produtoList.size());

		final Produto produto1 = produtoList.stream()
				.filter(p -> p.getCodigo() == ProdutoRepositoryImplementationTest.CODIGO_PRODUTO1).findFirst().get();
		assertEquals(ProdutoRepositoryImplementationTest.NOME_PRODUTO1, produto1.getNome());
		assertEquals(ProdutoRepositoryImplementationTest.PRECO_PRODUTO1, produto1.getPreco());

		final Produto produto2 = produtoList.stream()
				.filter(p -> p.getCodigo() == ProdutoRepositoryImplementationTest.CODIGO_PRODUTO2).findFirst().get();
		assertEquals(ProdutoRepositoryImplementationTest.NOME_PRODUTO2, produto2.getNome());
		assertEquals(ProdutoRepositoryImplementationTest.PRECO_PRODUTO2, produto2.getPreco());
		
		final Produto produto3 = produtoList.stream()
				.filter(p -> p.getCodigo() == ProdutoRepositoryImplementationTest.CODIGO_PRODUTO3).findFirst().get();
		assertEquals(ProdutoRepositoryImplementationTest.NOME_PRODUTO3, produto3.getNome());
		assertEquals(ProdutoRepositoryImplementationTest.PRECO_PRODUTO3, produto3.getPreco());
		
		final Produto produto4 = produtoList.stream()
				.filter(p -> p.getCodigo() == ProdutoRepositoryImplementationTest.CODIGO_PRODUTO4).findFirst().get();
		assertEquals(ProdutoRepositoryImplementationTest.NOME_PRODUTO4, produto4.getNome());
		assertEquals(ProdutoRepositoryImplementationTest.PRECO_PRODUTO4, produto4.getPreco());
		
		final Produto produto5 = produtoList.stream()
				.filter(p -> p.getCodigo() == ProdutoRepositoryImplementationTest.CODIGO_PRODUTO5).findFirst().get();
		assertEquals(ProdutoRepositoryImplementationTest.NOME_PRODUTO5, produto5.getNome());
		assertEquals(ProdutoRepositoryImplementationTest.PRECO_PRODUTO5, produto5.getPreco());
		
		final Produto produto6 = produtoList.stream()
				.filter(p -> p.getCodigo() == ProdutoRepositoryImplementationTest.CODIGO_PRODUTO6).findFirst().get();
		assertEquals(ProdutoRepositoryImplementationTest.NOME_PRODUTO6, produto6.getNome());
		assertEquals(ProdutoRepositoryImplementationTest.PRECO_PRODUTO6, produto6.getPreco());
		
		final Produto produto7 = produtoList.stream()
				.filter(p -> p.getCodigo() == ProdutoRepositoryImplementationTest.CODIGO_PRODUTO7).findFirst().get();
		assertEquals(ProdutoRepositoryImplementationTest.NOME_PRODUTO7, produto7.getNome());
		assertEquals(ProdutoRepositoryImplementationTest.PRECO_PRODUTO7, produto7.getPreco());
		
		final Produto produto8 = produtoList.stream()
				.filter(p -> p.getCodigo() == ProdutoRepositoryImplementationTest.CODIGO_PRODUTO8).findFirst().get();
		assertEquals(ProdutoRepositoryImplementationTest.NOME_PRODUTO8, produto8.getNome());
		assertEquals(ProdutoRepositoryImplementationTest.PRECO_PRODUTO8, produto8.getPreco());
		
		final Produto produto9 = produtoList.stream()
				.filter(p -> p.getCodigo() == ProdutoRepositoryImplementationTest.CODIGO_PRODUTO9).findFirst().get();
		assertEquals(ProdutoRepositoryImplementationTest.NOME_PRODUTO9, produto9.getNome());
		assertEquals(ProdutoRepositoryImplementationTest.PRECO_PRODUTO9, produto9.getPreco());
		
		final Produto produto10 = produtoList.stream()
				.filter(p -> p.getCodigo() == ProdutoRepositoryImplementationTest.CODIGO_PRODUTO10).findFirst().get();
		assertEquals(ProdutoRepositoryImplementationTest.NOME_PRODUTO10, produto10.getNome());
		assertEquals(ProdutoRepositoryImplementationTest.PRECO_PRODUTO10, produto10.getPreco());

	}

}
