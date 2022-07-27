package br.com.wmw.vendafacil_backend.domain.cliente.repository;

import java.util.List;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;

public interface ClienteRepository {

	List<Cliente> getClientes();

}
