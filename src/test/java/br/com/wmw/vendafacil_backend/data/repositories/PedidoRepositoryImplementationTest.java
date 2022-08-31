package br.com.wmw.vendafacil_backend.data.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.Cliente;
import br.com.wmw.vendafacil_backend.domain.cliente.entity.TipoPessoa;
import br.com.wmw.vendafacil_backend.domain.pedido.entity.Pedido;
import br.com.wmw.vendafacil_backend.domain.pedido.entity.StatusPedido;
import br.com.wmw.vendafacil_backend.domain.pedido.repository.PedidoRepository;
import br.com.wmw.vendafacil_backend.domain.produto.entity.Produto;
import br.com.wmw.vendafacil_backend.domain.shared.entity.ItemPedido;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class PedidoRepositoryImplementationTest {

	@Autowired
	private PedidoRepository pedidoRepository;

	private static final long PRODUTO_CODIGO = 1;
	private static final String PRODUTO_NOME = "Carteira de couro Bennesh";
	private static final double PRODUTO_PRECO = 30;

	private static final long CLIENTE_CODIGO = 1;
	private static final String CLIENTE_NOME = "Lucas";
	private static final String CLIENTE_TELEFONE = "(48)99999-9999";
	private static final String CLIENTE_EMAIL = "lucas@gmail.com";
	private static final String CLIENTE_CPFCNPJ = "888.888.888-88";
	private static final long TIPOPESSOA_CODIGO = 1;
	private static final String TIPOPESSOA_DESCRICAO = "Física";

	private static final long STATUSPEDIDO_CODIGO = 1;
	private static final String STATUSPEDIDO_DESCRICAO = "Emitido";

	private static final LocalDate PEDIDO_DATAEMISSAO = LocalDate.now();
	private static final LocalDate PEDIDO_DATAENTREGA = LocalDate.of(2022, 8, 6);
	private static final double PEDIDO_VALORTOTAL_UMITEM = 50;
	private static final double PEDIDO_VALORTOTAL_DOISITENS = 50;

	private static final long ITEMPEDIDO_NUMEROSEQUENCIA = 1;
	private static final int ITEMPEDIDO_QUANTIDADE = 2;
	private static final double ITEMPEDIDO_PRECOUNITARIO = 25;
	private static final double ITEMPEDIDO_DESCONTO = 5;
	private static final double ITEMPEDIDO_VALORTOTAL = 50;

	private static final long ITEMPEDIDO2_NUMEROSEQUENCIA = 2;
	private static final int ITEMPEDIDO2_QUANTIDADE = 3;
	private static final double ITEMPEDIDO2_PRECOUNITARIO = 35;
	private static final double ITEMPEDIDO2_DESCONTO = 15;
	private static final double ITEMPEDIDO2_VALORTOTAL = 105;

	@Test
	void deveriaCriarUmPedidoComUmItemVinculado() {
		final List<ItemPedido> itemPedidoList = List
				.of(new ItemPedido(PedidoRepositoryImplementationTest.ITEMPEDIDO_NUMEROSEQUENCIA,
						PedidoRepositoryImplementationTest.ITEMPEDIDO_QUANTIDADE,
						PedidoRepositoryImplementationTest.ITEMPEDIDO_PRECOUNITARIO,
						PedidoRepositoryImplementationTest.ITEMPEDIDO_DESCONTO,
						PedidoRepositoryImplementationTest.ITEMPEDIDO_VALORTOTAL,
						new Produto(PedidoRepositoryImplementationTest.PRODUTO_CODIGO,
								PedidoRepositoryImplementationTest.PRODUTO_NOME,
								PedidoRepositoryImplementationTest.PRODUTO_PRECO)));
		final Pedido pedidoComUmItem = new Pedido(PedidoRepositoryImplementationTest.PEDIDO_DATAEMISSAO,
				PedidoRepositoryImplementationTest.PEDIDO_DATAENTREGA,
				new StatusPedido(PedidoRepositoryImplementationTest.STATUSPEDIDO_CODIGO,
						PedidoRepositoryImplementationTest.STATUSPEDIDO_DESCRICAO),
				PedidoRepositoryImplementationTest.PEDIDO_VALORTOTAL_UMITEM,
				new Cliente(PedidoRepositoryImplementationTest.CLIENTE_CODIGO,
						PedidoRepositoryImplementationTest.CLIENTE_NOME,
						PedidoRepositoryImplementationTest.CLIENTE_TELEFONE,
						PedidoRepositoryImplementationTest.CLIENTE_EMAIL,
						PedidoRepositoryImplementationTest.CLIENTE_CPFCNPJ,
						new TipoPessoa(PedidoRepositoryImplementationTest.TIPOPESSOA_CODIGO,
								PedidoRepositoryImplementationTest.TIPOPESSOA_DESCRICAO)),
				itemPedidoList);

		final Pedido pedidoCriado = this.pedidoRepository.createPedido(pedidoComUmItem);

		assertNotNull(pedidoCriado);
		assertEquals(pedidoCriado.getDataEmissao(), PedidoRepositoryImplementationTest.PEDIDO_DATAEMISSAO);
		assertEquals(pedidoCriado.getDataEntrega(), PedidoRepositoryImplementationTest.PEDIDO_DATAENTREGA);
		assertEquals(pedidoCriado.getValorTotal(),
				PedidoRepositoryImplementationTest.PEDIDO_VALORTOTAL_UMITEM);
		assertEquals(pedidoCriado.getStatus().getCodigo(),
				PedidoRepositoryImplementationTest.STATUSPEDIDO_CODIGO);
		assertEquals(pedidoCriado.getStatus().getDescricao(),
				PedidoRepositoryImplementationTest.STATUSPEDIDO_DESCRICAO);
		assertEquals(pedidoCriado.getCliente().getCodigo(), PedidoRepositoryImplementationTest.CLIENTE_CODIGO);
		assertEquals(pedidoCriado.getCliente().getNome(), PedidoRepositoryImplementationTest.CLIENTE_NOME);
		assertEquals(pedidoCriado.getCliente().getTelefone(), PedidoRepositoryImplementationTest.CLIENTE_TELEFONE);
		assertEquals(pedidoCriado.getCliente().getEmail(), PedidoRepositoryImplementationTest.CLIENTE_EMAIL);
		assertEquals(pedidoCriado.getCliente().getCpfCnpj(), PedidoRepositoryImplementationTest.CLIENTE_CPFCNPJ);
		assertEquals(pedidoCriado.getCliente().getTipo().getCodigo(),
				PedidoRepositoryImplementationTest.TIPOPESSOA_CODIGO);
		assertEquals(pedidoCriado.getCliente().getTipo().getDescricao(),
				PedidoRepositoryImplementationTest.TIPOPESSOA_DESCRICAO);
		assertNotNull(pedidoCriado.getItens());

		final ItemPedido itemPedido = pedidoCriado.getItens().stream()
				.filter(i -> i.getNumeroSequencia() == PedidoRepositoryImplementationTest.ITEMPEDIDO_NUMEROSEQUENCIA)
				.findFirst().get();

		assertNotNull(itemPedido);
		assertEquals(itemPedido.getQuantidade(), PedidoRepositoryImplementationTest.ITEMPEDIDO_QUANTIDADE);
		assertEquals(itemPedido.getPrecoUnitario(),
				PedidoRepositoryImplementationTest.ITEMPEDIDO_PRECOUNITARIO);
		assertEquals(itemPedido.getDesconto(), PedidoRepositoryImplementationTest.ITEMPEDIDO_DESCONTO);
		assertEquals(itemPedido.getValorTotal(), PedidoRepositoryImplementationTest.ITEMPEDIDO_VALORTOTAL);
		assertEquals(itemPedido.getProduto().getCodigo(), PedidoRepositoryImplementationTest.PRODUTO_CODIGO);
		assertEquals(itemPedido.getProduto().getNome(), PedidoRepositoryImplementationTest.PRODUTO_NOME);
		assertEquals(itemPedido.getProduto().getPreco(), PedidoRepositoryImplementationTest.PRODUTO_PRECO);
	}

	@Test
	void deveriaCriarUmPedidoComDoisItensVinculados() {
		final ItemPedido itemPedido1 = new ItemPedido(PedidoRepositoryImplementationTest.ITEMPEDIDO_NUMEROSEQUENCIA,
				PedidoRepositoryImplementationTest.ITEMPEDIDO_QUANTIDADE,
				PedidoRepositoryImplementationTest.ITEMPEDIDO_PRECOUNITARIO,
				PedidoRepositoryImplementationTest.ITEMPEDIDO_DESCONTO,
				PedidoRepositoryImplementationTest.ITEMPEDIDO_VALORTOTAL,
				new Produto(PedidoRepositoryImplementationTest.PRODUTO_CODIGO,
						PedidoRepositoryImplementationTest.PRODUTO_NOME,
						PedidoRepositoryImplementationTest.PRODUTO_PRECO));

		final ItemPedido itemPedido2 = new ItemPedido(PedidoRepositoryImplementationTest.ITEMPEDIDO2_NUMEROSEQUENCIA,
				PedidoRepositoryImplementationTest.ITEMPEDIDO2_QUANTIDADE,
				PedidoRepositoryImplementationTest.ITEMPEDIDO2_PRECOUNITARIO,
				PedidoRepositoryImplementationTest.ITEMPEDIDO2_DESCONTO,
				PedidoRepositoryImplementationTest.ITEMPEDIDO2_VALORTOTAL,
				new Produto(PedidoRepositoryImplementationTest.PRODUTO_CODIGO,
						PedidoRepositoryImplementationTest.PRODUTO_NOME,
						PedidoRepositoryImplementationTest.PRODUTO_PRECO));

		final List<ItemPedido> itemPedidoList = List.of(itemPedido1, itemPedido2);

		final Pedido pedidoComDoisItens = new Pedido(PedidoRepositoryImplementationTest.PEDIDO_DATAEMISSAO,
				PedidoRepositoryImplementationTest.PEDIDO_DATAENTREGA,
				new StatusPedido(PedidoRepositoryImplementationTest.STATUSPEDIDO_CODIGO,
						PedidoRepositoryImplementationTest.STATUSPEDIDO_DESCRICAO),
				PedidoRepositoryImplementationTest.PEDIDO_VALORTOTAL_DOISITENS,
				new Cliente(PedidoRepositoryImplementationTest.CLIENTE_CODIGO,
						PedidoRepositoryImplementationTest.CLIENTE_NOME,
						PedidoRepositoryImplementationTest.CLIENTE_TELEFONE,
						PedidoRepositoryImplementationTest.CLIENTE_EMAIL,
						PedidoRepositoryImplementationTest.CLIENTE_CPFCNPJ,
						new TipoPessoa(PedidoRepositoryImplementationTest.TIPOPESSOA_CODIGO,
								PedidoRepositoryImplementationTest.TIPOPESSOA_DESCRICAO)),
				itemPedidoList);

		final Pedido pedidoCriado = this.pedidoRepository.createPedido(pedidoComDoisItens);

		assertNotNull(pedidoCriado);
		assertEquals(pedidoCriado.getDataEmissao(),
				PedidoRepositoryImplementationTest.PEDIDO_DATAEMISSAO);
		assertEquals(pedidoCriado.getDataEntrega(),
				PedidoRepositoryImplementationTest.PEDIDO_DATAENTREGA);
		assertEquals(pedidoCriado.getValorTotal(),
				PedidoRepositoryImplementationTest.PEDIDO_VALORTOTAL_DOISITENS);
		assertEquals(pedidoCriado.getStatus().getCodigo(),
				PedidoRepositoryImplementationTest.STATUSPEDIDO_CODIGO);
		assertEquals(pedidoCriado.getStatus().getDescricao(),
				PedidoRepositoryImplementationTest.STATUSPEDIDO_DESCRICAO);
		assertEquals(pedidoCriado.getCliente().getCodigo(),
				PedidoRepositoryImplementationTest.CLIENTE_CODIGO);
		assertEquals(pedidoCriado.getCliente().getNome(), PedidoRepositoryImplementationTest.CLIENTE_NOME);
		assertEquals(pedidoCriado.getCliente().getTelefone(),
				PedidoRepositoryImplementationTest.CLIENTE_TELEFONE);
		assertEquals(pedidoCriado.getCliente().getEmail(),
				PedidoRepositoryImplementationTest.CLIENTE_EMAIL);
		assertEquals(pedidoCriado.getCliente().getCpfCnpj(),
				PedidoRepositoryImplementationTest.CLIENTE_CPFCNPJ);
		assertEquals(pedidoCriado.getCliente().getTipo().getCodigo(),
				PedidoRepositoryImplementationTest.TIPOPESSOA_CODIGO);
		assertEquals(pedidoCriado.getCliente().getTipo().getDescricao(),
				PedidoRepositoryImplementationTest.TIPOPESSOA_DESCRICAO);
		assertNotNull(pedidoCriado.getItens());

		final ItemPedido itemPedido1Criado = pedidoCriado.getItens().stream()
				.filter(i -> i.getNumeroSequencia() == PedidoRepositoryImplementationTest.ITEMPEDIDO_NUMEROSEQUENCIA)
				.findFirst().get();

		assertNotNull(itemPedido1Criado);
		assertEquals(itemPedido1Criado.getQuantidade(), PedidoRepositoryImplementationTest.ITEMPEDIDO_QUANTIDADE);
		assertEquals(itemPedido1Criado.getPrecoUnitario(),
				PedidoRepositoryImplementationTest.ITEMPEDIDO_PRECOUNITARIO);
		assertEquals(itemPedido1Criado.getDesconto(), PedidoRepositoryImplementationTest.ITEMPEDIDO_DESCONTO);
		assertEquals(itemPedido1Criado.getValorTotal(), PedidoRepositoryImplementationTest.ITEMPEDIDO_VALORTOTAL);

		final ItemPedido itemPedido2Criado = pedidoCriado.getItens().stream()
				.filter(i -> i.getNumeroSequencia() == PedidoRepositoryImplementationTest.ITEMPEDIDO2_NUMEROSEQUENCIA)
				.findFirst().get();

		assertNotNull(itemPedido2Criado);
		assertEquals(itemPedido2Criado.getQuantidade(), PedidoRepositoryImplementationTest.ITEMPEDIDO2_QUANTIDADE);
		assertEquals(itemPedido2Criado.getPrecoUnitario(),
				PedidoRepositoryImplementationTest.ITEMPEDIDO2_PRECOUNITARIO);
		assertEquals(itemPedido2Criado.getDesconto(), PedidoRepositoryImplementationTest.ITEMPEDIDO2_DESCONTO);
		assertEquals(itemPedido2Criado.getValorTotal(), PedidoRepositoryImplementationTest.ITEMPEDIDO2_VALORTOTAL);
		assertEquals(itemPedido2Criado.getProduto().getCodigo(), PedidoRepositoryImplementationTest.PRODUTO_CODIGO);
		assertEquals(itemPedido2Criado.getProduto().getNome(), PedidoRepositoryImplementationTest.PRODUTO_NOME);
		assertEquals(itemPedido2Criado.getProduto().getPreco(), PedidoRepositoryImplementationTest.PRODUTO_PRECO);

	}

}
