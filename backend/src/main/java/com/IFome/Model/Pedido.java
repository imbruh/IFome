package com.IFome.Model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.IFome.Enum.FormaPagamento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(nullable = false)
	private int numero;
	
	@Column(nullable = false)
	private LocalDateTime dataHora;
	
	@Column(nullable = false)
	private int quantidadeProduto;
	
	@Column(nullable = false)
	private double total;
	
	@Column(nullable = false)
	private FormaPagamento formaPagamento;

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id")
	private Cliente cliente;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "produto_id")
	private Produto produto;
}
