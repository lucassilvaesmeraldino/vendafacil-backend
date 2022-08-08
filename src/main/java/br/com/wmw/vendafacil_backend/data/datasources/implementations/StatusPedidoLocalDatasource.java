package br.com.wmw.vendafacil_backend.data.datasources.implementations;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wmw.vendafacil_backend.data.datasources.JpaStatusPedidoRepository;
import br.com.wmw.vendafacil_backend.data.datasources.specifications.StatusPedidoDatasource;
import br.com.wmw.vendafacil_backend.data.models.pedido.StatusPedidoModel;

@Component
public class StatusPedidoLocalDatasource implements StatusPedidoDatasource {

	@Autowired
	private JpaStatusPedidoRepository jpaStatusPedidoRepository;

	@Override
	public Optional<StatusPedidoModel> getStatusPedidoByCodigo(final Long codigo) {
		return this.jpaStatusPedidoRepository.findById(codigo);
	}
}
