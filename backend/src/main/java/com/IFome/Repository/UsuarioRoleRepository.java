package com.IFome.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.IFome.Model.UsuarioRole;

@Repository
public interface UsuarioRoleRepository extends JpaRepository<UsuarioRole, UUID> {

	@Query(value = " SELECT r.role FROM UsuarioRole ur "
			+ " JOIN Role r"
			+ " ON ur.role.id = r.id "
			+ " WHERE ur.idUsuario = ?1 ")
	public List<String> getRole(UUID idUsuario);
	
}
