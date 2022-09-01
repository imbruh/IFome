package com.IFome.Model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false, unique = true)
	private String matricula;
	
	@Column(nullable = false)
	private String senha;
	
	@Column(nullable = false)
	private LocalDate dataContratacao;
	
	@ManyToOne
	@JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private Pessoa pessoa;
	
	//TODO - EMPRESA
	
//	public Funcionario(Funcionario funcionario) {
//		this.id = funcionario.getId();
//		this.matricula = funcionario.getMatricula();
//		this.senha = funcionario.getSenha();
//		this.dataContratacao = funcionario.getDataContratacao();
//	}
	
}
