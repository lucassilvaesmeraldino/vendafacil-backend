package br.com.wmw.vendafacil_backend.data.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;

import br.com.wmw.vendafacil_backend.data.models.produto.ProdutoResponseModel;
import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class ProdutoRestControllerTest {

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
	private MockMvc mockMvc;

	@Test
	void deveriaRetornarUmJSONComTodosOsProdutos() throws URISyntaxException, Exception {
		final Produto produto1 = new Produto(ProdutoRestControllerTest.CODIGO_PRODUTO1,
				ProdutoRestControllerTest.NOME_PRODUTO1, ProdutoRestControllerTest.PRECO_PRODUTO1);
		final Produto produto2 = new Produto(ProdutoRestControllerTest.CODIGO_PRODUTO2,
				ProdutoRestControllerTest.NOME_PRODUTO2, ProdutoRestControllerTest.PRECO_PRODUTO2);
		final Produto produto3 = new Produto(ProdutoRestControllerTest.CODIGO_PRODUTO3,
				ProdutoRestControllerTest.NOME_PRODUTO3, ProdutoRestControllerTest.PRECO_PRODUTO3);
		final Produto produto4 = new Produto(ProdutoRestControllerTest.CODIGO_PRODUTO4,
				ProdutoRestControllerTest.NOME_PRODUTO4, ProdutoRestControllerTest.PRECO_PRODUTO4);
		final Produto produto5 = new Produto(ProdutoRestControllerTest.CODIGO_PRODUTO5,
				ProdutoRestControllerTest.NOME_PRODUTO5, ProdutoRestControllerTest.PRECO_PRODUTO5);
		final Produto produto6 = new Produto(ProdutoRestControllerTest.CODIGO_PRODUTO6,
				ProdutoRestControllerTest.NOME_PRODUTO6, ProdutoRestControllerTest.PRECO_PRODUTO6);
		final Produto produto7 = new Produto(ProdutoRestControllerTest.CODIGO_PRODUTO7,
				ProdutoRestControllerTest.NOME_PRODUTO7, ProdutoRestControllerTest.PRECO_PRODUTO7);
		final Produto produto8 = new Produto(ProdutoRestControllerTest.CODIGO_PRODUTO8,
				ProdutoRestControllerTest.NOME_PRODUTO8, ProdutoRestControllerTest.PRECO_PRODUTO8);
		final Produto produto9 = new Produto(ProdutoRestControllerTest.CODIGO_PRODUTO9,
				ProdutoRestControllerTest.NOME_PRODUTO9, ProdutoRestControllerTest.PRECO_PRODUTO9);
		final Produto produto10 = new Produto(ProdutoRestControllerTest.CODIGO_PRODUTO10,
				ProdutoRestControllerTest.NOME_PRODUTO10, ProdutoRestControllerTest.PRECO_PRODUTO10);

		final List<ProdutoResponseModel> produtoResponseModelList = ProdutoResponseModel
				.convert(List.of(produto1, produto2, produto3, produto4, produto5, produto6, produto7, produto8, produto9, produto10));

		this.mockMvc.perform(MockMvcRequestBuilders.get(new URI("/produtos"))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(new Gson().toJson(produtoResponseModelList)));
	}

}
