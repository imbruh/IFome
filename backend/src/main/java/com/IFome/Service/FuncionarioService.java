package com.IFome.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IFome.Dto.FuncionarioDTO;
import com.IFome.Model.Funcionario;
import com.IFome.Model.Pessoa;
import com.IFome.Repository.FuncionarioRepository;
import com.IFome.Repository.PessoaRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Funcionario> listar() {
		return this.repository.findAll();
	}
	
	public void cadastrar(FuncionarioDTO funcionarioDto) {
		Pessoa pessoa;
		Funcionario funcionario = new Funcionario(funcionarioDto.getFuncionario());
		
		pessoa = this.pessoaRepository.findByCpf(funcionarioDto.getPessoa().getCpf());
		
		if (pessoa == null) {
			pessoa = this.pessoaRepository.save(funcionarioDto.getPessoa());
		}
		
		funcionario.setPessoa_id(pessoa.getId());
		this.repository.save(funcionario);
	}
	
}
