package com.IFome.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IFome.Enum.EnumCategoriaEmpresa;
import com.IFome.Model.Empresa;
import com.IFome.Repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;
	
	public List<Empresa> listar() {
		return this.repository.findAll();
	}
	
//	public List<Empresa> listarPorCategoria(EnumCategoriaEmpresa categoria) {
//		List<Empresa> empresas = this.repository.findByCategoria(categoria);
//		
//		if(empresas == null || empresas.isEmpty()) {
//			//exception
//		}
//	}
	
	public void cadastrar(Empresa empresa) {
		this.repository.save(empresa);
	}
}
