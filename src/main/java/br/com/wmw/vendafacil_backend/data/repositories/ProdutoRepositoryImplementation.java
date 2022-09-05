package br.com.wmw.vendafacil_backend.data.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wmw.vendafacil_backend.core.exceptions.NotFoundException;
import br.com.wmw.vendafacil_backend.data.datasources.specifications.ProdutoDatasource;
import br.com.wmw.vendafacil_backend.data.models.produto.ProdutoModel;
import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;
import br.com.wmw.vendafacil_backend.domain.produto.repository.ProdutoRepository;

@Component
public class ProdutoRepositoryImplementation implements ProdutoRepository {

	@Autowired
	private ProdutoDatasource datasourceProduto;

	@Override
	public List<Produto> getProdutos() {
		return ProdutoModel.convertToProdutoList(this.datasourceProduto.getProdutos());
	}

	@Override
	public Produto getProdutoByCodigo(final Long codigo) {
		final Optional<ProdutoModel> opProdutoModel = this.datasourceProduto.getProdutoByCodigo(codigo);
		if (!opProdutoModel.isPresent()) {
			throw new NotFoundException(String.format("O produto com o CODIGO %d não existe.", codigo));
		}
		return opProdutoModel.get().toProduto();
	}

}
