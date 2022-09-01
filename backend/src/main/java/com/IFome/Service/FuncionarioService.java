package com.IFome.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.IFome.Model.Funcionario;
import com.IFome.Repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	public List<Funcionario> listar() {
		return this.repository.findAll();
	}
	
	public void cadastrar(Funcionario funcionario) {
		this.repository.save(funcionario);
	}
	
}
