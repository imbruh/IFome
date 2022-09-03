package com.IFome.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.IFome.Model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, UUID> {

	@Query(value = " SELECT fu.matricula FROM Funcionario fu "
			+ " JOIN Empresa em "
			+ " ON fu.empresa = em "
			+ " WHERE em.nome = :nomeEmpresa ")
	public List<String> matriculaList(@Param("nomeEmpresa") String nomeEmpresa);
	
}
