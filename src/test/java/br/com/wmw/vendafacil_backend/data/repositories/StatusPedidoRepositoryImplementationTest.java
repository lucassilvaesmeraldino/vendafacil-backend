package br.com.wmw.vendafacil_backend.data.repositories;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.wmw.vendafacil_backend.core.exceptions.NotFoundException;
import br.com.wmw.vendafacil_backend.domain.pedido.entity.StatusPedido;
import br.com.wmw.vendafacil_backend.domain.pedido.repository.StatusPedidoRepository;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StatusPedidoRepositoryImplementationTest {

	@Autowired
	private StatusPedidoRepository statusPedidoRepository;

	private static final long STATUSPEDIDO_CODIGOVALIDO = 1;
	private static final String STATUSPEDIDO_DESCRICAOVALIDA = "Fechado";
	private static final long STATUSPEDIDO_CODIGOINVALIDO = 4;

	@Test
	void deveriaRetornarUmStatusDoPedidoQuandoEncontrado() {
		assertDoesNotThrow(() -> this.statusPedidoRepository
				.getStatusPedidoByCodigo(StatusPedidoRepositoryImplementationTest.STATUSPEDIDO_CODIGOVALIDO));
		final StatusPedido statusPedido = this.statusPedidoRepository
				.getStatusPedidoByCodigo(StatusPedidoRepositoryImplementationTest.STATUSPEDIDO_CODIGOVALIDO);
		assertEquals(StatusPedidoRepositoryImplementationTest.STATUSPEDIDO_DESCRICAOVALIDA,
				statusPedido.getDescricao());

	}

	@Test
	void deveriaRetornarUmaExceptionQuandoOStatusPedidoNaoForEncontrado() {
		assertThrows(NotFoundException.class, () -> this.statusPedidoRepository
				.getStatusPedidoByCodigo(StatusPedidoRepositoryImplementationTest.STATUSPEDIDO_CODIGOINVALIDO));
	}

}
