package br.com.wmw.vendafacil_backend.data.datasources.implementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wmw.vendafacil_backend.data.datasources.JpaPedidoRepository;
import br.com.wmw.vendafacil_backend.data.datasources.specifications.PedidoDatasource;
import br.com.wmw.vendafacil_backend.data.models.pedido.PedidoModel;

@Component
public class PedidoLocalDatasource implements PedidoDatasource {

	@Autowired
	private JpaPedidoRepository jpaPedidoRepository;

	@Override
	public PedidoModel createPedido(final PedidoModel pedidoModel) {
		return this.jpaPedidoRepository.save(pedidoModel);
	}

}
