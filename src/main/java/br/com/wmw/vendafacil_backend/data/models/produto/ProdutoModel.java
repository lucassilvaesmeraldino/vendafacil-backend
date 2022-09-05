package br.com.wmw.vendafacil_backend.data.models.produto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_PRODUTO")
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoModel {

	@Id
	private Long codigo;

	private String nome;

	private Double preco;

	public ProdutoModel(final Produto produto) {
		this.codigo = produto.getCodigo();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
	}

	public static List<Produto> convertToProdutoList(final List<ProdutoModel> produtoModelList) {
		return produtoModelList.stream().map(
				produtoModel -> new Produto(produtoModel.getCodigo(), produtoModel.getNome(), produtoModel.getPreco()))
				.toList();
	}

	public static ProdutoModel toProdutoModel(final Produto produto) {
		return new ProdutoModel(produto);
	}

	public Produto toProduto() {
		return new Produto(this.codigo, this.nome, this.preco);
	}
}
