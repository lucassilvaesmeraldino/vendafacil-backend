package br.com.wmw.vendafacil_backend.domain.pedido.entity;

import java.time.LocalDate;
import java.util.List;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import br.com.wmw.vendafacil_backend.domain.shared.entity.ItemPedido;

public class Pedido {

	private Long numero;

	private LocalDate dataEmissao;

	private LocalDate dataEntrega;

	private StatusPedido status;

	private Double valorTotal;

	private final Cliente cliente;

	private List<ItemPedido> itens;

	public Pedido(final Long numero, final LocalDate dataEmissao, final LocalDate dataEntrega,
			final StatusPedido status, final Double valorTotal, final Cliente cliente, final List<ItemPedido> itens) {
		this.numero = numero;
		this.dataEmissao = dataEmissao;
		this.dataEntrega = dataEntrega;
		this.status = status;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.itens = itens;
	}

	public Pedido(final LocalDate dataEmissao, final LocalDate dataEntrega, final StatusPedido status,
			final Double valorTotal, final Cliente cliente, final List<ItemPedido> itens) {
		this.dataEmissao = dataEmissao;
		this.dataEntrega = dataEntrega;
		this.status = status;
		this.valorTotal = valorTotal;
		this.cliente = cliente;
		this.itens = itens;
	}

	public Long getNumero() {
		return this.numero;
	}

	public void setNumero(final Long numero) {
		this.numero = numero;
	}

	public LocalDate getDataEmissao() {
		return this.dataEmissao;
	}

	public void setDataEmissao(final LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public LocalDate getDataEntrega() {
		return this.dataEntrega;
	}

	public void setDataEntrega(final LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public StatusPedido getStatus() {
		return this.status;
	}

	public void setStatus(final StatusPedido status) {
		this.status = status;
	}

	public Double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(final Double valor_total) {
		this.valorTotal = valor_total;
	}

	public List<ItemPedido> getItens() {
		return this.itens;
	}

	public void setItens(final List<ItemPedido> itens) {
		this.itens = itens;
	}

	public Cliente getCliente() {
		return this.cliente;
	}
}
