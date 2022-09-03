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
import com.IFome.Model.Funcionario;
import com.IFome.Service.FuncionarioService;

@RequestMapping("/funcionario")
@RestController
public class FuncionarioController {

	@Autowired
	private FuncionarioService service; 
	
	@GetMapping("/listar")
	public List<Funcionario> listar() {
		return service.listar();
	}
	
	@PostMapping("/cadastrar")
	public Funcionario cadastrar(@RequestBody Funcionario funcionarioNovo) {
		return this.service.cadastrar(funcionarioNovo);
	}
	
	@PutMapping("/atualizar")
	public Funcionario atualizar(@RequestBody Funcionario funcionarioAtualizar) {
		return this.service.atualizar(funcionarioAtualizar);
	}
	
	@DeleteMapping("/remover")
	public void remover(@RequestParam("id") UUID funcionarioRemover) {
		this.service.remover(funcionarioRemover);
	}
	
}
