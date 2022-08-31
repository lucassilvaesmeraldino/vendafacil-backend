package br.com.wmw.vendafacil_backend.data.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import br.com.wmw.vendafacil_backend.domain.cliente.entity.TipoPessoa;
import br.com.wmw.vendafacil_backend.domain.cliente.repository.ClienteRepository;

@ActiveProfiles("test")
@SpringBootTest
class ClienteRepositoryImplementationTest {

	private static final long CODIGO_CLIENTE1 = 1;
	private static final String NOME_CLIENTE1 = "Maria";
	private static final String EMAIL_CLIENTE1 = "maria@email.com";
	private static final String TELEFONE_CLIENTE1 = "(99)99999-9999";
	private static final String CPF_CLIENTE1 = "457.468.540-93";
	private static final String TIPOPESSOANOME_CLIENTE1 = "Fisica";

	private static final long CODIGO_CLIENTE2 = 2;
	private static final String NOME_CLIENTE2 = "San Marino Design Grafico";
	private static final String EMAIL_CLIENTE2 = "sanmarino@email.com";
	private static final String TELEFONE_CLIENTE2 = "(99)99999-9999";
	private static final String CNPJ_CLIENTE2 = "21.843.963/0001-27";
	private static final String TIPOPESSOANOME_CLIENTE2 = "Juridica";
	
	private static final long CODIGO_CLIENTE3 = 3;
	private static final String NOME_CLIENTE3 = "Lucas Esmeraldino";
	private static final String TELEFONE_CLIENTE3 = "(99)99999-9999";
	private static final String EMAIL_CLIENTE3 = "lucas@email.com";
	private static final String CPF_CLIENTE3 = "002.062.810-21";
	private static final String TIPOPESSOANOME_CLIENTE3 = "Fisica";
	
	private static final long CODIGO_CLIENTE4 = 4;
	private static final String NOME_CLIENTE4 = "Ricardo Alves";
	private static final String TELEFONE_CLIENTE4 = "(99)99999-9999";
	private static final String EMAIL_CLIENTE4 = "ricardo@email.com";
	private static final String CPF_CLIENTE4 = "633.107.330-25";
	private static final String TIPOPESSOANOME_CLIENTE4 = "Fisica";

	
	private static final long CODIGO_CLIENTE5 = 5;
	private static final String NOME_CLIENTE5 = "Marilene Mendes";
	private static final String TELEFONE_CLIENTE5 = "(99)99999-9999";
	private static final String EMAIL_CLIENTE5 = "marilene@email.com";
	private static final String CPF_CLIENTE5 = "213.637.120-71";
	private static final String TIPOPESSOANOME_CLIENTE5 = "Fisica";

	private static final long CODIGO_CLIENTE6 = 6;
	private static final String NOME_CLIENTE6 = "Carlos Almeida";
	private static final String TELEFONE_CLIENTE6 = "(99)99999-9999";
	private static final String EMAIL_CLIENTE6 = "carlos@email.com";
	private static final String CPF_CLIENTE6 = "392.542.780-50";
	private static final String TIPOPESSOANOME_CLIENTE6 = "Fisica";

	private static final long CODIGO_CLIENTE7 = 7;
	private static final String NOME_CLIENTE7 = "Mendes & Rocha Decoracoes";
	private static final String TELEFONE_CLIENTE7 = "(99)99999-9999";
	private static final String EMAIL_CLIENTE7 = "mendeserocha@email.com";
	private static final String CNPJ_CLIENTE7 = "27.050.665/0001-66";
	private static final String TIPOPESSOANOME_CLIENTE7 = "Juridica";
	
	private static final long CODIGO_CLIENTE8 = 8;
	private static final String NOME_CLIENTE8 = "Favarin Moveis";
	private static final String TELEFONE_CLIENTE8 = "(99)99999-9999";
	private static final String EMAIL_CLIENTE8 = "favarin@email.com";
	private static final String CNPJ_CLIENTE8 = "30.864.991/0001-11";
	private static final String TIPOPESSOANOME_CLIENTE8 = "Juridica";

	@Autowired
	private ClienteRepository clienteRepository;

	@Test
	void deveriaRetornarTodosOsClientes() {
		final List<Cliente> clienteList = this.clienteRepository.getClientes();

		assertEquals(8, clienteList.size());

		final Cliente cliente1 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE1).findFirst().get();
		assertEquals(cliente1.getNome(), ClienteRepositoryImplementationTest.NOME_CLIENTE1);
		assertEquals(cliente1.getEmail(), ClienteRepositoryImplementationTest.EMAIL_CLIENTE1);
		assertEquals(cliente1.getTelefone(), ClienteRepositoryImplementationTest.TELEFONE_CLIENTE1);
		assertEquals(cliente1.getCpfCnpj(), ClienteRepositoryImplementationTest.CPF_CLIENTE1);
		assertEquals(cliente1.getTipo().getDescricao(), ClienteRepositoryImplementationTest.TIPOPESSOANOME_CLIENTE1);

		final Cliente cliente2 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE2).findFirst().get();
		assertEquals(cliente2.getNome(), ClienteRepositoryImplementationTest.NOME_CLIENTE2);
		assertEquals(cliente2.getEmail(), ClienteRepositoryImplementationTest.EMAIL_CLIENTE2);
		assertEquals(cliente2.getTelefone(), ClienteRepositoryImplementationTest.TELEFONE_CLIENTE2);
		assertEquals(cliente2.getCpfCnpj(), ClienteRepositoryImplementationTest.CNPJ_CLIENTE2);
		assertEquals(cliente2.getTipo().getDescricao(), ClienteRepositoryImplementationTest.TIPOPESSOANOME_CLIENTE2);
		
		final Cliente cliente3 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE3).findFirst().get();
		assertEquals(cliente3.getNome(), ClienteRepositoryImplementationTest.NOME_CLIENTE3);
		assertEquals(cliente3.getEmail(), ClienteRepositoryImplementationTest.EMAIL_CLIENTE3);
		assertEquals(cliente3.getTelefone(), ClienteRepositoryImplementationTest.TELEFONE_CLIENTE3);
		assertEquals(cliente3.getCpfCnpj(), ClienteRepositoryImplementationTest.CPF_CLIENTE3);
		assertEquals(cliente3.getTipo().getDescricao(), ClienteRepositoryImplementationTest.TIPOPESSOANOME_CLIENTE3);
		
		final Cliente cliente4 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE4).findFirst().get();
		assertEquals(cliente4.getNome(), ClienteRepositoryImplementationTest.NOME_CLIENTE4);
		assertEquals(cliente4.getEmail(), ClienteRepositoryImplementationTest.EMAIL_CLIENTE4);
		assertEquals(cliente4.getTelefone(), ClienteRepositoryImplementationTest.TELEFONE_CLIENTE4);
		assertEquals(cliente4.getCpfCnpj(), ClienteRepositoryImplementationTest.CPF_CLIENTE4);
		assertEquals(cliente4.getTipo().getDescricao(), ClienteRepositoryImplementationTest.TIPOPESSOANOME_CLIENTE4);
		
		final Cliente cliente5 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE5).findFirst().get();
		assertEquals(cliente5.getNome(), ClienteRepositoryImplementationTest.NOME_CLIENTE5);
		assertEquals(cliente5.getEmail(), ClienteRepositoryImplementationTest.EMAIL_CLIENTE5);
		assertEquals(cliente5.getTelefone(), ClienteRepositoryImplementationTest.TELEFONE_CLIENTE5);
		assertEquals(cliente5.getCpfCnpj(), ClienteRepositoryImplementationTest.CPF_CLIENTE5);
		assertEquals(cliente5.getTipo().getDescricao(), ClienteRepositoryImplementationTest.TIPOPESSOANOME_CLIENTE5);
		
		final Cliente cliente6 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE6).findFirst().get();
		assertEquals(cliente6.getNome(), ClienteRepositoryImplementationTest.NOME_CLIENTE6);
		assertEquals(cliente6.getEmail(), ClienteRepositoryImplementationTest.EMAIL_CLIENTE6);
		assertEquals(cliente6.getTelefone(), ClienteRepositoryImplementationTest.TELEFONE_CLIENTE6);
		assertEquals(cliente6.getCpfCnpj(), ClienteRepositoryImplementationTest.CPF_CLIENTE6);
		assertEquals(cliente6.getTipo().getDescricao(), ClienteRepositoryImplementationTest.TIPOPESSOANOME_CLIENTE6);
		
		final Cliente cliente7 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE7).findFirst().get();
		assertEquals(cliente7.getNome(), ClienteRepositoryImplementationTest.NOME_CLIENTE7);
		assertEquals(cliente7.getEmail(), ClienteRepositoryImplementationTest.EMAIL_CLIENTE7);
		assertEquals(cliente7.getTelefone(), ClienteRepositoryImplementationTest.TELEFONE_CLIENTE7);
		assertEquals(cliente7.getCpfCnpj(), ClienteRepositoryImplementationTest.CNPJ_CLIENTE7);
		assertEquals(cliente7.getTipo().getDescricao(), ClienteRepositoryImplementationTest.TIPOPESSOANOME_CLIENTE7);
		
		final Cliente cliente8 = clienteList.stream()
				.filter(c -> c.getCodigo() == ClienteRepositoryImplementationTest.CODIGO_CLIENTE8).findFirst().get();
		assertEquals(cliente8.getNome(), ClienteRepositoryImplementationTest.NOME_CLIENTE8);
		assertEquals(cliente8.getEmail(), ClienteRepositoryImplementationTest.EMAIL_CLIENTE8);
		assertEquals(cliente8.getTelefone(), ClienteRepositoryImplementationTest.TELEFONE_CLIENTE8);
		assertEquals(cliente8.getCpfCnpj(), ClienteRepositoryImplementationTest.CNPJ_CLIENTE8);
		assertEquals(cliente8.getTipo().getDescricao(), ClienteRepositoryImplementationTest.TIPOPESSOANOME_CLIENTE8);
	
	}

}
