package br.com.wmw.vendafacil_backend.domain.produto.repository;

import java.util.List;

import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;

public interface ProdutoRepository {

	List<Produto> getProdutos();
}
