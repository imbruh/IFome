package com.IFome.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IFome.Model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID>{

	public List<Cliente> findAll();
}
