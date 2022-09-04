package com.IFome.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IFome.Enum.EnumException;
import com.IFome.Exception.IFMException;
import com.IFome.Model.Empresa;
import com.IFome.Model.Funcionario;
import com.IFome.Repository.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;
	
	@Autowired
	private EmpresaService empresaService;
	
	public List<Funcionario> listar() {
		return this.repository.findAll();
	}
	
	public Funcionario cadastrar(Funcionario funcionario) {
		funcionario.setDataContratacao(LocalDate.now());
		funcionario.setMatricula(this.gerarMatricula(funcionario.getEmpresa().getNome()));
		return this.repository.save(funcionario);
	}
		
	public Funcionario atualizar(Funcionario funcionario) {
		Funcionario funcionarioAlterar = this.repository.findById(funcionario.getId()).get();
		if (funcionarioAlterar == null) {
			throw new IFMException(EnumException.FUNCIONARIO_NAO_ENCONTRADO);
		}
		funcionarioAlterar.setSenha(funcionario.getSenha());
		return this.repository.save(funcionarioAlterar);
	}
	
	public void remover(UUID id) {
		Funcionario funcionario = this.repository.findById(id).get();
		if (funcionario == null) {
			throw new IFMException(EnumException.FUNCIONARIO_NAO_ENCONTRADO);
		}
		this.repository.deleteById(id);
	}
	
	public String gerarMatricula(String nomeEmpresa) {
		Empresa empresa = this.empresaService.buscar(nomeEmpresa);
		List<String> matriculas = this.repository.matriculaList(nomeEmpresa);
		int contador = 0;
		String codigo = ""; 
		String matriculaNova = "";
		while (true) {
			if (contador < 10) {
				codigo = "0000"+contador;
			}else if (contador < 100) {
				codigo = "000"+contador;
			}else if (contador < 1000) {
				codigo = "00"+contador;
			}else {
				codigo = String.valueOf(contador);
			}
			matriculaNova = String.valueOf(
					LocalDate.now().getYear() 
					+ this.ajusteNumeroMes(LocalDate.now().getMonthValue())
					+ empresa.getId().toString().substring(0,3)
					+ codigo);
			if (!matriculas.contains(matriculaNova)) {
				System.out.println(matriculaNova);
				return matriculaNova;
			}
			contador += 1;
		}
	}
	
	private String ajusteNumeroMes(int numeroMes) {
		if (numeroMes < 10) {
			return "0" + numeroMes;
		}
		return String.valueOf(numeroMes);
	}
	
}
