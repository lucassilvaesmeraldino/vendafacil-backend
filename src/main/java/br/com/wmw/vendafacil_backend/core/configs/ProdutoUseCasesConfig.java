package br.com.wmw.vendafacil_backend.core.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.wmw.vendafacil_backend.domain.produto.repository.ProdutoRepository;
import br.com.wmw.vendafacil_backend.domain.produto.usecases.GetProdutos;

@Configuration
public class ProdutoUseCasesConfig {

	@Autowired
	private ProdutoRepository produtoRepository;

	@Bean
	public GetProdutos getProdutos() {
		return new GetProdutos(this.produtoRepository);
	}

}
