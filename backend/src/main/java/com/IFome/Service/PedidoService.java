package com.IFome.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IFome.Dto.PedidoDTO;
import com.IFome.Model.Cliente;
import com.IFome.Model.Pedido;
import com.IFome.Repository.ClienteRepository;
import com.IFome.Repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Pedido> listar() {
		return this.repository.findAll();
	}
	
	public void cadastrar(Pedido pedido) {
//		Optional<Cliente> cliente = this.clienteRepository.findById(pedidoDTO.getIdCliente());
		
		this.repository.save(pedido);
	}
}
