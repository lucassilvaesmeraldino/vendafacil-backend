package br.com.wmw.vendafacil_backend.data.datasources.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wmw.vendafacil_backend.data.datasources.ClienteDatasource;
import br.com.wmw.vendafacil_backend.data.datasources.JpaClienteRepository;
import br.com.wmw.vendafacil_backend.data.models.cliente.ClienteModel;

@Component
public class ClienteLocalDatasource implements ClienteDatasource {

	@Autowired
	JpaClienteRepository jpaClienteRepository;

	@Override
	public List<ClienteModel> getClientes() {
		return this.jpaClienteRepository.findAll();
	}

}
