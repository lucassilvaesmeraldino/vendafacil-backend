package br.com.wmw.vendafacil_backend.domain.pedido.entity;

import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;

public class ItemDoPedido {

	private Pedido pedido;

	private Produto produto;

	private Integer numero;

	private Integer quantidade;

	private Double preco_unitario;

	private Double desconto;

	private Double valor_total;

	public Pedido getPedido() {
		return this.pedido;
	}

	public void setPedido(final Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(final Produto produto) {
		this.produto = produto;
	}

	public Integer getNumero() {
		return this.numero;
	}

	public void setNumero(final Integer numero) {
		this.numero = numero;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(final Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco_unitario() {
		return this.preco_unitario;
	}

	public void setPreco_unitario(final Double preco_unitario) {
		this.preco_unitario = preco_unitario;
	}

	public Double getDesconto() {
		return this.desconto;
	}

	public void setDesconto(final Double desconto) {
		this.desconto = desconto;
	}

	public Double getValor_total() {
		return this.valor_total;
	}

	public void setValor_total(final Double valor_total) {
		this.valor_total = valor_total;
	}

}
