package br.com.wmw.vendafacil_backend.domain.cliente.entity;

public class Cliente {

	private Long codigo;

	private String nome;

	private String telefone;

	private String email;

	private String cpfCnpj;

	private TipoPessoa tipo;

	public Cliente(final Long codigo, final String nome, final String telefone, final String email,
			final String cpfCnpj, final TipoPessoa tipo) {
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpfCnpj = cpfCnpj;
		this.tipo = tipo;
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

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(final String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public TipoPessoa getTipo() {
		return this.tipo;
	}

	public void setTipo(final TipoPessoa tipo) {
		this.tipo = tipo;
	}

	public String getCpfCnpj() {
		return this.cpfCnpj;
	}

	public void setCpfCnpj(final String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

}
