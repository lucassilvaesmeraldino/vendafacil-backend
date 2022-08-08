package br.com.wmw.vendafacil_backend.data.models.pedido;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import br.com.wmw.vendafacil_backend.data.models.cliente.ClienteModel;
import br.com.wmw.vendafacil_backend.data.models.cliente.TipoPessoaModel;
import br.com.wmw.vendafacil_backend.data.models.produto.ProdutoModel;
import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import br.com.wmw.vendafacil_backend.domain.cliente.entity.TipoPessoa;
import br.com.wmw.vendafacil_backend.domain.pedido.entity.Pedido;
import br.com.wmw.vendafacil_backend.domain.pedido.entity.StatusPedido;

class PedidoModelTest {

	private static final long CLIENTE_CODIGO = 1;
	private static final String CLIENTE_NOME = "Lucas";
	private static final String CLIENTE_TELEFONE = "(48)99999-9999";
	private static final String CLIENTE_EMAIL = "lucas@gmail.com";
	private static final String CLIENTE_CPFCNPJ = "888.888.888-88";
	private static final long TIPOPESSOA_CODIGO = 1;
	private static final String TIPOPESSOA_DESCRICAO = "Física";

	private static final long PRODUTOMODEL_CODIGO = 2;
	private static final String PRODUTOMODEL_NOME = "Camiseta BilaBong Tamanho M";
	private static final double PRODUTOMODEL_PRECO = 50;

	private static final long ITEMPEDIDOMODEL_CODIGO = 2;
	private static final long ITEMPEDIDOMODEL_NUMEROSEQUENCIA = 1;
	private static final int ITEMPEDIDOMODEL_QUANTIDADE = 3;
	private static final double ITEMPEDIDOMODEL_PRECOUNITARIO = 35;
	private static final double ITEMPEDIDOMODEL_DESCONTO = 15;
	private static final double ITEMPEDIDOMODEL_VALORTOTAL = 105;

	private static final long STATUSPEDIDO_CODIGO = 1;
	private static final String STATUSPEDIDO_DESCRICAO = "Emitido";

	private static final long PEDIDO_NUMERO = 1;
	private static final LocalDate PEDIDO_DATAEMISSAO = LocalDate.now();
	private static final LocalDate PEDIDO_DATAENTREGA = LocalDate.of(2022, 8, 5);
	private static final double PEDIDO_VALORTOTAL = 105;

	@Test
	void deveriaConverterUmPedidoEmUmPedidoModel() {
		final Pedido pedido = new Pedido(PedidoModelTest.PEDIDO_DATAEMISSAO, PedidoModelTest.PEDIDO_DATAENTREGA,
				new StatusPedido(PedidoModelTest.STATUSPEDIDO_CODIGO, PedidoModelTest.STATUSPEDIDO_DESCRICAO),
				PedidoModelTest.PEDIDO_VALORTOTAL,
				new Cliente(PedidoModelTest.CLIENTE_CODIGO, PedidoModelTest.CLIENTE_NOME,
						PedidoModelTest.CLIENTE_TELEFONE, PedidoModelTest.CLIENTE_EMAIL,
						PedidoModelTest.CLIENTE_CPFCNPJ,
						new TipoPessoa(PedidoModelTest.TIPOPESSOA_CODIGO, PedidoModelTest.TIPOPESSOA_DESCRICAO)),
				null);
		final PedidoModel pedidoModel = PedidoModel.convert(pedido);

		assertEquals(pedidoModel.getDataEmissao(), PedidoModelTest.PEDIDO_DATAEMISSAO);
		assertEquals(pedidoModel.getDataEntrega(), PedidoModelTest.PEDIDO_DATAENTREGA);
		assertEquals(pedidoModel.getValorTotal(), PedidoModelTest.PEDIDO_VALORTOTAL);
		assertEquals(pedidoModel.getStatus().getCodigo(), PedidoModelTest.STATUSPEDIDO_CODIGO);
		assertEquals(pedidoModel.getStatus().getDescricao(), PedidoModelTest.STATUSPEDIDO_DESCRICAO);
		assertEquals(pedidoModel.getCliente().getCodigo(), PedidoModelTest.CLIENTE_CODIGO);
		assertEquals(pedidoModel.getCliente().getNome(), PedidoModelTest.CLIENTE_NOME);
		assertEquals(pedidoModel.getCliente().getTelefone(), PedidoModelTest.CLIENTE_TELEFONE);
		assertEquals(pedidoModel.getCliente().getEmail(), PedidoModelTest.CLIENTE_EMAIL);
		assertEquals(pedidoModel.getCliente().getCpfCnpj(), PedidoModelTest.CLIENTE_CPFCNPJ);
		assertEquals(pedidoModel.getCliente().getTipo().getCodigo(), PedidoModelTest.TIPOPESSOA_CODIGO);
		assertEquals(pedidoModel.getCliente().getTipo().getDescricao(), PedidoModelTest.TIPOPESSOA_DESCRICAO);
	}

	@Test
	void deveriaConverterUmPedidoModelEmUmPedido() {
		final PedidoModel pedidoModel = new PedidoModel(PedidoModelTest.PEDIDO_NUMERO,
				PedidoModelTest.PEDIDO_DATAEMISSAO, PedidoModelTest.PEDIDO_DATAENTREGA,
				new StatusPedidoModel(PedidoModelTest.STATUSPEDIDO_CODIGO, PedidoModelTest.STATUSPEDIDO_DESCRICAO),
				PedidoModelTest.PEDIDO_VALORTOTAL,
				new ClienteModel(PedidoModelTest.CLIENTE_CODIGO, PedidoModelTest.CLIENTE_NOME,
						PedidoModelTest.CLIENTE_TELEFONE, PedidoModelTest.CLIENTE_EMAIL,
						new TipoPessoaModel(PedidoModelTest.TIPOPESSOA_CODIGO, PedidoModelTest.TIPOPESSOA_DESCRICAO),
						PedidoModelTest.CLIENTE_CPFCNPJ),
				new ArrayList<>());
		final Pedido pedido = pedidoModel.toPedido();

		assertEquals(pedido.getNumero(), PedidoModelTest.PEDIDO_NUMERO);
		assertEquals(pedido.getDataEmissao(), PedidoModelTest.PEDIDO_DATAEMISSAO);
		assertEquals(pedido.getDataEntrega(), PedidoModelTest.PEDIDO_DATAENTREGA);
		assertEquals(pedido.getValorTotal(), PedidoModelTest.PEDIDO_VALORTOTAL);
		assertEquals(pedido.getStatus().getCodigo(), PedidoModelTest.STATUSPEDIDO_CODIGO);
		assertEquals(pedido.getStatus().getDescricao(), PedidoModelTest.STATUSPEDIDO_DESCRICAO);
		assertEquals(pedido.getCliente().getCodigo(), PedidoModelTest.CLIENTE_CODIGO);
		assertEquals(pedido.getCliente().getNome(), PedidoModelTest.CLIENTE_NOME);
		assertEquals(pedido.getCliente().getTelefone(), PedidoModelTest.CLIENTE_TELEFONE);
		assertEquals(pedido.getCliente().getEmail(), PedidoModelTest.CLIENTE_EMAIL);
		assertEquals(pedido.getCliente().getCpfCnpj(), PedidoModelTest.CLIENTE_CPFCNPJ);
		assertEquals(pedido.getCliente().getTipo().getCodigo(), PedidoModelTest.TIPOPESSOA_CODIGO);
		assertEquals(pedido.getCliente().getTipo().getDescricao(), PedidoModelTest.TIPOPESSOA_DESCRICAO);
	}

	@Test
	void deveriaAdicionarUmItemPedidoModelEmUmPedidoModel() {
		final PedidoModel pedidoModel = new PedidoModel(PedidoModelTest.PEDIDO_NUMERO,
				PedidoModelTest.PEDIDO_DATAEMISSAO, PedidoModelTest.PEDIDO_DATAENTREGA,
				new StatusPedidoModel(PedidoModelTest.STATUSPEDIDO_CODIGO, PedidoModelTest.STATUSPEDIDO_DESCRICAO),
				PedidoModelTest.PEDIDO_VALORTOTAL,
				new ClienteModel(PedidoModelTest.CLIENTE_CODIGO, PedidoModelTest.CLIENTE_NOME,
						PedidoModelTest.CLIENTE_TELEFONE, PedidoModelTest.CLIENTE_EMAIL,
						new TipoPessoaModel(PedidoModelTest.TIPOPESSOA_CODIGO, PedidoModelTest.TIPOPESSOA_DESCRICAO),
						PedidoModelTest.CLIENTE_CPFCNPJ),
				new ArrayList<>());
		final ItemPedidoModel itemPedidoModel = new ItemPedidoModel(PedidoModelTest.ITEMPEDIDOMODEL_CODIGO,
				new ProdutoModel(PedidoModelTest.PRODUTOMODEL_CODIGO, PedidoModelTest.PRODUTOMODEL_NOME,
						PedidoModelTest.PRODUTOMODEL_PRECO),
				PedidoModelTest.ITEMPEDIDOMODEL_NUMEROSEQUENCIA, PedidoModelTest.ITEMPEDIDOMODEL_QUANTIDADE,
				PedidoModelTest.ITEMPEDIDOMODEL_PRECOUNITARIO, PedidoModelTest.ITEMPEDIDOMODEL_DESCONTO,
				PedidoModelTest.ITEMPEDIDOMODEL_VALORTOTAL);
		pedidoModel.addItemPedidoModel(itemPedidoModel);

		final ItemPedidoModel itemPedidoModel1 = pedidoModel.getItens().stream()
				.filter(i -> i.getCodigo() == PedidoModelTest.ITEMPEDIDOMODEL_CODIGO).findFirst().get();

		assertEquals(itemPedidoModel1.getNumeroSequencia(), PedidoModelTest.ITEMPEDIDOMODEL_NUMEROSEQUENCIA);
		assertEquals(itemPedidoModel1.getQuantidade(), PedidoModelTest.ITEMPEDIDOMODEL_QUANTIDADE);
		assertEquals(itemPedidoModel1.getPrecoUnitario(), PedidoModelTest.ITEMPEDIDOMODEL_PRECOUNITARIO);
		assertEquals(itemPedidoModel1.getDesconto(), PedidoModelTest.ITEMPEDIDOMODEL_DESCONTO);
		assertEquals(itemPedidoModel1.getValorTotal(), PedidoModelTest.ITEMPEDIDOMODEL_VALORTOTAL);
		assertEquals(itemPedidoModel1.getPedido().getNumero(), PedidoModelTest.PEDIDO_NUMERO);
		assertEquals(itemPedidoModel1.getPedido().getDataEmissao(), PedidoModelTest.PEDIDO_DATAEMISSAO);
		assertEquals(itemPedidoModel1.getPedido().getDataEntrega(), PedidoModelTest.PEDIDO_DATAENTREGA);
		assertEquals(itemPedidoModel1.getPedido().getStatus().getCodigo(), PedidoModelTest.STATUSPEDIDO_CODIGO);
		assertEquals(itemPedidoModel1.getPedido().getStatus().getDescricao(),
				PedidoModelTest.STATUSPEDIDO_DESCRICAO);
	}

}
