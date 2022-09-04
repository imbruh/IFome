package com.IFome.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.IFome.Model.Pedido;
import com.IFome.Model.Produto;
import com.IFome.Service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService service;
	
	@GetMapping("/listar")
	public List<Pedido> listar() {
		List<Pedido> pedidos = service.listar();
		return pedidos;
	}
	
	@GetMapping("/listar-produtos-pedido")
	public List<Produto> listarProdutosPedido(@RequestParam(name = "numeroPedido") int numeroPedido) {
		List<Produto> produtos = service.listarProdutosPedido(numeroPedido);
		return produtos;
	}
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody Pedido pedido) {
		this.service.cadastrar(pedido);
	}
}
