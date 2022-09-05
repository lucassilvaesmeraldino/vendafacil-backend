package br.com.wmw.vendafacil_backend.data.models.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import br.com.wmw.vendafacil_backend.domain.cliente.entity.TipoPessoa;

class ClienteModelTest {

	private static final long CODIGO_CLIENTE = 1;
	private static final String NOME_CLIENTE = "Lucas";
	private static final String TELEFONE_CLIENTE = "(48)88888-8888";
	private static final String EMAIL_CLIENTE = "lucas@gmail.com";
	private static final String CPF_CLIENTE = "888.888.888-88";

	private static final long CODIGO_CLIENTE2 = 2;
	private static final String NOME_CLIENTE2 = "João";
	private static final String TELEFONE_CLIENTE2 = "(48)88888-8888";
	private static final String EMAIL_CLIENTE2 = "joao@gmail.com";
	private static final String CNPJ_CLIENTE2 = "88.888.888/8888-88";

	private static final long CODIGO_TIPOPESSOA = 1;
	private static final String DESCRICAO_TIPOPESSOA = "Física";

	private static final long CODIGO_TIPOPESSOA2 = 2;
	private static final String DESCRICAO_TIPOPESSOA2 = "Jurídica";


	@Test
	void deveriaConverterUmaListaDeClientesModelEmUmaListaDeClientes() {
		final ClienteModel clienteModel1 = new ClienteModel(ClienteModelTest.CODIGO_CLIENTE,
				ClienteModelTest.NOME_CLIENTE, ClienteModelTest.TELEFONE_CLIENTE, ClienteModelTest.EMAIL_CLIENTE,
				new TipoPessoaModel(ClienteModelTest.CODIGO_TIPOPESSOA, ClienteModelTest.DESCRICAO_TIPOPESSOA),
				ClienteModelTest.CPF_CLIENTE);

		final ClienteModel clienteModel2 = new ClienteModel(ClienteModelTest.CODIGO_CLIENTE2,
				ClienteModelTest.NOME_CLIENTE2, ClienteModelTest.TELEFONE_CLIENTE2, ClienteModelTest.EMAIL_CLIENTE2,
				new TipoPessoaModel(ClienteModelTest.CODIGO_TIPOPESSOA2, ClienteModelTest.DESCRICAO_TIPOPESSOA2), ClienteModelTest.CNPJ_CLIENTE2);

		final List<Cliente> clienteList = ClienteModel.convertToClienteList(List.of(clienteModel1, clienteModel2));

		final Cliente cliente1 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteModelTest.CODIGO_CLIENTE).findFirst().get();

		assertEquals(ClienteModelTest.NOME_CLIENTE, cliente1.getNome());
		assertEquals(ClienteModelTest.TELEFONE_CLIENTE, cliente1.getTelefone());
		assertEquals(ClienteModelTest.EMAIL_CLIENTE, cliente1.getEmail());
		assertEquals(ClienteModelTest.DESCRICAO_TIPOPESSOA, cliente1.getTipo().getDescricao());
		assertEquals(ClienteModelTest.CPF_CLIENTE, cliente1.getCpfCnpj());

		final Cliente cliente2 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteModelTest.CODIGO_CLIENTE2).findFirst().get();

		assertEquals(ClienteModelTest.NOME_CLIENTE2, cliente2.getNome());
		assertEquals(ClienteModelTest.TELEFONE_CLIENTE2, cliente2.getTelefone());
		assertEquals(ClienteModelTest.EMAIL_CLIENTE2, cliente2.getEmail());
		assertEquals(ClienteModelTest.DESCRICAO_TIPOPESSOA2, cliente2.getTipo().getDescricao());
		assertEquals(ClienteModelTest.CNPJ_CLIENTE2, cliente2.getCpfCnpj());

	}

	@Test
	void deveriaConverterUmClienteModelEmUmCliente() {
		final ClienteModel clienteModelUnico = new ClienteModel(ClienteModelTest.CODIGO_CLIENTE,
				ClienteModelTest.NOME_CLIENTE, ClienteModelTest.TELEFONE_CLIENTE, ClienteModelTest.EMAIL_CLIENTE,
				new TipoPessoaModel(ClienteModelTest.CODIGO_TIPOPESSOA, ClienteModelTest.DESCRICAO_TIPOPESSOA),
				ClienteModelTest.CPF_CLIENTE);
		final Cliente cliente = clienteModelUnico.toCliente();
		assertEquals(ClienteModelTest.CODIGO_CLIENTE, cliente.getCodigo());
		assertEquals(ClienteModelTest.NOME_CLIENTE, cliente.getNome());
		assertEquals(ClienteModelTest.TELEFONE_CLIENTE, cliente.getTelefone());
		assertEquals(ClienteModelTest.EMAIL_CLIENTE, cliente.getEmail());
		assertEquals(ClienteModelTest.DESCRICAO_TIPOPESSOA, cliente.getTipo().getDescricao());
		assertEquals(ClienteModelTest.CPF_CLIENTE, cliente.getCpfCnpj());
	}

	@Test
	void deveriaConverterUmClienteEmUmClienteModel() {
		final Cliente clienteUnico = new Cliente(ClienteModelTest.CODIGO_CLIENTE, ClienteModelTest.NOME_CLIENTE,
				ClienteModelTest.TELEFONE_CLIENTE, ClienteModelTest.EMAIL_CLIENTE, ClienteModelTest.CPF_CLIENTE,
				new TipoPessoa(ClienteModelTest.CODIGO_TIPOPESSOA, ClienteModelTest.DESCRICAO_TIPOPESSOA));
		final ClienteModel clienteModel = ClienteModel.convert(clienteUnico);
		assertEquals(ClienteModelTest.CODIGO_CLIENTE, clienteModel.getCodigo());
		assertEquals(ClienteModelTest.NOME_CLIENTE, clienteModel.getNome());
		assertEquals(ClienteModelTest.TELEFONE_CLIENTE, clienteModel.getTelefone());
		assertEquals(ClienteModelTest.EMAIL_CLIENTE, clienteModel.getEmail());
		assertEquals(ClienteModelTest.DESCRICAO_TIPOPESSOA, clienteModel.getTipo().getDescricao());
		assertEquals(ClienteModelTest.CPF_CLIENTE, clienteModel.getCpfCnpj());
	}

}
