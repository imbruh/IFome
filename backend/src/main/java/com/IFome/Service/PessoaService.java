package com.IFome.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IFome.Model.Pessoa;
import com.IFome.Repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public Pessoa buscar(int cpf) {
		return this.repository.findByCpf(cpf);
	}
	
}
