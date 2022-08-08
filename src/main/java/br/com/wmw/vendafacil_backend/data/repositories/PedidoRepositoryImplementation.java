package br.com.wmw.vendafacil_backend.data.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wmw.vendafacil_backend.data.datasources.specifications.PedidoDatasource;
import br.com.wmw.vendafacil_backend.data.models.pedido.ItemPedidoModel;
import br.com.wmw.vendafacil_backend.data.models.pedido.PedidoModel;
import br.com.wmw.vendafacil_backend.domain.pedido.entity.Pedido;
import br.com.wmw.vendafacil_backend.domain.pedido.repository.PedidoRepository;

@Component
public class PedidoRepositoryImplementation implements PedidoRepository {

	@Autowired
	private PedidoDatasource datasourcePedido;

	@Override
	public Pedido createPedido(final Pedido pedido) {
		final PedidoModel pedidoModelConverted = PedidoModel.convert(pedido);
		pedido.getItens().forEach(itemPedido -> {
			final ItemPedidoModel itemPedidoModel = ItemPedidoModel.toItemPedidoModel(itemPedido);
			pedidoModelConverted.addItemPedidoModel(itemPedidoModel);
		});
		final PedidoModel pedidoModelCreated = this.datasourcePedido.createPedido(pedidoModelConverted);
		return pedidoModelCreated.toPedido();
	}

}
