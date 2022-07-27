package br.com.wmw.vendafacil_backend.data.datasources;

import java.util.List;

import br.com.wmw.vendafacil_backend.data.models.produto.ProdutoModel;

public interface ProdutoDatasource {

	List<ProdutoModel> getProdutos();
}
