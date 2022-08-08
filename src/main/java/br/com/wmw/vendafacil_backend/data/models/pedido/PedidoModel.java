package br.com.wmw.vendafacil_backend.data.models.pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.wmw.vendafacil_backend.data.models.cliente.ClienteModel;
import br.com.wmw.vendafacil_backend.domain.pedido.entity.Pedido;
import br.com.wmw.vendafacil_backend.domain.shared.entity.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_PEDIDO")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PedidoModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long numero;

	private LocalDate dataEmissao;

	private LocalDate dataEntrega;

	@ManyToOne
	@JoinColumn(name = "codigoStatusPedido")
	private StatusPedidoModel status;

	private Double valorTotal;

	@ManyToOne
	@JoinColumn(name = "codigoCliente")
	private ClienteModel cliente;

	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ItemPedidoModel> itens = new ArrayList<>();

	public PedidoModel(final Pedido pedido) {
		this.dataEmissao = pedido.getDataEmissao();
		this.dataEntrega = pedido.getDataEntrega();
		this.status = StatusPedidoModel.convert(pedido.getStatus());
		this.valorTotal = pedido.getValorTotal();
		this.cliente = ClienteModel.convert(pedido.getCliente());
	}

	public static PedidoModel convert(final Pedido pedido) {
		return new PedidoModel(pedido);
	}

	public Pedido toPedido() {
		final List<ItemPedido> itensConverted = this.itens.stream().map(ItemPedidoModel::toItemPedido)
				.collect(Collectors.toList());
		return new Pedido(this.numero, this.dataEmissao, this.dataEntrega, this.status.toStatusPedido(),
				this.valorTotal, this.cliente.toCliente(), itensConverted);
	}

	public void addItemPedidoModel(final ItemPedidoModel itemPedidoModel) {
		this.itens.add(itemPedidoModel);
		itemPedidoModel.setPedido(this);
	}

}
