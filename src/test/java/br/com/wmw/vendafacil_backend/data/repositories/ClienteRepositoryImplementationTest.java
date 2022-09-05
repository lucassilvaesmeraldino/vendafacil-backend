package br.com.wmw.vendafacil_backend.data.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import br.com.wmw.vendafacil_backend.domain.cliente.repository.ClienteRepository;

@ActiveProfiles("test")
@SpringBootTest
class ClienteRepositoryImplementationTest {

	private static final long CODIGO_CLIENTE1 = 1;
	private static final String NOME_CLIENTE1 = "Maria";
	private static final String CPF_CLIENTE1 = "457.468.540-93";

	private static final long CODIGO_CLIENTE2 = 2;
	private static final String NOME_CLIENTE2 = "San Marino Design Grafico";
	private static final String CNPJ_CLIENTE2 = "21.843.963/0001-27";
	private static final String TIPOPESSOANOME_CLIENTE2 = "Juridica";
	
	private static final long CODIGO_CLIENTE3 = 3;
	private static final String NOME_CLIENTE3 = "Lucas Esmeraldino";
	private static final String CPF_CLIENTE3 = "002.062.810-21";
	
	private static final long CODIGO_CLIENTE4 = 4;
	private static final String NOME_CLIENTE4 = "Ricardo Alves";
	private static final String CPF_CLIENTE4 = "633.107.330-25";

	
	private static final long CODIGO_CLIENTE5 = 5;
	private static final String NOME_CLIENTE5 = "Marilene Mendes";
	private static final String CPF_CLIENTE5 = "213.637.120-71";

	private static final long CODIGO_CLIENTE6 = 6;
	private static final String NOME_CLIENTE6 = "Carlos Almeida";
	private static final String CPF_CLIENTE6 = "392.542.780-50";

	private static final long CODIGO_CLIENTE7 = 7;
	private static final String NOME_CLIENTE7 = "Mendes & Rocha Decoracoes";
	private static final String CNPJ_CLIENTE7 = "27.050.665/0001-66";
	
	private static final long CODIGO_CLIENTE8 = 8;
	private static final String NOME_CLIENTE8 = "Favarin Moveis";
	private static final String CNPJ_CLIENTE8 = "30.864.991/0001-11";

	@Autowired
	private ClienteRepository clienteRepository;

	@Test
	void deveriaRetornarTodosOsClientes() {
		final List<Cliente> clienteList = this.clienteRepository.getClientes();

		assertEquals(8, clienteList.size());

		final Cliente cliente1 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE1).findFirst().get();
		assertEquals(ClienteRepositoryImplementationTest.NOME_CLIENTE1, cliente1.getNome());
		assertEquals(ClienteRepositoryImplementationTest.CPF_CLIENTE1, cliente1.getCpfCnpj());

		final Cliente cliente2 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE2).findFirst().get();
		assertEquals(ClienteRepositoryImplementationTest.NOME_CLIENTE2, cliente2.getNome());
		assertEquals(ClienteRepositoryImplementationTest.CNPJ_CLIENTE2, cliente2.getCpfCnpj());
		assertEquals(ClienteRepositoryImplementationTest.TIPOPESSOANOME_CLIENTE2, cliente2.getTipo().getDescricao());
		
		final Cliente cliente3 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE3).findFirst().get();
		assertEquals(ClienteRepositoryImplementationTest.NOME_CLIENTE3, cliente3.getNome());
		assertEquals(ClienteRepositoryImplementationTest.CPF_CLIENTE3, cliente3.getCpfCnpj());
		
		final Cliente cliente4 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE4).findFirst().get();
		assertEquals(ClienteRepositoryImplementationTest.NOME_CLIENTE4, cliente4.getNome());
		assertEquals(ClienteRepositoryImplementationTest.CPF_CLIENTE4, cliente4.getCpfCnpj());
		
		final Cliente cliente5 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE5).findFirst().get();
		assertEquals(ClienteRepositoryImplementationTest.NOME_CLIENTE5, cliente5.getNome());
		assertEquals(ClienteRepositoryImplementationTest.CPF_CLIENTE5, cliente5.getCpfCnpj());
		
		final Cliente cliente6 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE6).findFirst().get();
		assertEquals(ClienteRepositoryImplementationTest.NOME_CLIENTE6, cliente6.getNome());
		assertEquals(ClienteRepositoryImplementationTest.CPF_CLIENTE6, cliente6.getCpfCnpj());
		
		final Cliente cliente7 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE7).findFirst().get();
		assertEquals(ClienteRepositoryImplementationTest.NOME_CLIENTE7, cliente7.getNome());
		assertEquals(ClienteRepositoryImplementationTest.CNPJ_CLIENTE7, cliente7.getCpfCnpj());
		
		final Cliente cliente8 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE8).findFirst().get();
		assertEquals(ClienteRepositoryImplementationTest.NOME_CLIENTE8, cliente8.getNome());
		assertEquals(ClienteRepositoryImplementationTest.CNPJ_CLIENTE8, cliente8.getCpfCnpj());
	
	}

}
