package br.com.wmw.vendafacil_backend.data.models.pedido;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.wmw.vendafacil_backend.domain.pedido.entity.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_STATUSPEDIDO")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StatusPedidoModel {

	@Id
	private Long codigo;
	private String descricao;

	public StatusPedidoModel(final StatusPedido statusPedido) {
		this.codigo = statusPedido.getCodigo();
		this.descricao = statusPedido.getDescricao();
	}

	public static StatusPedidoModel convert(final StatusPedido statusPedido) {
		return new StatusPedidoModel(statusPedido);
	}

	public StatusPedido toStatusPedido() {
		return new StatusPedido(this.codigo, this.descricao);
	}
}
