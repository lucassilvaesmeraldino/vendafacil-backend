package br.com.wmw.vendafacil_backend.domain.produto.entity;

public class Produto {

	private Long codigo;

	private String nome;

	private Double preco;

	public Produto(final Long codigo, final String nome, final Double preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
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

	public Double getPreco() {
		return this.preco;
	}

	public void setPreco(final Double preco) {
		this.preco = preco;
	}

}
