package br.com.wmw.vendafacil_backend.data.datasources;

import java.util.List;

import br.com.wmw.vendafacil_backend.data.models.cliente.ClienteModel;

public interface ClienteDatasource {

	List<ClienteModel> getClientes();

}
