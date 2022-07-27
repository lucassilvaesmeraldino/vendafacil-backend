package br.com.wmw.vendafacil_backend.data.models.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.TipoPessoa;

@SpringBootTest
class TipoPessoaModelTest {

	private static final long CODIGO_TIPOPESSOAMODEL = 1;
	private static final String NOME_TIPOPESSOAMODEL = "Física";

	@Test
	void deveriaConverterUmTipoPessoaModelParaUmTipoPessoa() {
		final TipoPessoaModel tipoPessoamodel = new TipoPessoaModel(TipoPessoaModelTest.CODIGO_TIPOPESSOAMODEL,
				TipoPessoaModelTest.NOME_TIPOPESSOAMODEL);
		final TipoPessoa tipoPessoa = tipoPessoamodel.convertToEntity();

		assertEquals(tipoPessoa.getCodigo(), TipoPessoaModelTest.CODIGO_TIPOPESSOAMODEL);
		assertEquals(tipoPessoa.getNome(), TipoPessoaModelTest.NOME_TIPOPESSOAMODEL);
	}

}
