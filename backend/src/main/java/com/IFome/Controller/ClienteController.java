package com.IFome.Controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.IFome.Model.Cliente;
import com.IFome.Service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service; 
	
	@GetMapping("/listar")
	public List<Cliente> listar() {
		List<Cliente> clientes = service.listar();
		return clientes;
	}
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody Cliente cliente) {
		this.service.cadastrar(cliente);
	}
	
	@PutMapping("/atualizar")
	public Cliente atualizar(@RequestBody Cliente clienteAtualizar) {
		return this.service.atualizar(clienteAtualizar);
	}
	
	@DeleteMapping("/remover")
	public void remover(@RequestParam("id") UUID clienteRemover) {
		this.service.remover(clienteRemover);
	}

}
