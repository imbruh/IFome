package com.IFome.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IFome.Enum.EnumException;
import com.IFome.Exception.IFMException;
import com.IFome.Model.Cliente;
import com.IFome.Repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> listar() {
		return this.repository.findAll();
	}
	
	public Cliente cadastrar(Cliente cliente) {
		return this.repository.save(cliente);
	}
	
	public Cliente atualizar(Cliente cliente) {
		Cliente clienteAlterar = this.repository.findById(cliente.getId()).get();
		if (clienteAlterar == null) {
			throw new IFMException(EnumException.CLIENTE_NAO_ENCONTRADO);
		}
		clienteAlterar.setSenha(cliente.getSenha());
		return this.repository.save(clienteAlterar);
	}
	
	public void remover(UUID id) {
		Cliente cliente = this.repository.findById(id).get();
		if (cliente == null) {
			throw new IFMException(EnumException.CLIENTE_NAO_ENCONTRADO);
		}
		this.repository.deleteById(id);
	}
	
}
