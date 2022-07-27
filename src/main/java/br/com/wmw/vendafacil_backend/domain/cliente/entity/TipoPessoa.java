package br.com.wmw.vendafacil_backend.domain.cliente.entity;

public class TipoPessoa {

	private Long codigo;
	private String nome;

	public TipoPessoa(final Long codigo, final String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public Long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(final Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(final String nome) {
		this.nome = nome;
	}

}
