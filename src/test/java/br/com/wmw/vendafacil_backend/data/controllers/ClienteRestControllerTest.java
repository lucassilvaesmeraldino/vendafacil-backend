package br.com.wmw.vendafacil_backend.data.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.sql.init.dependency.DependsOnDatabaseInitialization;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;

import br.com.wmw.vendafacil_backend.data.models.cliente.ClienteResponseModel;
import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import br.com.wmw.vendafacil_backend.domain.cliente.entity.TipoPessoa;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class ClienteRestControllerTest {

	private static final long CODIGO_CLIENTE1 = 1;
	private static final String NOME_CLIENTE1 = "Maria";
	private static final String TELEFONE_CLIENTE1 = "(99)99999-9999";
	private static final String EMAIL_CLIENTE1 = "maria@email.com";
	private static final TipoPessoa TIPOPESSOA_CLIENTE1 = new TipoPessoa((long) 1, "Fisica");
	private static final String CPF_CLIENTEMODEL1 = "457.468.540-93";

	private static final long CODIGO_CLIENTE2 = 2;
	private static final String NOME_CLIENTE2 = "San Marino Design Grafico";
	private static final String TELEFONE_CLIENTE2 = "(99)99999-9999";
	private static final String EMAIL_CLIENTE2 = "sanmarino@email.com";
	private static final TipoPessoa TIPOPESSOA_CLIENTE2 = new TipoPessoa((long) 2, "Juridica");
	private static final String CNPJ_CLIENTE2 = "21.843.963/0001-27";
	
	private static final long CODIGO_CLIENTE3 = 3;
	private static final String NOME_CLIENTE3 = "Lucas Esmeraldino";
	private static final String TELEFONE_CLIENTE3 = "(99)99999-9999";
	private static final String EMAIL_CLIENTE3 = "lucas@email.com";
	private static final TipoPessoa TIPOPESSOA_CLIENTE3 = new TipoPessoa((long) 1, "Fisica");
	private static final String CNPJ_CLIENTE3 = "002.062.810-21";
	
	private static final long CODIGO_CLIENTE4 = 4;
	private static final String NOME_CLIENTE4 = "Ricardo Alves";
	private static final String TELEFONE_CLIENTE4 = "(99)99999-9999";
	private static final String EMAIL_CLIENTE4 = "ricardo@email.com";
	private static final TipoPessoa TIPOPESSOA_CLIENTE4 = new TipoPessoa((long) 1, "Fisica");
	private static final String CNPJ_CLIENTE4 = "633.107.330-25";
	
	private static final long CODIGO_CLIENTE5 = 5;
	private static final String NOME_CLIENTE5 = "Marilene Mendes";
	private static final String TELEFONE_CLIENTE5 = "(99)99999-9999";
	private static final String EMAIL_CLIENTE5 = "marilene@email.com";
	private static final TipoPessoa TIPOPESSOA_CLIENTE5 = new TipoPessoa((long) 1, "Fisica");
	private static final String CNPJ_CLIENTE5 = "213.637.120-71";
	
	private static final long CODIGO_CLIENTE6 = 6;
	private static final String NOME_CLIENTE6 = "Carlos Almeida";
	private static final String TELEFONE_CLIENTE6 = "(99)99999-9999";
	private static final String EMAIL_CLIENTE6 = "carlos@email.com";
	private static final TipoPessoa TIPOPESSOA_CLIENTE6 = new TipoPessoa((long) 1, "Fisica");
	private static final String CNPJ_CLIENTE6 = "392.542.780-50";
	
	private static final long CODIGO_CLIENTE7 = 7;
	private static final String NOME_CLIENTE7 = "Mendes & Rocha Decoracoes";
	private static final String TELEFONE_CLIENTE7 = "(99)99999-9999";
	private static final String EMAIL_CLIENTE7 = "mendeserocha@email.com";
	private static final TipoPessoa TIPOPESSOA_CLIENTE7 = new TipoPessoa((long) 2, "Juridica");
	private static final String CNPJ_CLIENTE7 = "27.050.665/0001-66";
	
	private static final long CODIGO_CLIENTE8 = 8;
	private static final String NOME_CLIENTE8 = "Favarin Moveis";
	private static final String TELEFONE_CLIENTE8 = "(99)99999-9999";
	private static final String EMAIL_CLIENTE8 = "favarin@email.com";
	private static final TipoPessoa TIPOPESSOA_CLIENTE8 = new TipoPessoa((long) 2, "Juridica");
	private static final String CNPJ_CLIENTE8 = "30.864.991/0001-11";

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
		final Cliente cliente3 = new Cliente(ClienteRestControllerTest.CODIGO_CLIENTE3,
				ClienteRestControllerTest.NOME_CLIENTE3, ClienteRestControllerTest.TELEFONE_CLIENTE3,
				ClienteRestControllerTest.EMAIL_CLIENTE3, ClienteRestControllerTest.CNPJ_CLIENTE3,
				ClienteRestControllerTest.TIPOPESSOA_CLIENTE3);
		final Cliente cliente4 = new Cliente(ClienteRestControllerTest.CODIGO_CLIENTE4,
				ClienteRestControllerTest.NOME_CLIENTE4, ClienteRestControllerTest.TELEFONE_CLIENTE4,
				ClienteRestControllerTest.EMAIL_CLIENTE4, ClienteRestControllerTest.CNPJ_CLIENTE4,
				ClienteRestControllerTest.TIPOPESSOA_CLIENTE4);
		final Cliente cliente5 = new Cliente(ClienteRestControllerTest.CODIGO_CLIENTE5,
				ClienteRestControllerTest.NOME_CLIENTE5, ClienteRestControllerTest.TELEFONE_CLIENTE5,
				ClienteRestControllerTest.EMAIL_CLIENTE5, ClienteRestControllerTest.CNPJ_CLIENTE5,
				ClienteRestControllerTest.TIPOPESSOA_CLIENTE5);
		final Cliente cliente6 = new Cliente(ClienteRestControllerTest.CODIGO_CLIENTE6,
				ClienteRestControllerTest.NOME_CLIENTE6, ClienteRestControllerTest.TELEFONE_CLIENTE6,
				ClienteRestControllerTest.EMAIL_CLIENTE6, ClienteRestControllerTest.CNPJ_CLIENTE6,
				ClienteRestControllerTest.TIPOPESSOA_CLIENTE6);
		final Cliente cliente7 = new Cliente(ClienteRestControllerTest.CODIGO_CLIENTE7,
				ClienteRestControllerTest.NOME_CLIENTE7, ClienteRestControllerTest.TELEFONE_CLIENTE7,
				ClienteRestControllerTest.EMAIL_CLIENTE7, ClienteRestControllerTest.CNPJ_CLIENTE7,
				ClienteRestControllerTest.TIPOPESSOA_CLIENTE7);
		final Cliente cliente8 = new Cliente(ClienteRestControllerTest.CODIGO_CLIENTE8,
				ClienteRestControllerTest.NOME_CLIENTE8, ClienteRestControllerTest.TELEFONE_CLIENTE8,
				ClienteRestControllerTest.EMAIL_CLIENTE8, ClienteRestControllerTest.CNPJ_CLIENTE8,
				ClienteRestControllerTest.TIPOPESSOA_CLIENTE8);

		final List<ClienteResponseModel> clienteResponseModelList = ClienteResponseModel
				.convert(List.of(cliente1, cliente2, cliente3, cliente4, cliente5, cliente6, cliente7, cliente8));

		this.mockMvc.perform(MockMvcRequestBuilders.get(new URI("/clientes")))
		.andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(content().json(new Gson().toJson(clienteResponseModelList)));
	}

}
