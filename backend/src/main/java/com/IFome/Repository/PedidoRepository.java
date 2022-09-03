package com.IFome.Repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.IFome.Model.Pedido;
import com.IFome.Model.Produto;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID>{

//	@Query(value = " SELECT NEW Produto(pr.id, pr.nome, pr.preco, pr.estoque, pr.empresa) FROM Pedido pe "
//			+ " JOIN Produto pr "
//			+ " ON pe.produto= pr.id "
//			+ " WHERE pe.numero = ?1 ")
//	public List<Produto> listarProdutosPedido(@Param("numeroPedido") int numeroPedido);
	
	@Query(value = " SELECT pr FROM Pedido pe "
			+ " JOIN Produto pr "
			+ " ON pe.produto= pr.id "
			+ " WHERE pe.numero = ?1 ")
	public List<Produto> listarProdutosPedido(@Param("numeroPedido") int numeroPedido);
}