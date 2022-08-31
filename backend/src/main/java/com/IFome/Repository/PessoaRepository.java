package com.IFome.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.IFome.Model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {

	public Pessoa findByCpf(int cpf);
	
}
