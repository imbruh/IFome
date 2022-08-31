package com.IFome.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IFome.Dto.ClienteDTO;
import com.IFome.Model.Cliente;
import com.IFome.Model.Pessoa;
import com.IFome.Repository.ClienteRepository;
import com.IFome.Repository.PessoaRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public List<Cliente> listar() {
		return this.repository.findAll();
	}
	
	public void cadastrar(ClienteDTO clienteDto) {
		Pessoa pessoa;
		Cliente cliente = new Cliente(clienteDto.getCliente());

		pessoa = this.pessoaRepository.findByCpf(clienteDto.getPessoa().getCpf());
		
		if (pessoa == null) {
			pessoa = this.pessoaRepository.save(clienteDto.getPessoa());
		}
		
		cliente.setPessoa_id(pessoa.getId());
		this.repository.save(cliente);
	}
	
}
