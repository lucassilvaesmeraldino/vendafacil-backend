package br.com.wmw.vendafacil_backend.data.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wmw.vendafacil_backend.data.datasources.ClienteDatasource;
import br.com.wmw.vendafacil_backend.data.models.cliente.ClienteModel;
import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import br.com.wmw.vendafacil_backend.domain.cliente.repository.ClienteRepository;

@Component
public class ClienteRepositoryImplementation implements ClienteRepository {

	@Autowired
	private ClienteDatasource datasourcesCliente;

	@Override
	public List<Cliente> getClientes() {
		return ClienteModel.convertToClienteList(this.datasourcesCliente.getClientes());
	}

}
