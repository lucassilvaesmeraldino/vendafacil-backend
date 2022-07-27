package br.com.wmw.vendafacil_backend.data.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wmw.vendafacil_backend.data.datasources.ProdutoDatasource;
import br.com.wmw.vendafacil_backend.data.models.produto.ProdutoModel;
import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;
import br.com.wmw.vendafacil_backend.domain.produto.repository.ProdutoRepository;

@Component
public class ProdutoRepositoryImplementation implements ProdutoRepository {

	@Autowired
	private ProdutoDatasource produtoDatasource;

	@Override
	public List<Produto> getProdutos() {
		return ProdutoModel.convertToProdutoList(this.produtoDatasource.getProdutos());
	}

}
