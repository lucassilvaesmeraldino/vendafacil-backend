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

	@Autowired
	private MockMvc mockMvc;

	@Test
	void deveriaRetornarUmJSONComTodosOsClientes() throws URISyntaxException, Exception {

		final TipoPessoa tipoPessoa1 = new TipoPessoa((long) 1, "Física");
		final TipoPessoa tipoPessoa2 = new TipoPessoa((long) 2, "Jurídica");

		final Cliente cliente1 = new Cliente((long) 1, "Maria", "(99)99999-9999", "maria@email.com",
				"457.468.540-93", tipoPessoa1);
		final Cliente cliente2 = new Cliente((long) 2, "San Marino", "(99)99999-9999", "sanmarino@email.com",
				"21.843.963/0001-27", tipoPessoa2);

		final List<ClienteResponseModel> clienteResponseModelList = ClienteResponseModel
				.convertToResponseList(List.of(cliente1, cliente2));

		this.mockMvc.perform(MockMvcRequestBuilders.get(new URI("/clientes")))
		.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(content().json(new Gson().toJson(clienteResponseModelList)));
	}

}
