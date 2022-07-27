package br.com.wmw.vendafacil_backend.core.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.wmw.vendafacil_backend.domain.cliente.repository.ClienteRepository;
import br.com.wmw.vendafacil_backend.domain.cliente.usecases.GetClientes;

@Configuration
public class ClienteUseCasesConfig {

	@Autowired
	private ClienteRepository clienteRepository;

	@Bean
	public GetClientes getClientes() {
		return new GetClientes(this.clienteRepository);
	}
}
