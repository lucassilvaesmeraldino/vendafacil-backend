package br.com.wmw.vendafacil_backend.data.models.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.wmw.vendafacil_backend.domain.cliente.entity.TipoPessoa;

class TipoPessoaModelTest {

	private static final long CODIGO_TIPOPESSOA = 1;
	private static final String DESCRICAO_TIPOPESSOA = "Física";

	@Test
	void deveriaConverterUmTipoPessoaModelParaUmTipoPessoa() {
		final TipoPessoaModel tipoPessoaModel = new TipoPessoaModel(TipoPessoaModelTest.CODIGO_TIPOPESSOA,
				TipoPessoaModelTest.DESCRICAO_TIPOPESSOA);
		final TipoPessoa tipoPessoa = tipoPessoaModel.toTipoPessoa();

		assertEquals(TipoPessoaModelTest.CODIGO_TIPOPESSOA, tipoPessoa.getCodigo());
		assertEquals(TipoPessoaModelTest.DESCRICAO_TIPOPESSOA, tipoPessoa.getDescricao());
	}

	@Test
	void deveriaConverterUmTipoPessoaParaUmTipoPessoaModel() {
		final TipoPessoa tipoPessoa = new TipoPessoa(TipoPessoaModelTest.CODIGO_TIPOPESSOA,
				TipoPessoaModelTest.DESCRICAO_TIPOPESSOA);
		final TipoPessoaModel tipoPessoaModel = TipoPessoaModel.convert(tipoPessoa);
		assertEquals(TipoPessoaModelTest.CODIGO_TIPOPESSOA, tipoPessoaModel.getCodigo());
		assertEquals(TipoPessoaModelTest.DESCRICAO_TIPOPESSOA, tipoPessoaModel.getDescricao());
	}

}
