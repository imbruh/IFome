package com.IFome.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.IFome.Model.Pessoa;
import com.IFome.Service.PessoaService;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;
	
	@GetMapping("/buscar")
	public Pessoa buscar(@RequestParam("cpf") int cpf) {
		return this.service.buscar(cpf);
	}
	
}
