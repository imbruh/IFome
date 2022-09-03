package com.IFome.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.IFome.Model.Pedido;
import com.IFome.Model.Produto;
import com.IFome.Repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repository;

	public List<Pedido> listar() {
		return this.repository.findAll();
	}
	
	public List<Produto> listarProdutosPedido(int numeroPedido) {
		return this.repository.listarProdutosPedido(1);
	}

	public Pedido cadastrar(Pedido pedido) {
		return this.repository.save(pedido);
	}
}