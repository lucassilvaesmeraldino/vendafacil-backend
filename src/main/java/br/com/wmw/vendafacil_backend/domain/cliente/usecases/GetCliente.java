package br.com.wmw.vendafacil_backend.domain.cliente.usecases;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import br.com.wmw.vendafacil_backend.domain.cliente.repository.ClienteRepository;

public class GetCliente {

	private final ClienteRepository clienteRepository;

	public GetCliente(final ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente execute(final Long codigo) {
		return this.clienteRepository.getClienteByCodigo(codigo);
	}
}
