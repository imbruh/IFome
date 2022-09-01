package com.IFome.Repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IFome.Model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, UUID>{

}
