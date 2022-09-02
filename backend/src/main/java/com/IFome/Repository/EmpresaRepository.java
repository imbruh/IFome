package com.IFome.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.IFome.Enum.EnumCategoriaEmpresa;
import com.IFome.Model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, UUID>{
	
	public List<Empresa> findByCategoria(EnumCategoriaEmpresa categoria);
		
}
