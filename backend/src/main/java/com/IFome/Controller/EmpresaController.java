package com.IFome.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IFome.Model.Empresa;
import com.IFome.Service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService service;
	
	@GetMapping("/listar")
	public List<Empresa> listar() {
		List<Empresa> empresas = service.listar();
		return empresas;
	}
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody Empresa empresa) {
		this.service.cadastrar(empresa);
	}
}
