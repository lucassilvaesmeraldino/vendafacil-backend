package br.com.wmw.vendafacil_backend.domain.cliente.usecases;

import java.util.List;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import br.com.wmw.vendafacil_backend.domain.cliente.repository.ClienteRepository;

public class GetClientes {

	ClienteRepository clienteRepository;

	public GetClientes(final ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public List<Cliente> execute() {
		return this.clienteRepository.getClientes();
	}
}
