package com.IFome.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.IFome.Dto.PedidoDTO;
import com.IFome.Model.Cliente;
import com.IFome.Model.Empresa;
import com.IFome.Model.Pedido;
import com.IFome.Repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;
	
//	public List<Empresa> listar() {
//		return this.repository.findAll();
//	}
//	
//	public void cadastrar(PedidoDTO pedidoDTO) {
//		Optional<Cliente> clienteOP = this.clienteRepository.findById(pedidoDTO.getIdCliente());
//
//		this.repository.save(Pedido.builder()
//							.numero(pedidoDTO.getNumero())
//							.cliente(clienteOP.get()).build());
//	}
}
