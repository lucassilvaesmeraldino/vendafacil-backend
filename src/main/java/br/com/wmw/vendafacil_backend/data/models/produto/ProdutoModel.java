package br.com.wmw.vendafacil_backend.data.models.produto;

import java.util.List;
import java.util.stream.Collectors;

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

	public static List<Produto> convertToProdutoList(final List<ProdutoModel> produtoModelList) {
		return produtoModelList.stream().map(
				produtoModel -> new Produto(produtoModel.getCodigo(), produtoModel.getNome(), produtoModel.getPreco()))
				.collect(Collectors.toList());
	}
}
