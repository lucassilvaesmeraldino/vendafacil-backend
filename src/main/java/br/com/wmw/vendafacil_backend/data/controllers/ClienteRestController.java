package br.com.wmw.vendafacil_backend.data.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.wmw.vendafacil_backend.data.models.cliente.ClienteResponseModel;
import br.com.wmw.vendafacil_backend.domain.cliente.usecases.GetClientes;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {

	@Autowired
	GetClientes getClientes;

	@GetMapping
	public List<ClienteResponseModel> findAll() {
		return ClienteResponseModel.convert(this.getClientes.execute());
	}
}
