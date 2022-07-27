package br.com.wmw.vendafacil_backend.domain.produto.usecases;

import java.util.List;

import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;
import br.com.wmw.vendafacil_backend.domain.produto.repository.ProdutoRepository;

public class GetProdutos {

	ProdutoRepository produtoRepository;

	public GetProdutos(final ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public List<Produto> execute() {
		return this.produtoRepository.getProdutos();
	}
}
