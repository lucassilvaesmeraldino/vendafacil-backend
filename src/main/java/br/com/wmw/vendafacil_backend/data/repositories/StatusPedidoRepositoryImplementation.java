package br.com.wmw.vendafacil_backend.data.repositories;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wmw.vendafacil_backend.core.exceptions.NotFoundException;
import br.com.wmw.vendafacil_backend.data.datasources.specifications.StatusPedidoDatasource;
import br.com.wmw.vendafacil_backend.data.models.pedido.StatusPedidoModel;
import br.com.wmw.vendafacil_backend.domain.pedido.entity.StatusPedido;
import br.com.wmw.vendafacil_backend.domain.pedido.repository.StatusPedidoRepository;

@Component
public class StatusPedidoRepositoryImplementation implements StatusPedidoRepository {

	@Autowired
	private StatusPedidoDatasource datasourceStatusPedido;

	@Override
	public StatusPedido getStatusPedidoByCodigo(final Long codigo) {
		final Optional<StatusPedidoModel> opStatusPedidoModel = this.datasourceStatusPedido
				.getStatusPedidoByCodigo(codigo);
		if (!opStatusPedidoModel.isPresent()) {
			throw new NotFoundException(String.format("O status do pedido de CODIGO %d não existe.", codigo));
		}
		return opStatusPedidoModel.get().toStatusPedido();
	}

}
