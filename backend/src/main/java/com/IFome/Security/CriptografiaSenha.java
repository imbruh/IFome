package com.IFome.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CriptografiaSenha {

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
		
	}
	
}