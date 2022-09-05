package br.com.wmw.vendafacil_backend.data.models.produto;

import java.util.List;

import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;
import lombok.Getter;

@Getter
public class ProdutoResponseModel {

	private final Long codigo;

	private final String nome;

	private final Double preco;

	public ProdutoResponseModel(final Produto produto) {
		this.codigo = produto.getCodigo();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
	}

	public static List<ProdutoResponseModel> convert(final List<Produto> produtoList) {
		return produtoList.stream().map(ProdutoResponseModel::new).toList();
	}

}
