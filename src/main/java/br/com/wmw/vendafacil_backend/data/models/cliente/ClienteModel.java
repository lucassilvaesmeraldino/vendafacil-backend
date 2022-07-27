package br.com.wmw.vendafacil_backend.data.models.cliente;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_CLIENTE")
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ClienteModel {

	@Id
	private Long codigo;

	private String nome;

	private String telefone;

	private String email;

	@ManyToOne
	@JoinColumn(name = "codigoTipoPessoa")
	private TipoPessoaModel tipo;

	private String cpfCnpj;

	public static List<Cliente> convertToClienteList(final List<ClienteModel> clienteModelList) {
		return clienteModelList.stream()
				.map(clienteModel -> new Cliente(clienteModel.getCodigo(), clienteModel.getNome(),
						clienteModel.getTelefone(), clienteModel.getEmail(), clienteModel.getCpfCnpj(),
						clienteModel.getTipo().convertToTipoPessoa()))
				.collect(Collectors.toList());
	}

}
