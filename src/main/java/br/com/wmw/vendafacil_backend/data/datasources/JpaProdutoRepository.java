package br.com.wmw.vendafacil_backend.data.datasources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wmw.vendafacil_backend.data.models.produto.ProdutoModel;

@Repository
public interface JpaProdutoRepository extends JpaRepository<ProdutoModel, Long> {

}
