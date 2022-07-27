package br.com.wmw.vendafacil_backend.data.models.cliente;

import java.util.List;
import java.util.stream.Collectors;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import lombok.Getter;

@Getter
public class ClienteResponseModel {

	private final Long codigo;
	private final String nome;

	public ClienteResponseModel(final Cliente entity) {
		this.codigo = entity.getCodigo();
		this.nome = entity.getNome();
	}

	public static List<ClienteResponseModel> convert(final List<Cliente> clientes) {
		return clientes.stream().map(ClienteResponseModel::new).collect(Collectors.toList());
	}

}
