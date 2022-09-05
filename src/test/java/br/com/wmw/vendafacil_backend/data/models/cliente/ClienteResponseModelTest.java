package br.com.wmw.vendafacil_backend.data.models.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import br.com.wmw.vendafacil_backend.domain.cliente.entity.TipoPessoa;

class ClienteResponseModelTest {

	private static final long CODIGO_CLIENTE = 1;
	private static final String NOME_CLIENTE = "Lucas";
	private static final String TELEFONE_CLIENTE = "(48)88888-8888";
	private static final String EMAIL_CLIENTE = "lucas@gmail.com";
	private static final TipoPessoa TIPOPESSOA_CLIENTE = new TipoPessoa((long) 1, "Física");
	private static final String CPF_CLIENTE = "888.888.888-88";

	private static final long CODIGO_CLIENTE2 = 2;
	private static final String NOME_CLIENTE2 = "João";
	private static final String TELEFONE_CLIENTE2 = "(48)88888-8888";
	private static final String EMAIL_CLIENTE2 = "joao@gmail.com";
	private static final TipoPessoa TIPOPESSOA_CLIENTE2 = new TipoPessoa((long) 2, "Jurídica");
	private static final String CNPJ_CLIENTE2 = "88.888.888/8888-88";

	@Test
	void deveriaConverterUmClienteParaUmClienteResponseModel() {
		final Cliente cliente = new Cliente(ClienteResponseModelTest.CODIGO_CLIENTE,
				ClienteResponseModelTest.NOME_CLIENTE, ClienteResponseModelTest.TELEFONE_CLIENTE,
				ClienteResponseModelTest.EMAIL_CLIENTE, ClienteResponseModelTest.CPF_CLIENTE,
				ClienteResponseModelTest.TIPOPESSOA_CLIENTE);

		final ClienteResponseModel clienteResponseModel = new ClienteResponseModel(cliente);

		assertEquals(clienteResponseModel.getCodigo(), cliente.getCodigo());
		assertEquals(clienteResponseModel.getNome(), cliente.getNome());
	}

	@Test
	void deveriaConverterUmaListaDeClientesParaUmaListaDeClientesModelResponse() {
		final Cliente cliente1 = new Cliente(ClienteResponseModelTest.CODIGO_CLIENTE,
				ClienteResponseModelTest.NOME_CLIENTE, ClienteResponseModelTest.TELEFONE_CLIENTE,
				ClienteResponseModelTest.EMAIL_CLIENTE, ClienteResponseModelTest.CPF_CLIENTE,
				ClienteResponseModelTest.TIPOPESSOA_CLIENTE);
		final Cliente cliente2 = new Cliente(ClienteResponseModelTest.CODIGO_CLIENTE2,
				ClienteResponseModelTest.NOME_CLIENTE2, ClienteResponseModelTest.TELEFONE_CLIENTE2,
				ClienteResponseModelTest.EMAIL_CLIENTE2, ClienteResponseModelTest.CNPJ_CLIENTE2,
				ClienteResponseModelTest.TIPOPESSOA_CLIENTE2);

		final List<ClienteResponseModel> clienteResponseModelList = ClienteResponseModel
				.convert(List.of(cliente1, cliente2));

		final ClienteResponseModel clienteResponseModel1 = clienteResponseModelList.stream()
				.filter(crm -> crm.getCodigo() == ClienteResponseModelTest.CODIGO_CLIENTE).findFirst().get();

		assertEquals(ClienteResponseModelTest.NOME_CLIENTE, clienteResponseModel1.getNome());

		final ClienteResponseModel clienteResponseModel2 = clienteResponseModelList.stream()
				.filter(crm -> crm.getCodigo() == ClienteResponseModelTest.CODIGO_CLIENTE2).findFirst().get();

		assertEquals(ClienteResponseModelTest.NOME_CLIENTE2, clienteResponseModel2.getNome());

	}

}
