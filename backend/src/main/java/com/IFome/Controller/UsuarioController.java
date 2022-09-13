package com.IFome.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IFome.Dto.LoginDTO;
import com.IFome.Service.JWTService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private JWTService jwtService;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginDTO loginDTO) {
		return this.jwtService.gerarToken(loginDTO);
	}
	
}
