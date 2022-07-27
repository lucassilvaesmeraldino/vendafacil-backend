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

import br.com.wmw.vendafacil_backend.data.models.cliente.ClienteResponseModel;
import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import br.com.wmw.vendafacil_backend.domain.cliente.entity.TipoPessoa;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ClienteRestControllerTest {

	private static final long CODIGO_CLIENTE1 = 1;
	private static final String NOME_CLIENTE1 = "Maria";
	private static final String TELEFONE_CLIENTE1 = "(99)99999-9999";
	private static final String EMAIL_CLIENTE1 = "maria@email.com";
	private static final TipoPessoa TIPOPESSOA_CLIENTE1 = new TipoPessoa((long) 1, "Física");
	private static final String CPF_CLIENTEMODEL1 = "457.468.540-93";

	private static final long CODIGO_CLIENTE2 = 2;
	private static final String NOME_CLIENTE2 = "San Marino";
	private static final String TELEFONE_CLIENTE2 = "(99)99999-9999";
	private static final String EMAIL_CLIENTE2 = "sanmarino@email.com";
	private static final TipoPessoa TIPOPESSOA_CLIENTE2 = new TipoPessoa((long) 2, "Jurídica");
	private static final String CNPJ_CLIENTE2 = "21.843.963/0001-27";

	@Autowired
	private MockMvc mockMvc;

	@Test
	void deveriaRetornarUmJSONComTodosOsClientes() throws URISyntaxException, Exception {

		final Cliente cliente1 = new Cliente(ClienteRestControllerTest.CODIGO_CLIENTE1,
				ClienteRestControllerTest.NOME_CLIENTE1, ClienteRestControllerTest.TELEFONE_CLIENTE1,
				ClienteRestControllerTest.EMAIL_CLIENTE1, ClienteRestControllerTest.CPF_CLIENTEMODEL1,
				ClienteRestControllerTest.TIPOPESSOA_CLIENTE1);
		final Cliente cliente2 = new Cliente(ClienteRestControllerTest.CODIGO_CLIENTE2,
				ClienteRestControllerTest.NOME_CLIENTE2, ClienteRestControllerTest.TELEFONE_CLIENTE2,
				ClienteRestControllerTest.EMAIL_CLIENTE2, ClienteRestControllerTest.CNPJ_CLIENTE2,
				ClienteRestControllerTest.TIPOPESSOA_CLIENTE2);

		final List<ClienteResponseModel> clienteResponseModelList = ClienteResponseModel
				.convert(List.of(cliente1, cliente2));

		this.mockMvc.perform(MockMvcRequestBuilders.get(new URI("/clientes")))
		.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(content().json(new Gson().toJson(clienteResponseModelList)));
	}

}
