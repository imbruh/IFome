package com.IFome.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum EnumException {
	
	CLIENTE_NAO_ENCONTRADO(404,"Cliente não encontrado"),
	FUNCIONARIO_NAO_ENCONTRADO(404,"Funcionario não encontrado");
	
	private int codigo;
	private String descricaoErro;

}
