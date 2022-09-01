package com.IFome.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.IFome.Model.Cliente;
import com.IFome.Repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> listar() {
		return this.repository.findAll();
	}
	
	public void cadastrar(Cliente cliente) {
		this.repository.save(cliente);
	}
	
}
