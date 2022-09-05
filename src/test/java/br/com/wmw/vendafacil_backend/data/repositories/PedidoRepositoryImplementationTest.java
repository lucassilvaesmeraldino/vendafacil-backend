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
		assertEquals(PedidoRepositoryImplementationTest.PEDIDO_DATAEMISSAO, pedidoCriado.getDataEmissao());
		assertEquals(PedidoRepositoryImplementationTest.PEDIDO_DATAENTREGA, pedidoCriado.getDataEntrega());
		assertEquals(PedidoRepositoryImplementationTest.PEDIDO_VALORTOTAL_UMITEM,
				pedidoCriado.getValorTotal());
		assertEquals(PedidoRepositoryImplementationTest.STATUSPEDIDO_CODIGO,
				pedidoCriado.getStatus().getCodigo());
		assertEquals(PedidoRepositoryImplementationTest.STATUSPEDIDO_DESCRICAO,
				pedidoCriado.getStatus().getDescricao());
		assertEquals(PedidoRepositoryImplementationTest.CLIENTE_CODIGO, pedidoCriado.getCliente().getCodigo());
		assertEquals(PedidoRepositoryImplementationTest.CLIENTE_NOME, pedidoCriado.getCliente().getNome());
		assertEquals(PedidoRepositoryImplementationTest.CLIENTE_TELEFONE, pedidoCriado.getCliente().getTelefone());
		assertEquals(PedidoRepositoryImplementationTest.CLIENTE_EMAIL, pedidoCriado.getCliente().getEmail());
		assertEquals(PedidoRepositoryImplementationTest.CLIENTE_CPFCNPJ, pedidoCriado.getCliente().getCpfCnpj());
		assertEquals(PedidoRepositoryImplementationTest.TIPOPESSOA_CODIGO,
				pedidoCriado.getCliente().getTipo().getCodigo());
		assertEquals(PedidoRepositoryImplementationTest.TIPOPESSOA_DESCRICAO,
				pedidoCriado.getCliente().getTipo().getDescricao());
		assertNotNull(pedidoCriado.getItens());

		final ItemPedido itemPedido = pedidoCriado.getItens().stream()
				.filter(i -> i.getNumeroSequencia() == PedidoRepositoryImplementationTest.ITEMPEDIDO_NUMEROSEQUENCIA)
				.findFirst().get();

		assertNotNull(itemPedido);
		assertEquals(PedidoRepositoryImplementationTest.ITEMPEDIDO_QUANTIDADE, itemPedido.getQuantidade());
		assertEquals(PedidoRepositoryImplementationTest.ITEMPEDIDO_PRECOUNITARIO,
				itemPedido.getPrecoUnitario());
		assertEquals(PedidoRepositoryImplementationTest.ITEMPEDIDO_DESCONTO, itemPedido.getDesconto());
		assertEquals(PedidoRepositoryImplementationTest.ITEMPEDIDO_VALORTOTAL, itemPedido.getValorTotal());
		assertEquals(PedidoRepositoryImplementationTest.PRODUTO_CODIGO, itemPedido.getProduto().getCodigo());
		assertEquals(PedidoRepositoryImplementationTest.PRODUTO_NOME, itemPedido.getProduto().getNome());
		assertEquals(PedidoRepositoryImplementationTest.PRODUTO_PRECO, itemPedido.getProduto().getPreco());
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
		assertEquals(PedidoRepositoryImplementationTest.PEDIDO_DATAEMISSAO,
				pedidoCriado.getDataEmissao());
		assertEquals(PedidoRepositoryImplementationTest.PEDIDO_DATAENTREGA,
				pedidoCriado.getDataEntrega());
		assertEquals(PedidoRepositoryImplementationTest.PEDIDO_VALORTOTAL_DOISITENS,
				pedidoCriado.getValorTotal());

		assertEquals(PedidoRepositoryImplementationTest.STATUSPEDIDO_DESCRICAO,
				pedidoCriado.getStatus().getDescricao());

		assertEquals(PedidoRepositoryImplementationTest.CLIENTE_NOME, pedidoCriado.getCliente().getNome());

		assertEquals(PedidoRepositoryImplementationTest.CLIENTE_CPFCNPJ,
				pedidoCriado.getCliente().getCpfCnpj());
		
		assertEquals(PedidoRepositoryImplementationTest.TIPOPESSOA_DESCRICAO,
				pedidoCriado.getCliente().getTipo().getDescricao());
		assertNotNull(pedidoCriado.getItens());

		final ItemPedido itemPedido1Criado = pedidoCriado.getItens().stream()
				.filter(i -> i.getNumeroSequencia() == PedidoRepositoryImplementationTest.ITEMPEDIDO_NUMEROSEQUENCIA)
				.findFirst().get();

		assertNotNull(itemPedido1Criado);
		assertEquals(PedidoRepositoryImplementationTest.ITEMPEDIDO_QUANTIDADE, itemPedido1Criado.getQuantidade());
		assertEquals(PedidoRepositoryImplementationTest.ITEMPEDIDO_PRECOUNITARIO,
				itemPedido1Criado.getPrecoUnitario());
		assertEquals(PedidoRepositoryImplementationTest.ITEMPEDIDO_DESCONTO, itemPedido1Criado.getDesconto());
		assertEquals(PedidoRepositoryImplementationTest.ITEMPEDIDO_VALORTOTAL, itemPedido1Criado.getValorTotal());

		final ItemPedido itemPedido2Criado = pedidoCriado.getItens().stream()
				.filter(i -> i.getNumeroSequencia() == PedidoRepositoryImplementationTest.ITEMPEDIDO2_NUMEROSEQUENCIA)
				.findFirst().get();

		assertNotNull(itemPedido2Criado);
		assertEquals(PedidoRepositoryImplementationTest.ITEMPEDIDO2_QUANTIDADE, itemPedido2Criado.getQuantidade());
		assertEquals(PedidoRepositoryImplementationTest.ITEMPEDIDO2_PRECOUNITARIO,
				itemPedido2Criado.getPrecoUnitario());
		assertEquals(PedidoRepositoryImplementationTest.ITEMPEDIDO2_DESCONTO, itemPedido2Criado.getDesconto());
		assertEquals(PedidoRepositoryImplementationTest.ITEMPEDIDO2_VALORTOTAL, itemPedido2Criado.getValorTotal());
		assertEquals(PedidoRepositoryImplementationTest.PRODUTO_NOME, itemPedido2Criado.getProduto().getNome());
		assertEquals(PedidoRepositoryImplementationTest.PRODUTO_PRECO, itemPedido2Criado.getProduto().getPreco());

	}

}
