package br.com.wmw.vendafacil_backend.domain.produto.usecases;

import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;
import br.com.wmw.vendafacil_backend.domain.produto.repository.ProdutoRepository;

public class GetProduto {

	private final ProdutoRepository produtoRepository;

	public GetProduto(final ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public Produto execute(final Long codigo) {
		return this.produtoRepository.getProdutoByCodigo(codigo);
	}
}
