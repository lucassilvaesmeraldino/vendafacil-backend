package br.com.wmw.vendafacil_backend.data.models.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;

@SpringBootTest
class ClienteModelTest {

	private static final long CODIGO_CLIENTEMODEL1 = 1;
	private static final String NOME_CLIENTEMODEL1 = "Lucas";
	private static final String TELEFONE_CLIENTEMODEL1 = "(48)88888-8888";
	private static final String EMAIL_CLIENTEMODEL1 = "lucas@gmail.com";
	private static final TipoPessoaModel TIPOPESSOA_CLIENTEMODEL1 = new TipoPessoaModel((long) 1, "Física");
	private static final String CPF_CLIENTEMODEL1 = "888.888.888-88";

	private static final long CODIGO_CLIENTEMODEL2 = 2;
	private static final String NOME_CLIENTEMODEL2 = "João";
	private static final String TELEFONE_CLIENTEMODEL2 = "(48)88888-8888";
	private static final String EMAIL_CLIENTEMODEL2 = "joao@gmail.com";
	private static final TipoPessoaModel TIPOPESSOA_CLIENTEMODEL2 = new TipoPessoaModel((long) 1, "Jurídica");
	private static final String CNPJ_CLIENTEMODEL2 = "88.888.888/8888-88";

	@Test
	void deveriaConverterUmaListaDeClientesModelParaUmaListaDeClientes() {
		final ClienteModel clienteModel1 = new ClienteModel(ClienteModelTest.CODIGO_CLIENTEMODEL1,
				ClienteModelTest.NOME_CLIENTEMODEL1, ClienteModelTest.TELEFONE_CLIENTEMODEL1,
				ClienteModelTest.EMAIL_CLIENTEMODEL1, ClienteModelTest.TIPOPESSOA_CLIENTEMODEL1,
				ClienteModelTest.CPF_CLIENTEMODEL1);

		final ClienteModel clienteMode2 = new ClienteModel(ClienteModelTest.CODIGO_CLIENTEMODEL2,
				ClienteModelTest.NOME_CLIENTEMODEL2, ClienteModelTest.TELEFONE_CLIENTEMODEL2,
				ClienteModelTest.EMAIL_CLIENTEMODEL2, ClienteModelTest.TIPOPESSOA_CLIENTEMODEL2,
				ClienteModelTest.CNPJ_CLIENTEMODEL2);

		final List<ClienteModel> clienteModelList = List.of(clienteModel1, clienteMode2);
		final List<Cliente> clienteList = ClienteModel.toClienteList(clienteModelList);

		final Cliente cliente1 = clienteList.stream().filter(c -> c.getCodigo() == 1).findFirst().get();

		assertEquals(cliente1.getNome(), ClienteModelTest.NOME_CLIENTEMODEL1);
		assertEquals(cliente1.getTelefone(), ClienteModelTest.TELEFONE_CLIENTEMODEL1);
		assertEquals(cliente1.getEmail(), ClienteModelTest.EMAIL_CLIENTEMODEL1);
		assertEquals(cliente1.getTipo().getNome(), ClienteModelTest.TIPOPESSOA_CLIENTEMODEL1.getNome());
		assertEquals(cliente1.getCpfCnpj(), ClienteModelTest.CPF_CLIENTEMODEL1);

		final Cliente cliente2 = clienteList.stream().filter(c -> c.getCodigo() == 2).findFirst().get();

		assertEquals(cliente2.getNome(), ClienteModelTest.NOME_CLIENTEMODEL2);
		assertEquals(cliente2.getTelefone(), ClienteModelTest.TELEFONE_CLIENTEMODEL2);
		assertEquals(cliente2.getEmail(), ClienteModelTest.EMAIL_CLIENTEMODEL2);
		assertEquals(cliente2.getTipo().getNome(), ClienteModelTest.TIPOPESSOA_CLIENTEMODEL2.getNome());
		assertEquals(cliente2.getCpfCnpj(), ClienteModelTest.CNPJ_CLIENTEMODEL2);

	}

}
