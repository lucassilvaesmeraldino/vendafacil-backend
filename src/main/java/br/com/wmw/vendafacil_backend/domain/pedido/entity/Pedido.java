package br.com.wmw.vendafacil_backend.domain.pedido.entity;

import java.time.LocalDate;
import java.util.List;

public class Pedido {

	private Integer numero;

	private LocalDate data_emissao;

	private LocalDate data_entrega;

	private StatusDoPedido status;

	private Double valor_total;

	private List<ItemDoPedido> itens;

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(final Integer numero) {
		this.numero = numero;
	}

	public LocalDate getData_emissao() {
		return this.data_emissao;
	}

	public void setData_emissao(final LocalDate data_emissao) {
		this.data_emissao = data_emissao;
	}

	public LocalDate getData_entrega() {
		return this.data_entrega;
	}

	public void setData_entrega(final LocalDate data_entrega) {
		this.data_entrega = data_entrega;
	}

	public StatusDoPedido getStatus() {
		return this.status;
	}

	public void setStatus(final StatusDoPedido status) {
		this.status = status;
	}

	public Double getValor_total() {
		return this.valor_total;
	}

	public void setValor_total(final Double valor_total) {
		this.valor_total = valor_total;
	}

	public List<ItemDoPedido> getItens() {
		return this.itens;
	}

	public void setItens(final List<ItemDoPedido> itens) {
		this.itens = itens;
	}

}
