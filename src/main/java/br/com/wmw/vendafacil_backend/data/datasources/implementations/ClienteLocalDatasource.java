package br.com.wmw.vendafacil_backend.data.datasources.implementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wmw.vendafacil_backend.data.datasources.JpaClienteRepository;
import br.com.wmw.vendafacil_backend.data.datasources.specifications.ClienteDatasource;
import br.com.wmw.vendafacil_backend.data.models.cliente.ClienteModel;

@Component
public class ClienteLocalDatasource implements ClienteDatasource {

	@Autowired
	private JpaClienteRepository jpaClienteRepository;

	@Override
	public List<ClienteModel> getClientes() {
		return this.jpaClienteRepository.findAll();
	}

	@Override
	public Optional<ClienteModel> getClienteByCodigo(final Long codigo) {
		return this.jpaClienteRepository.findById(codigo);
	}

}
