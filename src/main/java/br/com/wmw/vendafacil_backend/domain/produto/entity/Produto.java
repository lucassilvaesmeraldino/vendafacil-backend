package br.com.wmw.vendafacil_backend.domain.produto.entity;

public class Produto {

	private Integer codigo;

	private String nome;

	private Double preco;

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(final Integer codigo) {
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
