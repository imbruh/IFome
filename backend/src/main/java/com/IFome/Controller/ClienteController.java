package com.IFome.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.IFome.Model.Cliente;
import com.IFome.Service.ClienteService;

@RestController
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

}
