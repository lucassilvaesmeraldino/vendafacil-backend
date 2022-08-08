package br.com.wmw.vendafacil_backend.data.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.wmw.vendafacil_backend.data.models.pedido.PedidoRequestModel;
import br.com.wmw.vendafacil_backend.data.models.pedido.PedidoResponseModel;
import br.com.wmw.vendafacil_backend.domain.cliente.usecases.GetCliente;
import br.com.wmw.vendafacil_backend.domain.pedido.entity.Pedido;
import br.com.wmw.vendafacil_backend.domain.pedido.usecases.CreatePedido;
import br.com.wmw.vendafacil_backend.domain.pedido.usecases.GetStatusPedido;
import br.com.wmw.vendafacil_backend.domain.produto.usecases.GetProduto;

@RestController
@RequestMapping("pedidos")
public class PedidoRestController {

	@Autowired
	private CreatePedido createPedido;

	@Autowired
	private GetStatusPedido getStatusPedido;

	@Autowired
	private GetProduto getProduto;

	@Autowired
	private GetCliente getCliente;

	@PostMapping
	@Transactional
	public ResponseEntity<?> create(@Valid @RequestBody final PedidoRequestModel pedidoRequestModel,
			final UriComponentsBuilder uriBuilder) {
		final Pedido pedidoData = pedidoRequestModel.toPedido(this.getStatusPedido, this.getProduto, this.getCliente);
		final Pedido pedidoCreated = this.createPedido.execute(pedidoData);
		return ResponseEntity
				.created(uriBuilder.path("/pedidos/{numero}").buildAndExpand(pedidoCreated.getNumero()).toUri())
				.body(new PedidoResponseModel(pedidoCreated));
	}

}