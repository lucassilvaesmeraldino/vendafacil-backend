package br.com.wmw.vendafacil_backend.data.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class PedidoRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private final Gson gson = new Gson();

	private static final String PEDIDO_DATAEMISSAO = LocalDate.now().toString();
	private static final String PEDIDO_DATAENTREGA = LocalDate.now().plusDays(1).toString();
	private static final double PEDIDO_VALORTOTAL_UMITEM = 89.955;
	private static final double PEDIDO_VALORTOTAL_UMITEM_INVALIDO = 49;
	private static final double PEDIDO_VALORTOTAL_DOISITENS = 251.91500000000002;
	private static final long PEDIDO_CODIGOSTATUSPEDIDO = 1;
	private static final long PEDIDO_CODIGOSTATUSPEDIDO_INVALIDO = 4;
	private static final long PEDIDO_CODIGOCLIENTE = 1;
	private static final long PEDIDO_CODIGOCLIENTE_INVALIDO = 9;

	private static final long ITEMPEDIDO_NUMEROSEQUENCIA = 1;
	private static final int ITEMPEDIDO_QUANTIDADE = 5;
	private static final double ITEMPEDIDO_PRECOUNITARIO = 17.991;
	private static final double ITEMPEDIDO_PRECOUNITARIO_INCORRETO = 9.99;
	private static final double ITEMPEDIDO_DESCONTO = 1.9989999999999999;
	private static final double ITEMPEDIDO_VALORTOTAL = 89.955;
	private static final long ITEMPEDIDO_CODIGOPRODUTO = 1;

	private static final long ITEMPEDIDO2_NUMEROSEQUENCIA = 2;
	private static final int ITEMPEDIDO2_QUANTIDADE = 5;
	private static final double ITEMPEDIDO2_PRECOUNITARIO = 32.392;
	private static final double ITEMPEDIDO2_DESCONTO = 8.098;
	private static final double ITEMPEDIDO2_VALORTOTAL = 161.96;
	private static final long ITEMPEDIDO2_CODIGOPRODUTO = 3;

	private static final String STATUSPEDIDO_DESCRICAO = "Fechado";

	private static final String CLIENTE_CPFCNPJ = "457.468.540-93";

	private static final String VALORTOTAL_INCORRETO_MESSAGE = "O valor total do pedido difere da soma dos valores dos seus itens.";
	private static final String PRECOUNITARIOITEM_INCORRETO_MESSAGE = String.format(
			"O preco unitário do item de NUMERO SEQUENCIA %d não está com o desconto aplicado corretamente.",
			PedidoRestControllerTest.ITEMPEDIDO_NUMEROSEQUENCIA);
	private static final String CODIGOSTATUSPEDIDO_INCORRETO_MESSAGE = String.format(
			"O status do pedido de CODIGO %d não existe.", PedidoRestControllerTest.PEDIDO_CODIGOSTATUSPEDIDO_INVALIDO);
	private static final String CODIGOCLIENTE_INCORRETO_MESSAGE = String.format("O cliente com o CODIGO %d não existe.",
			PedidoRestControllerTest.PEDIDO_CODIGOCLIENTE_INVALIDO);

	@Test
	void deveriaCriarUmPedidoComUmItemVinculado() throws URISyntaxException, Exception {

		final JsonObject itemPedidoJson = new JsonObject();
		itemPedidoJson.addProperty("numeroSequencia", PedidoRestControllerTest.ITEMPEDIDO_NUMEROSEQUENCIA);
		itemPedidoJson.addProperty("quantidade", PedidoRestControllerTest.ITEMPEDIDO_QUANTIDADE);
		itemPedidoJson.addProperty("precoUnitario", PedidoRestControllerTest.ITEMPEDIDO_PRECOUNITARIO);
		itemPedidoJson.addProperty("desconto", PedidoRestControllerTest.ITEMPEDIDO_DESCONTO);
		itemPedidoJson.addProperty("valorTotal", PedidoRestControllerTest.ITEMPEDIDO_VALORTOTAL);
		itemPedidoJson.addProperty("codigoProduto", PedidoRestControllerTest.ITEMPEDIDO_CODIGOPRODUTO);
		final JsonArray itemPedidoListJson = new JsonArray(1);
		itemPedidoListJson.add(itemPedidoJson);

		final JsonObject pedidoJsonWithOneItem = new JsonObject();
		pedidoJsonWithOneItem.addProperty("dataEmissao", PedidoRestControllerTest.PEDIDO_DATAEMISSAO);
		pedidoJsonWithOneItem.addProperty("dataEntrega", PedidoRestControllerTest.PEDIDO_DATAENTREGA);
		pedidoJsonWithOneItem.addProperty("codigoStatusPedido", PedidoRestControllerTest.PEDIDO_CODIGOSTATUSPEDIDO);
		pedidoJsonWithOneItem.addProperty("codigoCliente", PedidoRestControllerTest.PEDIDO_CODIGOCLIENTE);
		pedidoJsonWithOneItem.addProperty("valorTotal", PedidoRestControllerTest.PEDIDO_VALORTOTAL_UMITEM);
		pedidoJsonWithOneItem.add("itens", itemPedidoListJson);

		this.mockMvc
		.perform(MockMvcRequestBuilders.post(new URI("/pedidos")).contentType(MediaType.APPLICATION_JSON)
				.content(this.gson.toJson(pedidoJsonWithOneItem)))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.dataEmissao", equalTo(PedidoRestControllerTest.PEDIDO_DATAEMISSAO)))
		.andExpect(jsonPath("$.statusPedido", equalTo(PedidoRestControllerTest.STATUSPEDIDO_DESCRICAO)))
		.andExpect(jsonPath("$.cpfCnpjCliente", equalTo(PedidoRestControllerTest.CLIENTE_CPFCNPJ)))
		.andExpect(jsonPath("$.valorTotal", equalTo(PedidoRestControllerTest.PEDIDO_VALORTOTAL_UMITEM)));

	}

	@Test
	void deveriaCriarUmPedidoComDoisItensVinculados() throws URISyntaxException, Exception {
		final JsonObject firstItemPedidoJson = new JsonObject();
		firstItemPedidoJson.addProperty("numeroSequencia", PedidoRestControllerTest.ITEMPEDIDO_NUMEROSEQUENCIA);
		firstItemPedidoJson.addProperty("quantidade", PedidoRestControllerTest.ITEMPEDIDO_QUANTIDADE);
		firstItemPedidoJson.addProperty("precoUnitario", PedidoRestControllerTest.ITEMPEDIDO_PRECOUNITARIO);
		firstItemPedidoJson.addProperty("desconto", PedidoRestControllerTest.ITEMPEDIDO_DESCONTO);
		firstItemPedidoJson.addProperty("valorTotal", PedidoRestControllerTest.ITEMPEDIDO_VALORTOTAL);
		firstItemPedidoJson.addProperty("codigoProduto", PedidoRestControllerTest.ITEMPEDIDO_CODIGOPRODUTO);

		final JsonObject secondItemPedidoJson = new JsonObject();
		secondItemPedidoJson.addProperty("numeroSequencia", PedidoRestControllerTest.ITEMPEDIDO2_NUMEROSEQUENCIA);
		secondItemPedidoJson.addProperty("quantidade", PedidoRestControllerTest.ITEMPEDIDO2_QUANTIDADE);
		secondItemPedidoJson.addProperty("precoUnitario", PedidoRestControllerTest.ITEMPEDIDO2_PRECOUNITARIO);
		secondItemPedidoJson.addProperty("desconto", PedidoRestControllerTest.ITEMPEDIDO2_DESCONTO);
		secondItemPedidoJson.addProperty("valorTotal", PedidoRestControllerTest.ITEMPEDIDO2_VALORTOTAL);
		secondItemPedidoJson.addProperty("codigoProduto", PedidoRestControllerTest.ITEMPEDIDO2_CODIGOPRODUTO);

		final JsonArray itemPedidoListJson = new JsonArray(2);
		itemPedidoListJson.add(firstItemPedidoJson);
		itemPedidoListJson.add(secondItemPedidoJson);

		final JsonObject pedidoJsonWithTwoItens = new JsonObject();
		pedidoJsonWithTwoItens.addProperty("dataEmissao", PedidoRestControllerTest.PEDIDO_DATAEMISSAO);
		pedidoJsonWithTwoItens.addProperty("dataEntrega", PedidoRestControllerTest.PEDIDO_DATAENTREGA);
		pedidoJsonWithTwoItens.addProperty("codigoStatusPedido", PedidoRestControllerTest.PEDIDO_CODIGOSTATUSPEDIDO);
		pedidoJsonWithTwoItens.addProperty("codigoCliente", PedidoRestControllerTest.PEDIDO_CODIGOCLIENTE);
		pedidoJsonWithTwoItens.addProperty("valorTotal", PedidoRestControllerTest.PEDIDO_VALORTOTAL_DOISITENS);
		pedidoJsonWithTwoItens.add("itens", itemPedidoListJson);

		this.mockMvc
		.perform(MockMvcRequestBuilders.post(new URI("/pedidos")).contentType(MediaType.APPLICATION_JSON)
				.content(this.gson.toJson(pedidoJsonWithTwoItens)))
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.dataEmissao", equalTo(PedidoRestControllerTest.PEDIDO_DATAEMISSAO)))
		.andExpect(jsonPath("$.statusPedido", equalTo(PedidoRestControllerTest.STATUSPEDIDO_DESCRICAO)))
		.andExpect(jsonPath("$.cpfCnpjCliente", equalTo(PedidoRestControllerTest.CLIENTE_CPFCNPJ)))
		.andExpect(jsonPath("$.valorTotal", equalTo(PedidoRestControllerTest.PEDIDO_VALORTOTAL_DOISITENS)));
	}

	@Test
	void naoDeveriaCriarUmPedidoComValorTotalCalculadoIncorretamente() throws URISyntaxException, Exception {

		final JsonObject itemPedidoJson = new JsonObject();
		itemPedidoJson.addProperty("numeroSequencia", PedidoRestControllerTest.ITEMPEDIDO_NUMEROSEQUENCIA);
		itemPedidoJson.addProperty("quantidade", PedidoRestControllerTest.ITEMPEDIDO_QUANTIDADE);
		itemPedidoJson.addProperty("precoUnitario", PedidoRestControllerTest.ITEMPEDIDO_PRECOUNITARIO);
		itemPedidoJson.addProperty("desconto", PedidoRestControllerTest.ITEMPEDIDO_DESCONTO);
		itemPedidoJson.addProperty("valorTotal", PedidoRestControllerTest.ITEMPEDIDO_VALORTOTAL);
		itemPedidoJson.addProperty("codigoProduto", PedidoRestControllerTest.ITEMPEDIDO_CODIGOPRODUTO);
		final JsonArray itemPedidoListJson = new JsonArray(1);
		itemPedidoListJson.add(itemPedidoJson);

		final JsonObject pedidoJsonWithOneItemAndTotalValueIncorrect = new JsonObject();
		pedidoJsonWithOneItemAndTotalValueIncorrect.addProperty("dataEmissao",
				PedidoRestControllerTest.PEDIDO_DATAEMISSAO);
		pedidoJsonWithOneItemAndTotalValueIncorrect.addProperty("dataEntrega",
				PedidoRestControllerTest.PEDIDO_DATAENTREGA);
		pedidoJsonWithOneItemAndTotalValueIncorrect.addProperty("codigoStatusPedido",
				PedidoRestControllerTest.PEDIDO_CODIGOSTATUSPEDIDO);
		pedidoJsonWithOneItemAndTotalValueIncorrect.addProperty("codigoCliente",
				PedidoRestControllerTest.PEDIDO_CODIGOCLIENTE);
		pedidoJsonWithOneItemAndTotalValueIncorrect.addProperty("valorTotal",
				PedidoRestControllerTest.PEDIDO_VALORTOTAL_UMITEM_INVALIDO);
		pedidoJsonWithOneItemAndTotalValueIncorrect.add("itens", itemPedidoListJson);

		this.mockMvc
		.perform(MockMvcRequestBuilders.post(new URI("/pedidos")).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(pedidoJsonWithOneItemAndTotalValueIncorrect)))
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.message", equalTo(PedidoRestControllerTest.VALORTOTAL_INCORRETO_MESSAGE)));
	}

	@Test
	void naoDeveriaCriarUmPedidoComPrecoUnitarioDoItemCalculadoIncorretamente() throws URISyntaxException, Exception {
		final JsonObject itemPedidoJson = new JsonObject();
		itemPedidoJson.addProperty("numeroSequencia", PedidoRestControllerTest.ITEMPEDIDO_NUMEROSEQUENCIA);
		itemPedidoJson.addProperty("quantidade", PedidoRestControllerTest.ITEMPEDIDO_QUANTIDADE);
		itemPedidoJson.addProperty("precoUnitario", PedidoRestControllerTest.ITEMPEDIDO_PRECOUNITARIO_INCORRETO);
		itemPedidoJson.addProperty("desconto", PedidoRestControllerTest.ITEMPEDIDO_DESCONTO);
		itemPedidoJson.addProperty("valorTotal", PedidoRestControllerTest.ITEMPEDIDO_VALORTOTAL);
		itemPedidoJson.addProperty("codigoProduto", PedidoRestControllerTest.ITEMPEDIDO_CODIGOPRODUTO);
		final JsonArray itemPedidoListJson = new JsonArray(1);
		itemPedidoListJson.add(itemPedidoJson);

		final JsonObject pedidoJsonWithOneItemAndItemUnitPriceIncorrect = new JsonObject();
		pedidoJsonWithOneItemAndItemUnitPriceIncorrect.addProperty("dataEmissao",
				PedidoRestControllerTest.PEDIDO_DATAEMISSAO);
		pedidoJsonWithOneItemAndItemUnitPriceIncorrect.addProperty("dataEntrega",
				PedidoRestControllerTest.PEDIDO_DATAENTREGA);
		pedidoJsonWithOneItemAndItemUnitPriceIncorrect.addProperty("codigoStatusPedido",
				PedidoRestControllerTest.PEDIDO_CODIGOSTATUSPEDIDO);
		pedidoJsonWithOneItemAndItemUnitPriceIncorrect.addProperty("codigoCliente",
				PedidoRestControllerTest.PEDIDO_CODIGOCLIENTE);
		pedidoJsonWithOneItemAndItemUnitPriceIncorrect.addProperty("valorTotal",
				PedidoRestControllerTest.PEDIDO_VALORTOTAL_UMITEM);
		pedidoJsonWithOneItemAndItemUnitPriceIncorrect.add("itens", itemPedidoListJson);

		this.mockMvc
		.perform(MockMvcRequestBuilders.post(new URI("/pedidos")).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(pedidoJsonWithOneItemAndItemUnitPriceIncorrect)))
		.andExpect(status().isBadRequest())
		.andExpect(
				jsonPath("$.message", equalTo(PedidoRestControllerTest.PRECOUNITARIOITEM_INCORRETO_MESSAGE)));
	}

	@Test
	void naoDeveriaCriarUmPedidoComCamposVazios() throws URISyntaxException, Exception {

		final JsonObject itemPedidoJson = new JsonObject();
		itemPedidoJson.addProperty("numeroSequencia", PedidoRestControllerTest.ITEMPEDIDO_NUMEROSEQUENCIA);
		itemPedidoJson.addProperty("quantidade", PedidoRestControllerTest.ITEMPEDIDO_QUANTIDADE);
		itemPedidoJson.addProperty("precoUnitario", PedidoRestControllerTest.ITEMPEDIDO_PRECOUNITARIO);
		itemPedidoJson.addProperty("desconto", PedidoRestControllerTest.ITEMPEDIDO_DESCONTO);
		itemPedidoJson.addProperty("valorTotal", PedidoRestControllerTest.ITEMPEDIDO_VALORTOTAL);
		itemPedidoJson.addProperty("codigoProduto", PedidoRestControllerTest.ITEMPEDIDO_CODIGOPRODUTO);
		final JsonArray itemPedidoListJson = new JsonArray(1);
		itemPedidoListJson.add(itemPedidoJson);

		final JsonObject pedidoJsonWithOneItemAndEmptyData = new JsonObject();
		pedidoJsonWithOneItemAndEmptyData.addProperty("dataEmissao", "");
		pedidoJsonWithOneItemAndEmptyData.addProperty("dataEntrega", PedidoRestControllerTest.PEDIDO_DATAENTREGA);
		pedidoJsonWithOneItemAndEmptyData.addProperty("codigoStatusPedido",
				PedidoRestControllerTest.PEDIDO_CODIGOSTATUSPEDIDO);
		pedidoJsonWithOneItemAndEmptyData.addProperty("codigoCliente", "");
		pedidoJsonWithOneItemAndEmptyData.addProperty("valorTotal", PedidoRestControllerTest.PEDIDO_VALORTOTAL_UMITEM);
		pedidoJsonWithOneItemAndEmptyData.add("itens", itemPedidoListJson);

		this.mockMvc
		.perform(MockMvcRequestBuilders.post(new URI("/pedidos")).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(pedidoJsonWithOneItemAndEmptyData)))
		.andExpect(status().isBadRequest());
	}

	@Test
	void naoDeveriaCriarUmPedidoComCodigoDoStatusDoPedidoInvalido() throws URISyntaxException, Exception {
		final JsonObject itemPedidoJson = new JsonObject();
		itemPedidoJson.addProperty("numeroSequencia", PedidoRestControllerTest.ITEMPEDIDO_NUMEROSEQUENCIA);
		itemPedidoJson.addProperty("quantidade", PedidoRestControllerTest.ITEMPEDIDO_QUANTIDADE);
		itemPedidoJson.addProperty("precoUnitario", PedidoRestControllerTest.ITEMPEDIDO_PRECOUNITARIO);
		itemPedidoJson.addProperty("desconto", PedidoRestControllerTest.ITEMPEDIDO_DESCONTO);
		itemPedidoJson.addProperty("valorTotal", PedidoRestControllerTest.ITEMPEDIDO_VALORTOTAL);
		itemPedidoJson.addProperty("codigoProduto", PedidoRestControllerTest.ITEMPEDIDO_CODIGOPRODUTO);
		final JsonArray itemPedidoListJson = new JsonArray(1);
		itemPedidoListJson.add(itemPedidoJson);

		final JsonObject pedidoJsonWithOneItemAndStatusPedidoCodeInvalid = new JsonObject();
		pedidoJsonWithOneItemAndStatusPedidoCodeInvalid.addProperty("dataEmissao",
				PedidoRestControllerTest.PEDIDO_DATAEMISSAO);
		pedidoJsonWithOneItemAndStatusPedidoCodeInvalid.addProperty("dataEntrega",
				PedidoRestControllerTest.PEDIDO_DATAENTREGA);
		pedidoJsonWithOneItemAndStatusPedidoCodeInvalid.addProperty("codigoStatusPedido",
				PedidoRestControllerTest.PEDIDO_CODIGOSTATUSPEDIDO_INVALIDO);
		pedidoJsonWithOneItemAndStatusPedidoCodeInvalid.addProperty("codigoCliente",
				PedidoRestControllerTest.PEDIDO_CODIGOCLIENTE);
		pedidoJsonWithOneItemAndStatusPedidoCodeInvalid.addProperty("valorTotal",
				PedidoRestControllerTest.PEDIDO_VALORTOTAL_UMITEM);
		pedidoJsonWithOneItemAndStatusPedidoCodeInvalid.add("itens", itemPedidoListJson);

		this.mockMvc
		.perform(MockMvcRequestBuilders.post(new URI("/pedidos")).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(pedidoJsonWithOneItemAndStatusPedidoCodeInvalid)))
		.andExpect(status().isBadRequest()).andExpect(
				jsonPath("$.message", equalTo(PedidoRestControllerTest.CODIGOSTATUSPEDIDO_INCORRETO_MESSAGE)));
	}

	@Test
	void naoDeveriaCriarUmPedidoComCodigoDoClienteInvalido() throws URISyntaxException, Exception {
		final JsonObject itemPedidoJson = new JsonObject();
		itemPedidoJson.addProperty("numeroSequencia", PedidoRestControllerTest.ITEMPEDIDO_NUMEROSEQUENCIA);
		itemPedidoJson.addProperty("quantidade", PedidoRestControllerTest.ITEMPEDIDO_QUANTIDADE);
		itemPedidoJson.addProperty("precoUnitario", PedidoRestControllerTest.ITEMPEDIDO_PRECOUNITARIO);
		itemPedidoJson.addProperty("desconto", PedidoRestControllerTest.ITEMPEDIDO_DESCONTO);
		itemPedidoJson.addProperty("valorTotal", PedidoRestControllerTest.ITEMPEDIDO_VALORTOTAL);
		itemPedidoJson.addProperty("codigoProduto", PedidoRestControllerTest.ITEMPEDIDO_CODIGOPRODUTO);
		final JsonArray itemPedidoListJson = new JsonArray(1);
		itemPedidoListJson.add(itemPedidoJson);

		final JsonObject pedidoJsonWithOneItemAndStatusPedidoCodeInvalid = new JsonObject();
		pedidoJsonWithOneItemAndStatusPedidoCodeInvalid.addProperty("dataEmissao",
				PedidoRestControllerTest.PEDIDO_DATAEMISSAO);
		pedidoJsonWithOneItemAndStatusPedidoCodeInvalid.addProperty("dataEntrega",
				PedidoRestControllerTest.PEDIDO_DATAENTREGA);
		pedidoJsonWithOneItemAndStatusPedidoCodeInvalid.addProperty("codigoStatusPedido",
				PedidoRestControllerTest.PEDIDO_CODIGOSTATUSPEDIDO);
		pedidoJsonWithOneItemAndStatusPedidoCodeInvalid.addProperty("codigoCliente",
				PedidoRestControllerTest.PEDIDO_CODIGOCLIENTE_INVALIDO);
		pedidoJsonWithOneItemAndStatusPedidoCodeInvalid.addProperty("valorTotal",
				PedidoRestControllerTest.PEDIDO_VALORTOTAL_UMITEM);
		pedidoJsonWithOneItemAndStatusPedidoCodeInvalid.add("itens", itemPedidoListJson);

		this.mockMvc
		.perform(MockMvcRequestBuilders.post(new URI("/pedidos")).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(pedidoJsonWithOneItemAndStatusPedidoCodeInvalid)))
		.andExpect(status().isBadRequest())
		.andExpect(jsonPath("$.message", equalTo(PedidoRestControllerTest.CODIGOCLIENTE_INCORRETO_MESSAGE)));
	}

	@Test
	void naoDeveriaCriarUmPedidoSemItens() throws URISyntaxException, Exception {

		final JsonObject itemPedidoJson = new JsonObject();
		final JsonArray itemPedidoListJson = new JsonArray(1);
		itemPedidoListJson.add(itemPedidoJson);

		final JsonObject pedidoJsonWithOneItemAndEmptyItem = new JsonObject();
		pedidoJsonWithOneItemAndEmptyItem.addProperty("dataEmissao", PedidoRestControllerTest.PEDIDO_DATAEMISSAO);
		pedidoJsonWithOneItemAndEmptyItem.addProperty("dataEntrega", PedidoRestControllerTest.PEDIDO_DATAENTREGA);
		pedidoJsonWithOneItemAndEmptyItem.addProperty("codigoStatusPedido",
				PedidoRestControllerTest.PEDIDO_CODIGOSTATUSPEDIDO_INVALIDO);
		pedidoJsonWithOneItemAndEmptyItem.addProperty("codigoCliente", PedidoRestControllerTest.PEDIDO_CODIGOCLIENTE);
		pedidoJsonWithOneItemAndEmptyItem.addProperty("valorTotal", PedidoRestControllerTest.PEDIDO_VALORTOTAL_UMITEM);
		pedidoJsonWithOneItemAndEmptyItem.add("itens", itemPedidoListJson);

		this.mockMvc
		.perform(MockMvcRequestBuilders.post(new URI("/pedidos")).contentType(MediaType.APPLICATION_JSON)
				.content(new Gson().toJson(pedidoJsonWithOneItemAndEmptyItem)))
		.andExpect(status().isBadRequest());
	}

}
