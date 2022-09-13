package com.IFome.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.IFome.Dto.LoginDTO;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

@Service
public class JWTService {

	@Value("${security.jwt.expiracao_token}")
	private String expiracaoToken;
	
	@Value("${security.jwt.token_senha}")
	private String tokenSenha;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public String gerarToken (LoginDTO loginDTO) {
		
		this.usuarioService.autenticar(loginDTO);
		
		//Gerar data hora da expiração do token
		Long expiracaoMinutos = Long.valueOf(expiracaoToken);
		LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(expiracaoMinutos);
		
		//Convertendo data hora para Date, para poder adicionar no token
		Date dataExpiracaoToken = Date.from(dataHoraExpiracao
				.atZone(ZoneId.systemDefault()) //Pegando a zona do Sistema operacional ("Brasil")
				.toInstant());
		
		//Para passar mais informações do payload
		HashMap<String, Object> claims = new HashMap<>();
		claims.put("nomeUsuario", "Teste");
		claims.put("roles", "ADMIN");
		
		
		//GERANDO NOVO TOKEN
		String token = JWT.create()
				.withSubject(loginDTO.getLogin())
				.withExpiresAt(dataExpiracaoToken)
				.sign(Algorithm.HMAC512(tokenSenha));
		return token;
	}
//	
//	//Retorna os "claims" do token (Subject, dataExpiracao e claims)
//	// Retorna erro throws ExpiredJwtException    v
//	private Claims obterClaims(String token) {
//		return Jwts
//				.parser()
//				.setSigningKey(this.chaveAssinaturaToken)
//				.parseClaimsJws(token)
//				.getBody();
//	}
//	
//	// Retorna erro throws ExpiredJwtException 
//	public boolean tokenValido(String token) {
//		try {
//			Claims claims = this.obterClaims(token);
//			Date dataExpiracao = claims.getExpiration();
//			LocalDateTime dataHoraExpiracao = dataExpiracao.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//			return !LocalDateTime.now().isAfter(dataHoraExpiracao);
//		} catch (Exception e) {
//			return false;
//		}
//	}
//
//	// Retorna erro throws ExpiredJwtException    v
//	public String obterLoginUsuario(String token) throws ExpiredJwtException {
//		return this.obterClaims(token).getSubject();
//	}
	
}
