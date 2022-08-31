package com.IFome.Model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private LocalDate dataNascimento;
	
	@Column(nullable = false, unique = true)
	private int cpf;
	
	@Column(nullable = false)
	private String endereco;
	
	@Column(nullable = false)
	private int telefone;
	
	public Pessoa getPessoa() {
		return Pessoa.builder()
				.id(id)
				.nome(nome)
				.cpf(cpf)
				.endereco(endereco)
				.telefone(telefone)
				.build();
	}
	
}
