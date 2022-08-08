package br.com.wmw.vendafacil_backend.data.models.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import br.com.wmw.vendafacil_backend.domain.cliente.entity.TipoPessoa;

@SpringBootTest
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

		assertEquals(cliente1.getNome(), ClienteModelTest.NOME_CLIENTE);
		assertEquals(cliente1.getTelefone(), ClienteModelTest.TELEFONE_CLIENTE);
		assertEquals(cliente1.getEmail(), ClienteModelTest.EMAIL_CLIENTE);
		assertEquals(cliente1.getTipo().getDescricao(), ClienteModelTest.DESCRICAO_TIPOPESSOA);
		assertEquals(cliente1.getCpfCnpj(), ClienteModelTest.CPF_CLIENTE);

		final Cliente cliente2 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteModelTest.CODIGO_CLIENTE2).findFirst().get();

		assertEquals(cliente2.getNome(), ClienteModelTest.NOME_CLIENTE2);
		assertEquals(cliente2.getTelefone(), ClienteModelTest.TELEFONE_CLIENTE2);
		assertEquals(cliente2.getEmail(), ClienteModelTest.EMAIL_CLIENTE2);
		assertEquals(cliente2.getTipo().getDescricao(), ClienteModelTest.DESCRICAO_TIPOPESSOA2);
		assertEquals(cliente2.getCpfCnpj(), ClienteModelTest.CNPJ_CLIENTE2);

	}

	@Test
	void deveriaConverterUmClienteModelEmUmCliente() {
		final ClienteModel clienteModelUnico = new ClienteModel(ClienteModelTest.CODIGO_CLIENTE,
				ClienteModelTest.NOME_CLIENTE, ClienteModelTest.TELEFONE_CLIENTE, ClienteModelTest.EMAIL_CLIENTE,
				new TipoPessoaModel(ClienteModelTest.CODIGO_TIPOPESSOA, ClienteModelTest.DESCRICAO_TIPOPESSOA),
				ClienteModelTest.CPF_CLIENTE);
		final Cliente cliente = clienteModelUnico.toCliente();
		assertEquals(cliente.getCodigo(), ClienteModelTest.CODIGO_CLIENTE);
		assertEquals(cliente.getNome(), ClienteModelTest.NOME_CLIENTE);
		assertEquals(cliente.getTelefone(), ClienteModelTest.TELEFONE_CLIENTE);
		assertEquals(cliente.getEmail(), ClienteModelTest.EMAIL_CLIENTE);
		assertEquals(cliente.getTipo().getDescricao(), ClienteModelTest.DESCRICAO_TIPOPESSOA);
		assertEquals(cliente.getCpfCnpj(), ClienteModelTest.CPF_CLIENTE);
	}

	@Test
	void deveriaConverterUmClienteEmUmClienteModel() {
		final Cliente clienteUnico = new Cliente(ClienteModelTest.CODIGO_CLIENTE, ClienteModelTest.NOME_CLIENTE,
				ClienteModelTest.TELEFONE_CLIENTE, ClienteModelTest.EMAIL_CLIENTE, ClienteModelTest.CPF_CLIENTE,
				new TipoPessoa(ClienteModelTest.CODIGO_TIPOPESSOA, ClienteModelTest.DESCRICAO_TIPOPESSOA));
		final ClienteModel clienteModel = ClienteModel.convert(clienteUnico);
		assertEquals(clienteModel.getCodigo(), ClienteModelTest.CODIGO_CLIENTE);
		assertEquals(clienteModel.getNome(), ClienteModelTest.NOME_CLIENTE);
		assertEquals(clienteModel.getTelefone(), ClienteModelTest.TELEFONE_CLIENTE);
		assertEquals(clienteModel.getEmail(), ClienteModelTest.EMAIL_CLIENTE);
		assertEquals(clienteModel.getTipo().getDescricao(), ClienteModelTest.DESCRICAO_TIPOPESSOA);
		assertEquals(clienteModel.getCpfCnpj(), ClienteModelTest.CPF_CLIENTE);
	}

}
