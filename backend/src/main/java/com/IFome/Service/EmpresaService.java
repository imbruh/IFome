package com.IFome.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IFome.Model.Empresa;
import com.IFome.Repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;
	
	public List<Empresa> listar() {
		return this.repository.findAll();
	}
	
	public Empresa buscar(String nomeEmpresa) {
		return this.repository.findByNome(nomeEmpresa);
	}
	
	public Empresa cadastrar(Empresa empresa) {
		return this.repository.save(empresa);
	}
}
