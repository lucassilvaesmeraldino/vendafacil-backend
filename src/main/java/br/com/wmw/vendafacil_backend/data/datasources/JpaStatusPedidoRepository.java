package br.com.wmw.vendafacil_backend.data.datasources;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.wmw.vendafacil_backend.data.models.pedido.StatusPedidoModel;

@Repository
public interface JpaStatusPedidoRepository extends JpaRepository<StatusPedidoModel, Long> {

}
