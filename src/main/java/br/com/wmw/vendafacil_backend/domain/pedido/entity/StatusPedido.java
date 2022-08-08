package br.com.wmw.vendafacil_backend.domain.pedido.entity;

public class StatusPedido {

	private Long codigo;
	private String descricao;

	public StatusPedido(final Long codigo, final String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(final Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(final String descricao) {
		this.descricao = descricao;
	}

}
