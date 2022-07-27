package br.com.wmw.vendafacil_backend.data.models.cliente;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.TipoPessoa;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_TIPOPESSOA")
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class TipoPessoaModel {

	@Id
	private Long codigo;
	private String nome;

	public TipoPessoa convertToTipoPessoa() {
		return new TipoPessoa(this.codigo, this.nome);
	}

}
