package br.com.wmw.vendafacil_backend.data.datasources.specifications;

import java.util.List;
import java.util.Optional;

import br.com.wmw.vendafacil_backend.data.models.produto.ProdutoModel;

public interface ProdutoDatasource {

	List<ProdutoModel> getProdutos();

	Optional<ProdutoModel> getProdutoByCodigo(Long codigo);
}
