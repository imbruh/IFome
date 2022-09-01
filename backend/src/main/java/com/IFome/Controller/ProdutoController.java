package com.IFome.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.IFome.Model.Produto;
import com.IFome.Service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	private ProdutoService service; 
	
	@GetMapping("/listar")
	public List<Produto> listar() {
		List<Produto> produtos = service.listar();
		return produtos;
	}
	
	@PostMapping("/cadastrar")
	public void cadastrar(@RequestBody Produto produto) {
		this.service.cadastrar(produto);
	}
	
}
