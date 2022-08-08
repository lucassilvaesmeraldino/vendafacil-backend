package br.com.wmw.vendafacil_backend.data.models.pedido;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.wmw.vendafacil_backend.data.models.produto.ProdutoModel;
import br.com.wmw.vendafacil_backend.domain.shared.entity.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "TB_ITEMPEDIDO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPedidoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@ManyToOne
	@JoinColumn(name = "numeroPedido")
	private PedidoModel pedido;

	@ManyToOne
	@JoinColumn(name = "codigoProduto")
	private ProdutoModel produto;

	private Long numeroSequencia;

	private Integer quantidade;

	private Double precoUnitario;

	private Double desconto;

	private Double valorTotal;

	public ItemPedidoModel(final ItemPedido itemPedido) {
		this.produto = ProdutoModel.toProdutoModel(itemPedido.getProduto());
		this.numeroSequencia = itemPedido.getNumeroSequencia();
		this.quantidade = itemPedido.getQuantidade();
		this.precoUnitario = itemPedido.getPrecoUnitario();
		this.desconto = itemPedido.getDesconto();
		this.valorTotal = itemPedido.getValorTotal();
	}

	public ItemPedidoModel(final Long codigo, final ProdutoModel produto, final Long numeroSequencia,
			final Integer quantidade, final Double precoUnitario, final Double desconto, final Double valorTotal) {
		this.codigo = codigo;
		this.produto = produto;
		this.numeroSequencia = numeroSequencia;
		this.quantidade = quantidade;
		this.precoUnitario = precoUnitario;
		this.desconto = desconto;
		this.valorTotal = valorTotal;
	}

	public static ItemPedidoModel toItemPedidoModel(final ItemPedido itemPedido) {
		return new ItemPedidoModel(itemPedido);
	}

	public ItemPedido toItemPedido() {
		return new ItemPedido(this.codigo, this.numeroSequencia, this.quantidade, this.precoUnitario, this.desconto,
				this.valorTotal, this.produto.toProduto());
	}

}
