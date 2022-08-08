package br.com.wmw.vendafacil_backend.data.models.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.TipoPessoa;

@SpringBootTest
class TipoPessoaModelTest {

	private static final long CODIGO_TIPOPESSOA = 1;
	private static final String DESCRICAO_TIPOPESSOA = "Física";

	@Test
	void deveriaConverterUmTipoPessoaModelParaUmTipoPessoa() {
		final TipoPessoaModel tipoPessoaModel = new TipoPessoaModel(TipoPessoaModelTest.CODIGO_TIPOPESSOA,
				TipoPessoaModelTest.DESCRICAO_TIPOPESSOA);
		final TipoPessoa tipoPessoa = tipoPessoaModel.toTipoPessoa();

		assertEquals(tipoPessoa.getCodigo(), TipoPessoaModelTest.CODIGO_TIPOPESSOA);
		assertEquals(tipoPessoa.getDescricao(), TipoPessoaModelTest.DESCRICAO_TIPOPESSOA);
	}

	@Test
	void deveriaConverterUmTipoPessoaParaUmTipoPessoaModel() {
		final TipoPessoa tipoPessoa = new TipoPessoa(TipoPessoaModelTest.CODIGO_TIPOPESSOA,
				TipoPessoaModelTest.DESCRICAO_TIPOPESSOA);
		final TipoPessoaModel tipoPessoaModel = TipoPessoaModel.convert(tipoPessoa);
		assertEquals(tipoPessoaModel.getCodigo(), TipoPessoaModelTest.CODIGO_TIPOPESSOA);
		assertEquals(tipoPessoaModel.getDescricao(), TipoPessoaModelTest.DESCRICAO_TIPOPESSOA);
	}

}
