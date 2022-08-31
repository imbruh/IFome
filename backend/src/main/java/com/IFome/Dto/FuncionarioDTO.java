package com.IFome.Dto;

import com.IFome.Model.Funcionario;
import com.IFome.Model.Pessoa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FuncionarioDTO {

	private Pessoa pessoa;
	
	private Funcionario funcionario;
	
}
