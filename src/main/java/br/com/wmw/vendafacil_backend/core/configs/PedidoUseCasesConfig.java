package br.com.wmw.vendafacil_backend.core.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.wmw.vendafacil_backend.domain.pedido.repository.PedidoRepository;
import br.com.wmw.vendafacil_backend.domain.pedido.repository.StatusPedidoRepository;
import br.com.wmw.vendafacil_backend.domain.pedido.usecases.CreatePedido;
import br.com.wmw.vendafacil_backend.domain.pedido.usecases.GetStatusPedido;
import br.com.wmw.vendafacil_backend.domain.pedido.validators.ValorTotalPedidoValidator;
import br.com.wmw.vendafacil_backend.domain.shared.validator.DescontoItemPedidoValidator;

@Configuration
public class PedidoUseCasesConfig {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private StatusPedidoRepository statusPedidoRepository;

	@Bean
	public ValorTotalPedidoValidator valorTotalPedidoValidator() {
		return new ValorTotalPedidoValidator();
	}

	@Bean
	public DescontoItemPedidoValidator descontoItemPedidoValidator() {
		return new DescontoItemPedidoValidator();
	}

	@Bean
	public CreatePedido createPedido() {
		return new CreatePedido(this.pedidoRepository, valorTotalPedidoValidator(), descontoItemPedidoValidator());
	}

	@Bean
	public GetStatusPedido getStatusPedido() {
		return new GetStatusPedido(this.statusPedidoRepository);
	}
}
