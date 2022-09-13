package com.IFome.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import com.IFome.Service.JWTService;
import com.IFome.Service.UsuarioService;

@Configuration
public class JWTConfiguracao extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private JWTService jwtService;
	
	@Bean
	public OncePerRequestFilter jwtFilter() {
		return new JWTAutenticacao(this.jwtService, this.usuarioService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			
			.authorizeRequests()
			.antMatchers("/usuario/login")
				.permitAll()
			.antMatchers("/cliente/cadastrar")
				.permitAll()
			.antMatchers("/funcionario/cadastrar")
				.permitAll()
			.antMatchers("/cliente/listar")
				.hasRole("USUARIO")
				//				.antMatchers("/cliente/listar")
//				.permitAll()
//				
//				.antMatchers("/cliente/**")
////					.hasRole("ADMIN")
//					.permitAll()
				
//				.antMatchers("/produto/listar")
//					.hasAnyRole("ADMIN","USUARIO", "FUNCIONARIO")
//					
//				.antMatchers("/produto/**")
//					.hasRole("ADMIN")
				
				//Para qualquer requisição não mapeada, é necessário pelo menos esta autenticado 
				.anyRequest()
					.authenticated()
			
			.and()
			//Define o formulario de login, podendo escolher uma pagina que esta no back
			  //.formLogin()
				//Login passando usuario e senha (username, password) no header
				.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS) //Define que toda requisição tem que ter um token
			.and()
				.addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
					
	}



}
