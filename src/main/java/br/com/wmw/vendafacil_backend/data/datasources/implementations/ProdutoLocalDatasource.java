package br.com.wmw.vendafacil_backend.data.datasources.implementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.wmw.vendafacil_backend.data.datasources.JpaProdutoRepository;
import br.com.wmw.vendafacil_backend.data.datasources.ProdutoDatasource;
import br.com.wmw.vendafacil_backend.data.models.produto.ProdutoModel;

@Component
public class ProdutoLocalDatasource implements ProdutoDatasource {

	@Autowired
	private JpaProdutoRepository jpaProdutoRepository;

	@Override
	public List<ProdutoModel> getProdutos() {
		return this.jpaProdutoRepository.findAll();
	}
}
