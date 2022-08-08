package br.com.wmw.vendafacil_backend.domain.shared.entity;

import br.com.wmw.vendafacil_backend.domain.pedido.entity.Pedido;
import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;

public class ItemPedido {

	private Long codigo;

	private Pedido pedido;

	private Produto produto;

	private Long numeroSequencia;

	private Integer quantidade;

	private Double precoUnitario;

	private Double desconto;

	private Double valorTotal;

	public ItemPedido(final Long codigo, final Long numeroSequencia, final Integer quantidade,
			final Double precoUnitario, final Double desconto, final Double valorTotal, final Produto produto) {
		this.produto = produto;
		this.numeroSequencia = numeroSequencia;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.desconto = desconto;
		this.valorTotal = valorTotal;
		this.codigo = codigo;
	}

	public ItemPedido(final Long numeroSequencia, final Integer quantidade, final Double precoUnitario,
			final Double desconto, final Double valorTotal, final Produto produto) {
		this.produto = produto;
		this.numeroSequencia = numeroSequencia;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.desconto = desconto;
		this.valorTotal = valorTotal;
	}

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

	public Long getNumeroSequencia() {
		return this.numeroSequencia;
	}

	public void setNumeroSequencia(final Long numeroSequencia) {
		this.numeroSequencia = numeroSequencia;
	}

	public Integer getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(final Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPrecoUnitario() {
		return this.precoUnitario;
	}

	public void setPrecoUnitario(final Double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public Double getDesconto() {
		return this.desconto;
	}

	public void setDesconto(final Double desconto) {
		this.desconto = desconto;
	}

	public Double getValorTotal() {
		return this.valorTotal;
	}

	public void setValorTotal(final Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(final Long codigo) {
		this.codigo = codigo;
	}

}
