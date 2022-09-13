package com.IFome.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.IFome.Dto.LoginDTO;
import com.IFome.Enum.EnumException;
import com.IFome.Exception.IFMException;
import com.IFome.Model.Cliente;
import com.IFome.Model.Funcionario;
import com.IFome.Repository.ClienteRepository;
import com.IFome.Repository.FuncionarioRepository;
import com.IFome.Repository.UsuarioRoleRepository;

@Service
public class UsuarioService implements UserDetailsService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private UsuarioRoleRepository usuarioRoleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public UserDetails autenticar(LoginDTO loginDTO) {
		UserDetails user = this.loadUserByUsername(loginDTO.getLogin());
		boolean senhaValida = passwordEncoder.matches(loginDTO.getSenha(), user.getPassword());
		if(senhaValida) {
			return user;
		}
		throw new IFMException(EnumException.CLIENTE_NAO_ENCONTRADO); // alterar para senha invalida
	}
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

		Cliente cliente = this.clienteRepository.findByEmail(login);
		Funcionario funcionario = this.funcionarioRepository.findByMatricula(login);

		if (cliente == null && funcionario == null) {
			throw new UsernameNotFoundException("usuario nao encontrado");			
			
		}
		
		LoginDTO usuario = LoginDTO.builder()
		.login(cliente.getEmail())
		.senha(cliente.getSenha())
		.build();
		
		List<String> roles_usuario = this.usuarioRoleRepository.getRole(cliente.getId());
//		String[] roles_usuario = {"FUNCIONARIO", "USUARIO"};
		return User.builder()
				.username(usuario.getLogin())
				.password(passwordEncoder.encode(usuario.getSenha()))
				.roles(this.convertRoles(roles_usuario))
//				.roles(roles_usuario)
				.build();
	}
	
	private String convertRoles(List<String> roles) {
		String roles_usuario = "";
		for (String role : roles) {
			roles_usuario+=role + ", ROLE_" ;
		}
		return roles_usuario.substring(0,roles_usuario.length()-7);
	}

}