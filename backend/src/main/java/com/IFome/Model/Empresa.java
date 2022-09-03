package com.IFome.Model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.IFome.Enum.CategoriaEmpresa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false)
	private String nome;
	
	//TODO - COLOCAR ANOTATION
	@Column(nullable = false)
	private int cnpj;
	
	@Column(nullable = false)
	private CategoriaEmpresa categoria;
	
	@Column(nullable = false)
	private int avaliacao;
	
}
