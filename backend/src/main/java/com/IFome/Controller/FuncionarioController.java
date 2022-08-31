package com.IFome.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IFome.Dto.FuncionarioDTO;
import com.IFome.Model.Funcionario;
import com.IFome.Service.FuncionarioService;

@RequestMapping("/funcionario")
@RestController
public class FuncionarioController {

	@Autowired
	private FuncionarioService service; 
	
	@GetMapping("/listar")
	public List<Funcionario> listar() {
		List<Funcionario> funcionarios = service.listar();
		return funcionarios;
	}
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody FuncionarioDTO funcionarioDto) {
		this.service.cadastrar(funcionarioDto);
	}
	
}
