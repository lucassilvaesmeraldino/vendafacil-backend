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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;

import br.com.wmw.vendafacil_backend.data.models.produto.ProdutoResponseModel;
import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProdutoRestControllerTest {

	private static final long CODIGO_PRODUTO1 = 1;
	private static final String NOME_PRODUTO1 = "Suporte para celular Samsung";
	private static final double PRECO_PRODUTO1 = 19.99;

	private static final long CODIGO_PRODUTO2 = 2;
	private static final String NOME_PRODUTO2 = "Capinha para celular Samsung S10 Plus";
	private static final double PRECO_PRODUTO2 = 59.89;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void deveriaRetornarUmJSONComTodosOsProdutos() throws URISyntaxException, Exception {
		final Produto produto1 = new Produto(ProdutoRestControllerTest.CODIGO_PRODUTO1,
				ProdutoRestControllerTest.NOME_PRODUTO1, ProdutoRestControllerTest.PRECO_PRODUTO1);
		final Produto produto2 = new Produto(ProdutoRestControllerTest.CODIGO_PRODUTO2,
				ProdutoRestControllerTest.NOME_PRODUTO2, ProdutoRestControllerTest.PRECO_PRODUTO2);

		final List<ProdutoResponseModel> produtoResponseModelList = ProdutoResponseModel
				.convert(List.of(produto1, produto2));

		this.mockMvc.perform(MockMvcRequestBuilders.get(new URI("/produtos"))).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(new Gson().toJson(produtoResponseModelList)));
	}

}
