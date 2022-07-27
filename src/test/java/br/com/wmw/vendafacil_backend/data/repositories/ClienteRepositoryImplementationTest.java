package br.com.wmw.vendafacil_backend.data.repositories;

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

	private static final long CODIGO_CLIENTE1 = 1;
	private static final String NOME_CLIENTE1 = "Maria";
	private static final String EMAIL_CLIENTE1 = "maria@email.com";
	private static final String TELEFONE_CLIENTE1 = "(99)99999-9999";
	private static final String CPF_CLIENTE1 = "457.468.540-93";
	private static final String TIPOPESSOANOME_CLIENTE1 = "Física";

	private static final long CODIGO_CLIENTE2 = 2;
	private static final String NOME_CLIENTE2 = "San Marino";
	private static final String EMAIL_CLIENTE2 = "sanmarino@email.com";
	private static final String TELEFONE_CLIENTE2 = "(99)99999-9999";
	private static final String CNPJ_CLIENTE2 = "21.843.963/0001-27";
	private static final String TIPOPESSOANOME_CLIENTE2 = "Jurídica";

	@Autowired
	private ClienteRepository clienteRepository;

	@Test
	void deveriaRetornarTodosOsClientes() {
		final List<Cliente> clienteList = this.clienteRepository.getClientes();

		assertEquals(2, clienteList.size());

		final Cliente cliente1 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE1).findFirst().get();
		assertEquals(cliente1.getNome(), ClienteRepositoryImplementationTest.NOME_CLIENTE1);
		assertEquals(cliente1.getEmail(), ClienteRepositoryImplementationTest.EMAIL_CLIENTE1);
		assertEquals(cliente1.getTelefone(), ClienteRepositoryImplementationTest.TELEFONE_CLIENTE1);
		assertEquals(cliente1.getCpfCnpj(), ClienteRepositoryImplementationTest.CPF_CLIENTE1);
		assertEquals(cliente1.getTipo().getNome(), ClienteRepositoryImplementationTest.TIPOPESSOANOME_CLIENTE1);

		final Cliente cliente2 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE2).findFirst().get();
		assertEquals(cliente2.getNome(), ClienteRepositoryImplementationTest.NOME_CLIENTE2);
		assertEquals(cliente2.getEmail(), ClienteRepositoryImplementationTest.EMAIL_CLIENTE2);
		assertEquals(cliente2.getTelefone(), ClienteRepositoryImplementationTest.TELEFONE_CLIENTE2);
		assertEquals(cliente2.getCpfCnpj(), ClienteRepositoryImplementationTest.CNPJ_CLIENTE2);
		assertEquals(cliente2.getTipo().getNome(), ClienteRepositoryImplementationTest.TIPOPESSOANOME_CLIENTE2);

	}

}
