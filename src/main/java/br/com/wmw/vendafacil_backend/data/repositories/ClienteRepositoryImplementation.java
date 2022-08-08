package br.com.wmw.vendafacil_backend.data.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wmw.vendafacil_backend.core.exceptions.NotFoundException;
import br.com.wmw.vendafacil_backend.data.datasources.specifications.ClienteDatasource;
import br.com.wmw.vendafacil_backend.data.models.cliente.ClienteModel;
import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import br.com.wmw.vendafacil_backend.domain.cliente.repository.ClienteRepository;

@Component
public class ClienteRepositoryImplementation implements ClienteRepository {

	@Autowired
	private ClienteDatasource datasourceCliente;

	@Override
	public List<Cliente> getClientes() {
		return ClienteModel.convertToClienteList(this.datasourceCliente.getClientes());
	}

	@Override
	public Cliente getClienteByCodigo(final Long codigo) {
		final Optional<ClienteModel> opClienteModel = this.datasourceCliente.getClienteByCodigo(codigo);
		if (!opClienteModel.isPresent()) {
			throw new NotFoundException(String.format("O cliente com o CODIGO %d não existe.", codigo));
		}
		return opClienteModel.get().toCliente();
	}

}
