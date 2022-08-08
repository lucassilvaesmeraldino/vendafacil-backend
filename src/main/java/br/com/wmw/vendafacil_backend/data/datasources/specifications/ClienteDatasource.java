package br.com.wmw.vendafacil_backend.data.datasources.specifications;

import java.util.List;
import java.util.Optional;

import br.com.wmw.vendafacil_backend.data.models.cliente.ClienteModel;

public interface ClienteDatasource {

	List<ClienteModel> getClientes();

	Optional<ClienteModel> getClienteByCodigo(Long codigo);

}
