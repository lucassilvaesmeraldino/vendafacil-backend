package br.com.wmw.vendafacil_backend.data.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wmw.vendafacil_backend.data.models.produto.ProdutoResponseModel;
import br.com.wmw.vendafacil_backend.domain.produto.usecases.GetProdutos;

@RestController
@RequestMapping("produtos")
public class ProdutoRestController {

	@Autowired
	private GetProdutos getProdutos;

	@GetMapping
	public List<ProdutoResponseModel> findAll() {
		return ProdutoResponseModel.convert(this.getProdutos.execute());
	}

}
