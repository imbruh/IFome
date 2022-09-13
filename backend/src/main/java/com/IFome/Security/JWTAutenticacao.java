package com.IFome.Security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.IFome.Service.JWTService;
import com.IFome.Service.UsuarioService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class JWTAutenticacao extends OncePerRequestFilter {

//	@Autowired
	private JWTService jwtService;
	
//	@Autowired
	private UsuarioService usuarioService;

	private static final String HEADER_ATRIBUTO = "Authorization";
	private static final String ATRIBUTO_PREFIXO = "Bearer ";
	
	@Value("${security.jwt.token_senha}")
	private String TOKEN_SENHA;
	
	public JWTAutenticacao(JWTService jwtService, UsuarioService usuarioService) {
		this.jwtService = jwtService;
		this.usuarioService = usuarioService;
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authorization = request.getHeader(HEADER_ATRIBUTO);
		
		if (authorization != null && authorization.startsWith(ATRIBUTO_PREFIXO)) {
			String token = authorization.split(" ")[1];
//			boolean tokenValido = this.jwtService.tokenValido(token);
			
			String loginUsuario;
//			if (tokenValido) {
			if (true) {
//				String loginUsuario = this.jwtService.obterLoginUsuario(token);
				loginUsuario = JWT.require(Algorithm.HMAC512(TOKEN_SENHA))
						.build()
						.verify(token)
						.getSubject();	
				UserDetails usuario = usuarioService.loadUserByUsername(loginUsuario);
				UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(
						usuario, 
						null, //Credenciais ?! 
						usuario.getAuthorities());
				user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(user);
			}
		}
		
		filterChain.doFilter(request, response);
		
	}
	
}
