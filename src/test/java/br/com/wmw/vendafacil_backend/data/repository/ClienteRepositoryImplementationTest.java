package br.com.wmw.vendafacil_backend.data.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import br.com.wmw.vendafacil_backend.domain.cliente.repository.ClienteRepository;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ClienteRepositoryImplementationTest {

	private static final String NOME_CLIENTE1 = "Maria";
	private static final String EMAIL_CLIENTE1 = "maria@email.com";
	private static final String TELEFONE_CLIENTE1 = "(99)99999-9999";
	private static final String CPF_CLIENTE1 = "457.468.540-93";
	private static final String TIPOPESSOANOME_CLIENTE1 = "Física";

	private static final String NOME_CLIENTE2 = "San Marino";
	private static final String EMAIL_CLIENTE2 = "sanmarino@email.com";
	private static final String TELEFONE_CLIENTE2 = "(99)99999-9999";
	private static final String CNPJ_CLIENTE2 = "21.843.963/0001-27";
	private static final String TIPOPESSOANOME_CLIENTE2 = "Jurídica";

	@Autowired
	private ClienteRepository clienteRepository;

	@Test
	void deveriaRetornarTodosOsClientes() {
		final List<Cliente> clientes = this.clienteRepository.getClientes();

		assertEquals(2, clientes.size());

		final Cliente primeiroCliente = clientes.stream().filter(c -> c.getCodigo() == 1).findFirst().get();
		assertEquals(primeiroCliente.getNome(), ClienteRepositoryImplementationTest.NOME_CLIENTE1);
		assertEquals(primeiroCliente.getEmail(), ClienteRepositoryImplementationTest.EMAIL_CLIENTE1);
		assertEquals(primeiroCliente.getTelefone(), ClienteRepositoryImplementationTest.TELEFONE_CLIENTE1);
		assertEquals(primeiroCliente.getCpfCnpj(), ClienteRepositoryImplementationTest.CPF_CLIENTE1);
		assertEquals(primeiroCliente.getTipo().getNome(), ClienteRepositoryImplementationTest.TIPOPESSOANOME_CLIENTE1);

		final Cliente segundoCliente = clientes.stream().filter(c -> c.getCodigo() == 2).findFirst().get();
		assertEquals(segundoCliente.getNome(), ClienteRepositoryImplementationTest.NOME_CLIENTE2);
		assertEquals(segundoCliente.getEmail(), ClienteRepositoryImplementationTest.EMAIL_CLIENTE2);
		assertEquals(segundoCliente.getTelefone(), ClienteRepositoryImplementationTest.TELEFONE_CLIENTE2);
		assertEquals(segundoCliente.getCpfCnpj(), ClienteRepositoryImplementationTest.CNPJ_CLIENTE2);
		assertEquals(segundoCliente.getTipo().getNome(), ClienteRepositoryImplementationTest.TIPOPESSOANOME_CLIENTE2);

	}

}
