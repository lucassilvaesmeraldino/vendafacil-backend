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

		assertEquals(PedidoModelTest.PEDIDO_DATAEMISSAO, pedidoModel.getDataEmissao());
		assertEquals(PedidoModelTest.PEDIDO_DATAENTREGA, pedidoModel.getDataEntrega());
		assertEquals(PedidoModelTest.PEDIDO_VALORTOTAL, pedidoModel.getValorTotal());
		assertEquals(PedidoModelTest.STATUSPEDIDO_CODIGO, pedidoModel.getStatus().getCodigo());
		assertEquals(PedidoModelTest.STATUSPEDIDO_DESCRICAO, pedidoModel.getStatus().getDescricao());
		assertEquals(PedidoModelTest.CLIENTE_CODIGO, pedidoModel.getCliente().getCodigo());
		assertEquals(PedidoModelTest.CLIENTE_NOME, pedidoModel.getCliente().getNome());
		assertEquals(PedidoModelTest.CLIENTE_TELEFONE, pedidoModel.getCliente().getTelefone());
		assertEquals(PedidoModelTest.CLIENTE_EMAIL, pedidoModel.getCliente().getEmail());
		assertEquals(PedidoModelTest.CLIENTE_CPFCNPJ, pedidoModel.getCliente().getCpfCnpj());
		assertEquals(PedidoModelTest.TIPOPESSOA_CODIGO, pedidoModel.getCliente().getTipo().getCodigo());
		assertEquals(PedidoModelTest.TIPOPESSOA_DESCRICAO, pedidoModel.getCliente().getTipo().getDescricao());
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

		assertEquals(PedidoModelTest.PEDIDO_NUMERO, pedido.getNumero());
		assertEquals(PedidoModelTest.PEDIDO_DATAEMISSAO, pedido.getDataEmissao());
		assertEquals(PedidoModelTest.PEDIDO_DATAENTREGA, pedido.getDataEntrega());
		assertEquals(PedidoModelTest.PEDIDO_VALORTOTAL, pedido.getValorTotal());
		assertEquals(PedidoModelTest.STATUSPEDIDO_CODIGO, pedido.getStatus().getCodigo());
		assertEquals(PedidoModelTest.STATUSPEDIDO_DESCRICAO, pedido.getStatus().getDescricao());
		assertEquals(PedidoModelTest.CLIENTE_CODIGO, pedido.getCliente().getCodigo());
		assertEquals(PedidoModelTest.CLIENTE_NOME, pedido.getCliente().getNome());
		assertEquals(PedidoModelTest.CLIENTE_TELEFONE, pedido.getCliente().getTelefone());
		assertEquals(PedidoModelTest.CLIENTE_EMAIL, pedido.getCliente().getEmail());
		assertEquals(PedidoModelTest.CLIENTE_CPFCNPJ, pedido.getCliente().getCpfCnpj());
		assertEquals(PedidoModelTest.TIPOPESSOA_CODIGO, pedido.getCliente().getTipo().getCodigo());
		assertEquals(PedidoModelTest.TIPOPESSOA_DESCRICAO, pedido.getCliente().getTipo().getDescricao());
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

		assertEquals(PedidoModelTest.ITEMPEDIDOMODEL_NUMEROSEQUENCIA, itemPedidoModel1.getNumeroSequencia());
		assertEquals(PedidoModelTest.ITEMPEDIDOMODEL_QUANTIDADE, itemPedidoModel1.getQuantidade());
		assertEquals(PedidoModelTest.ITEMPEDIDOMODEL_PRECOUNITARIO, itemPedidoModel1.getPrecoUnitario());
		assertEquals(PedidoModelTest.ITEMPEDIDOMODEL_DESCONTO, itemPedidoModel1.getDesconto());
		assertEquals(PedidoModelTest.ITEMPEDIDOMODEL_VALORTOTAL, itemPedidoModel1.getValorTotal());
		assertEquals(PedidoModelTest.PEDIDO_NUMERO, itemPedidoModel1.getPedido().getNumero());
		assertEquals(PedidoModelTest.PEDIDO_DATAEMISSAO, itemPedidoModel1.getPedido().getDataEmissao());
		assertEquals(PedidoModelTest.PEDIDO_DATAENTREGA, itemPedidoModel1.getPedido().getDataEntrega());
		assertEquals(PedidoModelTest.STATUSPEDIDO_CODIGO, itemPedidoModel1.getPedido().getStatus().getCodigo());
		assertEquals(PedidoModelTest.STATUSPEDIDO_DESCRICAO,
				itemPedidoModel1.getPedido().getStatus().getDescricao());
	}

}
