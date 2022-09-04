package com.IFome.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.IFome.Model.Produto;
import com.IFome.Repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> listar() {
		return this.repository.findAll();
	}
	
	public Produto cadastrar(Produto produto) {
		return this.repository.save(produto);
	}
	
}
